package taskManager.subject;

import taskManager.filter.DashboardFilter;
import taskManager.observers.Observer;

//Subject interface
public interface Subject {
	public void registerObs(taskManager.observers.Observer observer,DashboardFilter f);
	public void removeObs(Observer o);
	public void notifyAllObs();
}
