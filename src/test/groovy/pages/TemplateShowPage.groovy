package pages

import geb.Browser
import org.openqa.selenium.Keys

/**
 * Created by emiliano.pollero on 08/03/2016.
 */
class TemplateShowPage extends FlexManagerPage {
    static url = ""
    static at = { Browser.drive {driver.getCurrentUrl()}.contains("show") && spinnerNotPresent() }
    static content = {

        //Template Actions/UI handlers
        basicTabBtn { $('a', class: "pill") }
        designTabBtn { $('a', id: "designTab") }
        versionTabBtn { $('a', id: "versionsTab") }
        mappingTab {$('a', id:"mappingTab")}
        updateBtn { $('button', id: "createButton") }
        saveAndLockBtn { $('a', id: "saveAndLock") }
        deleteBtn { $('button', id: "deleteButton") }
        cancelBtn { $('button', id: "cancelButton") }
        listViewBtn { $('button', id: "listButton") }
        publishBtn {$('button', id: "publishButton")}
        editBtn {$('button', id: "editButton")}
        cloneButton {$('button', id:"cloningButton")}
        pageSubTitle {$('h4', id:"formTitle")}

        //Clone modal
        cloneModalPosLocaleDropdown{$('select', id:"cloneModalPosLocaleDropdown")}
        cloneModalCloneBtn{$('button', id:"cloneModalCloneBtn")}
        cloneModalCancelBtn{$('button', id:"cloneModalCancelBtn")}

        //Confirm template delete prompt
        confirmDeleteBtn { $('button', id: "confirmDeleteTemplate") }
        cancelDeleteBtn { $('button', id: "cancelDeleteTemplate") }

        //Basic tab elements
        posLocaleElement {$('label', class:"flex-template-label", text:"Pos Locale:")}
        templateNameElement {$('label', class:"flex-template-label", text:"Template Name:")}
        pageTitleElement {$('label', class:"flex-template-label", text:"Page Title:")}
        pageHeaderElement {$('label', class:"flex-template-label", text:"Page Header:")}
        metaDescriptionElement {$('label', class:"flex-template-label", text:"Meta Description:")}
        metaKeywordsElement {$('label', class:"flex-template-label", text:"Meta keywords:")}
        metaRobotsElement {$('label', class:"flex-template-label", text:"Meta Robots:")}
        lockedByElement {$('label', class:"flex-template-label", text:"Locked by:")}
        lockdateElement {$('label', class:"flex-template-label", text:"Lock date:")}
        versionElement {$('label', class:"flex-template-label", text:"Version")}
        authorElement {$('label', class:"flex-template-label", text:"Author:")}
        createdDateElement {$('label', class:"flex-template-label", text:"Created at:")}
        modifierElement {$('label', class:"flex-template-label", text:"Modifier:")}
        modifiedDateElement {$('label', class:"flex-template-label", text:"Modified at:")}
        publishedDateElement {$('label', class:"flex-template-label", text:"Published at:")}

        //Basic tab elements values
        templateName { $('label', id: "pageName") }
        pageTitle { $('label', id: "pageTitle") }
        pageHeader { $ 'label', id: "pageHeader" }
        metaDescription { $('label', id: "pageMetaDescription") }
        metaKeywords { $('label', id: "pageKeywords") }
        metaRobots { $('label', id: "pageMetaRobot") }
        authorName {$('label', id: "pageAuthor")}

        //Version tab elements
        versionDropdownElementText{$('#versions > div > div > div:nth-child(2) > label')}
        versionDropdownElement{$('select', "ng-model": "flexTemplateVersion")}
        restoreBtn{$('a', id:"restoreBtn")}
        nameElement{$('label', class:"control-label col-sm-4", text:"Name")}
        titleElement{$('label', class:"control-label col-sm-4", text:"Title")}
        headerElement{$('label', class:"control-label col-sm-4", text:"Header")}
        versionDateElement{$('label', class:"control-label col-sm-4", text:"Version Date")}
        publishDateElement{$('label', class:"control-label col-sm-4", text:"Publish Date")}
        versionTabVersionElement{$('label', class:"control-label col-sm-4", text:"Version")}
        versionTabModifierElement {$('label', class:"control-label col-sm-4", text:"Modifier")}
    }

    def checkUIElements(){
        assert basicTabBtn
        assert designTabBtn
        assert versionTabBtn
        assert mappingTab
        assert editBtn
        assert publishBtn
        assert cloneButton
        assert deleteBtn
        assert listViewBtn
        assert posLocaleElement
        assert templateNameElement
        assert pageTitleElement
        assert pageHeaderElement
        assert metaDescriptionElement
        assert metaKeywordsElement
        assert metaRobotsElement
        assert lockedByElement
        assert lockdateElement
        assert versionElement
        assert authorElement
        assert createdDateElement
        assert modifierElement
        assert modifiedDateElement
        assert publishedDateElement
        waitFor(10,0.5){designTabBtn}
        versionTabBtn.click()
        assert versionDropdownElement
        assert restoreBtn
        assert nameElement
        assert pageTitle
        assert headerElement
        assert versionTabVersionElement
        assert versionTabModifierElement
        assert versionDateElement
        assert publishDateElement
        }

    def basicTabFieldValueCheck(String field, String value) {
        switch (field.toLowerCase()) {
            case "name":
                waitFor(10,0.5){templateName}
                assert templateName.text().equals(value)
                break
            case "title":
                waitFor(10,0.5){pageTitle}
                assert pageTitle.text().equals(value)
                break
            case "header":
                waitFor(10,0.5){pageHeader}
                assert pageHeader.text().equals(value)
                break
            case "description":
                waitFor(10,0.5){metaDescription}
                assert metaDescription.text().equals(value)
                break
            case "keywords":
                waitFor(10,0.5){metaKeywords}
                assert metaKeywords.text().equals(value)
                break
            case "robots":
                waitFor(10,0.5){metaRobots}
                assert metaRobots.text().equals(value)
                break
            default:
                print("You entered an invalid field name:" + field + ", allowed fields are: name, title, header, description, keywords, robots")
                break
        }
    }

    def actionHandler(String value) {
        switch (value) {
            case "publish":
                waitFor(10,0.5){publishBtn}
                publishBtn.click()
                break
            case "edit":
                waitFor(10,0.5){editBtn}
                editBtn.click()
                break
            case "save":
                waitFor(10,0.5){updateBtn}
                updateBtn.click()
                break
            case "saveAndLock":
                waitFor(10,0.5){saveAndLockBtn}
                saveAndLockBtn.click()
                break
            case "cancel":
                waitFor(10,0.5){cancelBtn}
                cancelBtn.click()
                break
            case "delete":
                waitFor(10,0.5){deleteBtn}
                deleteBtn.click()
                break
            case "listView":
                waitFor(10,0.5){listViewBtn}
                listViewBtn.click()
                break
            case "confirmDelete":
                waitFor(10,0.5){confirmDeleteBtn}
                confirmDeleteBtn.click()
                break
            case "cancelDelete":
                waitFor(10,0.5){cancelDeleteBtn}
                cancelDeleteBtn.click()
                break
            case "clone":
                waitFor(10,0.5){cloneButton}
                cloneButton.click()
                break
        }
    }

    def cloneTemplate(String posLocale){
        waitFor(10,0.5){cloneModalPosLocaleDropdown}
        cloneModalPosLocaleDropdown.click()
        cloneModalPosLocaleDropdown << posLocale
        cloneModalPosLocaleDropdown << Keys.ENTER
        waitFor(10,0.5){cloneModalCloneBtn}
        cloneModalCloneBtn.click()
    }

}
