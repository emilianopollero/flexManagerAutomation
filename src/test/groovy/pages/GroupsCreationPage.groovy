package pages

import geb.Browser
import org.openqa.selenium.Keys


class GroupsCreationPage extends FlexManagerPage {
    static url = ""
    static at = {Browser.drive {driver.getCurrentUrl().contains("/groups/create") && spinnerNotPresent()}}
    static content = {
        createBtn {$('button', id: "createButton")}
        groupNameField {$('input', id: "groupName")}
        groupUserField {$('input', placeholder: "Add a user")}
    }

    def enterGroupName(String name){
        waitFor(10,1){groupNameField}
        groupNameField.click()
        groupNameField.firstElement().clear()
        groupNameField << name
    }
    def selectGroupUser(String username){
        waitFor(10,1){groupUserField}
        groupUserField.click()
        groupUserField.firstElement().clear()
        groupUserField << username
        waitFor(20, 1) { groupUserField.getAttribute("aria-expanded").equals("true") }
        groupUserField << Keys.ENTER
    }
}
