import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;

public class AVLTreeKB 
{
	
	/**
	 * Operation Counter variable which will be used inbetween all clasess
	 */
	public static int opCount=0;
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
		
		try 
		  {
			fileIn= new Scanner(new FileInputStream(F));
			for (int n=0; n<i && fileIn.hasNextLine(); n++) 
			{
					String line= fileIn.nextLine();
					Generics temp= new Generics(line);
					BSTNode<Generics> exist = mainTree.find(temp);
					if (exist!= null)
					{
						System.out.println(exist);
					}
					else
					{
						System.out.println(line+ ": This Term does not exist in the KB");
					}
			
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
		System.out.println(opCount);
		readFileDB("GenericsKB.txt");
		System.out.println(opCount);
		readFileQuery("GenericsKB-queries.txt", 10);
		System.out.println(opCount);
	}
	
	public static void count()
	{
		opCount++;
	}

}
