package Utility;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;


public final class CommonUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);
	
	/* Empty private constructor as its a utility method
	 * See: http://checkstyle.sourceforge.net/config_design.html#HideUtilityClassConstructor
	 */
	private CommonUtil() {
	}
	 
	/**
     * Escape special characters in jbehave .story file.
     * @param strVal
     * @return
     */
    public static String escapeSpecialChars(String strVal) {
    	//’ ' ’
    	LOGGER.info("CommonUtil.escapeSpecialChars strVal:" + strVal);
    	String  strValSub = strVal;
    	if (strVal.contains("’")) {
    		strValSub =  strVal.replace("'", "’");
    	} else if (strVal.contains("\u2019")) {
    		strValSub = strVal.replace("\u2019", "’");
    	} else if (strVal.contains("\\u2019")) {
    		strValSub = strVal.replace("\\u2019", "’");
    	}
    	LOGGER.info("CommonUtil.escapeSpecialChars strValSub:" + strValSub);
    	return strValSub;
    }

 	/**
 	 * Gets the computer name and writes to the specific temp properties file.
 	 * @return the machine name as "ComputerName"
 	 */
 	public static String getComputerName() {
 		String hostname = "";

		try {
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    hostname = addr.getHostName();
		    LOGGER.info("Test is running on computer:" + hostname);
		} catch (UnknownHostException ex) {
		   LOGGER.info("Computer Name can not be resolved.");
		}
 	    return hostname;	
 	}
 	
    /**
     * Repeats the input string the number of times specified by the string argument repeat.
     * @param inStr
     * @param repeat
     * @return a string that repeats the input string the number of times specified by the argument repeat or null if it fails to convert string to int.
     */
 	public static String repeatString(String inStr, String repeat) {
 		int counter = 0;
 		
 		try {
		      counter = Integer.parseInt(repeat);  
		} catch (NumberFormatException nfe) {
			LOGGER.error("Failed to convert string with value \"" + repeat + "\" to an int data type.");
			return null;
		}
 		
 		 return repeatString(inStr, counter);
 	}
 	
    /**
     * Repeats the input string the number of times specified by the int argument repeat.
     * @param inStr
     * @param repeat
     * @return a string that repeats the input string the number of times specified by the argument repeat.
     */
 	public static String repeatString(String inStr, int repeat) {
		return StringUtils.repeat(inStr, repeat);
 	}
 	
 	/**
     * Escape extra spaces in the string and replace with one whitespace
     * @param strVal
     * @return String
     */
    public static String escapeExtraSpaces(String strVal) {
    	return strVal.replaceAll("\\s+", " ");
    }
    
    /**
	 * Wait for certain time period in milliseconds.
	 * @param milli
	 */
	public  static void waitFoMilliSecs(long milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			LOGGER.info("exception happened - here's what I know: \n", e);
			Thread.currentThread().interrupt();
		}
	}
}

