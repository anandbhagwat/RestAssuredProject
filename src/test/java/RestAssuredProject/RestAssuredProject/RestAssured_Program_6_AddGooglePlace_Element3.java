package RestAssuredProject.RestAssuredProject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssured_Program_6_AddGooglePlace_Element3 {
  @Test
  public void RestAssured_Program() {
	  RestAssured.baseURI="http://216.10.245.166";
	  //Storing response in response
	 Response resposneOutput= given().
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
	  		post("/maps/api/place/add/json").
	  		then().assertThat().statusCode(200).and().body("status",equalTo("OK")).
	  		extract().response();
	  		
	 		// We got response in raw format, hence converting raw response into string
	 		String respsonseAsString = resposneOutput.asString();
	 		System.out.println(respsonseAsString);
	 		//Then converting string into JSON response to traverse for specific element
	 		JsonPath js = new JsonPath(respsonseAsString);
	 		System.out.println(js.get("place_id"));
	 		
	 		String place_id = js.get("place_id");
	 		
	 		//Deleting the place with captured place _ id
	 		
	 		
	 		
	 		
	 		given().
	 				queryParam("key","AIzaSyCo4aImrLRZQCNUSWQbFiFdRcZuY2QCnEM").
	 		body("{"+
	 		    "\"place_id\":\""+place_id+"\""+
	 		"}"
).
	 		when().
	 		post("/maps/api/place/delete/json").
	 		then().assertThat().statusCode(200);
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 		
  }
  
}
