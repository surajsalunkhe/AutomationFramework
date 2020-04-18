package Utility;

import org.apache.commons.codec.binary.Base64;

/**
 * Class to encode/decode String to and from Base64
 * Created by e037138 on 6/29/2015.
 */
public final class Base64Utils {

    private Base64Utils() {

    }

    public static String encodeToBase64String(String input) {
        return Base64.encodeBase64String(input.getBytes());
    }

    public static String decodeFromBase64String(String encodedString) {
        return new String(Base64.decodeBase64(encodedString.getBytes()));
    }

    /**
     * Pass encoded base64 string to the method and input is decoded
     * @param encodedString
     * @return
     */
    public static byte[] decodeBase64StringToBytes(String encodedString) {
        return Base64.decodeBase64(encodedString);
    }

    /**
     * Pass byte input to the method and input is encoded to base 64
     * @param input
     * @return
     */
    public static String encodeToBase64PublicKey(byte[] input) {
        return Base64.encodeBase64String(input);
    }
}
