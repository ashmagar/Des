package taskManager.observers;

import taskManager.util.MessageInterface;

//Observer interface
public interface Observer {
	public void update(MessageInterface msg);
	public String myName();
}
