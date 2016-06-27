package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.util.MyLogger;

public class PerformanceTabFilterImpl implements DashboardFilter {
	
	/*
	 constructor
	*/
	public PerformanceTabFilterImpl()
	{
		MyLogger.getInstance().printToStdout(4,"Constructor: PerformanceTabFilterImpl (empty)");
	}
	
	/*
	@param: entireLine, line to be filtered
	@return: whether observer require certain line or not, boolean value
	*/
	public boolean condition(String entireLine) {
		MyLogger.getInstance().printToStdout(3,"Method:condition Class: PerformanceTabFilterImpl");
		if(entireLine.contains("Performance")) {
			return true;
		} else {
			return false;
		}
	}
}
