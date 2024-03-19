import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

public class GenericsKbAVLApp 
{
	
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
	
	public static void readFileDB(String fName, int numS) 
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
			if (size== numS)
				break;
		} 
		
		System.out.println("\nKnowledge base loaded succesfully.");
		fileIn.close();
		
	  } catch (FileNotFoundException f) 
	  {
		System.out.println("File not found");
	  }	
	}
	
	public static void readFileQuery(String F, int i)
	{
		ArrayList<Generics> queries = new ArrayList<>();
		try 
		  {
			fileIn= new Scanner(new FileInputStream(F));
			while (fileIn.hasNextLine()) 
			{
				String line= fileIn.nextLine();
				Generics temp= new Generics(line);
				queries.add(temp);
				
			}
			
			int currentS=0;
			int prevSsum=0;
			for (int n=0; n<i; n++) 
			{
					int random=(int)( Math.random()* (queries.size()));
					BSTNode<Generics> exist = mainTree.find(queries.get(random));
					/*if (exist!= null)
					{
						System.out.println(exist);
					}
					else
					{
						System.out.println(queries.get(random).getTerm()+ ": This Term does not exist in the KB");
					}
					
					currentS= AVLTree.opCountSearch - prevSsum;
					// System.out.println("Cost value of this search: "+ currentS);
					prevSsum+= currentS;*/
			
			} 
			
			System.out.println("\nSearched for " + i + " queries");
			fileIn.close();
			
		  } catch (FileNotFoundException f) 
		  {
			System.out.println("File not found");
		  }	
		}
	
	public static void main(String[] args) 
	{
		System.out.println("Experiment 2 (Both):");
		Scanner keyboard= new Scanner(System.in);
		int Numsearches= keyboard.nextInt();
		
		readFileDB("GenericsKB.txt", Numsearches);
		System.out.println("size of the file: " + size);
		
		
		readFileQuery("GenericsKB-queries.txt", Numsearches);
		System.out.println("Total Cost of the insert operations: " + AVLTree.opCountInsert);
		System.out.println("Total Cost of the search operations: "+ AVLTree.opCountSearch);
		
		
		
	}
	


}
