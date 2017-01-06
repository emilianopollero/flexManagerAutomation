@UI @UserRoles @TemplateRole
Feature: Verify user roles access to flex manager template features

  Scenario Outline: Verify that the following user roles can create templates

    Given I open flex manager
    And I login with <role> credentials
    And I click on the navigation bar templatesDropdown and click on search
    And I select template pos/locale ORB.en_US
    And I click on the templates list view page createBtn
    And I change template field: name to this value: ROLES_TEST_TEMPLATE
    And I change template field: title to this value: ROLES_TEST_TEMPLATE
    And I open template creation page designTab
    And I drag and drop this element: norailLayout to the template area
    And I save my changes
    When I go to list view from templateShowPage
    And I select template pos/locale ORB.en_US
    Then I can see template ROLES_TEST_TEMPLATE is present
    And I click on the navigation bar userDropdown and click on logout
    And I login with admin credentials
    And I select template pos/locale ORB.en_US
    And I delete and confirmDelete template ROLES_TEST_TEMPLATE in list view page
    And I click on the navigation bar userDropdown and click on logout

    Examples:
      | role                |
      | admin               |
      | templateContributor |
      | templateEditor      |

  Scenario Outline: Verify that the following user roles can publish templates

    And I login with <role> credentials
    And I click on the navigation bar templatesDropdown and click on search
    And I select template pos/locale ORB.en_US
    And I click on the templates list view page createBtn
    And I change template field: name to this value: ROLES_TEST_TEMPLATE
    And I change template field: title to this value: ROLES_TEST_TEMPLATE
    And I open template creation page designTab
    And I drag and drop this element: norailLayout to the template area
    And I save my changes
    When I go to list view from templateShowPage
    And I select template pos/locale ORB.en_US
    Then I can see template ROLES_TEST_TEMPLATE is present
    And I show template with name ROLES_TEST_TEMPLATE
    And I publish my template from show page
    And I go to list view from templateShowPage
    Then I click on the templates list view page publishOrdersBtn
    And I can see publish publish order was completed for template ROLES_TEST_TEMPLATE
    And I can check template ROLES_TEST_TEMPLATE is present in flextemplateservice
    And I open flex manager
    And I click on the navigation bar userDropdown and click on logout
    And I login with admin credentials
    And I select template pos/locale ORB.en_US
    And I delete and confirmDelete template ROLES_TEST_TEMPLATE in list view page
    And I click on the navigation bar userDropdown and click on logout


    Examples:
      | role           |
      | admin          |
      | templateEditor |

  Scenario Outline: Verify that the following user roles can edit templates

    And I login with <role> credentials
    And I click on the navigation bar templatesDropdown and click on search
    And I select template pos/locale ORB.en_US
    And I click on the templates list view page createBtn
    And I change template field: name to this value: ROLES_TEST_TEMPLATE
    And I change template field: title to this value: ROLES_TEST_TEMPLATE
    And I open template creation page designTab
    And I drag and drop this element: norailLayout to the template area
    And I save my changes
    And I go to list view from templateShowPage
    And I select template pos/locale ORB.en_US
    And I edit template with name ROLES_TEST_TEMPLATE
    And I change template field: title to this value: automationEditedField
    When I save my changes
    Then I can see this template field: title value is automationEditedField
    And I click on the navigation bar userDropdown and click on logout
    And I login with admin credentials
    And I go to list view from templateShowPage
    And I select template pos/locale ORB.en_US
    And I delete and confirmDelete template ROLES_TEST_TEMPLATE in list view page
    And I click on the navigation bar userDropdown and click on logout

    Examples:
      | role                |
      | admin               |
      | templateContributor |
      | templateEditor      |

  Scenario Outline: Verify that the following user roles can clone templates

    And I login with <role> credentials
    And I click on the navigation bar templatesDropdown and click on search
    And I select template pos/locale ORB.en_US
    And I click on the templates list view page createBtn
    And I change template field: name to this value: ROLES_TEST_TEMPLATE
    And I change template field: title to this value: ROLES_TEST_TEMPLATE
    And I open template creation page designTab
    And I drag and drop this element: norailLayout to the template area
    And I save my changes
    And I clone my template from show page
    And I clone my template to CTIX.en_US from templateShowPage
    And I save my changes
    And I go to list view from templateShowPage
    And I select template pos/locale CTIX.en_US
    Then I can see template ROLES_TEST_TEMPLATE is present
    And I click on the navigation bar userDropdown and click on logout
    And I login with admin credentials
    And I select template pos/locale ORB.en_US
    And I delete and confirmDelete template ROLES_TEST_TEMPLATE in list view page
    And I select template pos/locale CTIX.en_US
    And I delete and confirmDelete template ROLES_TEST_TEMPLATE in list view page
    And I click on the navigation bar userDropdown and click on logout

    Examples:
      | role                |
      | admin               |
      | templateContributor |
      | templateEditor      |

  Scenario Outline: Verify that the following user roles can not create templates

    Given I login with <role> credentials
    When I click on the navigation bar templateDropdown and click on search
    Then I can see element dropdownCreateBtn from page templateListViewPage is disabled
    And I can see element createBtn from page templateListViewPage is disabled
    And I click on the navigation bar userDropdown and click on logout


    Examples:
      | role               |
      | viewer             |
      | moduleStoreEditor  |
      | contentContributor |
      | contentEditor      |
      | mappingContributor |
      | mappingEditor      |
