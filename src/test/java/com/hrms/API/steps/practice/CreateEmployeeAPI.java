package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import static io.restassured.RestAssured.*;

import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CreateEmployeeAPI {
	

	private Response response;
	private static RequestSpecification request;
	
	@Given("user calls createEmployee API")
	public void user_calls_createEmployee_API() {
		// Write code here that turns the phrase above into concrete actions

		request = given().header("Content-Type", "application/json").header("Authorization",
				SyntaxAPIAuthenticationSteps.Token);

		request.body(CommonMethods.readJson(
				"C:\\Users\\murta\\eclipse-workspace\\HrmsCucumberFramework"
				+ "\\src\\test\\resources\\JSONFiles\\createEmployee.json"));

	}

	@When("User retrieves response")
	public void user_retrieves_response() {
		// Write code here that turns the phrase above into concrete actions
		
		response = request.post("http://54.167.125.15/syntaxapi/api/createEmployee.php");
	}

	@Then("status code is {int}")
	public void status_code_is(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
	
		response.then().assertThat().statusCode(int1);
		
	}

	@Then("user validates employee is created")
	public void user_validates_employee_is_created() {
		System.out.println("Response is "+response.prettyPrint());
	}
	
}
