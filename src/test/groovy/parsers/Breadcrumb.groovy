package parsers

class Breadcrumb {

    def breadcrumbTexts = []
    def breadcrumbUrls = []

    Breadcrumb(def jsonData, def baseUrl) {
        def breadcrumbArray = jsonData.breadcrumbs
        for (index in 0..breadcrumbArray.size() - 1) {
            breadcrumbTexts.add(breadcrumbArray.text[index])
            breadcrumbUrls.add(baseUrl + breadcrumbArray.url[index])
        }
    }

    def getBreadcrumbSize() {
        this.breadcrumbTexts.size()
    }

    def getBreadcrumbTexts(int position) {
        this.breadcrumbTexts[position]
    }

    def getBreadcrumbLastText() {
        this.breadcrumbTexts.last()
    }

    def getBreadcrumbUrls(int position) {
        this.breadcrumbUrls[position]
    }
}