package com.hrms.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import static io.restassured.RestAssured.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features    = "src/test/resources/features"
		,glue       = "com.hrms.API.steps.practice"
		,dryRun     = false
		,monochrome = true
		,tags       = "@SyntaxHRMSAPIEndToEnd"
		)




public class APIRunner {

}
