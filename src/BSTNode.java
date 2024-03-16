
/**
 * Class to create the node for the Binary Search tree
 * 
 * @author Inhle Cele and CSC2001F notes- Binary trees (Prof. Jan Buys)
 * @version 1.0
 * @since 25-02-2024 
*/
public class BSTNode <E extends Comparable<? super Generics>>
{
	
	/**
	 * Object which stores the Term, Statement and Confidence score of an item in the Database
	 */
	 Generics data;
	 /**
	  * left child of the current node
	  */
	 BSTNode<Generics> leftChild;
	 /**
	  * right child of the currentt node
	  */
	 BSTNode<Generics> rightChild;
	 /**
	  * height of the current node in the tree
	  */
	 int height;

	 /**
	  * Constructor which creates a object of the BSTNode class that 
	  * has to be of type Generic and has no children/leaf nodes 
	  * 
	  * @param d Object which holds the term, statement and confidence score of the specified item
	  */
	 public BSTNode(Generics d)
	 {
		 data= d;
		 leftChild= null;
		 rightChild=null;
		 height=0;
	 }
	 
	 /**
	  * Constructor which creates a object of the BSTNode class that 
	  * has to be of type Generic but has children/leaf nodes that are known 
	  * @param d Object which holds the term, statement and confidence score of the specified item
	  * @param l left child of object specified in d
	  * @param r right child of object specified in d
	  */
	 public BSTNode(Generics d, BSTNode<Generics> l, BSTNode<Generics> r )
	 {
		 data = d;
		 leftChild = l;
		 rightChild = r;
	 }
	 
	 /**
	  * Returns the data of the specified node as a Generic Object 
	  * which holds the term, statement and confidence score
	  * 
	  * @return Generic object of the node with the term, statement and confidence score
	  */
	 public Generics getData() {
		return data;
	}
	 
	 /**
	  * Compares the data in the BSTnode to other BSTNode object alphabetically
	  * @param compareNode the BTSNode object of type Generic being compared to data
	  * @return -1, 0 or 1 as this compareNode is alphabetically less than, equal to, or greater than the BSTNode.
	  */
	 public int compareTo(Generics compareNode)
	 {
		 return (data.compareTo((compareNode)));

	 }

	 /**
	  * Returns the left child of the Node
	  * @return left child of node
	  */
	 public BSTNode<Generics> getLeft () { return leftChild; }
	 
	 /**
	  * Returns the right child of the Node
	  * @return right child of node
	  */
	 public BSTNode<Generics> getRight () { return rightChild; }
	 
	 /**
	  * Sets the left child as type BSTNode of the current BSTNode
	  * @param leftChild the left child of the node
	  */
	 public void setLeftChild(BSTNode<Generics> leftChild) {
		this.leftChild = leftChild;
	}
	 
	 /**
	  * Sets the right child as type BSTNode of the current BSTNode
	  * @param rightChild the right child of the node
	  */
	 public void setRightChild(BSTNode<Generics> rightChild) {
		this.rightChild = rightChild;
	}
	 
	 /**
	  * Outputs the string of the Generic data type, use the toString() of the Generic class
	  * 
	  * @return the data in the format: Term\tSentence\tConfidence_score
	  */
	   @Override
		public String toString() {
			// TODO Auto-generated method stub
			return data.toString();
		}

}
