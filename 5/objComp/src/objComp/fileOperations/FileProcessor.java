package objComp.fileOperations;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import objComp.util.MyLogger;

public class FileProcessor {

	private String line = null;
	private static String inFilename;
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
	@param: input,output - input and output file names, static method
	@return: NONE
	*/
	public static void setFileName(String input)
	{
		MyLogger.getInstance().printToStdout(3,"Method: setFileName Class: FileProcessor; Static Method");
		inFilename = input;
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
	@return: line read from file (string)
	*/
	public String readLineFromFile()
	{
		MyLogger.getInstance().printToStdout(3,"Method: readLineFromFile Class: FileProcessor");
		line=null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			System.err.println("Error reading line from file!!");
			e.printStackTrace();
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
}