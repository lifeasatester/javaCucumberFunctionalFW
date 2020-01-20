package com.testone.runner;

import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

//@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)

@CucumberOptions(
		dryRun=false,
		strict=true,
		monochrome=false,
		features= {"src/test/resources/features/web"},
		glue = {"com.testone.cucumber.stepdefinition.web"},
		plugin= {
				"html:target/site/cucumber-html",
				"json:target/cucumber.json"}
		)

public class MyRunner {
	

}
