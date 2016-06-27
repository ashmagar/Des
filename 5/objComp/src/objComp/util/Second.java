package objComp.util;

public class Second{
	private double DoubleValue;
	private int IntValue;

	/*
	 constructor
	*/
	public Second()
	{
		MyLogger.getInstance().printToStdout(4,"Constructor: Second");
	}
	
	/*
	@param: iIn, input parameter to be set to int value in private member of class
	@return: NONE
	*/
	public void setIntValue(int iIn)
	{
		MyLogger.getInstance().printToStdout(3,"Method: setIntValue, Class: Second");
		this.IntValue = iIn;
	}
	
	/*
	@param: dIn, input parameter to be set to Double value in private member of class
	@return: NONE
	*/
	public void setDoubleValue(Double dIn)
	{
		MyLogger.getInstance().printToStdout(3,"Method: setDoubleValue, Class: Second");
		this.DoubleValue = dIn;
	}
	
	/*
	 * overridden method
	@param: Object s, input parameter to be checked whether it is same reference as the calling object
	@return: true or false depending on result
	*/
	@Override
	public boolean equals(Object s)
	{
		MyLogger.getInstance().printToStdout(1,"Method: equals, Class: Second, Overridden method");
		if(s instanceof Second)
		{
			if ( ((Second) s).IntValue == this.IntValue && ((Second)s).DoubleValue == this.DoubleValue)
			return true;
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
		MyLogger.getInstance().printToStdout(1,"Method: hashcode, Class: Second, Overridden method");
		 final int prime = 31;
		    int result = 1;
		    result = (int) (prime * result + (this.IntValue * this.DoubleValue ) % 10 ) ;
		    return result;
	}
}