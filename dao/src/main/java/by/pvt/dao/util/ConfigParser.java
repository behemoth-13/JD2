package by.pvt.dao.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ConfigParser {
	
	private String driverName, url , login, password;
	private int poolSize;
	
	private final String TAG_BDCONNECTION = "bdconnection";
	private final String TAG_DRIVER = "driver";
	private final String TAG_URL = "url";
	private final String TAG_LOGIN = "login";
	private final String TAG_PASSWORD = "password";
	private final String TAG_POOL_SIZE = "poolSize";


	public void parseConfig(String xmlFile) throws ParserConfigurationException, SAXException, IOException {
		File configFile = new File(xmlFile);
		InputStream input = null;
		
		if (configFile.exists()) {
			input = new FileInputStream(configFile);
		} else {
			input = ConfigParser.class.getClassLoader().getResourceAsStream(xmlFile);
		}
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(input);
		Element element = (Element) document.getElementsByTagName(TAG_BDCONNECTION).item(0);
		
		driverName = element.getElementsByTagName(TAG_DRIVER).item(0).getChildNodes().item(0).getNodeValue();
		url = element.getElementsByTagName(TAG_URL).item(0).getChildNodes().item(0).getNodeValue();
		login = element.getElementsByTagName(TAG_LOGIN).item(0).getChildNodes().item(0).getNodeValue();
		password = element.getElementsByTagName(TAG_PASSWORD).item(0).getChildNodes().item(0).getNodeValue();
		poolSize = Integer.parseInt(element.getElementsByTagName(TAG_POOL_SIZE).item(0).getChildNodes().item(0).getNodeValue());
	}
	
	public String getDriver() {
		return driverName;
	}
	public String getUrl() {
		return url;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public int getPoolSize() {
		return poolSize;
	}
}
