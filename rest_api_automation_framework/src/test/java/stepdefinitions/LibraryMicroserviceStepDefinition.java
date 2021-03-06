package stepdefinitions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import api_automation_utils.RestApiUtils;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import junit.framework.Assert;
import microservice_config.RestapiHeaders;

public class LibraryMicroserviceStepDefinition extends RestApiUtils{

	private String baseUri;
	private String endpoint;
	FileReader reader;
	Properties prop = new Properties();
	private Response response;
	
	@Before
	public void before() throws IOException {
	    reader=new FileReader("src\\main\\java\\microservice_config\\LibraryService.properties");  
		prop.load(reader);
		baseUri = prop.getProperty("host");		
	}
	
	@Given("I make a {string} API call")
	public void i_make_a_api_call(String api) {
	    // Write code here that turns the phrase above into concrete actions
		Headers headers = new Headers(RestapiHeaders.contentTypeJson);
		if(api.equalsIgnoreCase("addbook")) {
			endpoint = baseUri + prop.getProperty("addbookAPI");
			String addbookPayload = "{\r\n"
					+ "\r\n"
					+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
					+ "\"isbn\":\"1238192\",\r\n"
					+ "\"aisle\":\"1231231\",\r\n"
					+ "\"author\":\"dasjkhdaskjhdkja\"\r\n"
					+ "}\r\n"
					+ "";
			response = postApiCall(endpoint, headers, addbookPayload);
		}
		 
	}

	@When("api response status of {string} is received")
	public void api_response_status_of_is_received(String responseStatus) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(responseStatus, response.statusCode());
	}

	@When("check the {string} field is correctly present in the api response")
	public void check_the_field_is_correctly_present_in_the_api_response(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I make a GetBook API call using {string}")
	public void i_make_a_get_book_api_call_using(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("check the fields value present in response is not null")
	public void check_the_fields_value_present_in_response_is_not_null() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I made a {string} API call")
	public void i_made_a_api_call(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("check the api response message contains {string}")
	public void check_the_api_response_message_contains(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
