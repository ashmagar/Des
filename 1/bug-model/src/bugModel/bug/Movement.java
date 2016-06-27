package bugModel.bug;

import bugModel.util.Debug;

public class Movement {

	private int intMovement;
	public Movement(int i) {
		// TODO Auto-generated constructor stub
		Debug.printToStdout(4," [Constructor of Movement.java called]");
		intMovement = i;
	}
	
	public int getIntMovement()
	{
		Debug.printToStdout(3," [Method getIntMovement() from Movement.java called]");
		return this.intMovement;
	}

}
