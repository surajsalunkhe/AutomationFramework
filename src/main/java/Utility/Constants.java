package Utility;

public final class Constants {
	public static final String NEWLINE = "\n";
	public static final String SPACE = " ";
	public static final String EMPTY = "";
	public static final String PERIOD = ".";
	public static final String DASH = " - ";
	public static final String PIPE = " | ";
	public static final String DATETIME = "MM/dd/yyyy HH:mm aa";
	public static final String DATE = "MM/dd/yyyy";
	public static final String EXCEL_DATE = "yyyy_MM_dd";
	public static final int LENGTH_RADOM_STR = 20;
	public static final int MIN_TO_SEC_CONVERSION_VAL = 60;
	public static final int WAIT_FOR_1 = 1;
	public static final int WAIT_FOR_2 = 2;
	public static final int WAIT_FOR_5 = 5;
	public static final int WAIT_FOR_10 = 10;
	public static final int WAIT_FOR_15 = 15;
	public static final int WAIT_FOR_20 = 20;
	public static final int WAIT_FOR_30 = 30;
	public static final int WAIT_FOR_45 = 45;
	public static final int WAIT_FOR_60 = 60;
	public static final int WAIT_FOR_90 = 90;
	public static final int WAIT_FOR_120 = 120;
	public static final int WAIT_FOR_240 = 240;
	
	//used in Thread sleep
	public static final int THREAD_SLEEP_1000 = 1000;
	public static final int THREAD_SLEEP_6000 = 6000;
	public static final int THREAD_SLEEP_3000 = 3000;
	public static final int THREAD_SLEEP_25000 = 25000;
	public static final int THREAD_SLEEP_10000 = 10000;
	
	public static final String COOKIE_EXPIRY = "expiry";
	public static final String COOKIE_DOMAIN = "domain";
	public static final String COOKIE_PATH = "path";
	public static final String COOKIE_NAME = "name";
	public static final String COOKIE_VALUE = "value";
	
	public static final String FIND_WINDOW_BY_TITLE = "title";
	public static final String FIND_WINDOW_BY_URL = "Url";
	public static final String FIND_WINDOW_CONTAINING_ELEMENT_ID = " window contains element ID";
	public static final String FIND_WINDOW_BY_TITLE_SUBSTRING = "title substring";	
	
	public static final String CURLY_BRACE_OPEN = "{";
	public static final String CURLY_BRACE_CLOSE = "}";

	public static final String TEST_RESOURCES = "src/test/resources/";
	public static final String TEST_RESOURCES_JSON = "src/test/resources/data/json/";
	public static final String TEST_RESOURCES_XML = "src/test/resources/data/xml/";
	public static final String TEST_RESOURCES_CONFIG = "src/test/resources/config/";
	public static final String TEST_SCREENSHOT_PATH = "/target/jbehave/screenshots/";
	public static final String LOGS = "logs/";
	public static final String WEB_ATTRIBUTE_ALIAS_CONFIG = Constants.TEST_RESOURCES_CONFIG + "attributeAlias.config";
	public static final String ANDROID_ATTRIBUTE_ALIAS_CONFIG = Constants.TEST_RESOURCES_CONFIG + "androidMobileAlias.config";
	public static final String ANDROID_WALLET_APP_PACKAGE = "com.mastercard.mp.wallet";
	public static final String IOS_ATTRIBUTE_ALIAS_CONFIG = Constants.TEST_RESOURCES_CONFIG + "iosMobileAlias.config";
	
	public static final int MAX_VIEWPORT_DIM_X = 1280;
	public static final int MAX_VIEWPORT_DIM_Y = 750;
	public static final int VIEWPORT_DIM_X = 1024;
	public static final int VIEWPORT_DIM_Y = 700;
	public static final String APPIUM = "appium";
	public static final String TEST_WEB = "WEB";
	public static final String TEST_REST = "REST";
	public static final String TEST_WEBREST = "WEBREST";
	public static final String TEMP_DIR = "C:/temp/";
	public static final String MAC_TEMP_DIR = "/Documents/temp";

	public static final String FIREBUG_PATH = "./src/main/resources/plugins/firebug-2.0.14.xpi";
	public static final String FIREPATH_PATH = "./src/main/resources/plugins/firepath-0.9.7.1-fx.xpi";
	
	public static final String HTTP_RESPONSE_BEGIN = "\n***** HTTP RESPONSE DETAILS BEGIN *****";
	public static final String HTTP_REQUEST_BEGIN = "\n***** HTTP REQUEST DETAILS BEGIN *****";
	public static final String HTTP_RESPONSE_END = "\n***** HTTP RESPONSE DETAILS END *****";
	public static final String HTTP_REQUEST_END = "\n***** HTTP REQUEST DETAILS END *****";
	
	public static final String HTTP_COOKIE_HDR = "COOKIE_HDR";
	public static final String TEMP_FILE_COOKIE_HDR = "***TEMP_FILE_VARIABLE:HEADER_FIELD_COOKIE***";
	public static final String HTTP_MPASSCSRFTKN_HDR = "MPASSCSRFTKN_HDR";
	public static final String TEMP_FILE_MPASSCSRFTKN_HDR = "***TEMP_FILE_VARIABLE:HEADER_FIELD_mpasscsrftoken***";
	public static final int HTTP_STATUS_OK = 200;
	public static final int HTTP_STATUS_BAD_REQUEST = 400;
	public static final int HTTP_STATUS_CLIENT_ERROR = 401;
	public static final int HTTP_STATUS_NOT_FOUND = 404;
	public static final int HTTP_STATUS_SERVER_ERROR = 500;
	public static final int POLL_TIME = 5;
	public static final String XPATH = "XPATH";
	public static final String ID = "ID";
	public static final String NAME = "NAME";
	public static final String CSSSELECTOR = "CSSSELECTOR";
	public static final String CLASSNAME = "CLASSNAME";
	public static final String LINKTEXT = "LINKTEXT";
	public static final String PARTIALLINKTEXT = "PARTIALLINKTEXT";
	public static final String TAGNAME = "TAGNAME";
	public static final String SET_FALSE = "false";
	public static final String SET_TRUE = "true";
	public static final long THREAD_SLEEP_1 = 1;
	public static final String ASTERISKS_3 = "***";

	public static final String CONFIG_VARIABLE_REPLACEMENT_START = "***CONFIG_VARIABLE:";
	public static final String THREAD_LOCAL_VARIABLE_REPLACEMENT_START = "***THREAD_LOCAL_VARIABLE:";
	public static final String TEMP_FILE_VARIABLE_REPLACEMENT_START = "***TEMP_FILE_VARIABLE:";
	public static final String DEFAULT_TEMP_FILE_VARIABLE_REPLACEMENT_START = "***DEFAULT_TEMP_FILE_VARIABLE:";
	public static final String DATE_VARIABLE_REPLACEMENT_START = "***DATE_VARIABLE:";
	public static final String FIX_VALUE_REPLACEMENT_START = "***FIX_VALUE:";
	public static final int IOS_SCROLL = 0;

    public static final String BROWSER_EMULATOR = "EMULATOR";

    public static final String PLATFORM_IOS = "IOS";
    public static final String PLATFORM_ANDROID = "ANDROID";

    public static final int FIREFOX_START_VERSION = 32;
    public static final int FIREFOX_END_VERSION = 48;

    public static final int CHROME_START_VERSION = 41;
    public static final int CHROME_END_VERSION = 53;

    public static final String DEFAULT_TEMPFILE_IDENTIFIER = "defaulttemp";
    public static final String TEMPFILE_IDENTIFIER = "temp";
    
    public static final String DBQUERYFILE_IDENTIFIER = "dbQueries";
    public static final String DBCONFIGFILE_IDENTIFIER = "dbConfig";
    public static final String UNDEFINED = "UNDEFINED";

	/**
	 * Empty private constructor as its a utility method
	 * See: http://checkstyle.sourceforge.net/config_design.html#HideUtilityClassConstructor
	 */
	private Constants() {
	}
	/**
	 * Enumerated https methods.
	 */
	public enum HTTP_METHOD {
		GET, POST, DELETE, PUT
	}
	

}

