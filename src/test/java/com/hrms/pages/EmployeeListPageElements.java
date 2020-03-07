package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class EmployeeListPageElements {
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement id;
	
	public EmployeeListPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
