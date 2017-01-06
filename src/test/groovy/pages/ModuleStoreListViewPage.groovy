package pages

import org.openqa.selenium.Keys

class ModuleStoreListViewPage extends FlexManagerPage {
    static url = ""
    static at = { driver.getCurrentUrl().contains("/moduleStore/list") && spinnerNotPresent() }
    static content = {
        moduleCreateBtn { $('button', title: "Create new definition") }
        searchField { $('input', placeholder: "search in table...") }
        DeleteModalConfirmBtn{$('button', id:"confirm")}
        DeleteModalCancelBtn{$('button', text:"Cancel")}
    }

    def searchDefinition(String value){
        waitFor(10,1){searchField}
        searchField << value
        searchField << Keys.ENTER
    }

}
