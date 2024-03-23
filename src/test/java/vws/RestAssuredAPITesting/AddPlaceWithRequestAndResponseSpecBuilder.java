package vws.RestAssuredAPITesting;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import pojo.Location;

public class AddPlaceWithRequestAndResponseSpecBuilder {
	
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
		addPlace.setName("Raj House");
		addPlace.setLanguage("French-IN");
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setWebsite("http://google.com");
		addPlace.setTypes(locTypes);
		addPlace.setLocation(loc);
		
			
		RequestSpecBuilder builder= new RequestSpecBuilder();
		RequestSpecification spec = builder.setContentType("application/json").setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", "qaclick123").build();
		
//		RestAssured.baseURI="https://rahulshettyacademy.com";
//		given().log().all().queryParam("key" , "qaclick123")
//		.header("Content-Type","application/json")
//		.body(addPlace)
//		.when().post("/maps/api/place/add/json")
//		.then().log().all().assertThat().statusCode(200);
		
		ResponseSpecBuilder builder1= new ResponseSpecBuilder();
		 ResponseSpecification resSpec = builder1.expectStatusCode(200).expectContentType("application/json").build();
		
		given().spec(spec).body(addPlace)
		.when().post("/maps/api/place/add/json")
		.then().log().all().spec(resSpec);
		
	}

}
