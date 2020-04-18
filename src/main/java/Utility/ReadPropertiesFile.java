package Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public final class ReadPropertiesFile {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReadPropertiesFile.class);

	/**
	 * Empty private constructor as its a utility method
	 * See: http://checkstyle.sourceforge.net/config_design.html#HideUtilityClassConstructor
	 */
	private ReadPropertiesFile() {
	}
	/**
	 * Load a properties file by passing in the fileName.
	 * @param propFileName
	 * @return Properties
	 * @throws Exception
	 */
	private static Properties loadPropertiesFile(final String propFileName) {
		// create and load default properties
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(propFileName);
			prop.load(input);
			input.close();
		} catch (IOException ex) {
//			LOGGER.error("Cannot open properties file: " + propFileName + " exception: \n" + ex);
		} finally {
	        if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					LOGGER.error("loadPropertiesFile(): \n" + e);
				}
	        }
	    }

		return prop;
	}

	/**
	 * Based on the key get the Value from the environment.properties file.
	 *
	 * @param key
	 * @return
	 */
	public static String getEnvironmentProperty(String key) {
		String value = null;
		String environment = ReadSystemVariables.getEnvironment();
		List<String> results = new ArrayList<String>();
		File[] files = new File(Constants.TEST_RESOURCES_CONFIG + environment + "/").listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null.
		for (File file : files) {
		    if (file.isFile()) {
		    	if (!file.getName().startsWith("locale") && !file.getName().startsWith("temp")) {
		    		results.add(file.getPath());
		    //		results.add(Constants.TEST_RESOURCES_CONFIG + "localecodes.properties");
		    //		results.add(Constants.TEST_RESOURCES_CONFIG + "shippingAddress.properties");
		    	}
		    }
		}

		//Properties localeProp = loadPropertiesFile(Constants.TEST_RESOURCES_CONFIG + "locale.properties");
		Properties prop = loadPropertiesFile(Constants.TEST_RESOURCES_CONFIG + environment + "/environment.properties");



		value = prop.getProperty(key);
		if (value == null || Constants.EMPTY.equals(value)) {
		//	value = localeProp.getProperty(key);
			if (value == null || Constants.EMPTY.equals(value)) {
				int count = 0;
				while (count < results.size()) {
					Properties searchAllProp = loadPropertiesFile(results.get(count));
					value = searchAllProp.getProperty(key);
					if (value != null) {
						break;
					}
					count++;
				}
			}

			if (value == null || Constants.EMPTY.equals(value)) {
			//	localeProp = loadPropertiesFile(Constants.TEST_RESOURCES_CONFIG + "locale.properties");
		//		value = localeProp.getProperty(key);
			}

			if (value == null || Constants.EMPTY.equals(value)) {
				Properties headerProp = loadPropertiesFile(Constants.TEST_RESOURCES_CONFIG + "commonHeader.properties");
				value = headerProp.getProperty(key);
			}
		}
		return value;
	}

	/**
	 * Get value for the key from the given properties file. Filename is the complete pathname.
	 * @parameter key
	 * @parameter completeFileName
	 * return value
	 * **/
	public static String getPropertyValueFromFile(String key, String completeFileName) {

			Properties prop = loadPropertiesFile(completeFileName);
			LOGGER.info("retrieving key <" + key + "> and value <" + prop.getProperty(key) + ">");
			return prop.getProperty(key);

	}





	public static void writeToProperties(String key, String value, String completeFileName) {
		Properties prop = loadPropertiesFile(completeFileName);		
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(completeFileName);
			prop.setProperty(key, value);
			prop.store(out, null);
			out.close();
		} catch (FileNotFoundException e) {
			LOGGER.debug("FileNotFoundException: Error setting the value from properties file for key" + key);
		} catch (IOException io) {
			LOGGER.error("IOException: Error setting the value from properties file for key" + key + " exception: \n" + io);
		} finally {
	        if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					LOGGER.error("writeToProperties(): \n" + e);
				}
	        }
	    }

		LOGGER.info("setting key <" + key + "> and value <" + value + ">");		
	}
	
	
	public static String getDBQueryFromPropertyFile(String key) {
		String filepath = Constants.TEST_RESOURCES_CONFIG + ReadSystemVariables.getEnvironment() + "/" + Constants.DBQUERYFILE_IDENTIFIER + ".properties";
		return getPropertyValueFromFile(key, filepath);
		
	}
	
	public static String getDBConfigValueFromPropertyFile(String key) {
		String filepath = Constants.TEST_RESOURCES_CONFIG + ReadSystemVariables.getEnvironment() + "/" + Constants.DBCONFIGFILE_IDENTIFIER + ".properties";
		return getPropertyValueFromFile(key, filepath);
	}
}

