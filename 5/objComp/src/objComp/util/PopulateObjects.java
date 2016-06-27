package objComp.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import objComp.fileOperations.FileProcessor;

public class PopulateObjects{
	
	private Map<Object, Integer> objectMap = new HashMap<Object,Integer>();
	@SuppressWarnings("rawtypes")
	private Map<String, Class> classMap = new HashMap<String, Class>();
	private String lineClassname,lineParam1,lineParam2;
	private FileProcessor fp = null;
	
	/*
	 constructor
	*/
    public PopulateObjects()
    {
    	MyLogger.getInstance().printToStdout(4,"Constructor: PopulateObjects");
    	setClassMapping();
    }
	
    /*
	@param: NONE
	@return: NONE
	*/
    public void deserObjects()
	{
    	MyLogger.getInstance().printToStdout(3,"Method: deserObjects, Class: PopulateObjects");
		fp = new FileProcessor("Input Mode");
		while(true)	{
			lineClassname = fp.readLineFromFile();
			if(lineClassname==null) break;
			lineParam1 = fp.readLineFromFile();
			if(lineParam1==null) break;
			lineParam2 = fp.readLineFromFile();
			if(lineParam2 == null) break;
			
			if(!lineClassname.contains("fqn") || !lineParam1.contains("type") || !lineParam2.contains("type") ) 
			{
				/*System.err.println("Input format is wrong for specific assignment"); System.exit(1);*/
				System.err.println("Panic!! input format might be wrong, ignoring current entry");
				continue;
			}
			
			lineClassname = lineClassname.substring(lineClassname.indexOf(":")+1);
		    Object obj = null;
		    @SuppressWarnings("rawtypes")
			Class cls = null;
		    
			try {
				cls = Class.forName(lineClassname);
				obj = cls.newInstance();
			} catch (ClassNotFoundException e1) {
				System.err.println("Class not found, exception occurred");
				System.exit(1);
			} catch (InstantiationException | IllegalAccessException e) {
				System.err.println("Illegal access exception occurred, object might not be instantiated");
				System.exit(1);
			} 
			
			try{
				Object result[] = new Object[2];
				result[0] = invokeMethod(lineParam1,obj,cls);
				result[1] = invokeMethod(lineParam2,obj,cls);
			} catch (ArrayIndexOutOfBoundsException e)
			{
				System.err.println("Array index out of bound!!");
				System.exit(1);
			}
		    
		    // add entry to hashmap
		    addToHashMap(obj);
		}
		
	}
	
    /*
	@param: NONE
	@return: NONE
	*/
    private void setClassMapping(){
    	MyLogger.getInstance().printToStdout(3,"Method: setClassMapping, Class: PopulateObjects");
		this.classMap.put("int", Integer.TYPE);
		this.classMap.put("Integer", Integer.class);
		this.classMap.put("double", Double.TYPE);
		this.classMap.put("double", Double.class);
		this.classMap.put("String", String.class);
		this.classMap.put("float", Float.TYPE);
	}

    /*
	@param: String lineParam is line which contains type, name and value of parameter
			Object o is object on which methode is to be invoked
			Class c is class of which method is to be invoked
	@return: result object
	*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object invokeMethod(String lineParam,Object o,Class c)
	{
		MyLogger.getInstance().printToStdout(3,"Method: invokeMethod, Class: PopulateObjects");
		String[] splitParam = lineParam.split(", ");
		
		try{
			Class[] signature = new Class[1];
			signature[0] = classMap.get(splitParam[0].substring(splitParam[0].indexOf("=")+1));
			String methodName = "set" + splitParam[1].substring(splitParam[1].indexOf("=")+1);
			Object[] params = new Object[1];
			params[0] = getParam(signature[0],splitParam[2].substring(splitParam[2].indexOf("=")+1));
		
			Method meth = null;
			Object res = null;
			try {
				meth = c.getMethod(methodName,signature);
				res = meth.invoke(o,params);
			} catch (NoSuchMethodException | SecurityException e) {
				System.err.println("No such method in particular class");
				System.exit(1);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				System.err.println("Argument or method might be illegal, expception occurred");
				System.exit(1);
			}
			return res;
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Array index out of bound!!");
			System.exit(1);
		}
		return null;
	    
	}
	
	/*
	@param: type of input param, value of param
	@return: Object with value
	*/
	private Object getParam(@SuppressWarnings("rawtypes") Class type, String value)
	{
		MyLogger.getInstance().printToStdout(3,"Method: getParam, Class: PopulateObjects");
		if(type == Integer.TYPE) {
			return Integer.parseInt(value);
		} else if(type == Integer.class) {
			return new Integer(value);
		} else if(type == String.class) {
			return value;
		} else if(type == Double.class) {
			return new Double(value);
		} else if(type == Double.TYPE) {
			return Double.parseDouble(value);
		} else if(type == Float.TYPE) {
				return new Float(Float.parseFloat(value));
		} 

		return null;
	}
	
	/*
	@param: Object to be added to hashmap
	@return: NONE
	*/
	private void addToHashMap(Object ob)
    {
		MyLogger.getInstance().printToStdout(3,"Method: addToHashMap, Class: PopulateObjects");
    	Object o = objectMap.get(ob);
		if (o == null)
		{
			objectMap.put(ob,1);
		}
		else
		{
			objectMap.put(ob,(int)(o)+1);
		}	
    }
		
	/*
	@param: NONE
	@return: NONE
	*/
	public void printResult()
	{
		MyLogger.getInstance().printToStdout(3,"Method: printResult, Class: PopulateObjects");
		Object ob = null;
		int count = 0;
		int nonDupFirstObjCount = 0;
		int firstObjCount = 0;
		int nonDupSecondObjCount = 0;
		int secondObjCount = 0;
		
		for(Entry<Object, Integer> entry : objectMap.entrySet()){
		    ob = entry.getKey();
		    count = entry.getValue();
		    if(ob instanceof First)
		    {
		    	firstObjCount += count;
		    	nonDupFirstObjCount++;
		    }
		    else if(ob instanceof Second)
		    {
		    	secondObjCount += count;
		    	nonDupSecondObjCount++;
		    }
		}
		
		MyLogger.getInstance().printToStdout(0,"Number of non-duplicate First objects: " + nonDupFirstObjCount);
		MyLogger.getInstance().printToStdout(0,"Number of First objects: " + firstObjCount);
		MyLogger.getInstance().printToStdout(0,"Number of non-duplicate Second objects: " + nonDupSecondObjCount);
		MyLogger.getInstance().printToStdout(0,"Number of Second objects: " + secondObjCount);		
	}
}