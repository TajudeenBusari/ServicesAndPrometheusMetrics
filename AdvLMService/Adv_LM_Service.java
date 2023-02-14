package AdvLMService;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Adv_LM_Service {
	
	@Test (priority=1)
	void GetFrData() 
	{
		given()
		
		.when()
			.get("http://127.0.0.1:8089/api/v1/fr")
		
		.then()
			.statusCode(401) // Expected Error: Unauthorized because you need authorization to access this API
			.log().all();
			
		
		
	}

	
	@Test (priority=2)
	void GetLogFiles() 
	{
		
		
		Response res=given()
				
			
		
		.when()
			.get("http://127.0.0.1:8089/api/v1/logs");
		
		String contentdisposition_value=res.getHeader("Content-Disposition");//this returns the value of content-disposition ref check Cookie.java script
		String contentlength_value=res.getHeader("Content-Length");
		
		System.out.println("Content-Length is:"+contentlength_value);
		System.out.println("Content-Disposition is:"+contentdisposition_value);
//FROM THE RESPONSE, GET THE HEADER AND EXTRACT THE CONTENT-DISPOSITION and CONTENT-LENGTH valueS AT RUN TIME BECAUSE THE VALUES KEEP CHANGING AT EVERY RUN
//THEN STORE IT IN A STRING VARIABLE 'contentdisposition_value and 'contentlength_value'THEN 
		
		Assert.assertEquals	(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/zip");
		Assert.assertEquals(res.header("Content-Disposition"), contentdisposition_value); //asserting the value of content-disposition at every run
		Assert.assertEquals(res.header("Content-Length"),contentlength_value );
			
	}

	@Test (priority=3)
	void GetLMSSetting() 
	
	{
		given()
		
		.when()
			.get("http://127.0.0.1:8089/api/v1/settings")
		
		.then()
			.statusCode(401); //Unauthorized
     }
	

	@Test (priority=4)
	void Post_SaveLMSSetting() throws FileNotFoundException
	
	{
		//
		File f = new File(".\\UpadeListManagementServiceSettingReqBoby.json");
		FileReader fr =new FileReader(f);
		JSONTokener jt= new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		given()
			.contentType("application/json")
			.body(data.toString())
			
		
		.when()
			.post("http://127.0.0.1:8089/api/v1/settings")
		
		.then()
			.statusCode(401); //Unauthorized
     }

	@Test (priority=5)
	void Post_updateIdentities() throws FileNotFoundException
	
	{
	
	File f_updateOfIdent=new File(".\\updateIdentitiesReqBody.json");
	FileReader fr_updateOfIdent=new FileReader(f_updateOfIdent);
	JSONTokener jt_updateOfIdent=new JSONTokener(fr_updateOfIdent);
	JSONObject data_updateOfIdent=new JSONObject(jt_updateOfIdent);
	
	
	
	
		given()
		.contentType("application/json")
		.body(data_updateOfIdent.toString())
			
		
		.when()
			.post("http://127.0.0.1:8089/api/v1/settings/identities")
		
		.then()
			.statusCode(401); //Unauthorized
     }
	
	
	@Test (priority=6)
	void Get_identityDescribtion() 
	
	{
		given()
		
		.when()
			.get("http://127.0.0.1:8089/api/v1/settings/identities/description")
		
		.then()
			.statusCode(401); //Unauthorized
     }
	
	@Test (priority=7)
	void Post_UpdateIdLists() throws FileNotFoundException 
	
	{
		File f_updateIdLists =new File(".\\updateIdentityListsReqBody.json");
		FileReader fr_updateIdLists=new FileReader(f_updateIdLists);
		JSONTokener jt_updateIdLists=new JSONTokener(fr_updateIdLists);
		JSONObject data_updateIdLists=new JSONObject(jt_updateIdLists);
		
		given()
			.contentType("application/json")
			.body(data_updateIdLists.toString())
		
		.when()
			.post("http://127.0.0.1:8089/api/v1/settings/lists")
		
		.then()
			.statusCode(401); //Unauthorized
     }
	
	
	@Test (priority=8)
	void Get_dataBaseSetting() 
	
	{
		
		
		given()
			
		.when()
			.get("http://127.0.0.1:8089/api/v1/settings/db")
		
		.then()
			.statusCode(401); //Unauthorized
     }
	
	
	
	@Test (priority=9)
	void Get_updatedataBaseSetting() throws FileNotFoundException 
	
	{
		File f_updateDbSettings =new File(".\\dataBaseSettingsReqBody.json");
		FileReader fr_updateDbSettings=new FileReader(f_updateDbSettings);
		JSONTokener tr_updateDbSettings =new JSONTokener(fr_updateDbSettings);
		JSONObject data_updateDbSettings=new JSONObject(tr_updateDbSettings);
		
			
		
		given()
			.contentType("application/json")
			.body(data_updateDbSettings.toString())
			
		.when()
			.post("http://127.0.0.1:8089/api/v1/settings/db")
		
		.then()
			.statusCode(401); //Unauthorized
     }
	
	
	@Test (priority=10)
	void Get_serviceVersion() 
	
	{
		given()
		
		.when()
			.get("http://127.0.0.1:8089/api/v1/version")
		
		.then()
			.statusCode(200) //success
			.header("Content-Type", "text/plain; charset=utf-8")
			.log().all();
     }
	
	
     }
 



