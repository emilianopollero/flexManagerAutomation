package pages

import geb.Browser

/**
 * Created by emiliano.pollero on 09/05/2016.
 */
class TemplatePublishOrdersPage extends FlexManagerPage {
    static url = ""
    static at = { Browser.drive { driver.getCurrentUrl() }.contains("publishorders/list") && spinnerNotPresent() }
    static content = {

    }

    def checkPublishOrder(String publishOrderType, String successOrFailure) {

        switch (publishOrderType) {
            case "delete":
                assert { $('td', templateid: tempId).text().equalsIgnoreCase("delete") }
                assert {
                    $('td', class: "flex-order-completed", templateid: tempId).text().equalsIgnoreCase(successOrFailure)
                }
                break
        }

    }
}
