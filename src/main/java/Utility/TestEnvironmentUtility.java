package Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;

/**
 * This is a utility class that will populate a file the TestEnvironment.properties file with environment specific data
 * such as machine name, browser type, user name etc, which will be needed when updating Jira.
 *
 */
public class TestEnvironmentUtility {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestEnvironmentUtility.class);
	// File path of where the file is located.
	private static final String FILEPATH = Constants.TEST_RESOURCES_CONFIG + ReadSystemVariables.getEnvironment() + "/TestEnvironment.properties";

	/**
	 * Constructor:  flushes file for the specified filePath
	 */
	public TestEnvironmentUtility() {
		FileUtil.flushFile(FILEPATH);
	}
	
	/**
	 * Return the computer name when the test is run.
	 * @return String
	 */
	public String getComputerName() {
		String computerName = null;
		java.net.InetAddress localMachine;
		try {
			localMachine = java.net.InetAddress.getLocalHost();
			computerName =  localMachine.getHostName();
			LOGGER.info("TestEnvironmentUtility(): Hostname of local machine/computerName: " + computerName);
			FileUtil.writeToFile(FILEPATH, "computerName", computerName);
			return computerName;
		} catch (UnknownHostException e) {
			LOGGER.error("Error cannot read machine name maybe on UNIX machine.", e);
		}
		return computerName;
	}
	
	/**
	 * Return the user who ran the test.
	 * @return String
	 */
	public String getUserName() {
		String userName = System.getProperty("user.name"); 
		LOGGER.info("TestEnvironmentUtility(): userName: " + userName);
		FileUtil.writeToFile(FILEPATH, "userName", userName);
		return userName;
	}
	
	/**
	 * Return the browser type that the test used.
	 * @return String
	 */
	public String getBrowserType() {
		String browser = System.getProperty("browser"); 
		LOGGER.info("TestEnvironmentUtility(): browserType: " + browser);
		FileUtil.writeToFile(FILEPATH, "browserType", browser);
		return browser;
	}

}
