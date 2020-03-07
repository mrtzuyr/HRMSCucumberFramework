package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;

public class PageInitiliazer extends BaseClass {
	
	protected static LoginPageElements login;
	protected static PersonalDetailsPageElements pdetails;
	protected static AddEmployeePageElements addEmp;
	protected static DashboardPageElements dashboard;
	
	
	public static void initializeAllPages() {
		
		login=new LoginPageElements();
		pdetails=new PersonalDetailsPageElements();
		addEmp=new AddEmployeePageElements();
		dashboard=new DashboardPageElements();
				
		
	}
	

}
