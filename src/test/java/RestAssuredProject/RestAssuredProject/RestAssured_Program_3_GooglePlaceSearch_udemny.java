package RestAssuredProject.RestAssuredProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RestAssured_Program_3_GooglePlaceSearch_udemny {
  @Test
  public void RestAssured_Program() {
	  RestAssured.baseURI="https://maps.googleapis.com";
	  
	  given().
	  		param("input","Basmath").
	  		param("inputtype","textquery").
	  		param("key","AIzaSyCo4aImrLRZQCNUSWQbFiFdRcZuY2QCnEM").
	  		param("fields","photos,formatted_address,name,rating,opening_hours,geometry,opening_hours").
	  when().
	  	get("/maps/api/place/findplacefromtext/json").
	  		then().assertThat().statusCode(200).and().assertThat().contentType(ContentType.JSON);
  }
}
