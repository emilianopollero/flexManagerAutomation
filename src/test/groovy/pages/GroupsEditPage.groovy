package pages

import geb.Browser


class GroupsEditPage extends FlexManagerPage {
    static url = ""
    static at = { Browser.drive { driver.getCurrentUrl().contains("groups/edit/") && spinnerNotPresent() } }
    static content = {
        listBtn {$('button', id: "listButton")}
        editBasicInfoBtn { $('button', id: "edit") }
        addOrRemoveUsersBtn { $('button', id: "addAttributeBtn") }
        basicInfoModalConfirmBtn { $('button', id: "confirm") }
    }
}
