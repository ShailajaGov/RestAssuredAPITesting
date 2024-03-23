package vws.RestAssuredAPITesting;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import pojo.Location;

public class AddPlaceWithPOJOClassRequest {
	
	@Test
	public void AddPlaceTest()
	{
		
		List<String> locTypes= new ArrayList<String>();
		locTypes.add("shoe park");
		locTypes.add("shop");
		
		Location loc= new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		
		pojo.AddPlace addPlace= new pojo.AddPlace();
		addPlace.setAccuracy(60);
		addPlace.setAddress("4465 Shore bird drive");
		addPlace.setName("Anshu House");
		addPlace.setLanguage("French-IN");
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setWebsite("http://google.com");
		addPlace.setTypes(locTypes);
		addPlace.setLocation(loc);
		
			
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given().log().all().queryParam("key" , "qaclick123")
		.header("Content-Type","application/json")
		.body(addPlace)
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
		
	}

}
