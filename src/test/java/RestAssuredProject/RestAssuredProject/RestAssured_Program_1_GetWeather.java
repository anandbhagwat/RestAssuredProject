package RestAssuredProject.RestAssuredProject;

import org.testng.annotations.Test;

import groovyjarjarasm.asm.commons.Method;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssured_Program_1_GetWeather {
  @Test
  public void RestAssured_Program() {
	  RestAssured.baseURI="http://restapi.demoqa.com";
	  String basePath = RestAssured.basePath="/utilities/weather/city/mumbai";
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  Response httpResponse = httpRequest.request(io.restassured.http.Method.GET, basePath);
	  String responseBody = httpResponse.getBody().asString();
	  System.out.println(responseBody);
  }
}
