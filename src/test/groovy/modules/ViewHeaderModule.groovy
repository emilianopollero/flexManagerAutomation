package modules

import geb.Module

/**
 * Created by emiliano.pollero on 08/03/2016.
 */
class ViewHeaderModule extends Module {

    static content = {
        container(wait: true) { $('h4', id: "formTitle") }
        flexLogo(wait: true) { $('img', alt: "Flex Tools Logo") }
    }

    def getViewTitle(String expectedTitle) {
        return container.text().trim().equalsIgnoreCase(expectedTitle.trim())
    }
}
