package modules

import geb.Browser
import geb.Module

/**
 * Created by emiliano.pollero on 06/04/2016.
 */
class NavBarModule extends Module {
    static content = {
        userDropdown { $('a', id: "dropDownRightId1") }
        userDropdownLogout { $('a', id: "dropDownRightId3") }
        //Vertical
        createContentDropdown { $('a', id: "navBarCreateContentDropdown") }
        manageContentDropdown { $('a', id: "navBarContentDropdown") }
        templatesDropdown { $('a', id: "navBarTemplateDropdown") }
        mappingDropdown { $('a', id: "navBarMappingDropdown") }
        //Content dropdown options
        contentSearchOption { $('a', id: "mnuContentSearch") }
        contentCreateEditorialOption { $('a', id: "mnuContentCreateEditorial") }
        contentCreateIntroductionOption { $('a', id: "mnuContentCreateIntroduction") }
        contentCreateLegalOption { $('a', id: "mnuContentCreateLegal") }
        contentCreateImageScapeOption { $('a', id: "mnuContentCreateImageScape") }
        contentCreateLinksOption { $('a', id: "mnuContentCreateLinks") }
        contentCreateTableOption { $('a', id: "mnuContentCreateTable") }
        //Templates dropdown options
        templatesSearchOption { $('a', id: "mnuTemplateSearch") }
        templatesCreateOption { $('a', id: "mnuCreateTemplate") }
        templatesModuleStoreOption { $('a', id: "mnuModuleStore") }
        //Mapping dropdown options
        mappingSearchOption { $('a', id: "mnuMappingSearch") }
        //Settings dropdown
        settingsDropdown { $('a', id: "dropDownLeftId1") }
        createUserOption { $('a', id: "dropDownLeftId5") }
        rolesOption { $('a', id: "dropDownLeftId2") }
        groupsOption { $('a', id: "dropDownLeftId3") }
        rolePermissionsOption { $('a', id: "dropDownLeftId4") }
    }

    def navBarHandler(String vertical, String option) {
        switch (vertical) {
            case "createContentDropdown":
                waitFor(20, 0.5) { createContentDropdown }
                Browser.drive {
                    createContentDropdown.click()
                }
                switch (option) {
                    case "createEditorial":
                        waitFor(20, 0.5) { contentCreateEditorialOption }
                        Browser.drive { contentCreateEditorialOption.click() }
                        break
                    case "createIntroduction":
                        waitFor(20, 0.5) { contentCreateIntroductionOption }
                        Browser.drive { contentCreateIntroductionOption.click() }
                        break
                    case "createLegal":
                        waitFor(20, 0.5) { contentCreateLegalOption }
                        Browser.drive { contentCreateLegalOption.click() }
                        break
                    case "createImageScape":
                        waitFor(20, 0.5) { contentCreateImageScapeOption }
                        Browser.drive { contentCreateImageScapeOption.click() }
                        break
                    case "createLinks":
                        waitFor(20, 0.5) { contentCreateLinksOption }
                        Browser.drive { contentCreateLinksOption.click() }
                        break
                }
                break
            case "manageContentDropdown":
                waitFor(20, 0.5) { manageContentDropdown }
                Browser.drive {
                    manageContentDropdown.click()
                }
                switch (option) {
                    case "search":
                        waitFor(20, 0.5) { contentSearchOption }
                        Browser.drive { contentSearchOption.click() }
                        break
                }
                break
            case "templatesDropdown":
                waitFor(20, 0.5) { templatesDropdown }
                Browser.drive {
                    templatesDropdown.click()
                }
                switch (option) {
                    case "search":
                        waitFor(20, 0.5) { templatesSearchOption }
                        Browser.drive { templatesSearchOption.click() }
                        break
                    case "create":
                        waitFor(20, 0.5) { templatesCreateOption }
                        Browser.drive { templatesCreateOption.click() }
                        break
                    case "ModuleStore":
                        waitFor(20, 0.5) { templatesModuleStoreOption }
                        Browser.drive { templatesModuleStoreOption.click() }
                        break
                }
                break
            case "mappingsDropdown":
                waitFor(20, 0.5) { mappingDropdown }
                Browser.drive {
                    mappingDropdown.click()
                }
                switch (option) {
                    case "search":
                        waitFor(20, 0.5) { mappingSearchOption }
                        Browser.drive { mappingSearchOption.click() }
                        break
                }
                break
            case "userDropdown":
                waitFor(20, 0.5) { userDropdown }
                Browser.drive { userDropdown.click() }
                switch (option) {
                    case "logout":
                        waitFor(20, 0.5) { userDropdownLogout }
                        Browser.drive { userDropdownLogout.click() }
                        break
                }
                break
            case "settingsDropDown":
                waitFor(20, 0.5) { settingsDropdown }
                Browser.drive { settingsDropdown.click() }
                switch (option) {
                    case "createUser":
                        waitFor(20, 0.5) { createUserOption }
                        Browser.drive { createUserOption.click() }
                        break
                    case "roles":
                        waitFor(20, 0.5) { rolesOption }
                        Browser.drive { rolesOption.click() }
                        break
                    case "groups":
                        waitFor(20, 0.5) { groupsOption }
                        Browser.drive { groupsOption.click() }
                        break
                    case "rolePermissions":
                        waitFor(20, 0.5) { rolePermissionsOption }
                        Browser.drive { rolePermissionsOption.click() }
                }
                break
        }
    }

}
