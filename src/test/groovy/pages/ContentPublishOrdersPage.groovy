package pages

import geb.Browser
import geb.waiting.WaitTimeoutException

class ContentPublishOrdersPage extends FlexManagerPage {
    static url = ""
    static at = { Browser.drive { driver.getCurrentUrl() }.contains("content/publishOrders") && spinnerNotPresent() }
    static content = {
    }

    def checkPublishOrderStatus(String status) {
        switch (status) {
            case "completed":
                (1..3).each {
                    spinnerNotPresent()
                    sleep(1000)
                    def publishOrder = $('td', contentid: ContentListViewPage.contentId, "ng-mouseenter": "showActions = true")
                    try {
                        waitFor(2, 1) { publishOrder.getAttribute("class").toString().equals("flex-order-completed") }
                    } catch (WaitTimeoutException e) {
                        driver.navigate().refresh()
                        if (it.equals(4)) {
                            assert publishOrder.getAttribute("class").toString().equals("flex-order-completed")
                        }
                    }
                }
                break
            case "failed":
                (1..3).each {
                    spinnerNotPresent()
                    sleep(1000)
                    def publishOrder = $('td', contentid: ContentListViewPage.contentId, "ng-mouseenter": "showActions = true")
                    try {
                        waitFor(2, 1) { publishOrder.getAttribute("class").toString().equals("flex-order-failed") }
                    } catch (WaitTimeoutException e) {
                        driver.navigate().refresh()
                        if (it.equals(4)) {
                            assert publishOrder.getAttribute("class").toString().equals("flex-order-failed")
                        }
                    }
                }
                break
            case "inProgress":
                (1..3).each {
                    spinnerNotPresent()
                    sleep(1000)
                    def publishOrder = $('td', contentid: ContentListViewPage.contentId, "ng-mouseenter": "showActions = true")
                    try {
                        waitFor(2, 1) { publishOrder.getAttribute("class").toString().equals("") }
                    } catch (WaitTimeoutException e) {
                        driver.navigate().refresh()
                        if (it.equals(4)) {
                            assert publishOrder.getAttribute("class").toString().equals("")
                        }
                    }
                }
                break
        }
    }

}
