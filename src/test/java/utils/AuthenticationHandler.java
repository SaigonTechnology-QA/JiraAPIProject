package utils;

import org.apache.commons.codec.binary.Base64;

public class AuthenticationHandler {
    public static String encodeCredStr(String email, String token){
        String cred = email.concat(":").concat(token);
        byte[] encodeCred = Base64.encodeBase64(cred.getBytes());
        return new String(encodeCred);
    }
}
