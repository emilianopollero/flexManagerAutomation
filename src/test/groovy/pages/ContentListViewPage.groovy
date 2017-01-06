package pages

import geb.Browser

/**
 * Created by emiliano.pollero on 20/04/2016.
 */
class ContentListViewPage extends FlexManagerPage {
    static url = ""
    static at = {Browser.drive {driver.getCurrentUrl()}.contains("content/list") && spinnerNotPresent()}
    static content = {

        contentSearchBox {$('input', name: "searchbox")}
        contentSearchButton {$('button', title: "Search")}
        contentClearSearchButton {$('button', title:"Clear filters and back to list")}
        contentCancelDeleteButton{$('button', class:"btn btn-warning", text: "Cancel")}
        contentConfirmDeleteButton{$('button', id:"confirmDeleteContent")}
        publishOrdersButton{$('button', id: "go-to-publish-order-list")}

        idColumnHeader{$('th', "st-sort":"id")}
        typeColumnHeader{$('th', "st-sort":"type")}
        nameColumnHeader{$('th', "st-sort":"name")}
        authorColumnHeader{$('th', "st-sort":"author")}
        dateCreatedColumnHeader{$('th', "st-sort":"dateCreated")}
        modifierColumnHeader{$('th', "st-sort":"modifier")}
        modifiedDateColumnHeader{$('th', "st-sort":"lastUpdated")}

        // Action column buttons
        showBtn { $('button', id: "showButton") }
        editBtn { $('button', id: "editButton") }
        publishBtn { $('button', id: "publishButton") }
        deleteBtn { $('button', id: "deleteButton") }

        contentPublishMessage { $("div", class: "alert alert-info").$("ul").$("li") }
    }

    static String expectedContentPublishMessage = "Publishing request is in process, please check publish order page for it's status"

    def checkUIElements() {
        assert contentSearchBox
        assert contentSearchButton
        assert idColumnHeader
        assert typeColumnHeader
        assert nameColumnHeader
        assert authorColumnHeader
        assert dateCreatedColumnHeader
        assert modifierColumnHeader
        assert modifiedDateColumnHeader
        assert showBtn
        assert editBtn
        assert publishBtn
        assert deleteBtn
    }

   static def contentId

    def contentActions(String action, String name) {

        def contentButton
        switch (action) {
            case "show":
                contentButton = $('button', id: "showButton", "content-name": name)
                waitFor(10,0.5){contentButton}
                contentButton.click()
                break
            case "edit":
                contentButton = $('button', id: "editButton", "content-name": name)
                waitFor(50,0.5){contentButton}
                contentButton.click()
                break
            case "publish":
                contentButton = $('button', id: "publishButton", "content-name": name)
                waitFor(10,0.5){contentButton}
                contentButton.click()
                verifyContentPublishMessage()
                getContentId(name)
                break
        }
    }

    def getContentId(String contentName) {
        def contentShowButton = $('button', id: "showButton", "content-name": contentName)
        contentId =  contentShowButton.getAttribute("page-id")
    }

    def verifyContentPublishMessage() {
        waitFor(20, 0.5) {contentPublishMessage}
        def actualContentPublishMessage = contentPublishMessage.text()
        assert actualContentPublishMessage.equals(expectedContentPublishMessage)
    }
}
