@UI @UserRoles @ModuleStoreRole
Feature: Verify user roles access to flex manager mapping features

  Scenario: Open flex manager
    Given I open flex manager

  Scenario Outline: As a user with Module Store Editor or Admin role I can create, edit and delete modules
    Given I login with <role> credentials
    And I click on the navigation bar templatesDropdown and click on ModuleStore
    And I click on the module store list view page create button
    When I create a definition with definition name AUTOMATION_TEST_DEFINITION, type MODULE and description AUTOMATION_TEST_DEFINITION
    And I go to list view from moduleStoreEditPage
    When I search for definition with name AUTOMATION_TEST_DEFINITION
    Then I can see definition AUTOMATION_TEST_DEFINITION of type MODULE is present
    And I edit definition with name AUTOMATION_TEST_DEFINITION and of type MODULE
    And I click on edit basic information button
    And I change definition field definition name with this value AUTOMATION_TEST_DEFINITION_EDITED
    And I change definition field definition type with this value REGION
    And I change definition field definition description with this value AUTOMATION_TEST_DEFINITION_EDITED
    When I click on the definition general properties update button
    Then I can see definition edit page value definition name is AUTOMATION_TEST_DEFINITION_EDITED
    And I can see definition edit page value definition type is REGION
    And I can see definition edit page value definition description is AUTOMATION_TEST_DEFINITION_EDITED
    And I go to list view from moduleStoreEditPage
    And I search for definition with name AUTOMATION_TEST_DEFINITION_EDITED
    And I delete definition with name AUTOMATION_TEST_DEFINITION_EDITED and of type REGION
    When I confirm definition delete
    And I click on the navigation bar templatesDropdown and click on search
    And I click on the navigation bar templatesDropdown and click on ModuleStore
    And I search for definition with name AUTOMATION_TEST_DEFINITION_EDITED
    Then I can see definition AUTOMATION_TEST_DEFINITION_EDITED of type REGION is not present
    And I click on the navigation bar userDropdown and click on logout

    Examples:
      | role              |
      | admin             |
      | moduleStoreEditor |

  Scenario Outline: As a user with viewer, mapping contributor, mapping editor, template contributor, template editor, content contributor
  or content editor roles I cannot create, edit or delete definitions.
    Given I login with <role> credentials
    When I click on the navigation bar templatesDropdown and click on ModuleStore
    Then I can see element createBtn from page moduleStoreListViewPage is disabled
    Then I can see element editBtn from page moduleStoreListViewPage is disabled
    Then I can see element deleteBtn from page moduleStoreListViewPage is disabled
    And I click on the navigation bar userDropdown and click on logout

    Examples:
      | role                |
      | viewer              |
      | mappingContributor  |
      | mappingEditor       |
      | templateContributor |
      | templateEditor      |
      | contentContributor  |
      | contentEditor       |