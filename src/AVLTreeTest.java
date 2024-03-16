// Hussein's AVL Tree
// 2 April2017
// Hussein Suleman

public class AVLTreeTest
{
   public static void main ( String [] args )
   {
      AVLTree<Generics> bt = new AVLTree<Generics> ();
   
/*
      // test for single node
      bt.root = new BinaryTreeNode<Integer> (10, null, null);
*/      
   
/*
      // test for 2-level tree
      bt.root = new BinaryTreeNode<Integer> (
          1, 
          new BinaryTreeNode<Integer> (2, null, null),
          new BinaryTreeNode<Integer> (3, null, null)
      );
*/      


      // test for 3-level tree
      Generics a= new Generics("a","s","9.0");
      Generics b= new Generics("b","s","9.0");
      Generics c= new Generics("c","s","9.0");
      Generics d= new Generics("d","s","9.0");
      bt.insert (a); 
      bt.insert (b);
      bt.insert (c);
      bt.insert (d); 
      
/*
                   5
            1             7
                2      6     9
                  4        8
                 3
*/                 
      System.out.println ("Inorder : ");
      bt.treeOrder ();

      System.out.println ("Search 2 : ");
      System.out.println (bt.find (c));

      System.out.println ("Delete 2 : ");
      bt.delete (d);
      bt.treeOrder ();
   }
}
