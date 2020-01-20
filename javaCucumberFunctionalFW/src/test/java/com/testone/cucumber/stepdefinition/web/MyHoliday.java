package com.testone.cucumber.stepdefinition.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.testone.framework.common.CommonActionHelper;
import com.testone.framework.web.helpers.WebDriverHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyHoliday extends CommonActionHelper{
	
	public MyHoliday () {
		
	}
	
	
	@Given ("I live in Bangalore")
	public void i_live() {
		System.out.println("I live in BLR");
	}
	
	
	@Given("I want to go on holiday")
	public void i_want_to_go_on_holiday() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I want to go on holiday");
		
	}

	@Given("we are {int} adults")
	public void we_are_adults(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("we are {int} adults");
	    
	}

	@Given("we want to book from {int}th Jan {int} to {int}th Feb {int}")
	public void we_want_to_book_from_th_Jan_to_th_Feb(Integer int1, Integer int2, Integer int3, Integer int4) {
		System.out.println("we want to book from {int}th Jan {int} to {int}th Feb {int}");
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("I go to travel agent")
	public void i_go_to_travel_agent() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I go to travel agent");
		
	}

	@Then("he should be able to help me in a budget of {int} Rs")
	public void he_should_be_able_to_help_me_in_a_budget_of_Rs(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("he should be able to help me in a budget of {int} Rs");
		
	}

	@Then("he should provide option to cancel")
	public void he_should_provide_option_to_cancel() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("he should provide option to cancel");
		
	}

	
	
	
	
	
}
