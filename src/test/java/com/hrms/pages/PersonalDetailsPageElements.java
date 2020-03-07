package com.hrms.pages;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElements {
	
	@FindBy(id="empPic")
	public WebElement empPicture;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement nameOnPicture;
	
	@FindBy(xpath="//input[@id='personal_txtEmployeeId']")
	public WebElement empId;
	
	@FindBy(id="btnSave")
	public WebElement editSave;
	
	@FindBy(id="personal_txtLicenNo")
	public WebElement driverLicence;
	
	@FindBy(id="personal_txtNICNo")
	public WebElement SSN;
	
	@FindBy(id="personal_txtSINNo")
	public WebElement SIN;
	

	@FindBy(xpath="//label[contains(@for, 'personal_optGender')]")
	public List<WebElement> genderLabels;
	
	@FindBy(name="personal[cmbMarital]")
	public WebElement maritalS;
	
	@FindBy(name="personal[cmbNation]")
	public WebElement nation;
	
	@FindBy(name="personal[txtLicExpDate]")
	public WebElement expDate;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//tbody//tr//td")
	public WebElement expDateTable;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	public WebElement monthPickDropDown;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	public WebElement yearPickDropDown;
	
	@FindBy(name="personal[DOB]")
	public WebElement DOB;
	
	
	
	
	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}