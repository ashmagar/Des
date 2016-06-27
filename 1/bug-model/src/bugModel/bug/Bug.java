package bugModel.bug;

import bugModel.results.StoreMovements;
import bugModel.util.Debug;

public class Bug implements AllDirectionsBug {

    public String toString() {
	String retValue = "\n I am a 2015 Volkswagen Bettle Convertible \n";
	return retValue;
    }

	private StoreMovements ResObj;
	public Bug(StoreMovements res)
	{
		ResObj = res;
	}
	
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		Debug.printToStdout(3," [Method moveRight() from Bug.java called]");
		ResObj.addInResult(new Movement(1));
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		Debug.printToStdout(3," [Method moveLeft() from Bug.java called]");
		ResObj.addInResult(new Movement(2));
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		Debug.printToStdout(3," [Method moveUp() from Bug.java called]");
		ResObj.addInResult(new Movement(3));
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		Debug.printToStdout(3," [Method moveDown() from Bug.java called]");
		ResObj.addInResult(new Movement(4));
	}

	@Override
	public void undoPrev() {
		// TODO Auto-generated method stub
		Debug.printToStdout(3," [Method undoPrev() from Bug.java called]");
		ResObj.removeFromResult();
	}

}