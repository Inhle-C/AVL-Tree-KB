// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

public class AVLTree<T extends Comparable<? super Generics>> extends BinaryTree<Generics>
{
	
	/**
	 * Operation Counter variable which will be used inbetween all clasess for the inserting
	 */
	public static int opCountInsert=0;
	/**
	 * Operation Counter variable which will be used inbetween all clasess for searching
	 */
	public static int opCountSearch=0;

	/**
	 * Empty Constructor of the AVLTree class
	 */
	public AVLTree() 
	{
		// TODO Auto-generated constructor stub
	}
/**
 * Return the height of the node in the tree
 * @param node The node your checking
 * @return the height of the node in tree
 */
   public int height ( BSTNode<Generics> node )
   {  
      if (node != null)
         return node.height;
      return -1;
   }
   
   /**
    * Returns the difference between the right child and the height of the left node
    * @param node The node youre checking the balance factor for
    * @return the balance factor of the single node
    */
   public int balanceFactor ( BSTNode<Generics> node )
   {
      return height (node.getRight()) - height (node.getLeft());
   }
   
   /**
    * Set the max height of the specific node youre on
    * @param node the node youre settinh the hegiht for 
    */
   public void fixHeight ( BSTNode<Generics> node )
   {
      node.height = Math.max (height (node.getLeft()), height (node.getRight())) + 1;
   }
   
   /**
    * Rotates the AVL tree one node to the right.
    * 
    * @param p the node around which the rotation is performed
    * @return the new root node after the rotation
    */
   public BSTNode<Generics> rotateRight ( BSTNode<Generics> p )
   {
      BSTNode<Generics> q = p.getLeft();
      p.leftChild = q.getRight();
      q.rightChild = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   /**
    * Rotates the AVL tree one node to the left.
    * 
    * @param q the node around which the rotation is performed
    * @return the new root node after the rotation
    */
   public BSTNode<Generics> rotateLeft ( BSTNode<Generics> q )
   {
      BSTNode<Generics> p = q.getRight();
      q.rightChild = p.getLeft();
      p.leftChild = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   /**
    * Balances the AVL tree at the specified node.
    * 
    * @param p the node at which balancing is performed
    * @return the new root node after balancing
    */
   public BSTNode<Generics> balance ( BSTNode<Generics> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.getRight()) < 0)
            p.setRightChild(rotateRight (p.getRight()));
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.getLeft()) > 0)
            p.leftChild = rotateLeft (p.getLeft());
         return rotateRight (p);
      }
      return p;
   }

   /**
    * Inserts a new node with the given data into the AVL tree.
    * 
    * @param d the data to be inserted
    */
   public void insert ( Generics d )
   {
      root = insert (d, root);
   }
   
   /**
    * Used in the insert(Generics d),inserts a new node with the given data into the AVL tree starting from the specified node.
    * 
    * @param d the data to be inserted
    * @param node the root node of the subtree
    * @return the root node of the subtree after insertion
    */
   public BSTNode<Generics> insert ( Generics d, BSTNode<Generics> node )
   {
      if (node == null)
         return new BSTNode<Generics> (d, null, null);
      countI();
      if (d.compareTo (node.data) <= 0)
         node.leftChild = insert (d, node.leftChild);
      else
         node.rightChild = insert (d, node.rightChild);
      return balance (node);
   }
   
   /**
    * Deletes a node with the given data from the AVL tree.
    * 
    * @param d the data to be deleted
    */
   public void delete ( Generics d )
   {
      root = delete (d, root);
   }
   
   /**
    * Used within the delete(Generics d), to delete a node with the given data from the AVL tree starting from the specified node.
    * 
    * @param d the data to be deleted
    * @param node the root node of the subtree
    * @return the root node of the subtree after deletion
    */
   public BSTNode<Generics> delete ( Generics d, BSTNode<Generics> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.getData()) < 0)
         node.leftChild = delete (d, node.leftChild);
      else if (d.compareTo (node.getData()) > 0)
         node.rightChild = delete (d, node.rightChild);
      else
      {
         BSTNode<Generics> q = node.getLeft();
         BSTNode<Generics> r = node.getRight();
         if (r == null)
            return q;
         BSTNode<Generics> min = findMin (r);
         min.rightChild = removeMin (r);
         min.leftChild = q;
         return balance (min);
      }
      return balance (node);
   }
   
   /**
    * Finds the node with the minimum data value starting from the specified node.
    * 
    * @param node the root node of the subtree
    * @return the node with the minimum data value
    */
   public BSTNode<Generics> findMin ( BSTNode<Generics> node )
   {
      if (node.getLeft() != null)
         return findMin (node.getLeft());
      else
         return node;
   }

   /**
    * Removes the node with the minimum data value starting from the specified node.
    * 
    * @param node the root node of the subtree
    * @return the root node of the subtree after removal
    */
   public BSTNode<Generics> removeMin ( BSTNode<Generics> node )
   { 
      if (node.getLeft() == null)
         return node.getRight();
      node.leftChild = removeMin (node.leftChild);
      return balance (node);
   }

   /**
    * Finds the node with the given data value in the AVL tree.
    * 
    * @param d the data to be found
    * @return the node with the specified data value, or null if not found
    */
   public BSTNode<Generics> find ( Generics d )
   { 
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   
   /**
    * Used in find(Generics d),finds the node with the given data value starting from the specified node.
    * 
    * @param d the data to be found
    * @param node the root node of the subtree
    * @return the node with the specified data value, or null if not found
    */
   public BSTNode<Generics> find ( Generics d, BSTNode<Generics> node )
   {
	  countS();
      if (d.compareTo (node.getData()) == 0) 
         return node;
      else if (d.compareTo (node.getData()) < 0)
         return (node.getLeft() == null) ? null : find (d, node.leftChild);
      else
         return (node.getRight() == null) ? null : find (d, node.rightChild);
   }
   
   /**
    * Prints the AVL tree in pre-order traversal.
    */
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   
   /**
    * Use in treeOrder(), to print the AVL tree in pre-order traversal starting from the root and adding spaces according to the level on the tree.
    * 
    * @param node the root node of the subtree
    * @param level the level of the node in the tree
    */
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
   
   /**
    * Instrumentation - Increments the count for insert operations.
    */
	public static void countI()
	{
		opCountInsert++;
	}
	
	/**
	 * Instrumentation - Increments the count for search operations.
	 */
	public static void countS()
	{
		opCountSearch++;
	}
	
	/**
     * Method to report the value of the counter for insert operations.
     */
    public void reportInsertComparisonCount()
    {
        System.out.println("Total Insert Comparison Count: " + opCountInsert);
    }
    
    /**
     * Method to report the value of the counter for search operations.
     */
    public void reportSearchComparisonCount()
    {
        System.out.println("Total Search Comparison Count: " + opCountSearch);
    }
}

