package vws.RestAssuredAPITesting;

import org.testng.annotations.Test;

import Utility.Payload;
import io.restassured.path.json.JsonPath;

public class ParseComplexJson {
	
	@Test
	public void parseJsonTest()
	{
		JsonPath json = new JsonPath(Payload.complexJsonResponse());
		
		//Print No of courses returned by API
		
		int courseCnt =json.getInt("courses.size()");
		System.out.println( "Courses count :" + courseCnt);
		
		//Print Purchase Amount
		
		System.out.println("Purchase amount :" +json.getInt("dashboard.purchaseAmount"));
		
		//Print Title of the first course
		System.out.println("Title of the first course :" +json.getString("courses[0].title"));
		
		for(int i= 0;i<courseCnt;i++)
		{
			System.out.println((i+1));
			System.out.println("Title :"+json.getString("courses["+i+"].title"));
			System.out.println("Price : " +json.getInt("courses["+i+"].price") );
		}
		
		//Print no of copies sold by RPA Course
		
		for(int i= 0;i<courseCnt;i++)
		{
			//System.out.println((i+1));
			String title=json.getString("courses["+i+"].title");
			if(title.equals("RPA"))
			{
				System.out.println("copies : " +json.getInt("courses["+i+"].copies") );
			}
		}
		
	}

}
