package ClientCredentialsOauth;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.GetCourse;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class GetAccessTokenAndGetCourseDetails {

	@Test
	public void GetCourseDetailsTest()
	{
		String accessToken = GetAccessToken();
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().queryParam("access_token",accessToken)		
		.when().get("/oauthapi/getCourseDetails")
		.then().log().all().extract().asString();
		
		System.out.println("Course Details Reponse"+response);
		
		
	}
	
	@Test
	public void getCourseDetailsWithPOJOClassTest()
	{
		
		String accessToken = GetAccessToken();
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		 GetCourse getCourse = given().queryParam("access_token",accessToken)		
		.when().get("/oauthapi/getCourseDetails")
		.then().log().all().extract().as(GetCourse.class);
		 
		 String courseTitle =getCourse.getCourses().getWebAutomation().get(0).getCourseTitle();
		 
		 Assert.assertEquals(getCourse.getInstructor(),"RahulShetty");
		 Assert.assertEquals(courseTitle, "Selenium Webdriver Java");
	}
	
	public String GetAccessToken()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope","trust")
		
		.when().post("/oauthapi/oauth2/resourceOwner/token")
		.then().assertThat().statusCode(200).extract().asString();
		
		JsonPath json = new JsonPath(response);
		String accessToken = json.get("access_token");
		
		System.out.println(accessToken);
		
		return accessToken;
		
	}
	
}
