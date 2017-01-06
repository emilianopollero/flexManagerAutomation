package pages

import geb.Browser
import org.openqa.selenium.Keys

/**
 * Created by rokulkarni on 7/28/16.
 */
class RolesPage extends FlexManagerPage {
    static url = ""
    static at = {Browser.drive {driver.getCurrentUrl().contains("/admin/groups") && spinnerNotPresent()}}

    static content = {
        usernameDropdown { $('#container > div:nth-child(2) > div > div > select') }
        viewerRoleToggle { $('switch',"id-switch": "Viewers") }
        templateContributorToggle { $('switch',"id-switch":"Template Contributors") }
        templateEditorToggle { $('switch',"id-switch": "Template Editors") }
        moduleStoreEditorToggle { $('switch',"id-switch":"Module Store Editors") }
        contentContributorToggle { $('switch',"id-switch":"Content Contributors") }
        contentEditorToggle { $('switch',"id-switch":"Content Editors") }
        mappingContributorToggle { $('switch',"id-switch":"Mapping Contributors") }
        mappingEditorToggle { $('switch',"id-switch":"Mapping Editors") }
        imageEditorToggle { $('switch',"id-switch":"Image Editors") }
    }

    def assignRole(String role) {
        switch (role) {
            case "Viewer":
                waitFor(10, 0.5) { viewerRoleToggle }
                viewerRoleToggle.click()
                break
            case "Template Contributor":
                waitFor(10, 0.5) { templateContributorToggle }
                templateContributorToggle.click()
                break
            case "Template Editor":
                waitFor(10, 0.5) { templateEditorToggle }
                templateEditorToggle.click()
                break
            case "Module Store Editor":
                waitFor(10, 0.5) { moduleStoreEditorToggle }
                moduleStoreEditorToggle.click()
                break
            case "Content Contributor":
                waitFor(10, 0.5) { contentContributorToggle }
                contentContributorToggle.click()
                break
            case "Content Editor":
                waitFor(10, 0.5) { contentEditorToggle }
                contentEditorToggle.click()
                break
            case "Mapping Contributor":
                waitFor(10, 0.5) { mappingContributorToggle }
                mappingContributorToggle.click()
                break
            case "Mapping Editor":
                waitFor(10, 0.5) { mappingEditorToggle }
                mappingEditorToggle.click()
                break
            case "Image Editor":
                waitFor(10, 0.5) { imageEditorToggle }
                imageEditorToggle.click()
                break
        }
    }

    def selectedUser

    def selectUser(String username) {
        waitFor(10, 0.5) {usernameDropdown}
        usernameDropdown.click()
        selectedUser = $('option', label: username)
        waitFor(30, 0.5) { selectedUser }
        usernameDropdown << username
        usernameDropdown << Keys.ENTER
        sleep(1000)
    }

    def checkUserRole(role){
        switch (role){
            case "viewer":
                viewerRoleToggle.getAttribute("aria-checked").equals("true")
                break
        }
    }
}