package steps

import geb.Browser

import pages.LoginPage

import static cucumber.api.groovy.EN.*


Then(~'^I login with (.+) credentials$') { String role ->
    Browser.drive {
        at LoginPage
        login(role)
    }
}