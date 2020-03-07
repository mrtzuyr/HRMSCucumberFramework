package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends CommonMethods {
	
	
	

	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
		
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		//login.login("username", "password");
	}

	@When("I click login button")
	public void i_click_login_button() {
		click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
		System.out.println("I am logged in");
	}
	
	@When("I enter valid username and invalid password")
	public void i_enter_valid_username_and_invalid_password() {
		
		sendText(login.username, "Admin");
	    sendText(login.password, "fhgfr");
	}

	@Then("I see error message")
	public void i_see_error_message() {
		
	 boolean error=login.errorMsg.isDisplayed();
	 Assert.assertTrue("Error message is not displayed" ,error);
	}
	
	@When("I enter {string} and {string}")
	public void i_enter_and(String string, String string2) {
		
	   sendText(login.username, string);
	   sendText(login.password, string2);
	}

	@Then("I see {string}")
	public void i_see(String string) {
		
	    String errMessage=login.errorMsg.getText();
	    Assert.assertEquals("Error message is not displayed" ,string ,errMessage);
	}
}
