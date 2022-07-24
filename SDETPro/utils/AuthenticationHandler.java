package utils;

import org.apache.commons.codec.binary.Base64;

public class AuthenticationHandler {

    public static String encodedCredString (String email, String token) {
        if (email == null || token == null) {
            throw new IllegalArgumentException("[ERROR] Email or Token can't be null !!!");
        }
        String credentials = email.concat(":").concat(token);
        byte[] encodedCred = Base64.encodeBase64(credentials.getBytes());
        return new String(encodedCred);
    }
}
