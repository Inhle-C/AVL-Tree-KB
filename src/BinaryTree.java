// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BinaryTree<E extends Comparable<? super Generics>>
{
	/**
	 * Represents the root node of the binary search tree.
	 */
   BSTNode<Generics> root;
   
   /**
    * Initializes an empty binary tree.
    */
   public BinaryTree ()
   {
      root = null;
   }
   
   /**
    * Gets the height of the binary tree.
    * 
    * @return the height of the binary tree
    */
   public int getHeight ()
   {
      return getHeight (root);
   }
   
   /**
    * Used in getHeight(), gets the height of the subtree rooted at the specified node.
    * 
    * @param node the root node of the subtree
    * @return the height of the subtree rooted at the specified node
    */
   public int getHeight ( BSTNode<Generics> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   /**
    * Gets the size of the binary tree.
    * 
    * @return the size of the binary tree
    */
   public int getSize ()
   {
      return getSize (root);
   } 
   
   /**
    * Used in getSize(),gets the size of the subtree rooted at the specified node.
    * 
    * @param node the root node of the subtree
    * @return the size of the subtree rooted at the specified node
    */
   public int getSize ( BSTNode<Generics> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   /**
    * Visits the specified node by printing its data.
    * 
    * @param node the node to be visited
    */
   public void visit ( BSTNode<Generics> node )
   {
      System.out.println (node.getData());
   }
   
   /**
    * Performs a pre-order traversal starting from the root node.
    */
   public void preOrder ()
   {
      preOrder (root);
   }
   
   /**
    * Used in preOrder(), performs a pre-order traversal starting from the specified node.
    * 
    * @param node the root node of the subtree
    */
   public void preOrder ( BSTNode<Generics> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }

   /**
    * Performs a post-order traversal starting from the root node.
    */
   public void postOrder ()
   {
      postOrder (root);
   }
   
   /**
    * Used postOrder(), performs a post-order traversal starting from the specified node.
    * 
    * @param node the root node of the subtree
    */
   public void postOrder ( BSTNode<Generics> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }

   /**
    * Performs an in-order traversal starting from the root node.
    */
   public void inOrder ()
   {
      inOrder (root);
   }
   
   /**
    * Used inOrder(),performs an in-order traversal starting from the specified node.
    * 
    * @param node the root node of the subtree
    */
   public void inOrder ( BSTNode<Generics> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }

}
