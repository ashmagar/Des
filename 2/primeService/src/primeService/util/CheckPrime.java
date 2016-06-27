package primeService.util;

public class CheckPrime {

	public static boolean checkPrime(int n)
	{
		Debug.printToStdout(3," [method checkPrime of CheckPrime.java called]");
		for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}
