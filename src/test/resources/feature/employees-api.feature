@RunTest
Feature: Validation of Employee Apis

  Scenario: Get application name and api version via the rest API
    When User hits the api.get.employees.list.url api to retrieve the list of employees
    Then Api returns 200 status code
    And Response should have the list of employees.
    
  Scenario: Create an employee
  	When User hits the api.create.employee.url api to create an employee with 
  			|name|salary|age|
  			|Abhi|098		|34|
  		
		Then Api returns 200 status code
		And Response should have the id generated for Employee.  
