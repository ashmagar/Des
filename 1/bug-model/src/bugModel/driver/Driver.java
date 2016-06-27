package bugModel.driver;
import bugModel.bug.AllDirectionsBug;
import bugModel.bug.Bug;
import bugModel.results.Display;
import bugModel.results.FileLog;
import bugModel.results.Results;
import bugModel.results.StoreMovements;
import bugModel.util.Debug;

public class Driver{

	public static void main(String args[]) {

		if(args.length < 2) {
			System.err.println("Please enter valid number of arguments\n");
			System.exit(1);
		}
		
		try {
			Debug.setDebugValue(args[0]);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.err.println("Please Enter valid integer NUMBER for debug level");
		}
		
		StoreMovements res = new Results();
		AllDirectionsBug b = new Bug(res);
		//  Display res = new Results();
		//  AllDirectionsBug b = new Bug(res);
	//	System.out.println(b);
		b.undoPrev();
		b.moveRight();
		b.moveLeft();
		b.moveUp();
		b.moveDown();
		b.moveRight();
		b.moveLeft();
		b.moveUp();
		b.moveDown();
		((Display)res).printToScreen();
		((FileLog)res).printToFile(args[1]);
		
//		System.out.println(res);
	
		// All test cases

	} // end main(...)

} // end public class Client

