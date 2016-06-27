package objComp.driver;

import objComp.fileOperations.FileProcessor;
import objComp.util.MyLogger;
import objComp.util.PopulateObjects;

public class Driver
{
	public static void main(String [] args)
	{
		if(args.length!=3){
			System.err.println("Please enter valid number of arguments"); System.exit(1); 
		}
		
		//set file names
		FileProcessor.setFileName(args[0]);
		
		//set debug value
		try {
			MyLogger.getInstance().setDebugValue(args[2]);
		} catch (NumberFormatException e) {
			System.err.println("Please Enter valid integer NUMBER for debug level");
			System.exit(1);
		}

		int NUM_ITERATIONS = 0;
		try {
			NUM_ITERATIONS = Integer.parseInt(args[1]);
			if(NUM_ITERATIONS <= 0)
			{
				System.err.println("The number of iterations must be positive");
				System.exit(1);
			}
		} catch (NumberFormatException e) {
			System.err.println("Please Enter valid integer NUMBER for number of iterations");
			System.exit(1);
		}

		PopulateObjects pop = null;
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < NUM_ITERATIONS; i++)
		{
			
			pop = new PopulateObjects();
			pop.deserObjects();
			
		}
		try{ pop.printResult(); } catch (NullPointerException e) { System.err.println("Null pointer exception occurred, object of PopulateObjects might be null"); }
		long finishTime = System.currentTimeMillis();

		try{
			MyLogger.getInstance().printToStdout(0, "Total Time: " +(double)(finishTime-startTime)/(double)(NUM_ITERATIONS*1000) + " seconds");
		}
		catch(Exception e)
		{
			System.err.println("Divide by zero error, number of iterations must be non zero");
			System.exit(1);
		}
	}
}