package taskManager.util;

public class Message implements MessageInterface{

	private String msg;
	
	/*
	 constructor
	*/
	public Message(){
		MyLogger.getInstance().printToStdout(4,"Constructor: Message (empty)");	
	}
	
	@Override
	/*
	@param: string to set as message
	@return: NONE
	*/
	public void setMessage(String ln) {
		MyLogger.getInstance().printToStdout(3,"Method: setMessage Class: Message");
		this.msg = ln;
	}

	@Override
	/*
	@param: NONE
	@return: message string
	*/
	public String getMessage() {
		MyLogger.getInstance().printToStdout(3,"Method: getMessage Class: Message");
		return this.msg;
	}
}
