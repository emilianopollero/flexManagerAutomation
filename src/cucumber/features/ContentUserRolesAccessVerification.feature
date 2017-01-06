@UI @UserRoles @ContentRole
Feature: Verify user roles access to flex manager content features

  Scenario: Open flex manager
    Given I open flex manager

  Scenario Outline: As a user with Content Editor or Admin role, I can create, edit, publish and delete content
    And I login with <role> credentials
    And I click on the navigation bar createContentDropdown and click on createEditorial
    And I enter the required fields for createEditorial with AUTOMATION-TEST-EDITORIAL-CONTENT
    And I click on the content create element
    When I click on the navigation bar manageContentDropdown and click on search
    Then I can see content with name AUTOMATION-TEST-EDITORIAL-CONTENT is present
    And I edit content named AUTOMATION-TEST-EDITORIAL-CONTENT
    And I change content field: title to this value: test
    And I change content field: textBody to this value: test
    When I click on the content update element
    Then I can see this content field: title value is test
    Then I can see this content field: body value is test
    And I click on the navigation bar manageContentDropdown and click on search
    When I publish content named AUTOMATION-TEST-EDITORIAL-CONTENT
    Then I can see AUTOMATION-TEST-EDITORIAL-CONTENT of type Editorial is published in elasticsearch
    And I open flex manager
    And I click on the navigation bar manageContentDropdown and click on search
    And I delete and confirmDelete content with content name AUTOMATION-TEST-EDITORIAL-CONTENT
    Then I can see content with name AUTOMATION-TEST-EDITORIAL-CONTENT is deleted
    And I click on the navigation bar userDropdown and click on logout

    Examples:
      | role          |
      | admin         |
      | contentEditor |

  Scenario Outline: As a user with Content Contributor role, I can create and edit content but I cannot publish and delete content
    Given I login with <role> credentials
    And I click on the navigation bar createContentDropdown and click on createEditorial
    And I enter the required fields for createEditorial with AUTOMATION-TEST-EDITORIAL-CONTENT
    And I click on the content create element
    When I click on the navigation bar manageContentDropdown and click on search
    Then I can see content with name AUTOMATION-TEST-EDITORIAL-CONTENT is present
    And I edit content named AUTOMATION-TEST-EDITORIAL-CONTENT
    And I change content field: title to this value: test
    And I change content field: textBody to this value: test
    When I click on the content update element
    Then I can see this content field: title value is test
    Then I can see this content field: body value is test
    When I click on the navigation bar manageContentDropdown and click on search
    Then I can see element contentPublishBtn from page contentListViewPage is disabled
    And I can see element contentDeleteBtn from page contentListViewPage is disabled
    And I click on the navigation bar userDropdown and click on logout

    Examples:
      | role               |
      | contentContributor |

  Scenario Outline: As a user with viewer, module store editor, template contributor, template editor, mapping contributor
    or mapping editor roles I cannot create, edit, publish or delete content.
    Given I login with <role> credentials
    And I click on the navigation bar manageContentDropdown and click on search
    Then I can see element contentEditBtn from page contentListViewPage is disabled
    Then I can see element contentPublishBtn from page contentListViewPage is disabled
    And I can see element contentDeleteBtn from page contentListViewPage is disabled
    And I can see element createEditorial from page flexManagerPage is disabled
    And I can see element createIntroduction from page flexManagerPage is disabled
    And I can see element createLegal from page flexManagerPage is disabled
    And I can see element createImageScape from page flexManagerPage is disabled
    And I can see element createLinks from page flexManagerPage is disabled
    And I can see element createTable from page flexManagerPage is disabled
    And I click on the navigation bar userDropdown and click on logout

    Examples:
      | role                |
      | viewer              |
      | moduleStoreEditor   |
      | templateContributor |
      | templateEditor      |
      | mappingContributor  |
      | mappingEditor       |

  Scenario: Delete content
    Given I login with admin credentials
    And I click on the navigation bar manageContentDropdown and click on search
    When I delete and confirmDelete content with content name AUTOMATION-TEST-EDITORIAL-CONTENT
    Then I can see content with name AUTOMATION-TEST-EDITORIAL-CONTENT is deleted
    And I click on the navigation bar userDropdown and click on logout