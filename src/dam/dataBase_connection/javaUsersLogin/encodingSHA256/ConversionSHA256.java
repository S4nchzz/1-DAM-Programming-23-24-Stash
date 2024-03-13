package dam.dataBase_connection.javaUsersLogin.encodingSHA256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConversionSHA256 {
    public static byte[] sha256(String s) {
        final byte[] b = s.getBytes();

        try {
            MessageDigest m = MessageDigest.getInstance("SHA-256");
            return m.digest(b);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}