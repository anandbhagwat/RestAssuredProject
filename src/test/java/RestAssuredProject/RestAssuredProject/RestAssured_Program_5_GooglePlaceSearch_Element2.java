package RestAssuredProject.RestAssuredProject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RestAssured_Program_5_GooglePlaceSearch_Element2 {
  @BeforeTest
  public void RestAssured_Program() {
	  RestAssured.baseURI="https://maps.googleapis.com";
	  
	  given().
	  		param("input","Basmath").
	  		param("inputtype","textquery").
	  		param("key","AIzaSyCo4aImrLRZQCNUSWQbFiFdRcZuY2QCnEM").
	  		param("fields","photos,formatted_address,name,rating,opening_hours,geometry,opening_hours").
	  when().
	  	get("/maps/api/place/findplacefromtext/json").
	  		then().assertThat().statusCode(200).and().assertThat().contentType(ContentType.JSON).and().
	  		assertThat().body("candidates[0].name",equalTo("Basmat"));
	  //https://jsoneditoronline.org/
  }
  @Test
  public void testStatusCode() {
	  given().
		param("input","Basmath").
		param("inputtype","textquery").
		param("key","AIzaSyCo4aImrLRZQCNUSWQbFiFdRcZuY2QCnEM").
		param("fields","photos,formatted_address,name,rating,opening_hours,geometry,opening_hours").
when().
	  get("/maps/api/place/findplacefromtext/json").
	  then().assertThat().statusCode(200).and().assertThat().contentType(ContentType.JSON).and().
		assertThat().body("candidates[0].name",equalTo("Basmat"));
  }
  @Test
  public void testContentType() {
	  given().
		param("input","Basmath").
		param("inputtype","textquery").
		param("key","AIzaSyCo4aImrLRZQCNUSWQbFiFdRcZuY2QCnEM").
		param("fields","photos,formatted_address,name,rating,opening_hours,geometry,opening_hours").
when().
	  get("/maps/api/place/findplacefromtext/json").
	  then().assertThat().contentType(ContentType.JSON);
  }
  @Test
  public void testCityeName() {
	  given().
		param("input","Basmath").
		param("inputtype","textquery").
		param("key","AIzaSyCo4aImrLRZQCNUSWQbFiFdRcZuY2QCnEM").
		param("fields","photos,formatted_address,name,rating,opening_hours,geometry,opening_hours").
when().
	  get("/maps/api/place/findplacefromtext/json").
	  then().assertThat().body("candidates[0].name",equalTo("Basmat"));
  }
}
