package pages

class ModuleStoreCreationPage extends FlexManagerPage {
    static url = ""
    static at = { driver.getCurrentUrl().contains("/moduleStore/create") && spinnerNotPresent() }
    static content = {
        createBtn {$('button', id: "createButton")}
        definitionNameField { $('input', id: "definitionName") }
        descriptionField {$('textarea', id: "definitionDescription")}
        definitionTypeDropdown { $('select', id: "definitionType") }
        moduleDropdownOption {$('option', value: "MODULE")}
        layoutDropdownOption {$('option', value: "LAYOUT")}
        regionDropdownOption {$('option', value: "REGION")}
        tabDropdownOption {$('option', value: "TAB")}
    }

    def definitionType(String type){
        waitFor(10,1){definitionTypeDropdown}
        definitionTypeDropdown.click()
        def dropdownOption = $('option', value: type.toUpperCase())
        waitFor(10,1){dropdownOption}
        dropdownOption.click()
    }
}
