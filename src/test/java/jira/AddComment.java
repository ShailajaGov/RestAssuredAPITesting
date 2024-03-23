package jira;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class AddComment {
	
	@Test
	public void addCommentTest()
	{
		RestAssured.baseURI="http://localhost:8080";
		
		SessionFilter session = new SessionFilter();
		
		setSessionId(session);
		
		System.out.println(session.getSessionId());
		
		given().log().all().header("Content-Type", "application/json")
		.pathParam("key", "JIR-1")
		.body("{\r\n"
				+ "    \"body\": \"This is Restassured comments\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}")
		.filter(session).when().post("rest/api/2/issue/{key}/comment")
		.then().log().all().statusCode(201);
		
		
		
	}
	
	
	@Test
	public void addAttachmentTest()
	{
        RestAssured.baseURI="http://localhost:8080";
		
		SessionFilter session = new SessionFilter();
		
		setSessionId(session);
		
		System.out.println(session.getSessionId());
		
		//See add attachment documentation for Jira with multiPart
		
		given().log().all().header("Content-Type", "multipart/form-data")
		.header("X-Atlassian-Token","no-check")
		.pathParam("key", "JIR-1")
		.filter(session)
		.multiPart("file",new File(System.getProperty("user.dir")+"\\src\\test\\java\\jira\\AttachmentTest.txt"))
		.when().post("/rest/api/2/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200);
	}
	
	@Test
	public void GetIssueTest()
	{
		RestAssured.baseURI="http://localhost:8080";
		
		SessionFilter session = new SessionFilter();
		
		setSessionId(session);
		
		System.out.println(session.getSessionId());
		
		String response = given().log().all().pathParam("key", "JIR-2")
		.queryParam("fields", "comment")
		.filter(session)
		.when().get("/rest/api/2/issue/{key}")
		.then().log().all().assertThat().statusCode(200).extract().asString();
		
		String expectedComment = "2nd Comments added from postman";
		JsonPath json = new JsonPath(response);
		String actualComment = json.get("fields.comment.comments[0].body").toString();
		
		//System.out.println("Response Issue details : "+response);
		
		
		Assert.assertEquals(actualComment, expectedComment);
		
		
		
	}
	

	private void setSessionId(SessionFilter session) {
		given().log().all().header("Content-Type", "application/json")
		.body("{ \"username\": \"sailu_saila\", \"password\": \"password@123\" }")
		.filter(session)
		.when().post("/rest/auth/1/session")
		.then().log().all().assertThat().statusCode(200);
	}
	
	
	public String getSessionId()
	{
		RestAssured.baseURI ="http://localhost:8080";
		String response = given().log().all().header("Content-Type", "application/json")
		.body("{ \"username\": \"sailu_saila\", \"password\": \"password@123\" }")
		.when().post("/rest/auth/1/session")
		.then().log().all().assertThat().statusCode(200).extract().asString();
		
		JsonPath json=new  JsonPath(response);
		
		
		return json.get("session.value");
	}

}
