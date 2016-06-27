package taskManager.subject;

import java.util.HashMap;
import java.util.Map;

import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;
import taskManager.util.FileProcessor;
import taskManager.util.Message;
import taskManager.util.MessageInterface;
import taskManager.util.MyLogger;

public class DashBoardSubject implements Subject{
	
	private Map<Observer,DashboardFilter> obsTable;
	private String line;
	private MessageInterface msg;
	
	/*
	 constructor
	*/
	public DashBoardSubject() {
		MyLogger.getInstance().printToStdout(4,"Constructor: DashBoardSubject");
		obsTable = new HashMap<Observer,DashboardFilter>();
		msg = new Message();
	}
	
	@Override
	/*
	@param: o,f - observer and filter to be registered
	@return: NONE
	*/
	public void registerObs(Observer o, DashboardFilter f) {
		MyLogger.getInstance().printToStdout(3,"Metohd: registerObs Class: DashBoardSubject");
		obsTable.put(o,f);
		
	}

	@Override
	/*
	@param: o,f - observer to be removed
	@return: NONE
	*/
	public void removeObs(Observer o) {
		MyLogger.getInstance().printToStdout(3,"Metohd: removeObs Class: DashBoardSubject");
		obsTable.remove(o);
	}

	@Override
	/*
	@param: NONE
	@return: NONE
	*/
	public void notifyAllObs() {
		MyLogger.getInstance().printToStdout(3,"Metohd: notifyAllObs Class: DashBoardSubject");
		for (Map.Entry<Observer, DashboardFilter> entry : obsTable.entrySet()) {
			Observer o = entry.getKey();
			DashboardFilter f = entry.getValue();
			if(f.condition(line)){
				//msg.setMessage(parsedLine(line,o.myName()));
				msg.setMessage(line);
				o.update(msg);
			}
		}
	}
	
	/*
	@param: NONE
	@return: NONE
	*/
	public void startTaskManager()
	{
		MyLogger.getInstance().printToStdout(3,"Metohd: startTaskManager Class: DashBoardSubject");
		FileProcessor fp = new FileProcessor("Input Mode");
		FileProcessor fpout = new FileProcessor();
		fpout.flushFile();
		String entireLine;
		while(true)	{
			entireLine = fp.readLineFromFile();
			if(entireLine==null) break;
			fpout.writeToFile("---TAB(s) BEGIN---");
			MyLogger.getInstance().printToStdout(1,"---TAB(s) BEGIN---");
			String[] setOfLines = entireLine.split("\\*");
			for(int i=0; i< setOfLines.length; i++) {
				line = setOfLines[i];
				notifyAllObs();
			}
			fpout.writeToFile("---TAB(s) END---");
			MyLogger.getInstance().printToStdout(1,"---TAB(s) END---");
		}
	}
}
