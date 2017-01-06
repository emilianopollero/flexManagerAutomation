package steps

import geb.Browser
import groovy.json.JsonSlurper
import pages.MappingListViewPage
import common.utils.FlexUtil
import common.utils.FlexManagerPropertyReader

import static cucumber.api.groovy.EN.And
import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When


And(~'^I click on the mappings list view page create button$') { ->
    Browser.drive {
        at MappingListViewPage
        page.listViewActionHandler("createBtn")
    }
}

And(~'^I select mapping pos/locale (.+)$') { String posLocale ->
    Browser.drive {
        at MappingListViewPage
        page.posLocaleSelector(posLocale)
    }
}

And(~'^I select mapping type (.+)$') { String mappingType ->
    Browser.drive {
        at MappingListViewPage
        page.mappingTypeSelector(mappingType)
    }
}

And(~'^I use these values (.+) and (.+) to fill in the required (.+) mapping type fields using this template (.+)$') { String mappingType, String value1, String value2, String templateName ->
    Browser.drive {
        at MappingListViewPage
        page.RequiredMappingTypeFields(mappingType, value1, value2, templateName)
    }
}



Then(~/^I can see mapping was created$/) { ->
    Browser.drive {
        at MappingListViewPage
        page.checkMappingCreation()
    }
}

Given(~/^I delete and (.+) mapping with template name (.+)$/) { String action, String mappingTemplateName ->

    Browser.drive {
        at MappingListViewPage
        def mappingButton
        switch (action) {
            case "confirmDelete":
                mappingButton = $('button', id: "deleteButton", "name": mappingTemplateName)
                waitFor(10, 0.5) { mappingButton }
                mappingButton.click()
                waitFor(10, 0.5) { page.mappingConfirmDeleteButton.isDisplayed() }
                page.mappingConfirmDeleteButton.click()
                break
            case "cancelDelete":
                mappingButton = $('button', id: "deleteButton", "name": mappingTemplateName)
                waitFor(10, 0.5) { mappingButton }
                mappingButton.click()
                waitFor(10, 0.5) { page.mappingCancelDeleteButton.isDisplayed() }
                page.mappingCancelDeleteButton.click()
                break
        }
    }
}

Then(~/^I can see mapping (.+) is (.+)$/) { String mappingTemplateName, String deletedOrPresent ->
    Browser.drive {
        at MappingListViewPage
        def mappingButton
        switch (deletedOrPresent) {
            case "deleted":
                mappingButton = $('button', id: "deleteButton", "name": mappingTemplateName)
                assert !mappingButton
                break
            case "present":
                mappingButton = $('button', id: "deleteButton", "name": mappingTemplateName)
                assert mappingButton
                break
        }
    }
}

When(~/^I publish mapping with template (.+)$/) { String mappingTemplateName ->
    def mappingButton
    Browser.drive {
        at MappingListViewPage
        mappingButton = $('button', id: "publishButton", "name": mappingTemplateName)
        waitFor(10, 0.5) { mappingButton }
        mappingButton.click()
        sleep(2000)
    }
}

And(~'^I check in flex-template-service mapping (.+) is (.+)$') { String name, String presentNotPresent ->
    Browser.drive {
        String posCode = FlexUtil.getTpidFromPosLocale(MappingListViewPage.selectedPosLocale)
        def json = new JsonSlurper().parseText(new URL(FlexManagerPropertyReader.instance.getProperty("mappingServiceUrl")).text)
        def result, currentTemplate, currentKey
        def expectedTemplate = posCode+"-"+name
        def expectedKey = posCode.replaceAll("-", "|")+"|"+MappingListViewPage.selectedMappingType.replaceAll(" ", "-")
        switch (presentNotPresent) {
            case "present":
                for (item in json) {
                    currentTemplate = item.defaultTemplate
                    currentKey = item.key
                    if ((currentKey.contains(expectedKey)) && currentTemplate == expectedTemplate) {
                        result = true
                        break
                    } else {
                        result = false
                    }
                }
                if (result == false) {
                    println(expectedKey + expectedTemplate + "not found in compositor")
                    throw new Exception("Mapping not found in compositor")
                }
                break
            case "notPresent":
                for (item in json) {
                    currentTemplate = item.defaultTemplate
                    currentKey = item.key
                    if ((currentKey.contains(expectedKey)) && currentTemplate == expectedTemplate) {
                        result = true
                        break
                    } else {
                        result = false
                    }
                }
                if (result == true) {
                    throw new Exception("Mapping found in compositor")
                }
                break
        }
    }
}