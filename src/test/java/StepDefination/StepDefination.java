package StepDefination;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResource;
import resources.TestDataBuild;
import resources.Utils;

import static org.junit.Assert.*;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;


@RunWith(Cucumber.class)
@Test
public class StepDefination extends Utils {


	RequestSpecification resp;
	Response  rp ;
	TestDataBuild data = new TestDataBuild();
	static String placeid;


	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {

		resp= given().relaxedHTTPSValidation().spec(requestSpecification())
				.body(data.addplacePayload(name, language, address));



	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {

		APIResource resourceapi =APIResource.valueOf(resource);
		System.out.println(resourceapi.getResource());

		if(method.equalsIgnoreCase("POST"))
			rp =resp.when().post(resourceapi.getResource());

		else if(method.equalsIgnoreCase("GET"))
			rp =resp.when().get(resourceapi.getResource());

		else if(method.equalsIgnoreCase("PUT"))
			rp =resp.when().put(resourceapi.getResource());

		else if (method.equalsIgnoreCase("DELETE"))
			rp =resp.when().delete(resourceapi.getResource());




	}
	@Then("the API call got succes with status code {int}")
	public void the_api_call_got_succes_with_status_code(Integer int1) {
		int sc = rp.getStatusCode();
		if(sc==200) {
			assertEquals(sc,200);
			System.out.println("Status code:"+sc);
		}
		else {
			System.out.println("Incorrect status code"+sc);
		}
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {


		assertEquals(jsonpath(rp,key),value);

	}

	@Then("verify place_id created maps to {string} with {string}")
	public void verify_place_id_created_maps_to_with(String expectedname, String resource) throws IOException {

		placeid = jsonpath(rp,"place_id");
		resp= given().relaxedHTTPSValidation().spec(requestSpecification()).queryParam("place_id",placeid);
		user_calls_with_http_request(resource, "GET");

		String actualname = jsonpath(rp,"name");
		assertEquals(actualname,expectedname);
	}




	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {

		resp =given().relaxedHTTPSValidation().spec(requestSpecification()).body(data.deletePlacePayload(placeid));



	}



}

