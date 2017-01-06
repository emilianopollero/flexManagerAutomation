package steps

import cucumber.api.PendingException
import geb.Browser
import pages.ContentCreationPage
import pages.ContentListViewPage
import pages.ContentShowPage
import pages.FlexManagerPage
import pages.LoginPage
import pages.MappingListViewPage
import pages.ModuleStoreEditPage
import pages.ModuleStoreListViewPage
import pages.TemplatePublishOrdersPage
import pages.TemplateCreationPage
import pages.TemplateListviewPage
import pages.TemplateShowPage
import services.Context

import static cucumber.api.groovy.EN.*

Given(~'^I open flex manager$') { ->
    Browser.drive {
        to LoginPage
        at LoginPage
    }
}

Then(~'^I see the page title$') { ->
    assert 'Flex Manager' == page.pageTitle()
}
//Use: save, saveAndLock or cancel. For template update/creation page.

And(~'^I (.+) my changes$') { String value ->

    Browser.drive {
        at TemplateCreationPage
        switch (value) {
            case "save":
                waitFor(10, 0.5) { page.updateBtn }
                sleep(1000)
                page.updateBtn.click()
                break
            case "saveAndLock":
                waitFor(10, 0.5) { page.saveAndLockBtn }
                page.saveAndLockBtn.click()
                break
            case "cancel":
                waitFor(10, 0.5) { page.cancelBtn }
                page.cancelBtn.click()
                break
        }
        if (value == "save" || value == "saveAndLock"){
           at TemplateShowPage
            Context.instance[page.templateName.text()] = page.getLastBitFromUrl(driver.getCurrentUrl())
        }
    }
}

When(~'^I go to list view from (.+)$') { String currentFmPage ->
    Browser.drive {
        switch (currentFmPage) {
            case "templateShowPage":
                Browser.drive {
                    at TemplateShowPage
                    sleep(1000)
                    page.listViewBtn.click()
                }
                break
            case "contentShowPage":
                Browser.drive {
                    at ContentShowPage
                    page.listViewBtn.click()
                }
                break
            case "moduleStoreEditPage":
                Browser.drive {
                    sleep(1000)
                    at ModuleStoreEditPage
                    page.listViewBtn.click()
                }
                break
        }
    }
}

And(~'^I click on the templates list view page (.+)$') { String btn ->
    Browser.drive {
        at TemplateListviewPage
        page.listViewActionHandler(btn)
    }
}

Then(~'^I can see this (.+) field: (.+) value is (.+)$') { String contentType, String fieldName, String fieldValue ->
    Browser.drive {
        switch (contentType) {
            case "template":
                at TemplateShowPage
                page.basicTabFieldValueCheck(fieldName, fieldValue)
                break
            case "content":
                at ContentShowPage
                page.basicTabFieldValueCheck(fieldName, fieldValue)
                break
        }

    }
}

And(~'^I click on the navigation bar (.+) and click on (.+)$') { String vertical, String option ->
    Browser.drive {
        sleep(2000)
        at FlexManagerPage
        sleep(1000)
        page.navBar.navBarHandler(vertical, option)
    }
}

Then(~'^I can see (.+) publish order was (.+) for template (.+)$') { String publishOrderType, String successOrFailure, String templateName ->
    Browser.drive {
        at TemplatePublishOrdersPage
        page.storeTemplateId(templateName)
        page.checkPublishOrder(publishOrderType, successOrFailure)
    }
}

Then(~/^I can see page (.+) has all expected UI elements$/) { String pageType ->
    switch (pageType) {
        case "templateListViewPage":
            Browser.drive {
                at TemplateListviewPage
                page.checkUIElements()
            }
            break
        case "contentListViewPage":
            Browser.drive {
                at ContentListViewPage
                page.checkUIElements()
            }
            break
        case "mappingListViewPage":
            Browser.drive {
                at MappingListViewPage
                page.checkUIElements()
            }
            break
        case "templateShowPage":
            Browser.drive {
                at TemplateShowPage
                page.checkUIElements()
            }
            break
        case "createEditorial":
            Browser.drive {
                at ContentShowPage
                page.checkUIElements(pageType)
            }
            break
        case "createIntroduction":
            Browser.drive {
                at ContentShowPage
                page.checkUIElements(pageType)
            }
            break
        case "createLegal":
            Browser.drive {
                at ContentShowPage
                page.checkUIElements(pageType)
            }
            break
        case "createImageScape":
            Browser.drive {
                at ContentShowPage
                page.checkUIElements(pageType)
            }
            break
        case "createLinks":
            Browser.drive {
                at ContentShowPage
                page.checkUIElements(pageType)
            }
            break
        case "contentCreationPage":
            Browser.drive {
                at ContentCreationPage
                page.checkUIElements()
            }
            break
    }
}
And(~/^I clone my template to (.+) from (.+)$/) { String posLocale, String atPage ->

    switch (atPage) {
        case "templateShowPage":
            Browser.drive {
                at TemplateShowPage
                page.cloneTemplate(posLocale)
            }
            break
    }
}
Then(~/^I can see element (.+) from page (.+) is disabled$/) { String element, String atPage ->

    switch (atPage) {
        case "moduleStoreListViewPage":
            switch (element) {
                case "createBtn":
                    Browser.drive {
                        at ModuleStoreListViewPage
                        assert page.moduleCreateBtn.getAttribute("disabled").equals("true")
                    }
                    break
                case "editBtn":
                    Browser.drive {
                        at ModuleStoreListViewPage
                        assert $('button', title: "Edit Definition").getAttribute("disabled").equals("true")
                    }
                    break
                case "deleteBtn":
                    Browser.drive {
                        at ModuleStoreListViewPage
                        assert $('button', title: "Delete Definition").getAttribute("disabled").equals("true")
                    }
                    break
            }
            break
        case "templateListViewPage":
            switch (element) {
                case "createBtn":
                    Browser.drive {
                        at TemplateListviewPage
                        assert page.createBtn.getAttribute("disabled").equals("true")
                    }
                    break
                case "dropdownCreateBtn":
                    Browser.drive {
                        at FlexManagerPage
                        assert page.navBar.templatesCreateOption.getAttribute("class").equals("hidden")
                    }
                    break
            }
            break
        case "contentListViewPage":
            switch (element) {
                case "contentPublishBtn":
                    Browser.drive {
                        at ContentListViewPage
                        def contentButton = $('button', id: "publishButton", "content-name": ContentCreationPage.contentNameUsed)
                        assert contentButton.getAttribute("disabled").equals("true")
                    }
                    break
                case "contentEditBtn":
                    Browser.drive {
                        at ContentListViewPage
                        def contentButton = $('button', id: "editButton", "content-name": ContentCreationPage.contentNameUsed)
                        assert contentButton.getAttribute("disabled").equals("true")
                    }
                    break
                case "contentDeleteBtn":
                    Browser.drive {
                        at ContentListViewPage
                        def contentButton = $('button', id: "deleteButton", "content-name": ContentCreationPage.contentNameUsed)
                        assert contentButton.getAttribute("disabled").equals("true")
                    }
                    break
            }
            break
        case "flexManagerPage":
            switch (element) {
                case "createEditorial":
                    Browser.drive {
                        at FlexManagerPage
                        assert page.navBar.contentCreateEditorialOption.getAttribute("class").equals("hidden")
                    }
                    break
                case "createIntroduction":
                    Browser.drive {
                        at FlexManagerPage
                        assert page.navBar.contentCreateIntroductionOption.getAttribute("class").equals("hidden")
                    }
                    break
                case "createLegal":
                    Browser.drive {
                        at FlexManagerPage
                        assert page.navBar.contentCreateLegalOption.getAttribute("class").equals("hidden")
                    }
                    break
                case "createImageScape":
                    Browser.drive {
                        at FlexManagerPage
                        assert page.navBar.contentCreateImageScapeOption.getAttribute("class").equals("hidden")
                    }
                    break
                case "createLinks":
                    Browser.drive {
                        at FlexManagerPage
                        assert page.navBar.contentCreateLinksOption.getAttribute("class").equals("hidden")
                    }
                    break
                case "createTable":
                    Browser.drive {
                        at FlexManagerPage
                        assert page.navBar.contentCreateTableOption.getAttribute("class").equals("hidden")
                    }
                    break
            }
            break
        case "mappingListViewPage":
            String templateName = MappingListViewPage.templateNameUsed
            switch (element) {
                case "createBtn":
                    Browser.drive {
                        at MappingListViewPage
                        assert page.addNewMappingBtn.getAttribute("disabled").equals("true")
                    }
                    break
                case "mappingPublishBtn":
                    Browser.drive {
                        at MappingListViewPage
                        def mappingButton = $('button', id: "publishButton", "name": templateName)
                        assert mappingButton.getAttribute("disabled").equals("true")
                    }
                    break
                case "mappingDeleteBtn":
                    Browser.drive {
                        at MappingListViewPage
                        def mappingButton = $('button', id: "deleteButton", "name": templateName)
                        assert mappingButton.getAttribute("disabled").equals("true")
                    }
                    break
            }
    }
}