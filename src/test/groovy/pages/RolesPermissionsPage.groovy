package pages

import geb.Browser
import org.openqa.selenium.Keys


class RolesPermissionsPage extends FlexManagerPage {
    static url = "http://flex-manager-grails.us-west-2.test.expedia.com/#/admin/permissions"
    static at = { Browser.drive { driver.getCurrentUrl().contains("admin/permissions") && spinnerNotPresent() } }
    static content = {
        rolesDropdown { $('#container > div.row.permissions-header.ng-scope > div:nth-child(2) > select') }
        rolesEditBtn { $('button', title: "Edit permissions") }
        rolesPermissionModalTitle { $('label', text: "Select to change permissions") }
        rolesPermissionModalCancelBtn { $('button', text: "Cancel") }
    }

    def selectRole(String role) {
        waitFor(10, 1) { rolesDropdown }
        rolesDropdown << role
        rolesDropdown << Keys.ENTER
    }

}
