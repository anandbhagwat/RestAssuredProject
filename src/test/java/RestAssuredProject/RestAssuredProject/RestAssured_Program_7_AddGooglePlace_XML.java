package RestAssuredProject.RestAssuredProject;
import utilties.Utilties;
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
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssured_Program_7_AddGooglePlace_XML {
	Properties property = new Properties();
	@BeforeTest
	public void setupProperties() throws IOException{
		
		FileInputStream file = new FileInputStream("C:\\Users\\anbhagwat\\eclipse-workspace\\RestAssuredProject\\src\\test\\java\\Properties\\env.properties");
		property.load(file);
		
		
	}
  @Test
  public void RestAssured_Program() throws IOException {
	  RestAssured.baseURI=property.getProperty("HOST");
	 String PostData = Utilties.GenerateStringFromResource("C:\\Users\\anbhagwat\\eclipse-workspace\\RestAssuredProject\\src\\test\\java\\payload\\mypayload.xml");
	  //Storing response in response
	 Response resposneOutput= given().log().all().
	  		queryParam("key","AIzaSyCo4aImrLRZQCNUSWQbFiFdRcZuY2QCnEM").
	  		body(PostData).
	  		when().
	  		post("/maps/api/place/add/xml").
	  		then().assertThat().statusCode(200).
	  		extract().response();
	  		
	 		// We got response in raw format, hence converting raw response into string
	 		String respsonseAsString = resposneOutput.asString();
	 		System.out.println(respsonseAsString);
	 		
	 		//Then converting string into JSON response to traverse for specific element
	 		XmlPath x = Utilties.rawToXML(resposneOutput);
	 		
	 		
	 		System.out.println(x.get("response.place_id"));
	 		//Deleting the place with captured place _ id
	 		
	 		//https://github.com/rest-assured/rest-assured/wiki/Usage#logging
	 		given().log().all().
	 				queryParam("key","AIzaSyCo4aImrLRZQCNUSWQbFiFdRcZuY2QCnEM").
	 		body("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" + 
	 				"<root>\n" + 
	 				"    <place_id>"+x.get("response.place_id")+"</place_id>\n" + 
	 				"</root>\n" + 
	 				""
).
	 		when().
	 		post("/maps/api/place/delete/xml").
	 		then().assertThat().statusCode(200);
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
  }
  
  
	
}
