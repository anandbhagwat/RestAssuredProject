package RestAssuredProject.RestAssuredProject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RestAssured_Program_6_AddGooglePlace_Element3 {
  @Test
  public void RestAssured_Program() {
	  RestAssured.baseURI="http://216.10.245.166";
	  
	  given().
	  		queryParam("key","AIzaSyCo4aImrLRZQCNUSWQbFiFdRcZuY2QCnEM").
	  		body("{"+

	  		    "\"location\":{"+

	  		        "\"lat\" : -38.383494,"+

	  		        "\"lng\" : 33.427362"+

	  		    "},"+

	  		    "\"accuracy\":100,"+

	  		    "\"name\":\"Bhagwat House\","+

	  		    "\"phone_number\":\"(+91) 7276261087\","+

	  		    "\"address\" : \"Shehar Peth\","+

	  		    "\"types\": [\"shoe park\",\"shop\"],"+

	  		    "\"website\" : \"http://google.com\","+

	  		    "\"language\" : \"French-IN\""+

	  		"}").
	  		when().
	  		post("/maps/api/place/add/json").andReturn();
	  
  }
  
}
