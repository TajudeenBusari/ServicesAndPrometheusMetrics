package PrometheusMetrics;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;


/*
 * 
 * @author tajudeen.busari
 * @date 
 *
 */
public class FR_LM_LPR_Services {
	
	@Test (priority=1)
	void FRServiceMetrics() 
	{
		        given()
				
				
		
				.when()
		          .get("http://127.0.0.1:8091/metrics")
	
		         .then()
					 .statusCode(200)	 	
					 .contentType("text/plain; version=0.0.4; charset=utf-8")   
					 .log().all();	
	
		        
	}
	
	@Test (priority=2)
	void LMServiceMetrics() 
	{
		        given()
				
				
		
				.when()
		          .get("http://127.0.0.1:8089/metrics")
	
		         .then()
					 .statusCode(200)	 	
					 .contentType("text/plain; version=0.0.4; charset=utf-8")   
					 .log().all();	
	
		        
	}
	
	@Test (priority=3)
	void LPRServiceMetrics() 
	{
		        given()
				
				
		
				.when()
		          .get("http://127.0.0.1:8090/metrics")
	
		         .then()
					 .statusCode(200)	 	
					 .contentType("text/plain; version=0.0.4; charset=utf-8")   
					 .log().all();	
	
		        
	}
	
	
	}
	
