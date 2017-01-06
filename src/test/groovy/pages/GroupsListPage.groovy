package pages

import geb.Browser
import org.openqa.selenium.Keys

class GroupsListPage extends FlexManagerPage {
    static url = ""
    static at = { Browser.drive { driver.getCurrentUrl().contains("/groups/list") && spinnerNotPresent() } }
    static content = {
        groupCreateBtn { $('button', title: "Create new Group") }
        deleteModalConfirmBtn { $('button', id: "confirm") }
    }
}
