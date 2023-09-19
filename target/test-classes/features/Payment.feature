Feature: payment functionality

@Smoke @Reg
Scenario: payment with card
When user login with valid details
Then validate successful login

@Reg
Scenario: payment with UPI
When user login with valid details
Then validate successful login

@Reg
Scenario: payment with COD
When user login with valid details
Then validate successful login

