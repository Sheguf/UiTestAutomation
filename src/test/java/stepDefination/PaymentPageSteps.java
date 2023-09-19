package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PaymentPageSteps {

	
	
	
	@When("user enter card number")
	public void user_enter_card_number() {
		System.out.println("Card Number");
	}

	@When("click on pay button")
	public void click_on_pay_button() {
		System.out.println("Pay Button");
	}
	
	@When("validate successful order")
	public void validate_successful_order() {
		System.out.println("order");
	}
	
}
