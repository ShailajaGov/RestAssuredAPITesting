package vws.RestAssuredAPITesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddPlaceAndGetPlace {
	
	@Test
	public  void addUpdateandGetPlaceTest(String[] arr)
	{
		
		//Add Place
		System.out.println("Add Place");
		
		//all input details should be part of given() like query params and headers
				//when submit the API request - resource and http method goes under when method
				//Then validate the API response
				RestAssured.baseURI = "https://rahulshettyacademy.com";
				String response = given().log().all().queryParam("key","qaclick123").headers("Content-Type","application/json")
				.body("{\r\n"
						+ "  \"location\": {\r\n"
						+ "    \"lat\": -38.383494,\r\n"
						+ "    \"lng\": 33.427362\r\n"
						+ "  },\r\n"
						+ "  \"accuracy\": 50,\r\n"
						+ "  \"name\": \"Sireesh  house\",\r\n"
						+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
						+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
						+ "  \"types\": [\r\n"
						+ "    \"shoe park\",\r\n"
						+ "    \"shop\"\r\n"
						+ "  ],\r\n"
						+ "  \"website\": \"http://google.com\",\r\n"
						+ "  \"language\": \"French-IN\"\r\n"
						+ "}\r\n"
						+ "")
				.when().post("/maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200)
				.body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
				
				//parsing response json
				JsonPath json = new JsonPath(response);
				String placeId = json.getString("place_id");
				String status = json.getString("status");
				
				System.out.println("Place Id : "+placeId);
				System.out.println("status :"+status);
				
				//Update Place
				
				System.out.println("Update Place");
				String newAddress = "208 lanyard terrace";
				
				RestAssured.baseURI = "https://rahulshettyacademy.com";
				given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body("{\r\n"
						+ "\"place_id\":\""+placeId+"\",\r\n"
						+ "\"address\":\""+newAddress+"\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n"
						+ "}")
				.when().put("/maps/api/place/update/json")
				.then().log().all().assertThat().statusCode(200);
				
				System.out.println("Get Place");
				
				RestAssured.baseURI = "https://rahulshettyacademy.com";
			String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", placeId)
				//.header("Content-Type", "application/json")
				.when().get("/maps/api/place/get/json")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();;
				
			JsonPath json1 = new JsonPath(getPlaceResponse);
			String actualAddress = json1.getString("address");
			
			System.out.println("********************");
			System.out.println("New address : "+newAddress);
			System.out.println("Actual address :"+actualAddress);
			
			Assert.assertEquals(actualAddress, newAddress);
				
	}

}
