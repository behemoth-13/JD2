package by.pvt.dao.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CodePassword {
    private static String ALGORITHM = "MD5";
    private static int POSITIVE = 1;
    
    public static String getHashCode(String password) {
        try {
            MessageDigest dig = MessageDigest.getInstance(ALGORITHM);
            BigInteger hash = new BigInteger(POSITIVE, dig.digest(password.getBytes()));
            return String.format("%032x", hash);
            
        } catch (NoSuchAlgorithmException e) {
            //TODO
        }
        throw new RuntimeException("Exception at Coder: NoSuchAlgorithm");
    }
}
