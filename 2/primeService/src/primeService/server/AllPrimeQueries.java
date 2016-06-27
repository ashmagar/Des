package primeService.server;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import primeService.util.Debug;

public class AllPrimeQueries {

	public static Map<String,ArrayList<Integer>> queryDB = new ConcurrentHashMap<String,ArrayList<Integer>>(100);

	public static void insertQuery(String clientName,int number)
	{
		Debug.printToStdout(3," [metohd insertQuery of AllPrimeQueries.java called]");	
		if(queryDB.containsKey(clientName))
		{
			ArrayList<Integer> lExisting = queryDB.get(clientName);
			lExisting.add(number);
		}
		else
		{
			ArrayList<Integer> lNew = new ArrayList<Integer>(100);
			lNew.add(number);
			queryDB.put(clientName,lNew);
		}
	}
	
	public static void printAllQueries()
	{
		Debug.printToStdout(3," [metohd printAllQueries of AllPrimeQueries.java called]");
			for(Map.Entry<String,ArrayList<Integer>> entry : queryDB.entrySet())
			{
				System.out.print(entry.getKey() + " ");
				for(int i : entry.getValue())
				{
					System.out.print(i + " ");
				}
				System.out.println();
			}
	}

	public static void printQuery(String clientNameIn) 
	{
		Debug.printToStdout(3," [metohd printQuery of AllPrimeQueries.java called]");
		if(queryDB.containsKey(clientNameIn))
		{
				ArrayList<Integer> listOfNumbers = queryDB.get(clientNameIn);
				System.out.print(clientNameIn + " ");
				for(int i : listOfNumbers)
				{
					System.out.print(i + " ");
				}
				System.out.println();
		}
		else
		{
			System.out.println("Client entry not present");
		}
		
	}
}
