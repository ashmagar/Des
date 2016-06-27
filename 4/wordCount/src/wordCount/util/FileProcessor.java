package wordCount.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileProcessor {

	private String line = null;
	private static String inFilename;
	private static String outFilename;
	private FileInputStream finstream = null;
	private BufferedReader br = null;
	
	/*
	 constructor: parameterized, for an object of file processor for input stream
	 @param: file mode, simply string
	*/
	public FileProcessor(String inputFile)
	{
		try {
			finstream = new FileInputStream(inFilename);

		} catch (FileNotFoundException e) {
			System.err.println("File does not exist!!");
			System.exit(1);
		}
		br = new BufferedReader(new InputStreamReader(finstream));

	}

	/*
	 constructor: default, for an object of file processor for output stream, flushes the file
	*/
	public FileProcessor(){

	}

	/*
	@param: NONE
	@return: NONE
	*/
	public void flushFile()
	{
		//flushing the file
		try {
			PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter(outFilename)));
			out1.close();
		} catch (IOException e) {
			System.err.println("I/O error!!");
			System.exit(1);
		} 
	}
	
	/*
	@param: input,output - input and output file names, static method
	@return: NONE
	*/
	public static void setFileName(String input,String output)
	{
		inFilename = input;
		outFilename = output;
	}	
	
	/*
	@param: NONE
	@return: input file name
	*/
	public String getInputFileName()
	{
		return inFilename;
	}

	/*
	@param: NONE
	@return: output file name
	*/
	public String getOutputFileName()
	{
		return outFilename;
	}

	/*
	@param: NONE
	@return: line read from file (string)
	*/
	public String readLineFromFile()
	{
		try {
			line = br.readLine();
		} catch (IOException e) {
			System.err.println("Error reading line from file!!");
			try {
				br.close();
			} catch (IOException e1) {
				System.err.println("Error closing input stream!!");
			}
			System.exit(1);
		}
		if(line==null){
			try {
				br.close();
			} catch (IOException e1) {
				System.err.println("Error closing input stream!!");
				System.exit(1);
			}
		}
		return line;
	}
	
	/*
	@param: string to be written to file
	@return: NONE
	*/
	public void writeToFile(String lineOut)
	{
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFilename, true)))) {
			if(lineOut.equals("\n")){
				out.print(lineOut);
			} else out.println(lineOut);
			out.close();
		}catch (IOException e) {
			System.err.println("Error writing line to file!!");
			System.exit(1);
		}
	}
}