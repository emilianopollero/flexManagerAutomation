@UI @UserRoles @MappingRole
Feature: Verify user roles access to flex manager mapping features

  Scenario: Open flex manager
    Given I open flex manager

  Scenario Outline: As a user with Mapping Editor or Admin role, I can create, publish and delete mappings
    And I login with <role> credentials
    And I click on the navigation bar mappingsDropdown and click on search
    And I select mapping pos/locale ORB.en_US
    And I select mapping type Destination Travel Guides
    And I click on the mappings list view page create button
    When I use these values Louis Trichardt and Messina to fill in the required Destination Travel Guides mapping type fields using this template automationMappingTestTemplatePolleroDoNotTouch
    Then I can see mapping was created
    When I publish mapping with template automationMappingTestTemplatePolleroDoNotTouch
    Then I check in flex-template-service mapping automationMappingTestTemplatePolleroDoNotTouch is present
    When I delete and confirmDelete mapping with template name automationMappingTestTemplatePolleroDoNotTouch
    Then I can see mapping automationMappingTestTemplatePolleroDoNotTouch is deleted
    And I click on the navigation bar userDropdown and click on logout

    Examples:
      | role          |
      | admin         |
      | mappingEditor |


  Scenario Outline: As a user with Mapping Contributor role, I can create mappings but I cannot publish and delete mappings
    Given I login with <role> credentials
    And I click on the navigation bar mappingsDropdown and click on search
    And I select mapping pos/locale ORB.en_US
    And I select mapping type Destination Travel Guides
    And I click on the mappings list view page create button
    When I use these values Louis Trichardt and Messina to fill in the required Destination Travel Guides mapping type fields using this template automationMappingTestTemplatePolleroDoNotTouch
    Then I can see mapping was created
    And I can see element mappingPublishBtn from page mappingListViewPage is disabled
    And I can see element mappingDeleteBtn from page mappingListViewPage is disabled
    And I click on the navigation bar userDropdown and click on logout

    Examples:
      | role               |
      | mappingContributor |

  Scenario Outline: As a user with viewer, module store editor, template contributor, template editor, content contributor
  or content editor roles I cannot create, publish or delete mappings.
    Given I login with <role> credentials
    When I click on the navigation bar mappingsDropdown and click on search
    Then I can see element createBtn from page mappingListViewPage is disabled
    And I can see element mappingPublishBtn from page mappingListViewPage is disabled
    And I can see element mappingDeleteBtn from page mappingListViewPage is disabled
    And I click on the navigation bar userDropdown and click on logout

    Examples:
      | role                |
      | viewer              |
      | moduleStoreEditor   |
      | templateContributor |
      | templateEditor      |
      | contentContributor  |
      | contentEditor       |

  Scenario: Delete mapping
    Given I login with admin credentials
    And I click on the navigation bar mappingsDropdown and click on search
    When I delete and confirmDelete mapping with template name automationMappingTestTemplatePolleroDoNotTouch
    Then I can see mapping automationMappingTestTemplatePolleroDoNotTouch is deleted
    And I click on the navigation bar userDropdown and click on logout