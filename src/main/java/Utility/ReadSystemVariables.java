package Utility;

import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;


public final class ReadSystemVariables {

	/**
	 * Empty private constructor as its a utility method
	 * See: http://checkstyle.sourceforge.net/config_design.html#HideUtilityClassConstructor
	 */
	private ReadSystemVariables() {
	}


	private static final Logger LOGGER = LoggerFactory.getLogger(ReadSystemVariables.class);

	/**
	 * Return the "env" value.
	 * @return String 
	 */
	public static String getEnvironment() {
		return System.getProperty("env", "stage");
	}
	
	/**
	 * Get value of "host" parameter from command line and return it.
	 * This parameter need to be passed in addition to "env" parameter. "env" parameter will identify the folder name from
	 * which property files needs to be accessed and "host" parameter will identify the environment in which scripts needs to
	 * be executed. "host" parameter will be replaced to command line variable passed instead of rest.host.uri in environment.properties
	 * file.
	 * @return
	 */
	public static String getHostName() {
		return System.getProperty("host", "stage");
	}
	
	/**
	 * Get value of "channel" parameter from command line and return it.
	 * This parameter need to be passed so that channel channel can be identified and replaced in uri.
	 * file.
	 * @return
	 */
	public static String getChannel() {
		return System.getProperty("channel", "web");
	}
	
	/**
	 * This method gets value of "cookie" parameter from command line and return cookie value. This
	 * parameter needs to be passed in addition to "cookie" parameter. "cookie"
	 * parameter will identify the node on which scripts need to execute.
	 * If this parameter not given at command line it will take default "0000" and 
	 * script will be run on randomly selected node if multiple nodes are available.
	 * 
	 * @return String
	 */
	public static String getCookieValue() {
		return System.getProperty("cookie", "0000");
	}
	
	
	/*
	 * Return the "story.filter" value. By default empty string
	 * @return String 
	 */
	public static String getStoryFilter() {
		return System.getProperty("story.filter", Constants.EMPTY);
	}
	
	/*
	 * Return the "retryCount" value. By default it will be 0.
	 * This will be helpful if user wants to run failed stories again.
	 * @return int
	 */
	public static int getretryCount() {
		return Integer.parseInt(System.getProperty("retryCount", "0"));
	}
	
	/**
	 * Return the "metaFilters" value. By default empty string
	 * @return String
	 */
	public static String getMetaFilters() {
		return System.getProperty("metaFilters", Constants.EMPTY);
	}
	
	/**
	 * Return the "browser". This will be used only by "web" tests, not to be confused with
	 * the browserName used by mobile. By default "firefox".
	 * @return String
	 */
	public static String getBrowserType() {
		return System.getProperty("browser", "firefox");
	}
	
	/*********** Appium settings ***********/
	/**
	 * Return the "platform", specifies which mobile OS platform to use. 
	 * This is needed to set the desired capabilities for use with Appium.
	 * Can be "Android" or "iOS"
	 * By default empty string.
	 * @return String
	 */
	public static String getAppiumPlatform() {
		return System.getProperty("platform", Constants.EMPTY);
	}
	
	/**
	 * Return the platformVersion, specifies which mobile OS version.
	 * This is needed to set the desired capabilities for use with Appium.
	 * eq: android has "4.4" or "7.1" for iOs.
	 * By default empty string.
	 * @return String
	 */
	public static String getAppiumPlatformVersion() {
		return System.getProperty("platformVersion", Constants.EMPTY);
	}
	
	/**
	 * Return "device", specifies the device type. This is needed to set the desired capabilities for use with Appium.
	 * @return String
	 */
	public static String getAppiumDevice() {
		return System.getProperty("device", Constants.EMPTY);
	}
	
	/**
	 * Return the "deviceName", specifies what kind of mobile device or emulator to use.
	 * This is needed to set the desired capabilities for use with Appium.
	 * for android can be "Android Emulator", for ios "iPhone Simulator", iPad "iPad Simulator".
	 * By default empty string.
	 * @return String
	 */
	public static String getAppiumDeviceName() {
		return System.getProperty("device.name", Constants.EMPTY);
	}
	
	/**
	 * Return the "browserName", specifies name of mobile web browser to automate. 
	 * Should be an empty string if automating an app instead.
	 * This is needed to set the desired capabilities for use with Appium. 
	 * eq: for android "Chrome" or for iOs "Safari".
	 * By default empty string.
	 * @return String
	 */
	public static String getAppiumBrowserName() {
		return System.getProperty("browserName", Constants.EMPTY);
	}
	
	/**
	 * Return the "app", this is needed to set the desired capabilities for use with Appium. 
	 * The absolute local path or remote http URL to an .ipa or .apk file, or a .zip containing one of these, 
	 * or "Chrome", "Safari.
	 * Appium will attempt to install this app binary on the appropriate device first.
	 * By default empty string.
	 * @return the "app" value
	 */
	public static String getAppiumApp() {
		return System.getProperty("app", Constants.EMPTY);
	}
	
	/**
	 * Return the appium server url. Currently the default is "http://127.0.0.1:4723/wd/hub".
	 * @return
	 */
	public static String getAppiumServer() {
		return System.getProperty("appium.server.url", "http://127.0.0.1:4723/wd/hub");
	}
	
	/**
	 * Return the "deviceId".
	 * This is needed to set the desired capabilities for use with Appium.
	 * By default empty string.
	 * @return String
	 */
	public static String getDeviceId() {
		return System.getProperty("udid", Constants.EMPTY);
	}
	
	/**
	 * Return the "noReset flag value".
	 * This is needed to set no reset capability for use with Appium.
	 * The noReset = true indicates that appium does not clear the app data
	 * By default set to false.
	 * @return String
	 **/
	public static String getNoResetFlagValue() {
		return System.getProperty("noReset", "false");
	}
	
	
	 
	/**
	 * Return the remoteUrl. Currently the default is "http://localhost:4444/wd/hub".
	 * This can be browserstack url, selenium grid url, or other remote urls.
	 * @return
	 */
	public static String getRemoteUrl() {
		return System.getProperty("remoteUrl", "http://localhost:4444/wd/hub");
	}	
	
	/**
	 * Return the deleteTempProperties property. Currently the default is "false".
	 * This will parse the string value and convert to primitive boolean type of true/false.
	 * @return
	 */
	public static boolean isDeleteTempProperties() {
		String boolStr =  System.getProperty("deleteTempProperties", "false");
		return Boolean.parseBoolean(boolStr);
	}
	
	/**
	 * Return the isResetStateBeforeScenario system property. Default is "false".
	 * If this is true, failure state would be reset before each Scenario/Example and 
	 * subsequent scenarios would be executed even after a Scenario or example is failed within a story
	 * This method will parse the string value and convert to primitive boolean type of true/false.
	 * @return
	 */
	public static boolean isResetStateBeforeScenario() {
		String boolStr =  System.getProperty("resetStateBeforeScenario", "false");
		return Boolean.parseBoolean(boolStr);
	}
	
	/**
	 * Return reportPropValues property. If true, this will pull values of config property
	 * into single page html report
	 * @return
	 */
	public static boolean reportPropValues() {
		String boolStr =  System.getProperty("reportPropValues", "false");
		return Boolean.parseBoolean(boolStr);
	}
	
	/**
	 * Return reportNarrativeAndScenarios property. If true, this will pull Narrative and Scenario descriptions
	 * into single page html report
	 * @return
	 */
	public static boolean reportNarrativeAndScenarios() {
		String boolStr =  System.getProperty("reportNarrativeAndScenarios", "false");
		return Boolean.parseBoolean(boolStr);
	}
	
	/**
	 * Return the launchWithFirePath system property. Default is "false".
	 * If this is true, Firefox browser will be launched with firebug and firepath
	 * @return
	 */
	public static boolean launchWithFirePath() {
		String boolStr = System.getProperty("launchWithFirePath", "false");
		return Boolean.parseBoolean(boolStr);
	}
	
	/**
	 * Return the deleteLogfiles property. Currently the default is "false".
	 * This will parse the string value and convert to primitive boolean typw of true/false.
	 * @return
	 */
	public static boolean isDeleteLogFiles() {
		String boolStr =  System.getProperty("deleteLogFiles", "false");
		return Boolean.parseBoolean(boolStr);
	}

	/**
	 * Return the type of wallet by default its empty.
	 * Example: fifththird or keybank [had to be lowercase]
	 * @return
	 */
	public static String getWalletType() {
		return System.getProperty("typeofwallet", Constants.EMPTY).toLowerCase();
	}
	
    /**
     * Read and return locale value from command line.
     * If no value/command line argument is specified, then return default (en, US)
     *
     * @return
     */
    public static Locale getLocale() {
    	try {
			String localeId = System.getProperty("locale");
			return Locale.forLanguageTag(localeId);
		} catch (NullPointerException npe) {
    		LOGGER.info("Locale is not set at run time");
		}
		return null;
	}

    /**
     * Read and return locale value from command line.
     * If no value/command line argument is specified, then return 
     * default as full screen
     * eq: 150*100
     * @return
     */
    public static Dimension getCustomScreenDimension() {
        String screenDimension = System.getProperty("screenSize");
        if (screenDimension != null) {
            String[] params = screenDimension.split("\\*");
            if (params.length == 2) {
                return new Dimension(Integer.valueOf(params[0]), Integer.valueOf(params[1]));
            }
        }
        return null;
    }
    
	/**
	 * Returns the "combined runner type name", specifies which runner is being used. 
	 * This is needed to get the temp property file created with the specific story name when using the combined runner
	 * Can be "mobilerest" or "webrest" depending on the type of runner being used.
	 * Not needed for normal runners like web /rest or mobile only needed in case of combined runner
	 * By default empty string.
	 * @return String
	 */
	public static String getRunnerType() {
		return System.getProperty("combinedrunnertype", Constants.EMPTY);
	}
	
	/**
	 * Return the "fullReset flag value".
	 * This is needed to set fullreset capability for use with Appium.
	 * The fullReset = true indicates that appium reset the whole app
	 * By default set to false.
	 * @return String
	 **/
	
		public static String fullReset() {
			return System.getProperty("fullReset", "false");
		}		
		
		/**
		 * Return the "speedBooster flag value".
		 * This is needed to set no reset capability for use with Appium.
		 * The speedBooster = true indicates that script would use direct adb commands and bypass appium
		 * By default set to false.
		 *
		 * @return String
		 */
		public static String getspeedBoosterFlagValue() {
			return System.getProperty("speedBooster", "false");
		}

	/**
	 * This is enable custom email triggers from the test
	 * @return
	 */
	public static Boolean getMailSenderEnabled() {
		return Boolean.getBoolean("sendEmail");
	}
		
		/**
		 * <p>getHostOSType.</p>
		 *
		 * @return a {@link String} object.
		 */
		public static String getHostOSType() {
			if (System.getProperty("os.name").toLowerCase().contains("win")) {
				return "windows";
			} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				return "mac";
			} else if (System.getProperty("os.name").toLowerCase().contains("nux") || System.getProperty("os.name").toLowerCase().contains("nix") || System.getProperty("os.name").toLowerCase().contains("aix")) {
				return "linux";
			}
			return "unKnownOS";
		}
	}
	

