import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

public class GenericsKbAVLApp 
{
	
	static int size=0;
	/**
	 * Operation Counter variable which will be used inbetween all clasess for the inserting
	 */
	public static int opCountInsert=0;
	/**
	 * Operation Counter variable which will be used inbetween all clasess for searching
	 */
	public static int opCountSearch=0;
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
	 
	if (fileIn== null)
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
	else 
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
				
				BSTNode<Generics> exist= mainTree.find(temp);
				if (exist!= null)//if the term exists in the knowledge base
				{
				  if (temp.getConfidence()>= exist.getData().getConfidence())
				  {
					  exist.getData().setTerm(temp.getTerm());
					  exist.getData().setConfidence(temp.getConfidence());
					  exist.getData().setSentence(temp.getSentence());
				  }
				}
				else //if it doesnt
				mainTree.insert(temp);
			} 
			
			System.out.println("Knowledge base loaded succesfully.");
			fileIn.close();
			
		  } catch (FileNotFoundException f) 
		  {
			System.out.println("File not found");
		  }	
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
			
			for (int n=0; n<i; n++) 
			{
					int random=(int)( Math.random()* (queries.size()));
					BSTNode<Generics> exist = mainTree.find(queries.get(random));
					if (exist!= null)
					{
						System.out.println(exist);
					}
					else
					{
						System.out.println(queries.get(random).getTerm()+ ": This Term does not exist in the KB");
					}
					System.out.println("N value: "+ opCountSearch);
			
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
		readFileDB("GenericsKB.txt");
		System.out.println("size of the file: " + size);
		readFileQuery("GenericsKB-queries.txt", 10);
		System.out.println(opCountInsert);
		System.out.println(opCountSearch);
		
		
		
	}
	
	public static void countI()
	{
		opCountInsert++;
	}
	public static void countS()
	{
		opCountSearch++;
	}

}
