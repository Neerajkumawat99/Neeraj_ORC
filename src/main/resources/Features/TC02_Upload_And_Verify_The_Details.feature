Feature: Validate Application SalesIntel Orchestration Upload And Verify The Details

  @First @Sanity
  Scenario: To Validate SalesIntel Orchestration Login Functionality
  	Given Launch The URL
  	When Enter The User Name
  	And Enter The Password
  	And Click On Remember Me Check Box
  	And Click On Submit Button
  	
  @First @Sanity
  Scenario: To Validate SalesIntel Orchestration Upload CSV File Functionality
 	 When Click On Job Label
 	 And Click On Reverify Contact Button
 	 And Click On Create New Job
 	 And Enter Job Name In Reverify Contact Job Page
 	 And Enter The Comments In Reverify Contact Job Page
 	 And Upload The CSV File In Reverify Contact Job Page
 	 And Click On Submit Button In Reverify Contact Job Page
 	 
 	@First @Sanity
  Scenario: To Validate SalesIntel Orchestration Uploaded CSV File Functionality After Submitting
  	Then Validate The Toast Message After The CSV File Upload
 	 
 	@First @Sanity
  Scenario: To Validate SalesIntel Orchestration Search Activity Functionality
 	 When Click On Search Label
 	 And Click On Reverify Contact(RV)
 	 And Click On Actvity Label
 	 And Enter The Search Contact Deatils From CSV File
 	 And Click On Search Button In Search Actvity
 	 And Choose The Searched Contact Dropdown Option
 	 And Click On Get Activity Status 
 	 
 	@First @Sanity
  Scenario: To Validate SalesIntel Orchestration Process Status Information Functionality
  	When Click On Process Status Information Icon
  	Then Validate Process Status Information
  	When Click On Close Button In Process Status Information
  
  @First @Sanity
  Scenario: To Validate SalesIntel Orchestration Search Functionality
  	When Click On Task Label
  	And Click On Latest Uploaded CSV File
  	Then Validate The Toast Message
  	
  @First @Sanity
  Scenario: To Validate SalesIntel Orchestration Search Activity After Submitting the Tasks and 5 minutes of wait Functionality
   When Wait For 5 Minutes
 	 And Click On Search Label
 	 And Click On Reverify Contact(RV)
 	 And Click On Actvity Label
 	 And Enter The Search Contact Deatils From CSV File
 	 And Click On Search Button In Search Actvity
 	 And Choose The Searched Contact Dropdown Option
 	 And Click On Get Activity Status 
 	 
 	@First @Sanity
  Scenario: To Validate SalesIntel Orchestration Process Status Information After Submitting the Tasks and 5 minutes of wait Functionality
  	When Click On Process Status Information Icon
  	Then Validate Process Status Information
  	When Click On Close Button In Process Status Information
  	
  @First @Sanity
  Scenario: To Validate SalesIntel Orchestration Search Activity After Submitting the Tasks and 15 minutes of wait Functionality
   When Click On Task Label
   And Wait For 15 Minutes
 	 And Click On Search Label
 	 And Click On Reverify Contact(RV)
 	 And Click On Actvity Label
 	 And Enter The Search Contact Deatils From CSV File
 	 And Click On Search Button In Search Actvity
 	 And Choose The Searched Contact Dropdown Option
 	 And Click On Get Activity Status 
 	 
 	@First @Sanity
  Scenario: To Validate SalesIntel Orchestration Process Status Information After Submitting the Tasks and 15 minutes of wait Functionality
  	When Click On Process Status Information Icon
  	Then Validate Process Status Information
  	When Click On Close Button In Process Status Information
  	
  @First @Sanity
  Scenario: To Validate SalesIntel Orchestration Logout Functionality  	
  	And Click On Logout Button
  
  
 	 
 	 
 	  