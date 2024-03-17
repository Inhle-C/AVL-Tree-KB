// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

public class AVLTree<T extends Comparable<? super Generics>> extends BinaryTree<Generics>
{
	
	
   public int height ( BSTNode<Generics> node )
   {
	  AVLTreeKB.count();
      if (node != null)
         return node.height;
      return -1;
   }
   
   public int balanceFactor ( BSTNode<Generics> node )
   {
      return height (node.getRight()) - height (node.getLeft());
   }
   
   public void fixHeight ( BSTNode<Generics> node )
   {
      node.height = Math.max (height (node.getLeft()), height (node.getRight())) + 1;
   }
   
   public BSTNode<Generics> rotateRight ( BSTNode<Generics> p )
   {
      BSTNode<Generics> q = p.getLeft();
      p.leftChild = q.getRight();
      q.rightChild = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public BSTNode<Generics> rotateLeft ( BSTNode<Generics> q )
   {
      BSTNode<Generics> p = q.getRight();
      q.rightChild = p.getLeft();
      p.leftChild = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   public BSTNode<Generics> balance ( BSTNode<Generics> p )
   {
      fixHeight (p);
      AVLTreeKB.count();
      if (balanceFactor (p) == 2)
      {
    	 AVLTreeKB.count();
         if (balanceFactor (p.getRight()) < 0)
            p.setRightChild(rotateRight (p.getRight()));
         return rotateLeft (p);
      }
      AVLTreeKB.count();
      if (balanceFactor (p) == -2)
      {
    	 AVLTreeKB.count();
         if (balanceFactor (p.getLeft()) > 0)
            p.leftChild = rotateLeft (p.getLeft());
         return rotateRight (p);
      }
      return p;
   }

   public void insert ( Generics d )
   {
      root = insert (d, root);
   }
   public BSTNode<Generics> insert ( Generics d, BSTNode<Generics> node )
   {
	  AVLTreeKB.count();
      if (node == null)
         return new BSTNode<Generics> (d, null, null);
      AVLTreeKB.count();
      if (d.compareTo (node.data) <= 0)
         node.leftChild = insert (d, node.leftChild);
      else
         node.rightChild = insert (d, node.rightChild);
      return balance (node);
   }
   
   public void delete ( Generics d )
   {
      root = delete (d, root);
   }   
   public BSTNode<Generics> delete ( Generics d, BSTNode<Generics> node )
   {
	  AVLTreeKB.count();
      if (node == null) return null;
      AVLTreeKB.count();
      if (d.compareTo (node.getData()) < 0)
         node.leftChild = delete (d, node.leftChild);
      else if (d.compareTo (node.getData()) > 0)
         node.rightChild = delete (d, node.rightChild);
      else
      {
         BSTNode<Generics> q = node.getLeft();
         BSTNode<Generics> r = node.getRight();
         AVLTreeKB.count();
         if (r == null)
            return q;
         BSTNode<Generics> min = findMin (r);
         min.rightChild = removeMin (r);
         min.leftChild = q;
         return balance (min);
      }
      return balance (node);
   }
   
   public BSTNode<Generics> findMin ( BSTNode<Generics> node )
   {
	  AVLTreeKB.count();
      if (node.getLeft() != null)
         return findMin (node.getLeft());
      else
         return node;
   }

   public BSTNode<Generics> removeMin ( BSTNode<Generics> node )
   {
	  AVLTreeKB.count(); 
      if (node.getLeft() == null)
         return node.getRight();
      node.leftChild = removeMin (node.leftChild);
      return balance (node);
   }

   public BSTNode<Generics> find ( Generics d )
   {
	  AVLTreeKB.count(); 
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   public BSTNode<Generics> find ( Generics d, BSTNode<Generics> node )
   {
	  AVLTreeKB.count();
      if (d.compareTo (node.getData()) == 0) 
         return node;
      else if (d.compareTo (node.getData()) < 0)
         return (node.getLeft() == null) ? null : find (d, node.leftChild);
      else
         return (node.getRight() == null) ? null : find (d, node.rightChild);
   }
   
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( BSTNode<Generics> node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.getData());
         treeOrder (node.getLeft(), level+1);
         treeOrder (node.getRight(), level+1);
      }
   }
}

