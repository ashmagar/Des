package taskManager.observers;

import java.util.ArrayList;
import java.util.List;

import taskManager.display.DisplayFile;
import taskManager.util.FileProcessor;
import taskManager.util.MessageInterface;
import taskManager.util.MyLogger;

public class UsersTab implements Observer, DisplayFile{
	private String line;
	private List<String> listOfLines;
	FileProcessor fp;
	
	/*
	constructor 
	*/
	public UsersTab() {
		MyLogger.getInstance().printToStdout(4,"Constructor: UsersTab");
		this.listOfLines = new ArrayList<String>();
		fp = new FileProcessor();
	}
	
	@Override
	/*
	@param: msg, object of Message class which carries message from subject
	@return: NONE
	*/
	public void update(MessageInterface msg) {
		MyLogger.getInstance().printToStdout(3,"Method:update Class: UsersTab");
		line = msg.getMessage();
		String[] users = line.split("-");
		String[] userStatus;
		for(int i=0;i<users.length;i++)	{
			try{
			userStatus = users[i].split(":");
			if(i==0){
				listOfLines.add("User: " + userStatus[1] + "  Status: " + userStatus[2]);
			}
			else {
				listOfLines.add("User: " + userStatus[0] + "  Status: " + userStatus[1]);
			}
			}catch(ArrayIndexOutOfBoundsException e)
			{
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
		MyLogger.getInstance().printToStdout(3,"Method:display Class: UsersTab");
		fp.writeToFile("---USERS---");
		MyLogger.getInstance().printToStdout(1,"---USERS---");
		for (String ln : listOfLines) {
			fp.writeToFile(ln);
			MyLogger.getInstance().printToStdout(1,ln);
		}
		listOfLines.clear();
	}	

	/*
	@param: NONE
	@return: name of observer
	*/
	public String myName()
	{
		MyLogger.getInstance().printToStdout(3,"Method:myName Class: UsersTab");
		return "Users";
	}
}