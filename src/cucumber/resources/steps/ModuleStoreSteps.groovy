package steps

import cucumber.api.PendingException
import geb.Browser
import org.openqa.selenium.Keys
import pages.ModuleStoreCreationPage
import pages.ModuleStoreEditPage
import pages.ModuleStoreListViewPage

import static cucumber.api.groovy.EN.*

And(~/^I click on the module store list view page create button$/) { ->
    Browser.drive {
        at ModuleStoreListViewPage
        page.moduleCreateBtn.click()
    }
}
And(~/^I create a definition with definition name (.+), type (.+) and description (.+)$/) { String name, String type, String description ->
    Browser.drive {
        at ModuleStoreCreationPage
        waitFor(10, 1) { page.definitionNameField }
        definitionNameField << name
        page.definitionType(type)
        waitFor(10, 1) { page.descriptionField }
        page.descriptionField << description
        page.createBtn.click()
    }
}
Then(~/^I can see definition (.+) of type (.+) is present$/) { String name, String type ->
    Browser.drive {
        at ModuleStoreListViewPage
        def element = $('button', id: "showButton-" + type.toUpperCase() + "-" + name)
        waitFor(10, 1) { element }
        assert element
    }
}

Then(~/^I can see definition (.+) of type (.+) is not present/) { String name, String type ->
    Browser.drive {
        at ModuleStoreListViewPage
        sleep(1000)
        assert !$('button', id: "showButton-" + type.toUpperCase() + "-" + name)
    }
}
And(~/^I edit definition with name (.+) and of type (.+)$/) { String name, String type ->
    Browser.drive {
        at ModuleStoreListViewPage
        def element = $('button', id: "editButton-" + type.toUpperCase() + "-" + name)
        waitFor(10, 1) { element }
        element.click()
    }
}
And(~/^I delete definition with name (.+) and of type (.+)$/) {String name, String type ->
    Browser.drive {
        at ModuleStoreListViewPage
        def element = $('button', id: "deleteButton-" + type.toUpperCase() + "-" + name)
        waitFor(10, 1) { element }
        element.click()
    }
}
When(~/^I confirm definition delete$/) { ->
    Browser.drive {
        at ModuleStoreListViewPage
        waitFor(10,1){page.DeleteModalConfirmBtn}
        page.DeleteModalConfirmBtn.click()
    }
}
When(~/^I cancel definition delete$/) { ->
    Browser.drive {
        at ModuleStoreListViewPage
        waitFor(10,1){page.DeleteModalCancelBtn}
        page.DeleteModalCancelBtn.click()
    }
}
And(~/^I show definition with name (.+) and of type (.+)$/) {String name, String type ->
    Browser.drive {
        at ModuleStoreListViewPage
        def element = $('button', id: "showButton-" + type.toUpperCase() + "-" + name)
        waitFor(10, 1) { element }
        element.click()
    }
}
And(~/^I click on edit basic information button$/) { ->
    Browser.drive {
        at ModuleStoreEditPage
        waitFor(10, 1) { page.editBasicInfoBtn }
        page.editBasicInfoBtn.click()
    }
}
And(~/^I change definition field definition name with this value (.+)$/) { String value ->
    Browser.drive {
        at ModuleStoreEditPage
        waitFor(10, 1) { page.definitionNameInputField }
        page.definitionNameInputField.click()
        page.definitionNameInputField.firstElement().clear()
        page.definitionNameInputField << value
    }
}
And(~/^I change definition field definition type with this value (.+)$/) { String value ->
    Browser.drive {
        at ModuleStoreEditPage
        waitFor(10, 1) { page.definitionTypeDropdown }
        page.definitionTypeDropdown.click()
        page.definitionTypeDropdown << value
        page.definitionTypeDropdown << Keys.ENTER
    }
}
And(~/^I change definition field definition description with this value (.+)$/) { String value ->
    Browser.drive {
        at ModuleStoreEditPage
        waitFor(10, 1) { page.definitionDescriptionTextArea }
        page.definitionDescriptionTextArea.click()
        page.definitionDescriptionTextArea.firstElement().clear()
        page.definitionDescriptionTextArea << value
    }
}
When(~/^I click on the definition general properties update button$/) { ->
    Browser.drive {
        at ModuleStoreEditPage
        waitFor(10, 1) { page.basicInfoModalUpdateBtn }
        page.basicInfoModalUpdateBtn.click()
    }
}
When(~/^I click on the definition general properties cancel button$/) { ->
    Browser.drive {
        at ModuleStoreEditPage
        waitFor(10, 1) { page.basicInfoModalCancelBtn }
        page.basicInfoModalCancelBtn.click()
    }
}
Then(~/^I can see definition edit page value definition name is (.+)$/) { String value ->
    Browser.drive {
        at ModuleStoreEditPage
        waitFor(10, 1) { page.definitionNameLabel }
        assert page.definitionNameLabel.text().equals(value)
    }
}
Then(~/^I can see definition edit page value definition type is (.+)$/) { String value ->
    Browser.drive {
        at ModuleStoreEditPage
        waitFor(10, 1) { page.definitionTypeLabel }
        assert page.definitionTypeLabel.text().equals(value)
    }
}
Then(~/^I can see definition edit page value definition description is (.+)$/) { String value ->
    Browser.drive {
        at ModuleStoreEditPage
        waitFor(10, 1) { page.definitionDescriptionLabel }
        assert page.definitionDescriptionLabel.text().equals(value)
    }
}
When(~/^I search for definition with name (.+)$/) { String value ->
    Browser.drive {
        at ModuleStoreListViewPage
        page.searchDefinition(value)
        sleep(1000)
    }
}