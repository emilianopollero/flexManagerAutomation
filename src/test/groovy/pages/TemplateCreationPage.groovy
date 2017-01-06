package pages

import geb.Browser

class TemplateCreationPage extends FlexManagerPage {

    static url = ""
    static at = {(Browser.drive { driver.getCurrentUrl() }.contains("/flexTemplate/create/") || Browser.drive { driver.getCurrentUrl() }.contains("/flexTemplate/edit/")) && spinnerNotPresent() }
    static content = {

        //Confirm template delete prompt
        confirmDeleteBtn { $('button', id: "confirmDeleteTemplate") }
        cancelDeleteBtn { $('button', id: "cancelDeleteTemplate") }

        //Template Actions/UI handlers
        basicTabBtn { $('a', class: "pill") }
        designTabBtn { $('a', id: "designTab") }
        versionTabBtn { $('a', id: "versionsTab") }
        updateBtn { $('button', id: "createButton") }
        saveAndLockBtn { $('a', id: "saveAndLock") }
        deleteBtn { $('button', id: "deleteButton") }
        cancelBtn { $('a', id: "cancelButton") }
        listViewBtn { $('a', id: "listButton") }

        //Basic tab elements
        templateNameField { $('input', id: "name") }
        pageTitleField { $('input', id: "pageMetaInfo.title") }
        pageHeaderField { $ 'input', id: "pageMetaInfo.header" }
        metaDescriptionField { $('textarea', id: "pageMetaInfo.metaDescription") }
        metaKeywordsField { $('textarea', id: "pageMetaInfo.metaKeywords") }
        metaRobotsField { $('input', id: "pageMetaInfo.metaRobots") }

        //Design tab elements
        moduleSearchBox {
            $('input', class: "form-control width-inherit filterModules ng-pristine ng-valid ng-scope ng-touched")
        }
        airportAddressModuleElement { $('div', id: "airport-address") }
        noRailLayoutElement { $('div', id: "norail") }
        dragAndDropArea { $('div', id: "dragAndDropArea") }
    }

    def dragAndDrop() {
        String flexNode = '{"flexNode":[{"allowedChildren":["SECTION","ROW","REGION"],"attributes":[{"name":"id","value":"norail","valueOptions":["norail"],"type":"STRING","required":true,"editable":false}],"class":"flex.manager.template.node.LayoutNode","cssClass":null,"columns":[[{"allowedChildren":["BACKGROUND","MODULE"],"attributes":[{"name":"id","value":"main","valueOptions":null,"type":"STRING","required":true,"editable":false},{"name":"width","value":"100","valueOptions":null,"type":"STRING","required":true,"editable":false}],"class":"flex.manager.template.node.RegionNode","cssClass":"onehundred","columns":[[]],"id":"main","name":"main","nodeType":"REGION","type":"container","errors":null}]],"id":"norail","name":"norail","nodeType":"LAYOUT","type":"container","errors":null}]}'
        js.exec("angular.element(document.getElementsByName('visualDesignerName')).scope().addNodes(" + flexNode + ")")
    }


    def basicTabFieldHandler(String field, String value) {
        switch (field.toLowerCase()) {
            case "name":
                waitFor(10, 0.5) { templateNameField }
                templateNameField.firstElement().clear()
                templateNameField << value
                break
            case "title":
                waitFor(10, 0.5) { pageTitleField }
                pageTitleField.firstElement().clear()
                pageTitleField << value
                break
            case "header":
                waitFor(10, 0.5) { pageHeaderField }
                pageHeaderField.firstElement().clear()
                pageHeaderField << value
                break
            case "description":
                waitFor(10, 0.5) { metaDescriptionField }
                metaDescriptionField.firstElement().clear()
                metaDescriptionField << value
                break
            case "keywords":
                waitFor(10, 0.5) { metaKeywordsField }
                metaKeywordsField.firstElement().clear()
                metaKeywordsField << value
                break
            case "robots":
                waitFor(10, 0.5) { metaRobotsField }
                metaRobotsField.firstElement().clear()
                metaRobotsField << value
                break
            default:
                print("You entered an invalid field name:" + field + ", allowed fields are: name, title, header, description, keywords, robots")
                break
        }
    }

    def actionHandler(String value) {
        switch (value) {
            case "save":
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
}
