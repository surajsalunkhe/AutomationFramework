package Utility;

import java.util.Locale;

public final class LocaleUtil {

	/* Empty private constructor as its a utility method
	 * See: http://checkstyle.sourceforge.net/config_design.html#HideUtilityClassConstructor
	 */
	private LocaleUtil() {
	}
	
	/**
	 * Get the country as a string; eq US, UK etc
	 * @return
	 */
	public static String getCountry() {
		return ReadSystemVariables.getLocale().getCountry();
	}
	
	/**
	 * Get the displayed country; eq: United States
	 * @return
	 */
	public static String getDisplayCountry() {
		return ReadSystemVariables.getLocale().getDisplayCountry();
	}
	
	/**
	 * Get the displayed country for a given Locale; eq: forLocale.US it is United States
	 * @param locale
	 * @return
	 */
	public static String getDisplayCountry(Locale locale) {
		return ReadSystemVariables.getLocale().getDisplayCountry(locale);
	}
	
	/**
	 * Get the display language; eq: English
	 * @return
	 */
	public static String getDisplayLanguage() {
		return ReadSystemVariables.getLocale().getDisplayLanguage();
	}
	
	/**
	 * Get the display language for a given Locale; eq: for Locale.US display language is English
	 * @return
	 */
	public static String getDisplayLanguage(Locale locale) {
		return ReadSystemVariables.getLocale().getDisplayLanguage(locale);
	}
	
	/**
	 * Get the display name; eq.English (United States)
	 * @return
	 */
	public static String getDisplayName() {
		return ReadSystemVariables.getLocale().getDisplayName();
	}
	
	/**
	 * Get the display name for a given Locale; eq.for Locale.US: English (United States)
	 * @return
	 */
	public static String getDisplayName(Locale locale) {
		return ReadSystemVariables.getLocale().getDisplayName(locale);
	}
	
	/**
	 * Get the display variant
	 * @return
	 */
	public static String getDisplayVariant() {
		return ReadSystemVariables.getLocale().getDisplayVariant();
	}
	
	/**
	 * Get the display variant for a given Locale; eq.for Locale.US: varient is empty string
	 * @return
	 */
	public static String getDisplayVariant(Locale locale) {
		return ReadSystemVariables.getLocale().getDisplayVariant(locale);
	}
	
	/**
	 * Get the ISO3 country; eq: USA
	 * @return
	 */
	public static String getISO3Country() {
		return ReadSystemVariables.getLocale().getISO3Country();
	}
	
	/**
	 * Get the ISO3 language; eq: eng
	 * @return
	 */
	public static String getISO3Language() {
		return ReadSystemVariables.getLocale().getISO3Language();
	}
	
	/**
	 * Get language; eq: en
	 * @return
	 */
	public static String getLanguage() {
		return ReadSystemVariables.getLocale().getLanguage();
	}
	
	/**
	 * Get ISO locale eq: en-us
	 * @return
	 */
	public static String getISOLocale() {
		String lang = ReadSystemVariables.getLocale().getLanguage();
		String country = ReadSystemVariables.getLocale().getCountry();
		return lang + "-" + country.toLowerCase();
	}
	
	/**
	 * Get Locale in uppercase eq: en_US
	 * @return
	 */
	public static String getLocaleUpperCase() {
		String lang = ReadSystemVariables.getLocale().getLanguage();
		String country = ReadSystemVariables.getLocale().getCountry();
		return lang + "_" + country;
	}
}
