package bugModel.util;

public class Debug {


		private static int DEBUG_VALUE;
		public static void printToStdout(int level,String debugMessage){
			
			if(level==DEBUG_VALUE)
			{
				System.out.println(debugMessage);
			}
		}
		
		public static void setDebugValue(String val) throws NumberFormatException
		{
			DEBUG_VALUE = Integer.parseInt(val);
		}
		
		public static int getDebugValue()
		{
			return DEBUG_VALUE;
		}


}
