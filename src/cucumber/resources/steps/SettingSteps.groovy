package steps  

import geb.Browser
import static cucumber.api.groovy.EN.And
import pages.CreateUserPage
import pages.RolesPage

def usernameList
def rolesList

And(~'^I create user$') { ->
    usernameList = System.getProperty("username").split(",")
    Browser.drive {
        at CreateUserPage
        for (user in usernameList) {
            page.createUserHandler("username", user)
            page.createUserHandler("password", "password")
            page.saveUser()
        }
    }
}

And(~'^I assign roles to users$') { ->
    rolesList = System.getProperty("roles").split(",")
    Browser.drive {
        at RolesPage
        for (user in usernameList) {
            page.selectUser(user)
            for (role in rolesList) {
                page.assignRole(role)
            }
        }
    }
}