package com.hrms.steps;

import java.util.List;
import java.util.Map;

import org.apache.poi.poifs.nio.CleanerUtil;
import org.junit.Assert;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {
	
	
	String empId;

	@Given("I am logged into HRMS")
	public void i_am_logged_into_HRMS() {
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		jsClick(login.loginBtn);
	}

	@Given("I navigated to Add Employee Page")
	public void i_navigated_to_Add_Employee_Page() {
		 
		dashboard.navigateToAddEmployee();
	}

	@When("I add {string}, {string} and {string}")
	public void i_add_and(String fName, String mName, String lName) {

		sendText(addEmp.firstName, fName);
		sendText(addEmp.middleName, mName);
		sendText(addEmp.lastName, lName);
		empId = addEmp.id.getAttribute("value");
	}

	@When("I click Save")
	public void i_click_Save() {
		click(addEmp.button);
	}

	@Then("I see Employee has been succesfully added")
	public void i_see_Employee_has_been_succesfully_added() {

		Assert.assertEquals("Employee is NOT being added", pdetails.empId.getAttribute("value"), empId);
	}

	@Then("I see Employee with {string}, {string} and {string} is displayed")
	public void i_see_Employee_with_and_is_displayed(String string, String string2, String string3) {

		Assert.assertEquals("Employee is NOT being added", pdetails.empId.getAttribute("value"), empId);
	}

	@When("I delete employee id")
	public void i_delete_employee_id() {
		addEmp.id.clear();
	}

	@Then("I see employee without employee id is being added")
	public void i_see_employee_without_employee_id_is_being_added() {
		Assert.assertTrue("Id is shown",pdetails.empId.getText().isEmpty());

	}

	@Then("I see required error message next to the first and last name")
	public void i_see_required_error_message_next_to_the_first_and_last_name() {
		boolean errorName = addEmp.error1.isDisplayed();
		boolean errorLastName = addEmp.error2.isDisplayed();
		Assert.assertTrue(errorName);
		Assert.assertTrue(errorLastName);
	}

	@When("I click on create login checkbox")
	public void i_click_on_create_login_checkbox() {
		click(addEmp.checkbox);
	}

	@When("I enter {string}, {string} and {string}")
	public void i_enter_and(String string, String string2, String string3) {
		addEmp.createUser(string, string2, string3);
	}
	
	@When("I enter employee details")
	public void i_enter_employee_details(DataTable empDetails) {
		
		List<Map<String, String>> empDetailList=empDetails.asMaps();
		
		for(Map<String, String> map:empDetailList) {
			sendText(addEmp.firstName, map.get("FirstName"));
			sendText(addEmp.middleName, map.get("MiddleName"));
			sendText(addEmp.lastName, map.get("LastName"));
		}
	}
	

	@When("I click on Edit")
	public void clickOnEdit_SaveButton() {
		click(pdetails.editSave);
	}
	
	
	@Then("I am able to modify Employee Details")
	public void modifyEmployeeDetails(DataTable modifyEmpDetail) throws InterruptedException {
		
		List<Map<String, String>> modifyList=modifyEmpDetail.asMaps();

		
		
		for(Map<String,String> map:modifyList) {
			sendText(pdetails.driverLicence, map.get("DriverLisence"));
			sendText(pdetails.expDate, map.get("ExpirationDate"));
			sendText(pdetails.SSN, map.get("SSN"));
			sendText(pdetails.SIN, map.get("SIN"));
			clickRadio(pdetails.genderLabels, map.get("Gender"));
			selectDdValue(pdetails.maritalS, map.get("MaritalStatus"));
			selectDdValue(pdetails.nation, map.get("Nationality"));
			sendText(pdetails.DOB, map.get("DOB"));
			
			
			click(pdetails.editSave);
			Thread.sleep(2000);

			click(pdetails.editSave);
		}
		
	}
	
	
}
