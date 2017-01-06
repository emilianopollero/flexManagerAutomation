package pages

import geb.Browser

/**
 * Created by rokulkarni on 7/28/16.
 */
class CreateUserPage extends FlexManagerPage {
    static url = ""
    static at = {Browser.drive {driver.getCurrentUrl().contains("/admin/createUser") && spinnerNotPresent()}}

    static content = {
        username { $('input', id: "username") }
        password { $('input', id: "password") }
        saveButton { $('button', id: "saveButton") }
        createUserSuccessMessage { $("div", class: "alert alert-info").$("ul").$("li") }
    }

    static String expectedUserCreateMessage = "User have been successfully saved."

    def createUserHandler(String field, String value) {
        switch (field) {
            case "username":
                waitFor(10, 0.5) { username }
                username << value
                break
            case "password":
                waitFor(10, 0.5) { password }
                password << value
                break

        }
    }

    def saveUser() {
        waitFor (10, 0.5) {saveButton}
        saveButton.click()
        verifyUserCreatedSuccessMessage()
    }

    def verifyUserCreatedSuccessMessage() {
        waitFor(10, 0.5) {createUserSuccessMessage}
        def actualUserCreateMessage = createUserSuccessMessage.text()
        assert actualUserCreateMessage.equals(expectedUserCreateMessage)
    }
}
