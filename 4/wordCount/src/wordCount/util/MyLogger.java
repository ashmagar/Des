package wordCount.util;

//singleton class
public class MyLogger {

	private volatile static MyLogger logUniqueInstance;
	private int DEBUG_VALUE;

	//private constructor
	private MyLogger() {}
	
	/*
	static method to create unique instance, with double locking
	@param: NONE
	@return: NONE
	*/
	public static MyLogger getInstance() {
		if(logUniqueInstance == null) {
			synchronized (MyLogger.class) {
				if(logUniqueInstance == null) {
					logUniqueInstance = new MyLogger();
				}
			}
		}
		return logUniqueInstance;
	}
	
	/*
	@param: NONE
	@return: debug value to be set
	*/
	public void setDebugValue(String val) throws NumberFormatException
	{
		DEBUG_VALUE = Integer.parseInt(val);
		if(DEBUG_VALUE > 4 || DEBUG_VALUE < 0){
			System.err.println("Please enter correct debug level !!");
			System.exit(0);
		}
	}
	
	/*
	@param: level,debugMessage
	@return: NONE
	*/
	public void printToStdout(int level,String debugMessage){
		
		if(level==DEBUG_VALUE) {
			System.out.println(debugMessage);
		}
	}
	
	/*
	@param: NONE
	@return: current debug value
	*/
	public int getDebugValue()
	{
		return DEBUG_VALUE;
	}

}