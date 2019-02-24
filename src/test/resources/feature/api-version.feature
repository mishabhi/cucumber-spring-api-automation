@RunTest
Feature: Application Naming and Versionning
  
  Scenario: Get application name and api version via the rest API
    When I hit the "spm.ingestion.api.url" hello api
    Then I get the application name "spm.ingestion.api.name"
    And I get the api version "spm.ingestion.api.version"
   