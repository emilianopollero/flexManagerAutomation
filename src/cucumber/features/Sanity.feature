@UI @Sanity
Feature: Sanity suite for flex manager

  Scenario: Open flex manager
    Given I open flex manager
    And I login with admin credentials

  Scenario Outline: User can create, publish, edit and delete Editorial and Links content
    Given I click on the navigation bar createContentDropdown and click on <contentEditorial>
    And I can see page contentCreationPage has all expected UI elements
    And I enter the required fields for <contentEditorial> with <editorialContentName>
    And I click on the content create element
    And I can see page <contentEditorial> has all expected UI elements
    When I click on the navigation bar manageContentDropdown and click on search
    Then I can see content with name <editorialContentName> is present
    And I click on the navigation bar createContentDropdown and click on <contentLinks>
    And I enter the required fields for <contentLinks> with <linksContentName>
    And I can see page contentCreationPage has all expected UI elements
    And I click on the content create element
    And I can see page <contentLinks> has all expected UI elements
    And I click on the navigation bar manageContentDropdown and click on search
    Then I can see content with name <linksContentName> is present
    And I publish content named <editorialContentName>
    And I click on the content list view page publish orders button
    And I verify content publish order is completed
    And I click on the navigation bar manageContentDropdown and click on search
    Then I can see <editorialContentName> of type Editorial is published in elasticsearch
    And I open flex manager
    And I click on the navigation bar manageContentDropdown and click on search
    And I publish content named <linksContentName>
    And I click on the content list view page publish orders button
    And I verify content publish order is completed
    And I click on the navigation bar manageContentDropdown and click on search
    Then I can see <linksContentName> of type Links is published in elasticsearch
    And I open flex manager
    And I click on the navigation bar manageContentDropdown and click on search
    And I edit content named <editorialContentName>
    And I change content field: title to this value: Test-Editorial-Title
    And I change content field: textBody to this value: Test-Editorial-Body
    When I click on the content update element
    And I go to content show page for content with name <editorialContentName>
    Then I can see this content field: title value is Test-Editorial-Title
    Then I can see this content field: body value is Test-Editorial-Body
    And I click on the navigation bar manageContentDropdown and click on search
    And I edit content named <linksContentName>
    And I delete and confirmDelete link details with content name <linksContentName>
    And I update link details
    When I click on the content update element
    And I go to content show page for content with name <linksContentName>
    Then I can see this content field: linkName value is TestEdit
    Then I can see this content field: linkUrl value is https://www.wikipedia.org/
    And I click on the navigation bar manageContentDropdown and click on search
    When I delete and confirmDelete content with content name <editorialContentName>
    Then I can see content with name <editorialContentName> is deleted
    When I delete and confirmDelete content with content name <linksContentName>
    Then I can see content with name <linksContentName> is deleted

    Examples:
      | contentEditorial | contentLinks | editorialContentName              | linksContentName              |
      | createEditorial  | createLinks  | AUTOMATION-TEST-EDITORIAL-CONTENT | AUTOMATION-TEST-LINKS-CONTENT |

  Scenario: Verify content list view page UI elements
    Then I can see page contentListViewPage has all expected UI elements

  Scenario Outline: User can create, publish and delete mappings
    Given I click on the navigation bar mappingsDropdown and click on search
    And I select mapping pos/locale <posLocale>
    And I select mapping type <mappingType>
    And I click on the mappings list view page create button
    When I use these values <value1> and <value2> to fill in the required <mappingType> mapping type fields using this template <templateName>
    Then I can see mapping was created
    And I select mapping pos/locale <posLocale>
    And I select mapping type <mappingType>
    When I publish mapping with template automationMappingTestTemplatePolleroDoNotTouch
    Then I check in flex-template-service mapping automationMappingTestTemplatePolleroDoNotTouch is present
    And I select mapping pos/locale <posLocale>
    And I select mapping type <mappingType>
    When I delete and confirmDelete mapping with template name automationMappingTestTemplatePolleroDoNotTouch
    Then I can see mapping automationMappingTestTemplatePolleroDoNotTouch is deleted

    Examples:
      | posLocale  | mappingType               | value1    | value2  | templateName                                   |
      | ORB.en_US  | Destination Travel Guides | Las Vegas | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EBUK.en_GB | Travel Guide Hotels       | Las Vegas | Chicago | automationMappingTestTemplatePolleroDoNotTouch |
      | EXP.en_US  | Flight Ond City           | Las Vegas | Chicago | automationMappingTestTemplatePolleroDoNotTouch |

  Scenario: Verify mapping list view page UI elements
    Then I can see page mappingListViewPage has all expected UI elements

  Scenario Outline: User can create, edit, publish and delete templates
    Given I click on the navigation bar templatesDropdown and click on search
    And I select template pos/locale EXP.en_US
    And I click on the templates list view page createBtn
    And I change template field: name to this value: <name>
    And I change template field: title to this value: <name>
    And I open template creation page designTab
    And I drag and drop this element: norailLayout to the template area
    And I save my changes
    And I can see page templateShowPage has all expected UI elements
    When I go to list view from templateShowPage
    And I select template pos/locale EXP.en_US
    Then I can see template <name> is present
    When I publish template with name <name>
    Then I click on the templates list view page publishOrdersBtn
    And I can see publish publish order was completed for template <name>
    And I can check template <name> is present in flextemplateservice
    And I open flex manager
    And I select template pos/locale EXP.en_US
    And I edit template with name <name>
    And I change template field: title to this value: <value>
    And I change template field: header to this value: <value>
    And I change template field: description to this value: <value>
    And I change template field: keywords to this value: <value>
    And I change template field: robots to this value: <value>
    When I save my changes
    Then I can see this template field: title value is <value>
    Then I can see this template field: header value is <value>
    Then I can see this template field: description value is <value>
    Then I can see this template field: keywords value is <value>
    Then I can see this template field: robots value is <value>
    And I go to list view from templateShowPage
    And I select template pos/locale EXP.en_US
    When I delete and confirmDelete template <name> in list view page
    Then I can see template <name> is deleted
    And I click on the templates list view page publishOrdersBtn
    And I can see delete publish order was completed for template <name>
    And I can check template <name> is notPresent in flextemplateservice

    Examples:
      | value                 | name                     |
      | automationEditedField | AUTOMATION_TEST_TEMPLATE |

  Scenario: Verify template list view page UI elements
    Given I open flex manager
    And I click on the navigation bar templatesDropdown and click on search
    Then I can see page templateListViewPage has all expected UI elements
    And I click on the navigation bar userDropdown and click on logout
