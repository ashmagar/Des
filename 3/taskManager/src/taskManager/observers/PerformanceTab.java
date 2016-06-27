package taskManager.observers;

import java.util.ArrayList;
import java.util.List;

import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;
import taskManager.util.MessageInterface;
import taskManager.util.MyLogger;

//performance tab observer
public class PerformanceTab implements Observer, DisplayFile{

	private String line;
	private List<String> listOfLines;
	private FileProcessor fp;

	/*
	 constructor
	*/
	public PerformanceTab() {
		MyLogger.getInstance().printToStdout(4,"Constructor: PerformanceTab");
		this.listOfLines = new ArrayList<String>();
		fp = new FileProcessor();
	}
	
	@Override
	/*
	@param: msg, object of Message class which carries message from subject
	@return: NONE
	*/
	public void update(MessageInterface msg) {
		MyLogger.getInstance().printToStdout(3,"Method:update Class: PerformanceTab");
		line = msg.getMessage();
		String[] performance = line.split(":");
		try{
				listOfLines.add("Memory Total: "+performance[1]+"  Memory Used: "+performance[2]+"  Memory  Free: "+performance[3]+"  Memory  Cached: "+performance[4]+"\nCPU Idle: "+performance[5]+"  CPU User Level: "+performance[6]+"  CPU System Level: "+performance[7] + "\n");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Incorrect input file, array index out of bound");
			System.exit(1);
		}
		display();
	}

	@Override
	/*
	@param: NONE
	@return: NONE
	*/
	public void display() {
		MyLogger.getInstance().printToStdout(3,"Method:display Class: PerformanceTab");
		fp.writeToFile("---PERFORMANCE---");
		MyLogger.getInstance().printToStdout(1,"---PERFORMANCE---");
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
		MyLogger.getInstance().printToStdout(3,"Method:myName Class: PerformanceTab");
		return "Performance";
	}
}
