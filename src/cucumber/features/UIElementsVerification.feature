@Regression @UI

Feature: Verification of Flex Manager UI elements

  Scenario: Log in to flex manager
    Given I open flex manager
    And I login with admin credentials

  Scenario: Verify template list view page UI elements
    Then I can see page templateListViewPage has all expected UI elements

  Scenario: Verify content list view page UI elements
    And I click on the navigation bar manageContentDropdown and click on search
    Then I can see page contentListViewPage has all expected UI elements

  Scenario: Verify mapping list view page UI elements
    And I click on the navigation bar mappingsDropdown and click on search
    Then I can see page mappingListViewPage has all expected UI elements

  Scenario: User logout
    Given I open flex manager
    And I click on the navigation bar userDropdown and click on logout
