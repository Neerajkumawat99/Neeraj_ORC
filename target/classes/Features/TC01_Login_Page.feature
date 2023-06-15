Feature: Validate Application SalesIntel Orchestration Login Page

  @First @Sanity
  Scenario: To Validate SalesIntel Orchestration Login Functionality
  	Given Launch The URL
  	When Enter The User Name
  	And Enter The Password
  	And Click On Remember Me Check Box
  	And Click On Submit Button
  	
  @First @Sanity
  Scenario: To Validate SalesIntel Orchestration Logout Functionality  	
  	And Click On Logout Button
  