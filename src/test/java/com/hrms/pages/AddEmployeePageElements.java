package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods{
	
	
	@FindBy(id="firstName")
	public WebElement firstName; 
	
	@FindBy(id="middleName")
	public WebElement middleName; 
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="employeeId")
	public WebElement id; 
	
	@FindBy(id="btnSave")
	public WebElement button; 
	
	@FindBy(id="chkLogin")
	public WebElement checkbox;
	
	@FindBy(xpath="//span[@for='firstName']" )
	public WebElement error1;
	
	@FindBy(xpath="//span[@for='lastName']" )
	public WebElement error2;
	
	@FindBy(id="user_name")
	public WebElement userName;
	
	@FindBy(id="user_password")
	public WebElement password;
	
	@FindBy(id="re_password")
	public WebElement confirmPassword;
	
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void addEmployee(String name, String mName, String lName) {
		sendText(firstName, name);
		sendText(middleName, mName);
		sendText(lastName, lName);
		//jsClick(button);
	}
	
	public void createUser(String uName, String pWord, String rPword) {
		//click(checkbox);
		sendText(userName, uName);
		sendText(password, pWord);
		sendText(confirmPassword, rPword);
		//jsClick(button);
	}
	
	
}
