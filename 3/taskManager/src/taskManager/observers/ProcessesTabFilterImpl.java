package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

public class ProcessesTabFilterImpl implements DashboardFilter{
	
	/*
	 constructor
	*/
	public ProcessesTabFilterImpl(){
		MyLogger.getInstance().printToStdout(4,"Constructor: ProcessesTabFilterImpl (empty)");
	}

	/*
	@param: entireLine, line to be filtered
	@return: whether observer require certain line or not, boolean value
	*/
	public boolean condition(String entireLine) {
		MyLogger.getInstance().printToStdout(3,"Method:condition Class: ProcessesTabFilterImpl");
		if(entireLine.contains("Processes")) {
			return true;
		} else {
			return false;
		}
	}
}
