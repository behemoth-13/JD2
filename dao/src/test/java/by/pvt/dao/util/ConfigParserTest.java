package by.pvt.dao.util;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Alex on 05.01.2017.
 */
public class ConfigParserTest {

    private final static String CONFIG_XML = "src/test/java/by/pvt/resource/config/config.xml";

    private ConfigParser parserTest = new ConfigParser();

    @Before
    public void parseConfigTest(){
        try {
            parserTest.parseConfig(CONFIG_XML);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getDriver() throws Exception {
        String driverTest = parserTest.getDriver();
        assertEquals("org.gjt.mm.mysql.Driver", driverTest);
    }

    @Test
    public void getUrl() throws Exception {
        String urlTest = parserTest.getUrl();
        assertEquals("jdbc:mysql://127.0.0.1/autobaseTest?useSSL=false", urlTest);
    }

    @Test
    public void getLogin() throws Exception {
        String loginTest = parserTest.getLogin();
        assertEquals("root", loginTest);
    }

    @Test
    public void getPassword() throws Exception {
        String passwordTest = parserTest.getPassword();
        assertEquals("ad10101101", passwordTest);
    }

    @Test
    public void getPoolSize() throws Exception {
        int poolSizeTest = parserTest.getPoolSize();
        assertEquals(5, poolSizeTest);
    }
}