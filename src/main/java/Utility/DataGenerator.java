package Utility;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * This is use to Generates all types of data like numeric, string, alphabetical string, 
 * alphanumeric string, password and email
 */
public final class DataGenerator {
	
	/* Empty private constructor as its a utility method
	 * See: http://checkstyle.sourceforge.net/config_design.html#HideUtilityClassConstructor
	 */
	protected DataGenerator() {
	}
	
	/**
	 * It generates email address based on system time stamp
	 * @return email address
	 */
	public static String generateEmailAddress() {
		long threadId = Thread.currentThread().getId();
		String timeStamp = Constants.EMPTY + System.currentTimeMillis() + threadId / Constants.THREAD_SLEEP_1000;
		String email = "user_" + timeStamp + "@yopmail.com";
		return email;
	}
	
	/**
	 * It generates numeric string of required/passed digit
	 * @param digit
	 * @return
	 */
	public static String generateNumberOfDigit(int digit) {
		String randomNumber = RandomStringUtils.random(digit, false, true);
		if(randomNumber.charAt(0) == '0'){
			randomNumber = "2" + randomNumber.substring(1,randomNumber.length());			
		}
		return randomNumber;
	}
	
	/**
	 * It generates password with special characters
	 * @return
	 */
	public static String generatePassword() {
		String password = "@" + RandomStringUtils.random(10, true, true);
		return password; 
	}

	/**
	 * It generates word of required/passed digit
	 * @param digit
	 * @return
	 */
	public static String generateWordOfDigit(int digit) {
		String randomWord = RandomStringUtils.random(digit, true, false);
		return randomWord;
	}
	
	/**
	 * Generates random alpha numeric string of 10 bits
	 * @return
	 */
	public static String generateRandomString() {
		String randomString = RandomStringUtils.random(10, true, true);
		return randomString; 
	}
	
	/**
	 * Generates Brazilian CPF(National ID) numbers. 
	 * @param formatted
	 * @return
	 */
	public String generateCPF(Boolean formatted) {
	   	StringBuilder buf = new StringBuilder();
	   	ArrayList<Integer> digits = new ArrayList<Integer>();
	   	Random random = new Random();
	   	final int maxLoop = 9;
		    for (int i = 0; i < maxLoop; i++) {
		    	digits.add(random.nextInt(maxLoop));
		    }  
		    addDigit(digits);
		    addDigit(digits);
		
		    for (int i = 0; i < digits.size(); i++) {
		    	buf.append(digits.get(i));
		    }
		    
		    final int formate = 11;
		    if (formatted) {
		        buf.insert(3, '.');
				buf.insert(7, '.');
				buf.insert(formate, '-');
		    }
		    return buf.toString();
	   }
	   
	 /**
	 * use to generate type for generateCPF
	 * @return
	 */
	 public Class<String> getGeneratedType() {
	       return String.class;
	 }
	   
	  /**
	   * add digit for generateCPF
	   * @param digits
	   */
	  private static void addDigit(ArrayList<Integer> digits){
	   	int sum = 0;
	   	for (int i = 0, j = digits.size() + 1; i < digits.size(); i++, j--) {
	   		sum += digits.get(i) * j;
	   	}
	   	final int maxLoop = 11;
	   	digits.add((sum % maxLoop < 2) ? 0 : maxLoop - (sum % maxLoop));
	   }
}
