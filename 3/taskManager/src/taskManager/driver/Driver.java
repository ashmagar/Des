package taskManager.driver;

import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;
import taskManager.observers.PerformanceTab;
import taskManager.observers.PerformanceTabFilterImpl;
import taskManager.observers.ProcessesTab;
import taskManager.observers.ProcessesTabFilterImpl;
import taskManager.observers.UserTabFilterImpl;
import taskManager.observers.UsersTab;
import taskManager.subject.DashBoardSubject;
import taskManager.subject.Subject;
import taskManager.util.FileProcessor;
import taskManager.util.MyLogger;

public class Driver {

	public static void main(String [] args){
		
		if(args.length!=3){
			System.err.println("Please enter valid number of arguments"); System.exit(0); 
		}
		
		//set file names
		FileProcessor.setFileName(args[0],args[1]);
		
		//set debug value
		try {
			MyLogger.getInstance().setDebugValue(args[2]);
		} catch (NumberFormatException e) {
			System.err.println("Please Enter valid integer NUMBER for debug level");
		}

		//instantiate subject
		Subject taskManager = new DashBoardSubject();
		
		//instantiate observers and respected filters
		DashboardFilter user_filter = new UserTabFilterImpl();
		Observer user_tab = new UsersTab();
		
		DashboardFilter performance_filter = new PerformanceTabFilterImpl();
		Observer performance_tab = new PerformanceTab();
		
		DashboardFilter processes_filter = new ProcessesTabFilterImpl();
		Observer processes_tab = new ProcessesTab();
		
		//register observers
		taskManager.registerObs(user_tab,user_filter);
		taskManager.registerObs(processes_tab,processes_filter);
		taskManager.registerObs(performance_tab,performance_filter);
		
		//start task manager
		((DashBoardSubject) taskManager).startTaskManager();
	}
}
