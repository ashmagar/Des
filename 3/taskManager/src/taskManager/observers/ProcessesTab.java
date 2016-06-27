package taskManager.observers;

import java.util.ArrayList;
import java.util.List;

import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;
import taskManager.util.MessageInterface;
import taskManager.util.MyLogger;

public class ProcessesTab implements Observer, DisplayFile{
	private String line;
	private List<String> listOfLines;
	private FileProcessor fp;
	
	/*
	constructor
	*/
	public ProcessesTab() {
		MyLogger.getInstance().printToStdout(4,"Constructor: ProcessesTab");
		this.listOfLines = new ArrayList<String>();
		fp = new FileProcessor();
	}
	
	@Override
	/*
	@param: msg, object of Message class which carries message from subject
	@return: NONE
	*/
	public void update(MessageInterface msg) {
		MyLogger.getInstance().printToStdout(3,"Method:update Class: ProcessesTab");
		line = msg.getMessage();
		String[] processes = line.split("-");
		String[] processDetails;
		String formattedLine;
		for(int i=0;i<processes.length;i++)	{
			processDetails = processes[i].split(":");
			try{
				if(i==0) {
					formattedLine = String.format("%5s %-15s %-8s %4s %4s",processDetails[1],processDetails[2],processDetails[3],processDetails[4],processDetails[5]);
					listOfLines.add(formattedLine);
				} else {
					formattedLine = String.format("%5s %-15s %-8s %4s %4s",processDetails[0],processDetails[1],processDetails[2],processDetails[3],processDetails[4]);
					listOfLines.add(formattedLine);
				}
			}catch (ArrayIndexOutOfBoundsException e){
				System.err.println("Incorrect input file, array index out of bound");
				System.exit(1);
			}
		}
		listOfLines.add("\n");
		display();
	}

	@Override
	/*
	@param: NONE
	@return: NONE
	*/
	public void display() {
		MyLogger.getInstance().printToStdout(3,"Method:display Class: ProcessesTab");
		fp.writeToFile("---PROCESSES---");
		MyLogger.getInstance().printToStdout(1,"---PROCESSES---");
		String columns = String.format("%5s %-15s %-8s %s %s","PID","COMMAND","USER", "%CPU", "%MEM");
		fp.writeToFile(columns);
		for (String ln : listOfLines) {
			fp.writeToFile(ln);
			MyLogger.getInstance().printToStdout(1,ln);
		}
		listOfLines.clear();
	}
	
	@Override
	/*
	@param: NONE
	@return: name of observer
	*/
	public String myName() {
		MyLogger.getInstance().printToStdout(3,"Method:myName Class: ProcessesTab");
		return "Processes";
	}
}