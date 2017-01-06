@TemplateRegression @Regression @UI
Feature: Template regression

  Scenario: User can create a template
    Given I open flex manager
    And I login with admin credentials
    And I select template pos/locale EXP.en_US
    And I click on the templates list view page createBtn
    And I change template field: name to this value: AUTOMATION_TEST_TEMPLATE
    And I change template field: title to this value: AUTOMATION_TEST_TEMPLATE
    And I open template creation page designTab
    And I drag and drop this element: norailLayout to the template area
    And I save my changes
    And I go to list view from templateShowPage
    And I select template pos/locale EXP.en_US
    And I click on the templates list view page createBtn
    And I change template field: name to this value: AUTOMATION_TEST_TEMPLATE1
    And I change template field: title to this value: AUTOMATION_TEST_TEMPLATE1
    And I open template creation page designTab
    And I drag and drop this element: norailLayout to the template area
    And I save my changes
    And I can see page templateShowPage has all expected UI elements
    When I go to list view from templateShowPage
    And I select template pos/locale EXP.en_US
    Then I can see template AUTOMATION_TEST_TEMPLATE is present
    And I can see template AUTOMATION_TEST_TEMPLATE1 is present

  Scenario: User can publish templates from list view and show page.
    Given I show template with name AUTOMATION_TEST_TEMPLATE
    And I publish my template from show page
    And I go to list view from templateShowPage
    And I select template pos/locale EXP.en_US
    When I publish template with name AUTOMATION_TEST_TEMPLATE1
    Then I click on the templates list view page publishOrdersBtn
    And I can see publish publish order was completed for template AUTOMATION_TEST_TEMPLATE
    And I can see publish publish order was completed for template AUTOMATION_TEST_TEMPLATE1
    And I can check template AUTOMATION_TEST_TEMPLATE is present in flextemplateservice
    And I can check template AUTOMATION_TEST_TEMPLATE1 is present in flextemplateservice

  Scenario: User can edit a template from list view
    And I open flex manager
    And I select template pos/locale EXP.en_US
    And I edit template with name AUTOMATION_TEST_TEMPLATE
    And I change template field: title to this value: automationEditedField
    And I change template field: header to this value: automationEditedField
    And I change template field: description to this value: automationEditedField
    And I change template field: keywords to this value: automationEditedField
    And I change template field: robots to this value: automationEditedField
    When I save my changes
    Then I can see this template field: title value is automationEditedField
    Then I can see this template field: header value is automationEditedField
    Then I can see this template field: description value is automationEditedField
    Then I can see this template field: keywords value is automationEditedField
    Then I can see this template field: robots value is automationEditedField

  Scenario: User can edit a template from show page
    And I edit my template from show page
    And I change template field: title to this value: automationEditedField1
    And I change template field: header to this value: automationEditedField1
    And I change template field: description to this value: automationEditedField1
    And I change template field: keywords to this value: automationEditedField1
    And I change template field: robots to this value: automationEditedField1
    When I save my changes
    Then I can see this template field: title value is automationEditedField1
    Then I can see this template field: header value is automationEditedField1
    Then I can see this template field: description value is automationEditedField1
    Then I can see this template field: keywords value is automationEditedField1
    Then I can see this template field: robots value is automationEditedField1

  Scenario: User can cancel template deletion from list view page.
    Given I go to list view from templateShowPage
    And I select template pos/locale EXP.en_US
    When I delete and cancelDelete template AUTOMATION_TEST_TEMPLATE in list view page
    Then I can see template AUTOMATION_TEST_TEMPLATE is present

  Scenario: User can delete template from list view page.
    Given I delete and confirmDelete template AUTOMATION_TEST_TEMPLATE in list view page
    Then I can see template AUTOMATION_TEST_TEMPLATE is deleted
    And I click on the templates list view page publishOrdersBtn
    And I can see delete publish order was completed for template AUTOMATION_TEST_TEMPLATE

  Scenario: User can cancel template deletion from template show page.
    Given I click on the navigation bar templatesDropdown and click on search
    And I select template pos/locale EXP.en_US
    And I show template with name AUTOMATION_TEST_TEMPLATE1
    And I delete and cancelDelete the template in show page
    When I go to list view from templateShowPage
    And I select template pos/locale EXP.en_US
    Then I can see template AUTOMATION_TEST_TEMPLATE1 is present

  Scenario: User can delete template from template show page.
    Given I show template with name AUTOMATION_TEST_TEMPLATE1
    Given I delete and confirmDelete the template in show page
    Then I can see template AUTOMATION_TEST_TEMPLATE1 is deleted
    And I click on the templates list view page publishOrdersBtn
    And I can see delete publish order was completed for template AUTOMATION_TEST_TEMPLATE1
    And I can check template AUTOMATION_TEST_TEMPLATE is notPresent in flextemplateservice
    And I can check template AUTOMATION_TEST_TEMPLATE1 is notPresent in flextemplateservice

  Scenario: User logout
    Given I open flex manager
    And I click on the navigation bar userDropdown and click on logout