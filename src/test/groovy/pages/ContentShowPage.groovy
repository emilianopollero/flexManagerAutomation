package pages

import geb.Browser

/**
 * Created by emiliano.pollero on 19/04/2016.
 */
class ContentShowPage extends FlexManagerPage {
    static url = ""
    static at = { Browser.drive { driver.getCurrentUrl() }.contains("content/show") && spinnerNotPresent() }
    static content = {
        contentTitle { $('div', id: "contentTitle") }
        body { $('div', id: "body") }
        name { $('p', id: "contentName") }
        linkName { $('td', class: "linkName ng-binding") }
        linkUrl { $('td', class: "linkUrl ng-binding") }
        editBtn { $('button', id: "editButton") }
        publishBtn { $('button', id: "publishButton") }
        deleteBtn { $('button', id: "deleteButton") }
        listViewBtn { $('button', id: "listButton") }
        nameLabel { $('label', text: "Name") }
        nameContent { $('p', id: "contentName") }
        authorLabel { $('label', text: "Author") }
        authorContent { $('p', id: "author") }
        modifierLabel { $('label', text: "Modifier") }
        modifierContent { $('p', id: "username") }
        createdDateLabel { $('label', text: "Created date") }
        createdDateContent { $('p', id: "dateCreated") }
        modifiedDateLabel { $('label', text: "Modified date") }
        modifiedDateContent { $('p', id: "lastUpdated") }
        posLocaleLabel { $('span', id: "pos_locales") }
        pageTypeeLabel { $('span', id: "page_type") }
        contentTitleLabel { $('div', id: "contentTitle") }
        languageLabel { $('div', id: "language") }
        publishableLabel { $('div', class: "col-xs-2") }
        linkTable { $('table', id: "linkTable") }
    }

    def basicTabFieldValueCheck(String field, String value) {
        switch (field.toLowerCase()) {
            case "name":
                waitFor(10, 0.5) { name }
                assert name.text().equals(value)
                break
            case "title":
                waitFor(10, 0.5) { contentTitle }
                assert contentTitle.text().equals(value)
                break
            case "body":
                waitFor(20, 0.5) { body }
                assert body.text().equals(value)
                break
            case "linkName":
                waitFor(10, 0.5) { linkName }
                assert linkName.text().equals(value)
                break
            case "linkUrl":
                waitFor(10, 0.5) { linkUrl }
                assert linkUrl.text().equals(value)
                break
        }
    }

    def checkUIElements(String contentType) {
        assert editBtn
        assert publishBtn
        assert deleteBtn
        assert listViewBtn
        assert nameLabel
        assert nameContent
        assert authorLabel
        assert authorContent
        assert modifierLabel
        assert modifierContent
        assert createdDateLabel
        assert createdDateContent
        assert modifiedDateLabel
        assert modifiedDateContent
        assert posLocaleLabel
        assert pageTypeeLabel
        if (contentType != "createLinks") {
            assert contentTitleLabel
        }
        if (contentType == "createLinks") {
            assert linkTable
        }
        assert languageLabel
        assert languageLabel.text() == "English" || "Spanish" || "Danish" || "German" || "French" || "Italian" ||
                "Japanese" || "Korean" || "Malaysian" || "Dutch" || "Norwegian" || "Polish" || "Portuguese" ||
                "Russian" || "Swedish" || "Thai" || "Chinese" || "Finnish" || "Indonesian" || "Filipino" ||
                "Vietnamese" || "Traditional Chinese (Taiwan)" || "Traditional Chinese (Hong Kong)" ||
                "Simplified Chinese"
        assert publishableLabel.text() == " Not Publishable " || "Publishable"
    }
}
