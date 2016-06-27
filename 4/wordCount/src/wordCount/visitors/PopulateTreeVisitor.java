package wordCount.visitors;

import wordCount.treesForStrings.MyTree;
import wordCount.util.FileProcessor;
import wordCount.util.MyLogger;


public class PopulateTreeVisitor implements Visitor
{

	/*
	@param: Tree object of MyTree class which contains tree data structure
			It is the tree to be populated
	@return: None
	*/
	@Override
	public void visit(MyTree myTree) {
		MyLogger.getInstance().printToStdout(3,"Visit Method: PopulateTreeVisitor");
		FileProcessor fp = new FileProcessor("Input Mode");
		String word;		//word to be added to tree
		while(true)	{
			word = fp.readLineFromFile();
			if(word==null) break;
			myTree.addToTree(word);
		}
	}
}