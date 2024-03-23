package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Payload {
	
	public static String complexJsonResponse()
	{
		
		return "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
	}

	public static String addBookPayload(String aisle, String isbn)
	{
		return "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"Shailaja foe\"\r\n"
				+ "}\r\n"
				+ "";
	}

	public static String staticJsonPayloadFromFile() throws IOException
	{
		byte[] bytes = Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"\\src\\test\\java\\Utility\\AddPlace.json"));
		String body = new String(bytes);
		
		return body;
	}

}
