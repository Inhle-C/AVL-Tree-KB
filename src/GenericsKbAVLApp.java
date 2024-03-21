import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

/**
 * @author Inhle Cele
 */
public class GenericsKbAVLApp 
{
	/**
	 * The size of the AVL tree/number of nodes in the tree
	 */
	static int size=0;
	
	/**
	 * Creates a AVL Search Tree that we'll be using to store all the items
	 */
	static AVLTree<Generics> mainTree = new AVLTree<Generics>();
	
	/**
	 * Scanner which holds the files
	 */
	static Scanner fileIn = null;
	/**
	 * Reads in each line from a file with specified name in the folder and puts that information into the search tree
	 * @param fName The name of the file we are going to read in
	 */
	public static void readFileDB(String fName) 
	{
	 
	  try 
	  {
		fileIn= new Scanner(new FileInputStream(fName));
		while (fileIn.hasNext()) 
		{
			String line= fileIn.nextLine();
			String [] genericDetails = new String[3];
			genericDetails = line.split("\\t");
			Generics temp = new Generics(genericDetails[0],genericDetails[1], genericDetails[2]);
			mainTree.insert(temp);
			size++;
		} 
		
		System.out.println("\nKnowledge base loaded succesfully.");
		fileIn.close();
		
	  } catch (FileNotFoundException f) 
	  {
		System.out.println("File not found");
	  }	
	}
	
	/**
	 * Reads in each line from a file with specified name in the folder and puts that information into the search tree
	 * @param fName The name of the file we are going to read in
	 * @param numS The number of lines we are readiing in
	 */
	public static void readFileDB(String fName, int numS) 
	{
	 
		int count=0;
	  try 
	  {
		Generics [] listKB= new Generics[50000];
		fileIn= new Scanner(new FileInputStream(fName));
		while (fileIn.hasNext()) 
		{
			String line= fileIn.nextLine();
			String [] genericDetails = new String[3];
			genericDetails = line.split("\\t");
			Generics temp = new Generics(genericDetails[0],genericDetails[1], genericDetails[2]);
			listKB[count]= temp;
			count++;

		} 
		for (int i = 0; i < numS; i++) 
		{
			int random=(int)( Math.random()* (count));
			mainTree.insert(listKB[random]);
			size++;
		}
		
		
		System.out.println("\nKnowledge base loaded succesfully.");
		fileIn.close();
		
	  } catch (FileNotFoundException f) 
	  {
		System.out.println("File not found");
	  }	
	}
	/**
	 * 
	 * @param F
	 * @param i
	 */
	public static void readFileQuery(String F)
	{
		try 
		  {
			int currentS=0;
			int prevSsum=0;
			int i=0;
			fileIn= new Scanner(new FileInputStream(F));
			while (fileIn.hasNextLine()) 
			{
				String line= fileIn.nextLine();
				Generics temp= new Generics(line);
				BSTNode<Generics> exist = mainTree.find(temp);
				/*if (exist!= null) 
				{
					System.out.println(exist);
				}
				else
				{
					System.out.println(temp.getTerm()+ ": This Term does not exist in the KB");
				}*/
				
				currentS= AVLTree.opCountSearch - prevSsum;
				//System.out.println("Cost value of this search: "+ currentS);
				prevSsum+= currentS;
				i++;
			}
			fileIn.close();
			System.out.println("\nSearched for " + i + " queries");
			System.out.println("Avg Search comparision count:  " + prevSsum/i);
		  } catch (FileNotFoundException f) 
		  {
			System.out.println("File not found");
		  }	
		}
	
	public static void main(String[] args) 
	{
		System.out.println("Experiment:");
		Scanner keyboard= new Scanner(System.in);
		int Numsearches= keyboard.nextInt();
		keyboard.close();
		
		readFileDB("GenericsKB.txt", Numsearches); // Creating the random data set
		System.out.println("size of the dataset: " + size);
		
		readFileQuery("GenericsKB-queries.txt"); //testing the search
		mainTree.reportInsertComparisonCount();
		mainTree.reportSearchComparisonCount();
		
	}

}
