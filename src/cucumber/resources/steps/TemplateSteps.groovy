package steps

import common.utils.FlexManagerPropertyReader
import common.utils.FlexUtil
import geb.Browser
import pages.TemplateCreationPage
import pages.TemplateListviewPage
import pages.TemplateShowPage

import static cucumber.api.groovy.EN.*

//Use: name, title, header, description, keywords and robots. Will clear text field and use fieldValue.
When(~'^I change template field: (.+) to this value: (.+)$') { String field, String fieldValue ->
    Browser.drive {
        at TemplateCreationPage
        page.basicTabFieldHandler(field, fieldValue)
    }
}

And(~'^I drag and drop this element: norailLayout to the template area$') {  ->
    Browser.drive {
        at TemplateCreationPage
        page.dragAndDrop()
    }
}

And(~'^I (.+) my template from show page$') { String action ->
    Browser.drive {
        at TemplateShowPage
        sleep(1000)
        page.actionHandler(action)
    }
}

//Use confirmDelete or cancelDelete to confirm or cancel delete prompt in show page.
Then(~'^I delete and (.+) the template in show page$') { String confirmOrCancel->
    Browser.drive {
        at TemplateShowPage
        page.deleteBtn.click()
        switch (confirmOrCancel){
            case "confirmDelete":
                waitFor(30,0.5){page.confirmDeleteBtn.isDisplayed()}
                page.confirmDeleteBtn.click()
                break
            case "cancelDelete":
                waitFor(30,0.5){page.cancelDeleteBtn.isDisplayed()}
                page.cancelDeleteBtn.click()
                break
        }
    }
}

Then(~'^I delete and (.+) template (.+) in list view page$') { String confirmOrCancel, String templateName->

    Browser.drive {
        at TemplateListviewPage
        def templateDeleteButton = $('button', id: "deleteButton", "template-name": templateName)
        Browser.drive {templateDeleteButton.click()}
        switch (confirmOrCancel){
            case "confirmDelete":
                waitFor(30,0.5){page.confirmDeleteBtn.isDisplayed()}
                page.confirmDeleteBtn.click()
                page.spinnerNotPresent()
                break
            case "cancelDelete":
                waitFor(30,0.5){page.cancelDeleteBtn.isDisplayed()}
                page.cancelDeleteBtn.click()
                break
        }
    }
}

/*
Step used to perform actions on templates from list view, possible action parameters are: show, edit, publish, clone,
unlock, delete, confirmDelete and cancelDelete.
"id" parameter must be the template id from the "id" column from the chosen template.
*/
And(~'^I (.+) template with name (.+)$') { String action, String templateName ->

    Browser.drive {
        at TemplateListviewPage
        def templateButton
        switch (action) {
            case "show":
                templateButton = $('button', id: "showButton", "template-name": templateName)
                waitFor(10,0.5){templateButton}
                templateButton.click()
                break
            case "edit":
                templateButton = $('button', id: "editButton", "template-name": templateName)
                waitFor(50,0.5){templateButton}
                templateButton.click()
                break
            case "publish":
                templateButton = $('button', id: "publishButton", "template-name": templateName)
                waitFor(20,0.5){templateButton}
                templateButton.click()
                break
            case "clone":
                templateButton = $('button', id: "cloningButton", "template-name": templateName)
                waitFor(10,0.5){templateButton}
                templateButton.click()
                break
            case "unlock":
                templateButton = $('button', id: "unlockButton", "template-name": templateName)
                waitFor(10,0.5){templateButton}
                templateButton.click()
                break
            case "delete":
                templateButton = $('button', id: "deleteButton", "template-name": templateName)
                waitFor(10,0.5){templateButton}
                templateButton.click()
                break
        }
    }
}

And(~'^I open template creation page (.+)$') { String tabName ->
    Browser.drive {
        at TemplateCreationPage
        switch (tabName){
            case "designTab":
                page.designTabBtn.click()
                break
            case "basicTab":
                page.basicTabBtn.click()
                break
        }
    }
}

Then(~'^I can see template (.+) is (.+)$') { String templateName, String deletedOrPresent ->
    Browser.drive {
        at TemplateListviewPage
        switch (deletedOrPresent){
            case "deleted":
                assert !$('button', id: "showButton", "template-name": templateName)
                break
            case "present":
                sleep(3000)
                assert $('button', id: "showButton", "template-name": templateName)
                break
        }
    }
}

And(~'^I select template pos/locale (.+)$') { String posLocale ->
    Browser.drive {
        at TemplateListviewPage
        page.posLocaleSelector(posLocale)
    }
}

And(~'^I can check template (.+) is (.+) in flextemplateservice$') { String name, String presentNotPresent ->
    String templateServiceUrl
    String templateServiceBaseUrl = FlexManagerPropertyReader.instance.getProperty("templateServiceUrl")
    Browser.drive {
        templateServiceUrl = templateServiceBaseUrl+FlexUtil.getTpidFromPosLocale(TemplateListviewPage.posLocale)+"-"
        go(templateServiceUrl + name)
        sleep(1000)
        switch (presentNotPresent) {
            case "present":
                assert driver.getPageSource().contains("\"name\":" + "\"" + name + "\"" + ",")
                break
            case "notPresent":
                assert !driver.getPageSource().contains("\"name\":" + "\"" + name + "\"" + ",")
                break
        }
    }
}