package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

public class UserTabFilterImpl implements DashboardFilter{

	/*
	 constructor
	*/
	public UserTabFilterImpl(){
		MyLogger.getInstance().printToStdout(4,"Constructor: UserTabFilterImpl (empty)");
	}
	
	@Override
	/*
	@param: entireLine, line to be filtered
	@return: whether observer require certain line or not, boolean value
	*/
	public boolean condition(String entireLine) {
		MyLogger.getInstance().printToStdout(3,"Method:condition Class: UserTabFilterImpl");
		if(entireLine.contains("Users")) {
			return true;
		} else {
			return false;
		}
	}
}