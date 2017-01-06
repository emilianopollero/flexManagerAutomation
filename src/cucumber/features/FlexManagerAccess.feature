@FlexManagerAccess
Feature: Create new users in Flex Manager and assign them roles  

  Scenario: Open Flex Manager
    Given I open flex manager
    And I login with admin credentials

  Scenario: Create Users and Assign Roles
    And I click on the navigation bar settingsDropDown and click on createUser
    And I create user
    And I click on the navigation bar settingsDropDown and click on roles
    And I assign roles to users

  Scenario: User logout
    And I click on the navigation bar userDropdown and click on logout