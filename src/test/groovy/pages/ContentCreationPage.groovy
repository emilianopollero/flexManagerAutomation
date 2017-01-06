package pages

import geb.Browser
import services.Context

import java.text.SimpleDateFormat
import java.time.LocalDateTime


/**
 * Created by emiliano.pollero on 06/04/2016.
 */
class ContentCreationPage extends FlexManagerPage {
    static String posLocale = 'ORB.en_US'
    static String pageType = 'hotelDestination'
    static String language = 'english'
    static String linkName = "Test"
    static String linkUrl = "www.orbitz.com"
    static String editedLinkName = "TestEdit"
    static String editedLinkUrl = "https://www.wikipedia.org/"
    static def selectedContentType


    def format = new SimpleDateFormat('h:00 a')
    static url = ""
    static at = {
        (driver.getCurrentUrl().contains("/content/create") || driver.getCurrentUrl().contains("/content/edit")) && spinnerNotPresent()
    }
    static content = {
        createButton { $('a', id: "createButton") }
        cancelButton { $('a', id: "cancelButton") }
        contentNameField { $('input', id: "contentName") }
        publishableSwitch { $('switch', value: "booleanAttr.value") }
        editorContentTab { $('a', id: "contentTab") }
        editorMediaAssetsTab { $('a', id: "mediaAssetsTab") }
        editorLinksTab { $('a', id: "linksTab") }
        updateButton { $('a', id: "createButton") }
        //dropdowns
        posLocalesDropdown { $('button', id: "pos_locales") }
        pageTypeDropdown { $('button', id: "page_type") }
        languageDropdown { $('button', id: "language") }
        pageSubTypeDropdown { $('button', id: "page_sub_type") }
        amenitiesDropdown { $('button', id: "amenities") }
        //pos/locale dropdown options
        posSearchField {
            $('#container > div:nth-child(2) > div.content-form.ng-scope > div:nth-child(2) > div:nth-child(1) > content-attribute > div > div > multi-select > isteven-multi-select > span > div > div.helperContainer.ng-scope > div:nth-child(2) > input')
        }
        orbEnUsPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "1") }
        ctixEnUsPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "2") }
        ebukEnGBPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "3") }
        ebchDeChPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "4") }
        ebchEnGBPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "5") }
        ebchFrCHPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "6") }
        ebfiFiFiPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "7") }
        ebfiEnGBPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "8") }
        ebdeDeDePosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "9") }
        ebfrFrFrPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "10") }
        ebieEnIePosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "11") }
        expEnUsPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "12") }
        expEnGbPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "13") }
        expEnAUPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "14") }
        expEnCAPosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "15") }
        mjseSvSePosLocaleDropDownOption { dropdownLocatorGenerator("posLocale", "16") }
        //lannguage dropdown options
        englishLanguageDropDownOption { dropdownLocatorGenerator("language", "1") }
        spanishLanguageDropDownOption { dropdownLocatorGenerator("language", "2") }
        danishLanguageDropDownOption { dropdownLocatorGenerator("language", "3") }
        germanLanguageDropDownOption { dropdownLocatorGenerator("language", "4") }
        frenchLanguageDropDownOption { dropdownLocatorGenerator("language", "5") }
        italianLanguageDropDownOption { dropdownLocatorGenerator("language", "6") }
        japaneseLanguageDropDownOption { dropdownLocatorGenerator("language", "7") }
        koreanLanguageDropDownOption { dropdownLocatorGenerator("language", "8") }
        malaysianLanguageDropDownOption { dropdownLocatorGenerator("language", "9") }
        dutchLanguageDropDownOption { dropdownLocatorGenerator("language", "10") }
        norwegianLanguageDropDownOption { dropdownLocatorGenerator("language", "11") }
        polishLanguageDropDownOption { dropdownLocatorGenerator("language", "12") }
        portugueseLanguageDropDownOption { dropdownLocatorGenerator("language", "13") }
        russianLanguageDropDownOption { dropdownLocatorGenerator("language", "14") }
        swedishLanguageDropDownOption { dropdownLocatorGenerator("language", "15") }
        thaiLanguageDropDownOption { dropdownLocatorGenerator("language", "16") }
        chineseLanguageDropDownOption { dropdownLocatorGenerator("language", "17") }
        finnishLanguageDropDownOption { dropdownLocatorGenerator("language", "18") }
        indonesianLanguageDropDownOption { dropdownLocatorGenerator("language", "19") }
        filipinoLanguageDropDownOption { dropdownLocatorGenerator("language", "20") }
        vietnameseLanguageDropDownOption { dropdownLocatorGenerator("language", "21") }
        traditionalChineseTaiwanLanguageDropDownOption { dropdownLocatorGenerator("language", "22") }
        traditionalChineseHongKongLanguageDropDownOption { dropdownLocatorGenerator("language", "23") }
        simplifiedChineseLanguageDropDownOption { dropdownLocatorGenerator("language", "24") }
        //links content language dropdown options
        linksEnglishLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "1") }
        linksSpanishLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "2") }
        linksDanishLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "3") }
        linksGermanLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "4") }
        linksFrenchLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "5") }
        linksItalianLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "6") }
        linksJapaneseLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "7") }
        linksKoreanLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "8") }
        linksMalaysianLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "9") }
        linksDutchLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "10") }
        linksNorwegianLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "11") }
        linksPolishLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "12") }
        linksPortugueseLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "13") }
        linksRussianLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "14") }
        linksSwedishLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "15") }
        linksThaiLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "16") }
        linksChineseLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "17") }
        linksFinnishLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "18") }
        linksIndonesianLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "19") }
        linksFilipinoLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "20") }
        linksVietnameseLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "21") }
        linksTraditionalChineseTaiwanLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "22") }
        linksTraditionalChineseHongKongLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "23") }
        linksSimplifiedChineseLanguageDropDownOption { dropdownLocatorGenerator("linksLanguage", "24") }
        //page type dropdown options
        pageTypeSearchField {
            $('#container > div:nth-child(2) > div.content-form.ng-scope > div:nth-child(3) > div > span > content-attribute > div > div > multi-select > isteven-multi-select > span > div > div.helperContainer.ng-scope > div:nth-child(2) > input')
        }
        destinationTravelGuidePageTypeDropdownOption { dropdownLocatorGenerator("pageType", "1") }
        flightOnDAirportPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "2") }
        flightOnDCityPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "3") }
        flightOriginAirportPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "4") }
        flightDestinationsPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "5") }
        flightOriginCityPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "6") }
        hotelDestinationsPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "7") }
        travelGuideFilterHotelsPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "8") }
        travelGuideFlightsPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "9") }
        travelGuideHotelsPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "10") }
        travelGuideAirlinesPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "11") }
        travelGuideAirportsPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "12") }
        travelGuideCarRentalCompanyPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "13") }
        carRentalGuidePageTypeDropdownOption { dropdownLocatorGenerator("pageType", "14") }
        carRentalGuideAirportPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "15") }
        carRentalDestinationsPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "16") }
        travelGuideVacationRentalsPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "17") }
        loyaltyPageTypeDropdownOption { dropdownLocatorGenerator("pageType", "18") }
        //page sub type dropdown options
        brandPageSubTypeDropdownOption { $('span', class: "ng-binding", text: " Brand") }
        amenitiesPageSubTypeDropdownOption { $('span', class: "ng-binding", text: " Amenities") }
        //amenities options
        bathTubAmenitiesOption { $('span', class: "ng-binding", text: " Bath Tub") }
        //Text editor elements
        textTitleInputField { $('input', id: "title") }
        textContentInputArea { $('div', contenteditable: "true") }
        //Links module tab contents
        linkDetailsAddButton { $('a', class: "btn btn-sm btn-primary add-link", title: "Add Link") }
        linkDetailsRemoveAllButton { $('a', class: "btn btn-sm btn-default remove-all-links", id: "removeAllLinks") }
        linkNameField { $('a', class: "name ng-scope ng-binding editable editable-click editable-empty") }
        linkNameInputField { $('#links-tbody > tr > td.angular-editable-form.name-row > form > div > input') }
        linkUrlField { $('a', class: "url ng-scope ng-binding editable editable-click editable-empty") }
        linkUrlInputField { $('#links-tbody > tr > td.angular-editable-form.url-row > form > div > input') }
        linkDetailsSubmitButton { $('button', type: "submit") }
        linkDetailsDeleteButton { $('a', class: "btn btn-sm flex-btn-delete") }
        linkDetailsConfirmDeleteButton { $('button', class: "btn btn-primary", text: "Confirm") }
        linkDetailsCancelDeleteButton { $('button', class: "btn btn-warning", text: "Cancel") }
        //dates
        effectiveDateStart { $('input-date', id: "effective_date_start") }
        effectiveDateEnd { $('input-date', id: "effective_date_end") }
        currentDayOfMonth {
            $('td', class: "day ng-binding ng-scope", text: String.valueOf(LocalDateTime.now().getDayOfMonth()))
        }
        currentHourOfDay { $('span', class: "hour", text: format.format(new Date()).toString()) }
        currentMinuteOfDay { $('span', class: "minute", text: format.format(new Date()).toString()) }
        endDay {
            $('td', class: "day ng-binding ng-scope", text: String.valueOf(Integer.valueOf(String.valueOf(LocalDateTime.now().getDayOfMonth())) + 1))
        }
        //media assets tab contents
        mediaAssetsAddButton { $('a', class: "btn btn-sm btn-primary add-media-asset") }
        mediaAssetsRemoveAllButton { $('a', class: "btn btn-sm btn-default remove-all-media-asset") }
        mediaAssetsImagePreview { $('a', id: "imagePreview") }
        mediaAssetsMediaUrlInputField {
            $('#media-asset-tbody > tr > td.angular-editable-form.imagePreview-row > form > div > input')
        }
        mediaAssetsMediaUrlSubmitButton { $('button', type: "submit") }
        mediaUrlColumn { $('th', text: "Media URL") }
        mediaTypeColumn { $('th', text: "Media Type") }
        imageTypeColumn { $('th', text: "Image type") }
        clickUrlColumn { $('th', text: "Click URL") }
        altTextColumn { $('th', text: "Alt text") }
        captionColumn { $('th', text: "Caption") }
        creditColumn { $('th', text: "Credit") }
        mediaSequenceNumberColumn { $('th', text: "Media Sequence Number") }
    }

    static String contentNameUsed

    def dropdownLocatorGenerator(String locator, String position) {
        switch (locator) {
            case "posLocale":
                def posLocaleSelector = $("#container > div:nth-child(2) > div.content-form.ng-scope > div:nth-child(2) > div:nth-child(1) > content-attribute > div > div > multi-select > isteven-multi-select > span > div > div.checkBoxContainer > div:nth-child(" + position + ") > div > label > span")
                return posLocaleSelector
                break
            case "language":
                def languageSelector = $("#content > div > div:nth-child(1) > div:nth-child(2) > content-attribute > div > div > single-select > isteven-multi-select > span > div > div.checkBoxContainer > div:nth-child(" + position + ") > div > label > span")
                return languageSelector
                break
            case "linksLanguage":
                def linksLanguageSelector = $("#content > div > div > div.col-md-3.content-links-language > content-attribute > div > div > single-select > isteven-multi-select > span > div > div.checkBoxContainer > div:nth-child(" + position + ") > div > label > span")
                return linksLanguageSelector
                break
            case "pageType":
                def pageTypeSelector = $("#container > div:nth-child(2) > div.content-form.ng-scope > div:nth-child(3) > div > span > content-attribute > div > div > multi-select > isteven-multi-select > span > div > div.checkBoxContainer > div:nth-child(" + position + ") > div > label > span")
                return pageTypeSelector
                break
        }
    }

    def checkUIElements() {
        assert contentNameField
        assert posSearchField
        posLocalesDropdown.click()
        assert orbEnUsPosLocaleDropDownOption
        assert ctixEnUsPosLocaleDropDownOption
        assert ebukEnGBPosLocaleDropDownOption
        assert ebchDeChPosLocaleDropDownOption
        assert ebchEnGBPosLocaleDropDownOption
        assert ebchFrCHPosLocaleDropDownOption
        assert ebfiFiFiPosLocaleDropDownOption
        assert ebfiEnGBPosLocaleDropDownOption
        assert ebdeDeDePosLocaleDropDownOption
        assert ebfrFrFrPosLocaleDropDownOption
        assert ebieEnIePosLocaleDropDownOption
        assert expEnUsPosLocaleDropDownOption
        assert expEnGbPosLocaleDropDownOption
        assert expEnAUPosLocaleDropDownOption
        assert expEnCAPosLocaleDropDownOption
        assert mjseSvSePosLocaleDropDownOption
        pageTypeDropdown.click()
        assert hotelDestinationsPageTypeDropdownOption
        assert destinationTravelGuidePageTypeDropdownOption
        assert flightOnDAirportPageTypeDropdownOption
        assert flightOnDCityPageTypeDropdownOption
        assert flightOriginAirportPageTypeDropdownOption
        assert flightDestinationsPageTypeDropdownOption
        assert flightOriginCityPageTypeDropdownOption
        assert travelGuideFilterHotelsPageTypeDropdownOption
        assert travelGuideFlightsPageTypeDropdownOption
        assert travelGuideHotelsPageTypeDropdownOption
        assert travelGuideAirlinesPageTypeDropdownOption
        assert travelGuideAirportsPageTypeDropdownOption
        assert travelGuideCarRentalCompanyPageTypeDropdownOption
        assert carRentalGuidePageTypeDropdownOption
        assert carRentalGuideAirportPageTypeDropdownOption
        assert carRentalDestinationsPageTypeDropdownOption
        assert travelGuideVacationRentalsPageTypeDropdownOption
        assert loyaltyPageTypeDropdownOption
        editorContentTab.click()
        languageDropdown.click()
        if (selectedContentType == "createLinks") {
            assert linksEnglishLanguageDropDownOption
            assert linksSpanishLanguageDropDownOption
            assert linksDanishLanguageDropDownOption
            assert linksGermanLanguageDropDownOption
            assert linksFrenchLanguageDropDownOption
            assert linksItalianLanguageDropDownOption
            assert linksJapaneseLanguageDropDownOption
            assert linksKoreanLanguageDropDownOption
            assert linksMalaysianLanguageDropDownOption
            assert linksDutchLanguageDropDownOption
            assert linksNorwegianLanguageDropDownOption
            assert linksPolishLanguageDropDownOption
            assert linksPortugueseLanguageDropDownOption
            assert linksRussianLanguageDropDownOption
            assert linksSwedishLanguageDropDownOption
            assert linksThaiLanguageDropDownOption
            assert linksChineseLanguageDropDownOption
            assert linksFinnishLanguageDropDownOption
            assert linksIndonesianLanguageDropDownOption
            assert linksFilipinoLanguageDropDownOption
            assert linksVietnameseLanguageDropDownOption
            assert linksTraditionalChineseTaiwanLanguageDropDownOption
            assert linksTraditionalChineseHongKongLanguageDropDownOption
            assert linksSimplifiedChineseLanguageDropDownOption
            editorLinksTab.click()
            assert linkDetailsAddButton
            assert linkDetailsRemoveAllButton
            editorContentTab.click()
        } else {
            assert englishLanguageDropDownOption
            assert spanishLanguageDropDownOption
            assert danishLanguageDropDownOption
            assert germanLanguageDropDownOption
            assert frenchLanguageDropDownOption
            assert italianLanguageDropDownOption
            assert japaneseLanguageDropDownOption
            assert koreanLanguageDropDownOption
            assert malaysianLanguageDropDownOption
            assert dutchLanguageDropDownOption
            assert norwegianLanguageDropDownOption
            assert polishLanguageDropDownOption
            assert portugueseLanguageDropDownOption
            assert russianLanguageDropDownOption
            assert swedishLanguageDropDownOption
            assert thaiLanguageDropDownOption
            assert chineseLanguageDropDownOption
            assert finnishLanguageDropDownOption
            assert indonesianLanguageDropDownOption
            assert filipinoLanguageDropDownOption
            assert vietnameseLanguageDropDownOption
            assert traditionalChineseTaiwanLanguageDropDownOption
            assert traditionalChineseHongKongLanguageDropDownOption
            assert simplifiedChineseLanguageDropDownOption
            assert textTitleInputField
            assert textContentInputArea
            editorMediaAssetsTab.click()
            assert mediaAssetsAddButton
            assert mediaAssetsRemoveAllButton
            editorContentTab.click()
        }
        assert effectiveDateStart
        assert effectiveDateEnd
        assert publishableSwitch
    }

    def enterRequiredFieldsForContentCreation(String contentType, String contentName) {
        contentNameUsed = contentName
        selectedContentType = contentType
        contentFieldsHandler("name", contentName)
        contentFieldsHandler("posLocale", posLocale)
        contentFieldsHandler("pageType", pageType)
        contentFieldsHandler("language", language)
        if (contentType == 'createLinks') {
            addLinkDetailsContent("new")
        }
    }

    def addLinkDetailsContent(String state) {
        switchToTab("links")
        contentElementsClick("addLinkDetails")
        switch (state) {
            case "new":
                contentFieldsHandler("linkName", linkName)
                contentFieldsHandler("linkUrl", linkUrl)
                break
            case "edit":
                contentFieldsHandler("linkName", editedLinkName)
                contentFieldsHandler("linkUrl", editedLinkUrl)
                break
        }
    }

    def contentFieldsHandler(String field, String value) {
        switch (field) {
            case "mediaUrl":
                waitFor(10, 0.5) { mediaAssetsMediaUrlInputField }
                mediaAssetsMediaUrlInputField.firstElement().clear()
                mediaAssetsMediaUrlInputField << value
                mediaAssetsMediaUrlSubmitButton.click()
                break
            case "startDate":
                waitFor(10, 0.5) { effectiveDateStart }
                effectiveDateStart.click()
                if (value == "currentDay") {
                    waitFor(10, 0.5) { currentDayOfMonth }
                    currentDayOfMonth.click()
                    waitFor(10, 0.5) { currentHourOfDay }
                    currentHourOfDay.click()
                    waitFor(10, 0.5) { currentMinuteOfDay }
                    currentMinuteOfDay.click()
                } else {
                    def dayOfMonth = $('td', class: "day ng-binding ng-scope", text: value)
                    waitFor(10, 0.5) { dayOfMonth }
                    dayOfMonth.click()
                    waitFor(10, 0.5) { currentHourOfDay }
                    currentHourOfDay.click()
                    waitFor(10, 0.5) { currentMinuteOfDay }
                    currentMinuteOfDay.click()
                }
                break
            case "endDate":
                waitFor(10, 0.5) { effectiveDateEnd }
                effectiveDateEnd.click()
                if (value == "endDate") {
                    waitFor(10, 0.5) { endDay }
                    endDay.click()
                    waitFor(10, 0.5) { currentHourOfDay }
                    currentHourOfDay.click()
                    waitFor(10, 0.5) { currentMinuteOfDay }
                    currentMinuteOfDay.click()
                } else {
                    def selectedEndDate = $('td', class: "day ng-binding ng-scope", text: value)
                    waitFor(10, 0.5) { selectedEndDate }
                    selectedEndDate.click()
                    waitFor(10, 0.5) { currentHourOfDay }
                    currentHourOfDay.click()
                    waitFor(10, 0.5) { currentMinuteOfDay }
                    currentMinuteOfDay.click()
                }
                break
            case "textBody":
                waitFor(10, 0.5) { textContentInputArea }
                if (!textContentInputArea.isEmpty())
                    textContentInputArea.firstElement().clear()
                textContentInputArea << value
                break
            case "title":
                waitFor(10, 0.5) { textTitleInputField }
                if (!textTitleInputField.isEmpty())
                    textTitleInputField.firstElement().clear()
                textTitleInputField << value
                break
            case "amenities":
                waitFor(10, 0.5) { amenitiesDropdown }
                amenitiesDropdown.click()
                switch (value) {
                    case "bathTub":
                        waitFor(10, 0.5) { bathTubAmenitiesOption }
                        bathTubAmenitiesOption.click()
                        break
                }
                break
            case "pageSubType":
                waitFor(10, 0.5) { pageSubTypeDropdown }
                pageSubTypeDropdown.click()
                switch (value) {
                    case "brand":
                        waitFor(10, 0.5) { brandPageSubTypeDropdownOption }
                        brandPageSubTypeDropdownOption.click()
                        break
                    case "amenities":
                        waitFor(10, 0.5) { amenitiesPageSubTypeDropdownOption }
                        amenitiesPageSubTypeDropdownOption.click()
                        break
                    case "theme":
                        waitFor(10, 0.5) { themesPageSubTypeDropdownOption }
                        themesPageSubTypeDropdownOption.click()
                        break
                }
                break
            case "posLocale":
                waitFor(10, 0.5) { posLocalesDropdown }
                posLocalesDropdown.click()
                switch (value) {
                    case "ORB.en_US":
                        orbEnUsPosLocaleDropDownOption.click()
                        break
                }
                break
            case "name":
                waitFor(10, 0.5) { contentNameField }
                contentNameField.firstElement().clear()
                contentNameField << value
                break
            case "pageType":
                waitFor(10, 0.5) { pageTypeDropdown }
                pageTypeDropdown.click()
                switch (value) {
                    case "hotelDestination":
                        hotelDestinationsPageTypeDropdownOption.click()
                        break
                }
                break
            case "publishableSwitch":
                waitFor(10, 0.5) { publishableSwitch }
                publishableSwitch.click()
                break
            case "language":
                waitFor(10, 0.5) { languageDropdown }
                languageDropdown.click()
                switch (value) {
                    case "english":
                        if (selectedContentType == "createLinks") {
                            linksEnglishLanguageDropDownOption.click()
                        } else {
                            englishLanguageDropDownOption.click()
                        }
                        break
                }
                break
            case "linkName":
                waitFor(10, 0.5) { linkNameField }
                linkNameField.click()
                waitFor(10, 0.5) { linkNameInputField }
                linkNameInputField << value
                linkDetailsSubmitButton.click()
                break
            case "linkUrl":
                waitFor(10, 0.5) { linkUrlField }
                linkUrlField.click()
                waitFor(10, 0.5) { linkUrlInputField }
                linkUrlInputField << value
                linkDetailsSubmitButton.click()
                break
        }
    }

//    def createOrCancelContent(String option) {
//        switch (option) {
//            case "create":
//                waitFor(10, 0.5) { createButton }
//                ((JavascriptExecutor) driver).executeScript("scroll(0, -250);");
//                createButton.click()
//                break
//            case "cancel":
//                waitFor(10, 0.5) { cancelButton }
//                ((JavascriptExecutor) driver).executeScript("scroll(0, -250);");
//                cancelButton.click()
//                break
//        }
//    }

    def switchToTab(String tab) {
        switch (tab) {
            case "content":
                waitFor(10, 0.5) { editorContentTab }
                editorContentTab.click()
                break
            case "mediaAssets":
                waitFor(10, 0.5) { editorMediaAssetsTab }
                editorMediaAssetsTab.click()
                break
            case "links":
                sleep(5000)
                waitFor(10, 0.5) { editorLinksTab }
                editorLinksTab.click()
                break
        }
    }

    def contentElementsClick(String element) {
        switch (element) {
            case "create":
                waitFor(10, 0.5) { createButton }
                createButton.click()
                Browser.drive {
                    at ContentShowPage
                    spinnerNotPresent()
                    def contentPublishButton = $('button', id: "publishButton")
                    waitFor(10,1){contentPublishButton}
                    Context.instance[contentNameUsed] = contentPublishButton.attr("private-id")
                }
                break
            case "cancel":
                waitFor(10, 0.5) { cancelButton }
                cancelButton.click()
                break
            case "addMediaAsset":
                waitFor(10, 0.5) { mediaAssetsAddButton }
                mediaAssetsAddButton.click()
                break
            case "mediaAssetImage":
                waitFor(10, 0.5) { mediaAssetsImagePreview }
                mediaAssetsImagePreview.click()
                break
            case "addLinkDetails":
                waitFor(20, 0.5) { linkDetailsAddButton }
                linkDetailsAddButton.click()
                break
            case "update":
                waitFor(10, 0.5) { updateButton }
                updateButton.click()
                break
        }
    }
}
