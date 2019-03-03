package RestAssuredProject.RestAssuredProject;
import resources.Resources;
import payload.Payload;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssured_Program_6_AddGooglePlace_Properties {
	Properties property = new Properties();
	@BeforeTest
	public void setupProperties() throws IOException{
		
		FileInputStream file = new FileInputStream("C:\\Users\\anbhagwat\\eclipse-workspace\\RestAssuredProject\\src\\test\\java\\Properties\\env.properties");
		property.load(file);
		
		
	}
  @Test
  public void RestAssured_Program() {
	  RestAssured.baseURI=property.getProperty("HOST");
	  //Storing response in response
	 Response resposneOutput= given().
	  		queryParam("key",property.getProperty("key")).
	  		body(Payload.getPostPayload()).
	  		when().
	  		post(Resources.postData()).
	  		then().assertThat().statusCode(200).and().body("status",equalTo("OK")).
	  		extract().response();
	  		
	 		// We got response in raw format, hence converting raw response into string
	 		
	 
	 		String respsonseAsString = resposneOutput.asString();
	 		System.out.println(respsonseAsString);
	 		
	 		
	 		//JsonPath js = new JsonPath(resposneOutput.asString()); //Not Alowed
	 		//Then converting string into JSON response to traverse for specific element
	 		JsonPath js = new JsonPath(respsonseAsString);
	 		System.out.println(js.get("place_id"));
	 		
	 		String place_id = js.get("place_id");
	 		
	 		//Deleting the place with captured place _ id
	 		
	 		
	 		
	 		
	 		given().
	 				queryParam("key",property.getProperty("key")).
	 		body(Payload.getDeletePayload(place_id)).
	 		when().
	 		post(Resources.deleteData()).
	 		then().assertThat().statusCode(200);
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
  }
  
}
