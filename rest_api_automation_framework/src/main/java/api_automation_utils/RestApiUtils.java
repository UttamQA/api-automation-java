package api_automation_utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.Headers;

interface IRestApiUtils{
	public Response postApiCall(String endpoint,Headers headers,Object object); 
	public Response getApiCall(String endpoint,Headers headers);
	public Response putApiCall(String endpoint,Headers headers,Object object);
	public Response deleteApiCall(String endpoint,Headers headers,Object object);
}

public class RestApiUtils implements IRestApiUtils{

	@Override
	public Response postApiCall(String endpoint,Headers headers,Object object) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = endpoint;
		return given().log().all().headers(headers).body(object)
				.when().post()
				.then().log().all().extract().response();
	}

	@Override
	public Response getApiCall(String endpoint,Headers headers) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = endpoint;
		return given().log().all().headers(headers)
				.when().get()
				.then().log().all().extract().response();
	}

	@Override
	public Response putApiCall(String endpoint,Headers headers,Object object) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = endpoint;
		return given().log().all().headers(headers)
				.when().put()
				.then().log().all().extract().response();
	}

	@Override
	public Response deleteApiCall(String endpoint,Headers headers,Object object) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = endpoint;
		return given().log().all().headers(headers)
				.when().delete()
				.then().log().all().extract().response();
	}
	
	
}
