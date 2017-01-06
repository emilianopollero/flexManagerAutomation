package steps

import cucumber.api.PendingException
import geb.Browser
import pages.ContentCreationPage
import pages.ContentListViewPage
import pages.ContentPublishOrdersPage

import static cucumber.api.groovy.EN.*
import org.openqa.selenium.JavascriptExecutor;
import common.utils.FlexManagerPropertyReader

And(~'^I change content field: (.+) to this value: (.+)$') { String field, String fieldValue ->
    Browser.drive {
        at ContentCreationPage
        page.contentFieldsHandler(field, fieldValue)
    }
}

And(~'^I enter the required fields for (.+) with (.+)$') { String contentType, String contentName ->
    Browser.drive {
        at ContentCreationPage
        page.enterRequiredFieldsForContentCreation(contentType, contentName)
    }
}


When(~'^I click on the content (.+) element$') { String element ->
    Browser.drive {
        at ContentCreationPage
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
        page.contentElementsClick(element)
    }
}

And(~'^I (.+) content named (.+)$') { String action, String name ->
    Browser.drive {
        at ContentListViewPage
        page.contentActions(action, name)
        sleep(2000)
    }
}

When (~/^I delete and (.+) content with content name (.+)$/) { String action, String contentName ->
    Browser.drive {
        at ContentListViewPage
        def deleteContentButton = $('button', id: "deleteButton", "content-name": contentName)
        waitFor(10,0.5){deleteContentButton}
        deleteContentButton.click()
        switch (action) {
            case "confirmDelete":
                waitFor(40,0.5){page.contentConfirmDeleteButton.isDisplayed()}
                page.contentConfirmDeleteButton.click()
                break
            case "cancelDelete":
                waitFor(40,0.5){page.contentCancelDeleteButton.isDisplayed()}
                page.contentCancelDeleteButton.click()
                break
        }
    }
}

And(~'I delete and (.+) link details with content name (.+)$') { String action, String contentName ->
    Browser.drive {
        at ContentCreationPage
        page.switchToTab("links")
        page.linkDetailsDeleteButton.click()
        switch (action) {
            case "confirmDelete":
                waitFor(40, 0.5) { page.linkDetailsConfirmDeleteButton.isDisplayed() }
                page.linkDetailsConfirmDeleteButton.click()
                break
            case "cancelDelete":
                waitFor(40, 0.5) { page.linkDetailsCancelDeleteButton.isDisplayed() }
                page.linkDetailsCancelDeleteButton.click()
                break
        }
    }
}

And(~'^I update link details$') { ->
    Browser.drive {
        at ContentCreationPage
        page.addLinkDetailsContent("edit")
    }
}

And(~'I go to content show page for content with name (.+)$') { String contentName ->
    Browser.drive {
        at ContentListViewPage
        def contentShowButton = $('button', id: "showButton", "content-name": contentName)
        contentShowButton.click()
    }
}

Then(~'^I can see content with name (.+) is (.+)$') { String contentName, String deletedOrPresent ->
    Browser.drive {
        at ContentListViewPage
        switch (deletedOrPresent){
            case "deleted":
                assert !$('button', id: "showButton", "content-name": contentName)
                break
            case "present":
                sleep(3000)
                assert $('button', id: "showButton", "content-name": contentName)
                break
        }
    }
}

Then(~'I can see (.+) of type (.+) is (.+) in elasticsearch$') { String contentName, String contentType, String action ->
    String elasticSearchUrl
    String contentStatus = "publish"
    Browser.drive {
        at ContentListViewPage
        def contentId = page.getContentId(contentName)
        if (contentType == "Links")
            elasticSearchUrl = FlexManagerPropertyReader.instance.getProperty("elasticSearchUrlLinksContent")
        else
            elasticSearchUrl = FlexManagerPropertyReader.instance.getProperty("elasticSearchUrl")
        sleep(5000)
        go(elasticSearchUrl+contentId)
        switch (action) {
            case "published":
                assert driver.getPageSource().contains("\"name\":" + "\"" + contentName + "\"" + ",")
                assert driver.getPageSource().contains("\"contentPurpose\":" + "\"" + contentType + "\"" + ",")
                assert driver.getPageSource().contains("\"status\":" + "\"" + contentStatus + "\"" )
                break
        }
    }
}

And(~'^I switch to (.+) tab$') { String tabValue ->
    Browser.drive {
        at ContentCreationPage
        page.switchToTab(tabValue)
    }
}
And(~/^I verify content publish order is (.+)$/) { String status->
    Browser.drive {
        at ContentPublishOrdersPage
        page.checkPublishOrderStatus(status)
    }
}
And(~/^I click on the content list view page publish orders button$/) { ->
    Browser.drive {
        at ContentListViewPage
        page.publishOrdersButton.click()
    }
}