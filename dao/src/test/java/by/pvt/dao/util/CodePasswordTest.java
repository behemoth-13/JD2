package by.pvt.dao.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alex on 04.01.2017.
 */
public class CodePasswordTest {
    @Test
    public void getHashCode() throws Exception {
        String password = "qweqwe";
        String hash = CodePassword.getHashCode(password);
        assertEquals("efe6398127928f1b2e9ef3207fb82663", hash);
    }
}