package pages

/**
 * Created by Emi y Adri on 22/08/2016.
 */
class ModuleStoreEditPage extends FlexManagerPage {
    static url = ""
    static at = { driver.getCurrentUrl().contains("/moduleStore/edit/") && spinnerNotPresent() }
    static content = {
        listViewBtn { $('button', id: "listButton") }
        editBasicInfoBtn { $('button', id: "edit") }
        definitionNameInputField { $('input', id: "definitionName") }
        definitionTypeDropdown { $('select', id: "definitionType") }
        definitionTypeDropdownOptionModule { $('option', value: "MODULE") }
        definitionTypeDropdownOptionLayout { $('option', value: "LAYOUT") }
        definitionTypeDropdownOptionRegion { $('option', value: "REGION") }
        definitionDescriptionTextArea { $('textarea', id: "definitionDescription") }
        basicInfoModalUpdateBtn{$('button', id:"confirm")}
        basicInfoModalCancelBtn{$('button', text:"Cancel")}
        definitionNameLabel{$('label', id:"definitionName")}
        definitionTypeLabel{$('label', id:"definitionType")}
        definitionDescriptionLabel{$('label', id:"definitionDescription")}
    }
}
