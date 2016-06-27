package wordCount.treesForStrings;

public class MyNodeValues {

	private int wordCount;
	private int noOfChars;
	/*
	 * Constructor
	@param: wordCount to be set for current node
			number of characters to be set for current node
	@return: None
	*/
	public MyNodeValues(int wordCountIn,int noOfCharsIn)
	{
		wordCount  = wordCountIn;
		noOfChars = noOfCharsIn;
	}
	
	/*
	@param: None
	@return: Returns wordCount of current node object
	*/
	public int getWordCount()
	{
		return this.wordCount;
	}
	
	/*
	@param: None
	@return: Returns number of characters of current node object
	*/
	public int getTotNoOfChars()
	{
		return this.noOfChars;
	}
	
	/*
	@param: Updated wordCount in case of repeated words
	@return: None
	*/
	public void setWordCount(int wordCountUpdated)
	{
		this.wordCount = wordCountUpdated;
	}
	
	/*
	@param: Updated number of characters in case of repeated words
	@return: None
	*/
	public void setTotNoOfChars(int noOfCharsUpdated)
	{
		this.noOfChars = noOfCharsUpdated;
	}
}
