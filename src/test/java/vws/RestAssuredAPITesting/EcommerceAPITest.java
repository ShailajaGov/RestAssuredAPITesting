package vws.RestAssuredAPITesting;

import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;
import io.restassured.builder.*;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

public class EcommerceAPITest {
	
	
	//Ecommerce practice website 
	//https://rahulshettyacademy.com/client/

	private LoginResponse loginRes;
	private RequestSpecification reqSpec;
	
	@Test
	public void CreateProductTest()
	{
		Login();
		
		//Bypass SSL certification validation
		//
		
		reqSpec = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				//.addHeader("Content-Type", "application/json")
				.build();
		
		given().relaxedHTTPSValidation().log().all().spec(reqSpec)
		.header("Authorization", loginRes.getToken())
		.formParam("productName", "Saree")
		.formParam("productAddedBy", loginRes.getUserId())
		.formParam("productCategory", "fashion")
		.formParam("productSubCategory", "shirts")
		.formParam("productPrice","5000")
		.formParam("productDescription", "Casual saree")
		.formParam("productFor", "women")
		.multiPart("productImage", new File(System.getProperty("user.dir")+"\\src\\test\\java\\SareeImage.jpg"))
		.when().post("/api/ecom/product/add-product")
		.then().log().all().assertThat().statusCode(201).extract().asString();
		
		String productId = "65fcb744a86f8f74dca7a645";
		//.formParam("essff", null);
		
	}
	
	
	
	public void Login()
	{
		 reqSpec = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Content-Type", "application/json")
				.build();
		
		LoginRequest logReq = new LoginRequest();
		logReq.setUserEmail("shailaja.sireesh@gmail.com");
		logReq.setUserPassword("Password@123");
		
		 loginRes = given().log().all().spec(reqSpec)
		.body(logReq)		
		.when().post("/api/ecom/auth/login").then().log().all().extract().as(LoginResponse.class);	
		
		 
		
		System.out.println(loginRes.getToken());
		
		
		
	}
	
	@Test
	public void LoginTest()
	{
		 reqSpec = new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Content-Type", "application/json")
				.build();
		
		LoginRequest logReq = new LoginRequest();
		logReq.setUserEmail("shailaja.sireesh@gmail.com");
		logReq.setUserPassword("Password@123");
		
		 LoginResponse loginRes = given().log().all().spec(reqSpec)
		.body(logReq)		
		.when().post("/api/ecom/auth/login").then().log().all().extract().as(LoginResponse.class);	
		
		 
		
		System.out.println(loginRes.getToken());
		
		
		
	}
	
	
}
