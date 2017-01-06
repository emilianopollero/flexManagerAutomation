@ContentRegression @Regression @UI
Feature: Content Regression

  Scenario: Open flex manager
    Given I open flex manager
    And I login with admin credentials

  Scenario Outline: User can create Editorial, Introduction, Legal, ImageScape and Links content
    Given I click on the navigation bar createContentDropdown and click on <contentType>
    And I enter the required fields for <contentType> with <contentName>
    And I can see page contentCreationPage has all expected UI elements
    And I click on the content create element
    And I can see page <contentType> has all expected UI elements
    And I click on the navigation bar manageContentDropdown and click on search
    Then I can see content with name <contentName> is present

    Examples:
      | contentType        | contentName                          |
      | createEditorial    | AUTOMATION-TEST-EDITORIAL-CONTENT    |
      | createIntroduction | AUTOMATION-TEST-INTRODUCTION-CONTENT |
      | createLegal        | AUTOMATION-TEST-LEGAL-CONTENT        |
      | createImageScape   | AUTOMATION-TEST-IMAGESCAPE-CONTENT   |
      | createLinks        | AUTOMATION-TEST-LINKS-CONTENT        |

  Scenario Outline: User publishes content and verifies content is published to elastic search
    Given I open flex manager
    And I click on the navigation bar manageContentDropdown and click on search
    When I publish content named <contentName>
    And I click on the content list view page publish orders button
    And I verify content publish order is completed
    And I click on the navigation bar manageContentDropdown and click on search
    Then I can see <contentName> of type <contentType> is published in elasticsearch

    Examples:
      | contentType  | contentName                          |
      | Editorial    | AUTOMATION-TEST-EDITORIAL-CONTENT    |
      | Introduction | AUTOMATION-TEST-INTRODUCTION-CONTENT |
      | Legal        | AUTOMATION-TEST-LEGAL-CONTENT        |
      | ImageScape   | AUTOMATION-TEST-IMAGESCAPE-CONTENT   |
      | Links        | AUTOMATION-TEST-LINKS-CONTENT        |

  Scenario Outline: User can edit Editorial content
    Given I open flex manager
    And I click on the navigation bar manageContentDropdown and click on search
    And I edit content named <contentName>
    And I change content field: title to this value: <title>
    And I change content field: textBody to this value: <body>
    When I click on the content update element
    And I go to content show page for content with name <contentName>
    Then I can see this content field: title value is <title>
    Then I can see this content field: body value is <body>

    Examples:
      | contentName                       | title                | body                |
      | AUTOMATION-TEST-EDITORIAL-CONTENT | Test-Editorial-Title | Test-Editorial-Body |

  Scenario Outline: User can edit Links content
    Given I click on the navigation bar manageContentDropdown and click on search
    And I edit content named <contentName>
    And I delete and confirmDelete link details with content name <contentName>
    And I update link details
    When I click on the content update element
    And I go to content show page for content with name <contentName>
    Then I can see this content field: linkName value is <linkName>
    Then I can see this content field: linkUrl value is <linkUrl>

    Examples:
      | contentName                   | linkName | linkUrl                    |
      | AUTOMATION-TEST-LINKS-CONTENT | TestEdit | https://www.wikipedia.org/ |

  Scenario: Open the Content Search page
    Given I click on the navigation bar manageContentDropdown and click on search

  Scenario Outline: User deletes and cancels deletion of content
    Given I can see content with name <contentName> is present
    When I delete and cancelDelete content with content name <contentName>
    Then I can see content with name <contentName> is present

    Examples:
      | contentName                   |
      | AUTOMATION-TEST-LINKS-CONTENT |

  Scenario Outline: User deletes and confirms deletion of content
    Given I can see content with name <contentName> is present
    When I delete and confirmDelete content with content name <contentName>
    Then I can see content with name <contentName> is deleted

    Examples:
      | contentName                          |
      | AUTOMATION-TEST-EDITORIAL-CONTENT    |
      | AUTOMATION-TEST-INTRODUCTION-CONTENT |
      | AUTOMATION-TEST-LEGAL-CONTENT        |
      | AUTOMATION-TEST-IMAGESCAPE-CONTENT   |
      | AUTOMATION-TEST-LINKS-CONTENT        |

  Scenario: User logout
    Given I open flex manager
    And I click on the navigation bar userDropdown and click on logout
