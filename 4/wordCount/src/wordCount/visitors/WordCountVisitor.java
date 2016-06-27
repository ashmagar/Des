package wordCount.visitors;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import wordCount.treesForStrings.MyNodeValues;
import wordCount.treesForStrings.MyTree;
import wordCount.util.FileProcessor;
import wordCount.util.MyLogger;

public class WordCountVisitor implements Visitor
{

	/*
	@param: Tree object of MyTree class which contains tree data structure
			It is tree to be extracted to count words
	@return: None
	*/
	@Override
	public void visit(MyTree myTree) {
		MyLogger.getInstance().printToStdout(3,"Visit Method: WordCountVisitor");
		//tree retrieval
		TreeMap<String, MyNodeValues> tm = myTree.getTree();
		int wordCount = 0;
		int uniqueWordsCount = 0;
		int charCount = 0;
		FileProcessor fpout = new FileProcessor();

		Set<Entry<String, MyNodeValues>> set = tm.entrySet();
	      // Get an iterator
	    Iterator<Entry<String, MyNodeValues>> i = set.iterator();
	      // Display elements
	    while(i.hasNext()) {
	    	 Entry<String, MyNodeValues> me = i.next();
	    	 wordCount += ((MyNodeValues) me.getValue()).getWordCount();
	         charCount += ((MyNodeValues) me.getValue()).getTotNoOfChars();
	        //temp file 
			//fpout.writeToFile((String) me.getKey() + " " + tempWC + " " + ((MyNodeValues) me.getValue()).getTotNoOfChars());
	    }
	    uniqueWordsCount = tm.size();
	    fpout.flushFile();
	    fpout.writeToFile("Total no of Words :" + wordCount );
	    fpout.writeToFile("Total no of Unique Words :" + uniqueWordsCount );
	    fpout.writeToFile("Total no of characters :" + charCount );
	}	
}