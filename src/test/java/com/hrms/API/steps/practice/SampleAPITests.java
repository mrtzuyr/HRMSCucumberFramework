package com.hrms.API.steps.practice;


import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class SampleAPITests {
	@Test
	public void getAllJobTitles() {
		Response response = RestAssured.given().contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3ODIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk4MiwidXNlcklkIjoiNjUifQ.OfgG6KnM_B9nNamV36NxJCCt7q4kTBZ3s3xCnfAxR7c")
				.when().get("http://54.167.125.15/syntaxapi/api/jobTitle.php");
		
		response.prettyPrint();
		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);
	}
	@Test
	public void getOneEmployee() {
		Response response = RestAssured.given().param("employee_id","3917").contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3ODIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk4MiwidXNlcklkIjoiNjUifQ.OfgG6KnM_B9nNamV36NxJCCt7q4kTBZ3s3xCnfAxR7c")
				.when().get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");
		response.prettyPrint();
	}
	
	@Test
	public void getAllEmployeeStatuses() {
		Response response = RestAssured.given().contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3ODIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk4MiwidXNlcklkIjoiNjUifQ.OfgG6KnM_B9nNamV36NxJCCt7q4kTBZ3s3xCnfAxR7c")
				.when().get("http://54.167.125.15/syntaxapi/api/employeeStatus.php");
		response.prettyPrint();
		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);
	}
	
	@Test
	public void createEmployee() {
		Response response = RestAssured.given().contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3ODIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk4MiwidXNlcklkIjoiNjUifQ.OfgG6KnM_B9nNamV36NxJCCt7q4kTBZ3s3xCnfAxR7c")
			.body("{\n    \"emp_firstname\": \"sacma\",\n    \"emp_lastname\": \"sapan\",\n    \"bisey\": \"Senior\",\n    \"emp_gender\": \"2\",\n    \"emp_birthday\": \"2000-02-19\",\n    \"emp_status\": \"Worker\",\n    \"emp_job_title\": \"Cloud Consultant\"\n}")
			.when().post("http://54.167.125.15/syntaxapi/api/createEmployee.php");
		
		response.prettyPrint();
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(200, actualStatusCode);
	}	
	
	//@Test
	public void getAllEmployees() {
		Response response = RestAssured.given().contentType("application/json").header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzI3ODIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU4Nzk4MiwidXNlcklkIjoiNjUifQ.OfgG6KnM_B9nNamV36NxJCCt7q4kTBZ3s3xCnfAxR7c")
				.when().get("http://54.167.125.15/syntaxapi/api/getAllEmployees.php");
		
		response.prettyPrint();
		int actualResponseCode = response.getStatusCode();
		System.out.println(actualResponseCode);
	}
	
}