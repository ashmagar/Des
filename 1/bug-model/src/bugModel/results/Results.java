package bugModel.results;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import bugModel.bug.Movement;
import bugModel.util.Debug;

public class Results implements Display, FileLog, StoreMovements{

		private Vector<Movement> V = new Vector<Movement>();
		
		public Results() {
			Debug.printToStdout(4," [Default Constructor of Results.java called]");	
		}

		
		
		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			for(Movement m:this.V)
			{
				result.append((m.getIntMovement()));
			}
			return result.toString();
		}



		public void addInResult(Movement movement) {
			Debug.printToStdout(3," [Method addInResult() from Results.java called]");
			V.add(movement);
			
			Debug.printToStdout(2," [Entry added to result data structure]");
			// TODO Auto-generated method stub
			
		}

		public void removeFromResult() {
			// TODO Auto-generated method stub
			Debug.printToStdout(3," [Method RemoveFromResult() from Results.java called]");
			if(V.size() == 0){
				V.add(new Movement(0));
			}
			else if(V.elementAt(0).getIntMovement() != 0){
				V.removeElementAt(V.size()-1);
			}
			
			Debug.printToStdout(2," [Entry removed from result data structure]");
		}
		
		public void printToScreen()
		{
			Debug.printToStdout(3," [Method printToScreen() from Results.java called]");
			if (Debug.getDebugValue()==1)
			{ 
				for(Movement m:this.V)
				{
					System.out.print(m.getIntMovement());
				}
			}
		}

		
		public void printToFile(String Fname)
		{
			Debug.printToStdout(3," [Method printToFile() from Results.java called]");
			BufferedWriter out = null;
			File myFile = new File(Fname);
			try {
			
				out = new BufferedWriter(new FileWriter(myFile));
				for(Movement m:this.V)
				{
					out.write(String.valueOf(m.getIntMovement()));
				}
				out.close();
			
			} 
			 catch(FileNotFoundException e1){
					System.err.println("File not found");
					System.exit(1);
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Unexception exception occurred while writing to file");
				System.exit(1);
			}
			finally{
				
			}
		}
		
} // end public class Results


