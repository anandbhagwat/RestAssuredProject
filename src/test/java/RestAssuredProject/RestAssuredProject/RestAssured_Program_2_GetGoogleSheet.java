package RestAssuredProject.RestAssuredProject;

import org.testng.annotations.Test;

import groovyjarjarasm.asm.commons.Method;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_Program_2_GetGoogleSheet {
  @Test
  public void RestAssured_Program() {
	  RestAssured.baseURI="https://sheetsu.com/apis/v1.0su/4fcbddd4dafd";
	  String basePath = RestAssured.basePath="/";
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  Response httpResponse = httpRequest.request(io.restassured.http.Method.GET, basePath);
	  String responseBody = httpResponse.getBody().asString();
	  System.out.println(responseBody);
  }
}
