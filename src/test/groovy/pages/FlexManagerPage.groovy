package pages

import geb.Page
import modules.NavBarModule

/**
 * Created by emiliano.pollero on 08/03/2016.
 */

class FlexManagerPage extends Page {
    static at = {spinnerNotPresent()}
    static content = {

        spinner(wait: true) { $('div', id: "loaderDiv") }
        navBar {module NavBarModule}

    }

    static String tempId

    def storeTemplateId(String templateName){
        tempId = {$('button', id:"showButton", templateName: templateName).getAttribute("page-id")
        }
    }

    def spinnerNotPresent() {
        return waitFor(100, 0.5) { spinner.getAttribute("class").toString().equalsIgnoreCase("hidden") }
    }

    public static String getLastBitFromUrl(final String url){
        return url.replaceFirst(".*/([^/?]+).*", '$1')
    }

}
