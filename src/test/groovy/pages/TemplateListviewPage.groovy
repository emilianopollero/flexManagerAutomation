package pages

import common.utils.FlexManagerPropertyReader
import geb.Browser
import modules.ViewHeaderModule
import org.openqa.selenium.Keys
import modules.PosLocaleModule

/**
 * Created by emiliano.pollero on 08/03/2016.
 */

class TemplateListviewPage extends FlexManagerPage {

    static url = FlexManagerPropertyReader.instance.getProperty("flex-manager-url") + "/#/flexTemplate/list/ORB.en_US"
    static at = { Browser.drive { driver.getCurrentUrl() }.contains("list") && spinnerNotPresent() }
    static content = {
        header { module ViewHeaderModule }
        posLoc { module PosLocaleModule }
        createBtn { $('button', id: "add-new-flex-template") }
        publishOrdersBtn { $('button', id: "go-to-publish-order-list") }

        // List Columns Headers
        idColumnHeader { $('th', "st-sort": "id") }
        nameColumnHeader { $('th', "st-sort": "name") }
        authorColumnHeader { $('th', "st-sort": "author.username") }
        modifierColumnHeader { $('th', "st-sort": "modifier.username") }
        modifiedDateColumnHeader { $('th', "st-sort": "lastUpdated") }
        publishDateColumnHeader { $('th', "st-sort": "lastPublishDate") }

        // Action column buttons
        showBtn { $('button', id: "showButton") }
        editBtn { $('button', id: "editButton") }
        publishBtn { $('button', id: "publishButton") }
        deleteBtn { $('button', id: "deleteButton") }
        unlockBtn { $('button', id: "unlockButton") }
        cloneBtn { $('button', id: "cloningButton") }

        //Confirm template delete prompt
        confirmDeleteBtn { $('button', id: "confirmDeleteTemplate") }
        cancelDeleteBtn { $('button', id: "cancelDeleteTemplate") }

        //Template Actions/UI handlers
        basicTabBtn { $('a', class: "pill") }
        designTabBtn { $('a', id: "designTab") }
        versionTabBtn { $('a', id: "versionsTab") }
        updateBtn { $('button', id: "createButton") }
        saveAndLockBtn { $('a', id: "saveAndLock") }
        cancelBtn { $('a', id: "cancelButton") }
        listViewBtn { $('a', id: "listButton") }
    }
    public static String posLocale

    def checkUIElements() {
        posLoc.checkUIElements()
        assert createBtn
        assert publishOrdersBtn
        assert showBtn
        assert editBtn
        assert publishBtn
        assert deleteBtn
        assert unlockBtn
        assert cloneBtn
        assert idColumnHeader
        assert nameColumnHeader
        assert authorColumnHeader
        assert modifierColumnHeader
        assert modifiedDateColumnHeader
        assert publishDateColumnHeader
    }

    def listViewActionHandler(String btn) {
        sleep(1000)
        switch (btn) {
            case "createBtn":
                waitFor(10, 0.5) { createBtn }
                createBtn.click()
                break
            case "publishOrdersBtn":
                waitFor(10, 0.5) { publishOrdersBtn }
                publishOrdersBtn.click()
                break
        }
    }

    def confirmOrCancelDelete(String value) {
        switch (value) {
            case "confirmDelete":
                waitFor(10, 0.5) { confirmDeleteBtn }
                confirmDeleteBtn.click()
                break
            case "cancelDelete":
                waitFor(10, 0.5) { cancelDeleteBtn }
                cancelDeleteBtn.click()
                break
        }
    }

    def templateActions(String action, String id) {

        def templateButton

        switch (action) {
            case "show":
                templateButton = $('button', id: "showButton", "page-id": id)
                waitFor(10, 0.5) { templateButton }
                templateButton.click()
                break
            case "edit":
                templateButton = $('button', id: "editButton", "page-id": id)
                waitFor(50, 0.5) { templateButton }
                templateButton.click()
                break
            case "publish":
                templateButton = $('button', id: "publishButton", "page-id": id)
                waitFor(10, 0.5) { templateButton }
                templateButton.click()
                break
            case "clone":
                templateButton = $('button', id: "cloningButton", "page-id": id)
                waitFor(10, 0.5) { templateButton }
                templateButton.click()
                break
            case "unlock":
                templateButton = $('button', id: "unlockButton", "page-id": id)
                waitFor(10, 0.5) { templateButton }
                templateButton.click()
                break
            case "delete":
                templateButton = $('button', id: "deleteButton", "page-id": id)
                waitFor(10, 0.5) { templateButton }
                templateButton.click()
                break
        }
    }

    def actionHandler(String value) {
        switch (value) {
            case "update":
                waitFor(10, 0.5) { updateBtn }
                updateBtn.click()
                break
            case "saveAndLock":
                waitFor(10, 0.5) { saveAndLockBtn }
                saveAndLockBtn.click()
                break
            case "cancel":
                waitFor(10, 0.5) { cancelBtn }
                cancelBtn.click()
                break
            case "delete":
                waitFor(10, 0.5) { deleteBtn }
                deleteBtn.click()
                break
            case "listView":
                waitFor(10, 0.5) { listViewBtn }
                listViewBtn.click()
                break
        }
    }

    def posLocaleSelector(String posLocaleSelected) {
        posLocale = posLocaleSelected
        posLoc.templateDropdown << posLocaleSelected
        posLoc.templateDropdown << Keys.ENTER
        spinnerNotPresent()
        sleep(1000)
    }
}
