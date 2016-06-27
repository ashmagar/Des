package taskManager.util;

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
		MyLogger.getInstance().printToStdout(4,"Constructor: FileProcessor; parameterized");
		try {
			finstream = new FileInputStream(inFilename);

		} catch (FileNotFoundException e) {
			System.err.println("File does not exist!!");
			System.exit(1);
		}
		br = new BufferedReader(new InputStreamReader(finstream));
		MyLogger.getInstance().printToStdout(2,"Descriptors: input stream opened");
	}

	/*
	 constructor: default, for an object of file processor for output stream, flushes the file
	*/
	public FileProcessor(){
		MyLogger.getInstance().printToStdout(4,"Constructor: FileProcessor; default, empty");
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
		MyLogger.getInstance().printToStdout(3,"Method: setFileName Class: FileProcessor; Static Method");
		inFilename = input;
		outFilename = output;
	}	
	
	/*
	@param: NONE
	@return: input file name
	*/
	public String getInputFileName()
	{
		MyLogger.getInstance().printToStdout(3,"Method: getInputFileName Class: FileProcessor; Static Method");
		return inFilename;
	}

	/*
	@param: NONE
	@return: output file name
	*/
	public String getOutputFileName()
	{
		MyLogger.getInstance().printToStdout(3,"Method: getOutFileName Class: FileProcessor; Static Method");
		return outFilename;
	}

	/*
	@param: NONE
	@return: line read from file (string)
	*/
	public String readLineFromFile()
	{
		MyLogger.getInstance().printToStdout(3,"Method: readLineFromFile Class: FileProcessor");
		try {
			line = br.readLine();
		} catch (IOException e) {
			System.err.println("Error reading line from file!!");
			try {
				br.close();
				MyLogger.getInstance().printToStdout(2,"Descriptors: input stream closed");
			} catch (IOException e1) {
				System.err.println("Error closing input stream!!");
			}
			System.exit(1);
		}
		if(line==null){
			try {
				br.close();
				MyLogger.getInstance().printToStdout(2,"Descriptors: input stream closed");
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
		MyLogger.getInstance().printToStdout(3,"Method: writeToFile Class: FileProcessor");
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFilename, true)))) {
			MyLogger.getInstance().printToStdout(2,"Descriptors: output stream opened");
			if(lineOut.equals("\n")){
				out.print(lineOut);
			} else out.println(lineOut);
			out.close();
			MyLogger.getInstance().printToStdout(2,"Descriptors: output stream closed");
		}catch (IOException e) {
			System.err.println("Error writing line to file!!");
			System.exit(1);
		}
	}
}