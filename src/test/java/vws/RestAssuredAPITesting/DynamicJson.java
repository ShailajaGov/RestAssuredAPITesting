package vws.RestAssuredAPITesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException; 

public class DynamicJson {
	
	@Test(dataProvider = "booksdata" )
	public void addBook(String aisle,String isbn)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		String response=given().log().all().header("Content-Type", "application/json")
		.body(Payload.addBookPayload(aisle,isbn))
		.when().post("/Library/Addbook.php")
		.then().log().all()
		.assertThat().statusCode(200).extract().asString();
		
		JsonPath json = new JsonPath(response);
		String id =json.get("ID");
		
		System.out.println("\n");
		System.out.println(id);
		
		//bcd1234227123
		//isbn123asdfghs
		
	}
	
	@Test
	public void addPlaceTest() throws IOException
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(Payload.staticJsonPayloadFromFile())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().asString();
		
			
		
	}
	
	@DataProvider(name = "booksdata")
	public Object[][] getData()
	{
		Object[][] obj = new Object[][]{{"aisle123","isbn123"},{"aisle345","isbn345"},{"aisle567","isbn567"}};
		return obj;
		
	}
	
	

}
