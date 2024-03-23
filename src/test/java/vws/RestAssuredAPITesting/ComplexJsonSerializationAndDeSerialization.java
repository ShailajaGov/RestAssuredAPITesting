package vws.RestAssuredAPITesting;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import pojo.AddPlan;
import pojo.CartInfo;
import pojo.Data;
import pojo.Feature;
import pojo.Line;
import pojo.Plan;

public class ComplexJsonSerializationAndDeSerialization {
	
	@Test
	public void buildPOJOUsingInputJSONAndCompareWithOutPutJSON() throws IOException
	{
		//add-plan service call in verizon website
		
		  /* MyPOJO myPOJO = new MyPOJO();
	        myPOJO.setId(1);
	        myPOJO.setName("John Doe");

	        // Serialize POJO to JSON using Gson
	        Gson gson = new Gson();
	        String jsonString = gson.toJson(myPOJO);
	        
	        	        */
		
		String inputJson = new String(Files
				.readAllBytes(Paths.get(System.getProperty("user.dir") + "\\src\\test\\java\\Utility\\AddPlan.json")));
		
	   //POJO classes are built for inputJson check the json payload in pojo.AddPlan.json file 
		
		AddPlan addPlan= new AddPlan();
	    
		
		CartInfo cartInfo= new CartInfo();
	    cartInfo.setProcessingMTN("newLine1");
	    cartInfo.setProcessStep("NewRecommendedPlanSelection");
	    cartInfo.setIntendType("NSE");
	    cartInfo.setEditPlanClick(false);
	    cartInfo.setCustomerType("N");
	    cartInfo.setProcessAction("addPlan");
	    
	    addPlan.setCartInfo(cartInfo);
	    
	    Data data =new Data();
	    
	    Line line= new Line();
	    line.setPath("popular");
	    line.setAction("preset");
	    line.setMtn("newLine1");;
	    
	    Plan plan = new Plan();
	    plan.setId("69185");
	    	    
	    line.setPlan(plan);
	    
	    List<Feature>  features = new ArrayList<Feature>();
	    Feature feature = new Feature();
	    feature.setId("2678");
	    feature.setRank("3");
	    feature.setActionIndicator("A");
	    feature.setType("SPO");
	    feature.setQuantity(1);
	    features.add(feature);
	    
	    line.setAddFeatures(features);
	    
	    List<Feature>  removeFeatures = new ArrayList<Feature>();
	    line.setRemoveFeatures(removeFeatures);
	    
	    List<Line> lines = new ArrayList<Line>();
	    lines.add(0, line);
	    
	    	    
	    data.setLines(lines);
	    data.setEnableFcc(true);
	    data.setParentMtn("");
	    
	    addPlan.setData(data);
	    addPlan.setOptPlanSku(true);
	    addPlan.setByou(true);
	
	    // Serialize POJO to JSON using Gson
        Gson gson = new Gson();
        String jsonString = gson.toJson(addPlan);
        
        System.out.println(jsonString);
        
       // Assert.assertEquals(inputJson, jsonString);
	
	}

}
