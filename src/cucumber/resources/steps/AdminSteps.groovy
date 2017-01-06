package steps

import cucumber.api.PendingException
import geb.Browser
import pages.GroupsCreationPage
import pages.GroupsEditPage
import pages.GroupsListPage
import pages.RolesPage
import pages.RolesPermissionsPage

import static cucumber.api.groovy.EN.*


And(~/^I select user (.+)$/) { String username ->
    Browser.drive {
        at RolesPage
        page.selectUser(username)
    }
}
And(~/^I assign this role (.+) to the user$/) { String role ->
    Browser.drive {
        at RolesPage
        page.assignRole(role)
    }
}
Then(~/^I can see user has (.+) role enabled$/) { String role ->
    Browser.drive {
        at RolesPage
        page.checkUserRole(role)
    }
}
And(~/^I click on the list view group create button$/) { ->
    Browser.drive {
        at GroupsListPage
        waitFor(10, 1) { page.groupCreateBtn }
        page.groupCreateBtn.click()
    }
}
And(~/^I enter group name (.+)$/) { String name ->
    Browser.drive {
        at GroupsCreationPage
        page.enterGroupName(name)
    }
}
And(~/^I select group user (.+)$/) { String username ->
    Browser.drive {
        at GroupsCreationPage
        page.selectGroupUser(username)
    }
}
And(~/^I click on the create group button$/) { ->
    Browser.drive {
        at GroupsCreationPage
        waitFor(10, 1) { page.createBtn }
        page.createBtn.click()
    }
}
Then(~/^I can see group (.+) is present$/) { String name ->
    Browser.drive {
        at GroupsListPage
        sleep(1000)
        def groupBtn = $('button', id: name + "-showButton")
        waitFor(10, 1) { groupBtn }
        assert groupBtn
    }
}
Then(~/^I can see group (.+) is not present$/) { String name ->
    Browser.drive {
        at GroupsListPage
        assert !$('button', id: name + "-showButton")
    }
}
And(~/^I edit (.+) group$/) { String name ->
    Browser.drive {
        at GroupsListPage
        def editBtn = $('button', id: name + "-editButton")
        waitFor(10, 1) { editBtn }
        editBtn.click()
    }
}
And(~/^I edit group group basic information$/) { ->
    Browser.drive {
        at GroupsEditPage
        waitFor(10, 1) { page.editBasicInfoBtn }
        page.editBasicInfoBtn.click()
    }
}
And(~/^I confirm group basic information edition$/) { ->
    Browser.drive {
        at GroupsEditPage
        waitFor(10, 1) { page.basicInfoModalConfirmBtn }
        page.basicInfoModalConfirmBtn.click()
    }
}
And(~/^I delete (.+) group$/) { String name ->
    Browser.drive {
        at GroupsListPage
        def deleteBtn = $('button', id: name + "-deleteButton")
        waitFor(10, 1) { deleteBtn }
        deleteBtn.click()
    }
}
And(~/^I confirm group delete$/) { ->
    Browser.drive {
        at GroupsListPage
        waitFor(10, 1) { page.deleteModalConfirmBtn }
        page.deleteModalConfirmBtn.click()
    }
}
And(~/^I select from the roles permission page dropdown the role (.+)$/) { String role ->
    Browser.drive {
        at RolesPermissionsPage
        page.selectRole(role)
    }
}
And(~/^I edit role permissions$/) { ->
    Browser.drive {
        at RolesPermissionsPage
        waitFor(10, 1) { page.rolesEditBtn }
        page.rolesEditBtn.click()
    }
}
Then(~/^I can see the list of permissions$/) { ->
    Browser.drive {
        at RolesPermissionsPage
        waitFor(10, 1) { page.rolesPermissionModalTitle }
    }
}
And(~/^I close role permissions list$/) { ->
    Browser.drive {
        at RolesPermissionsPage
        waitFor(10, 1) { page.rolesPermissionModalCancelBtn }
        page.rolesPermissionModalCancelBtn.click()
    }
}
And(~/^I click on the create group edit page list button$/) { ->
    Browser.drive {
        at GroupsEditPage
        waitFor(10, 1) { page.listBtn }
        sleep(500)
        page.listBtn.click()
    }
}
And(~/^I open roles permissions page$/) { ->
    Browser.drive {to RolesPermissionsPage}
}