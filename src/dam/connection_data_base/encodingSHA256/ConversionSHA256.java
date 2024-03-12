package dam.connection_data_base.encodingSHA256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConversionSHA256 {
    public static String hashToString(byte[] hash) {
        final StringBuilder r = new StringBuilder();

        for (int k = 0; k < hash.length; k++) {
            r.append(toHex((hash[k] >> 4) & 0xF));
            r.append(toHex(hash[k] & 0xF));
        }

        return r.toString();
    }

    public static char toHex(int x) {
        if (x < 0) {
            return '?';
        } else if (x < 10) {
            return (char) ('0' + x);
        } else if (x < 16) {
            return (char) ('A' + x - 10);
        } else {
            return '?';
        }
    }

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
