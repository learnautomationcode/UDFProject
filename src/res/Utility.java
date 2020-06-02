package res;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Utility {
	
	
	public static String getpropertyFromPropertyfile(String propertname) throws IOException{

		// creating filereader object
		FileReader flereader = new FileReader(System.getProperty("user.dir")+"\\src\\res\\data.properties");

		// creating instance of properties class object
		Properties prop = new Properties();

		// passing the property file to Properties object
		prop.load(flereader);

		// returning value from the property file
		return prop.getProperty(propertname);

	}

	
	public static String getTestDataFromXMLFile(String strXpath) {
		String valTobereturned = null;
		try {

			strXpath = "Automation/" + getpropertyFromPropertyfile("url") + "/" + strXpath;
			
			System.out.println(strXpath);
			File xmlfile = new File("TestData.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(xmlfile);

			doc.getDocumentElement().normalize();

			XPath xPath = XPathFactory.newInstance().newXPath();

			NodeList nodelst = (NodeList) xPath.compile(strXpath).evaluate(doc, XPathConstants.NODESET);

			valTobereturned = nodelst.item(0).getTextContent();
		} catch (Exception e) {

			Assert.fail("exception occured while reading data from xml file: " + e.toString());
		}

		return valTobereturned;
	}
	
	public static int RandomNum()
	{
		Random r=new Random();
		int val=r.nextInt(1000);
		return val;
		
	}
	

}
