package wordCount.driver;

import wordCount.treesForStrings.MyTree;
import wordCount.util.FileProcessor;
import wordCount.util.MyLogger;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.Visitor;
import wordCount.visitors.WordCountVisitor;

public class Driver
{
	public static void main(String [] args)
	{
		if(args.length!=4){
			System.err.println("Please enter valid number of arguments"); System.exit(1); 
		}
		
		//set file names
		FileProcessor.setFileName(args[0],args[1]);
		
		//set debug value
		try {
			MyLogger.getInstance().setDebugValue(args[3]);
		} catch (NumberFormatException e) {
			System.err.println("Please Enter valid integer NUMBER for debug level");
			System.exit(1);
		}

		int NUM_ITERATIONS = 0;
		try {
			NUM_ITERATIONS = Integer.parseInt(args[2]);
			if(NUM_ITERATIONS <= 0)
			{
				System.err.println("The number of iterations must be positive");
				System.exit(1);
			}
		} catch (NumberFormatException e) {
			System.err.println("Please Enter valid integer NUMBER for number of iterations");
			System.exit(1);
		}

		long startTime = System.currentTimeMillis();
		for(int i = 0; i < NUM_ITERATIONS; i++)
		{
			
			//create element
			MyTree myTree = new MyTree();
						
			//create visitors
			Visitor ptVisitor = new PopulateTreeVisitor();
			Visitor wcVisitor = new WordCountVisitor();
			
			//visit element
			try{
				myTree.accept(ptVisitor);
				myTree.accept(wcVisitor);
			}catch(NullPointerException e)
			{
				System.err.println("Null pointer exception occurred, one of the object is not instantiated");
				System.exit(1);
			}
			
			
		}
		long finishTime = System.currentTimeMillis();
		//Calculate total_time as (finishTime-startTime)/NUM_ITERATIONS.
		try{
			MyLogger.getInstance().printToStdout(1, "Total Time: " +(finishTime-startTime)/(NUM_ITERATIONS*1000) + " seconds");
			MyLogger.getInstance().printToStdout(1, "Total Time: " +(finishTime-startTime)/(NUM_ITERATIONS) + " milliseconds");
		}
		catch(Exception e)
		{
			System.err.println("Divide by zero error, number of iterations must be non zero");
			System.exit(1);
		}
	}
}