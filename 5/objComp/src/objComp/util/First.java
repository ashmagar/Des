package objComp.util;

public class First{
	
	private int IntValue;
	private String StringValue;
	//private float FloatValue;
	
	/*
	 constructor
	*/
	public First()
	{
		MyLogger.getInstance().printToStdout(4,"Constructor: First");	
	}
	
	/*
	@param: iIn, input parameter to be set to int value in private member of class
	@return: NONE
	*/
	public void setIntValue(int iIn)
	{
		MyLogger.getInstance().printToStdout(3,"Method: setIntValue, Class: First");
		this.IntValue = iIn;
	}
	
	//	check for float, to check whether code in PopulateObjects is generic
	/*
	@param: fIn, input parameter to be set to float value in private member of class
	@return: NONE
	*/
/* 	public void setFloatValue(float fIn)
	{
		MyLogger.getInstance().printToStdout(3,"Method: setFloatValue, Class: First");
		this.FloatValue = fIn;
	}
*/
	/*
	@param: sIn, input parameter to be set to String value in private member of class
	@return: NONE
	*/
	public void setStringValue(String sIn)
	{
		MyLogger.getInstance().printToStdout(3,"Method: setStringValue, Class: First");
		this.StringValue = sIn;
	}
	

	/*
	 * overridden method
	@param: Object f, input parameter to be checked whether it is same reference as the calling object
	@return: true or false depending on result
	*/
	@Override
	public boolean equals(Object f)
	{
		MyLogger.getInstance().printToStdout(1,"Method: equals, Class: First, Overridden method");
		if(f instanceof First){
	
		    try{
		    	if(((First)f).IntValue == this.IntValue && ((First)f).StringValue.equals(this.StringValue))
		    		return true;
		    }
		    catch (NullPointerException e) {
		    	System.err.println("Null pointer exception occurred, First.java: equals() - string might be null");
		    	System.exit(1);
		    }
		}		
		return false;
	}
	
	/*
	 * Overridden method
	@param: NONE
	@return: hash value for particular bucket
	*/
	@Override
	public int hashCode()
	{
		MyLogger.getInstance().printToStdout(1,"Method: hashcode, Class: First, Overridden method");
		 final int prime = 31;
		    int result = 1;
		    try{
		    	result = (int) (prime * result + (this.IntValue * this.StringValue.length() ) % 10 ) ;
		    } catch (NullPointerException e) {
		    	System.err.println("Null pointer exception occurred, First.java: hashcode() - string might be null");
		    	System.exit(1);
		    }
		    return result;
	}
}