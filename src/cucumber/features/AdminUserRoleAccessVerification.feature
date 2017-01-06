@UI @UserRoles @AdminRole
Feature: Verify admin user role acccess

  Scenario: Open flex manager
    Given I open flex manager

    Scenario: As an user with admin role I can assign roles, manage groups, role permissions and create users
      
      Given I login with admin credentials
      And I click on the navigation bar settingsDropDown and click on roles
      And I select user automation-admin
      When I assign this role Viewer to the user
      Then I can see user has viewer role enabled
      And I assign this role Viewer to the user
      And I click on the navigation bar settingsDropDown and click on groups
      And I click on the list view group create button
      And I enter group name automation-test-group
      And I select group user automation-admin
      When I click on the create group button
      Then I can see group automation-test-group is present
      And I edit automation-test-group group
      And I edit group group basic information
      And I enter group name automation-test-group-edited
      When I confirm group basic information edition
      And I click on the create group edit page list button
      Then I can see group automation-test-group-edited is present
      And I delete automation-test-group-edited group
      And I confirm group delete
      Then I can see group automation-test-group is not present
      And I open roles permissions page
      And I select from the roles permission page dropdown the role viewer
      When I edit role permissions
      Then I can see the list of permissions
      And I close role permissions list
      And I click on the navigation bar userDropdown and click on logout

