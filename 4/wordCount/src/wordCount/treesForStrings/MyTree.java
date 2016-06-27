package wordCount.treesForStrings;

import java.util.TreeMap;

import wordCount.util.MyLogger;
import wordCount.visitors.Visitor;

public class MyTree {

	// Create a tree, TreeMap
    TreeMap<String, MyNodeValues> tm = new TreeMap<String, MyNodeValues>();
    
    /*
	@param: Word to be added to Tree
	@return: None
	*/
    //populate tree
    public void addToTree(String word)
    {
    	MyNodeValues currentVal = tm.get(word);
    	if(currentVal != null)
    	{
    		currentVal.setWordCount(currentVal.getWordCount()+1);
    		currentVal.setTotNoOfChars(currentVal.getTotNoOfChars()+word.length());
    	}
    	else
    	{
			if(!(word.contains(" ")) && word.length()!=0)
    		tm.put(word, new MyNodeValues(1,word.length()));
    	}
    }
    
    /*
	@param: None
	@return: Tree data structure which is used to store words
	*/
    //Retrieve tree
    public TreeMap<String, MyNodeValues> getTree()
    {
		MyLogger.getInstance().printToStdout(3,"Method: getTree <- MyTree.java");
    	return tm;
    }
    
    /*
    Accept method
	@param: Visitor object
	@return: None
	*/
	public void accept(Visitor visitor)
	{
		MyLogger.getInstance().printToStdout(3,"Method: Accept <- MyTree.java");
		visitor.visit(this);
	}
}
