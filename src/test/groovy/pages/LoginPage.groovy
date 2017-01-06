package pages

import common.utils.FlexManagerPropertyReader
/**
 * Created by emiliano.pollero on 08/03/2016.
 */

class LoginPage extends FlexManagerPage {

    static url = FlexManagerPropertyReader.instance.getProperty("flex-manager-url")+ "/#/login"
    static at = {
        waitFor(100, 0.5) { title ==~ /Flex Manager/ && spinnerNotPresent() }
    }


    static content = {
        usernameField { $('input', id: "username") }
        passwordField { $('input', id: "password") }
        loginButton { $('button', class: "btn btn-primary") }
    }

    def pageTitle() {
        return title
    }

    def login(String role) {
        String username = FlexManagerPropertyReader.instance.getProperty("${role}.username")
        String password = FlexManagerPropertyReader.instance.getProperty("${role}.password")
        waitFor(10, 0.5) { usernameField }
        usernameField.firstElement().clear()
        usernameField << username
        waitFor(10, 0.5) { passwordField }
        passwordField.firstElement().clear()
        passwordField << password
        waitFor(10, 0.5) { loginButton }
        loginButton.click()
    }
}
