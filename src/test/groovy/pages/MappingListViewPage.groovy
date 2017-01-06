package pages

import modules.PosLocaleModule
import org.openqa.selenium.Keys
import services.Context


class MappingListViewPage extends FlexManagerPage {
    static url = ""
    static at = { driver.getCurrentUrl().contains("/mapping/list/") && spinnerNotPresent() }
    static content = {
        posLocale { module PosLocaleModule }

        addNewMappingBtn { $('button', id: "add-new-flex-mapping") }
        publishOrdersBtn { $('button', id: "go-to-publish-order-list") }
        mappingTypeDropdown { $('#container > table > thead > tr:nth-child(1) > th > div > select:nth-child(4)') }
        mappingConfirmDeleteButton { $('#confirmDeleteMapping') }
        mappingCancelDeleteButton { $('button', class: "btn btn-warning", text: "Cancel") }
        modalTitle {
            $('body > div.modal.fade.ng-isolate-scope.custom-css-class.in > div > div > div.modal-header-green.ng-scope > h4')
        }
        modalTemplateField { $($('input', placeholder: "Select any template")[0]) }
        modalTemplateRulesFields { $($('input', placeholder: "Select any template")[1]) }
        modalSaveBtn { $('button', class: "btn btn-primary", text: "Save") }
        modalCancelBtn { $('button', class: "btn btn-warning", text: "Cancel") }

        //Mapping type dropdown options
        destinationTravelGuideOption { $('option', label: "Destination Travel Guides") }
        flightOnDAirportOption { $('option', label: "Flight Ond Airport") }
        flightOnDCityOption { $('option', label: "Flight Ond City") }
        flightOriginAirportOption { $('option', label: "Flight Origin Airport") }
        flightDestinationsOption { $('option', label: "Flight Destinations") }
        flightOriginCityOption { $('option', label: "Flight Origin City") }
        hotelDestinationsOption { $('option', label: "Hotel Destinations") }
        travelGuideFlightsOption { $('option', label: "Travel Guide Flights") }
        travelGuideHotelsOption { $('option', label: "Travel Guide Hotels") }
        travelGuideAirlinesOption { $('option', label: "Travel Guide Airlines") }
        travelGuideCarRentalCompanyOption { $('option', label: "Travel Guide Car Rental Company") }
        travelGuideFilterHotelsOption { $('option', label: "Travel Guide Filter Hotels") }
        urlMappingOption { $('option', label: "Url Mapping") }

        //Destination travel guide modal
        destinationTravelGuideAirportRadioBtn { $('input', name: "3329") }
        destinationTravelGuideCityRadioBtn { $('input', name: "3330") }
        destinationTravelGuidePoiRadioBtn { $('input', name: "3331") }
        destinationTravelGuideCountryRadioBtn { $('input', name: "3332") }
        destinationTravelGuideNeighborhoodRadioBtn { $('input', name: "3333") }
        destinationTravelGuideMultiregionRadioBtn { $('input', name: "3334") }
        destinationTravelGuideStateRadioBtn { $('input', name: "3335") }
        mappingLocationField { $('input', id: "mappingLocationField") }
        //Flight OnD Airport modal
        ondOriginField {
            $($('#mappingLocationField')[0])
        }
        ondDestinationField {
            $($('#mappingLocationField')[1])
        }
        //Flight destinations modal
        flightDestinationAirportRadioBtn { $('input', name: "3470") }
        flightDestinationCityRadioBtn { $('input', name: "3471") }
        flightDestinationPoiRadioBtn { $('input', name: "3472") }
        flightDestinationCountryRadioBtn { $('input', name: "3473") }
        flightDestinationNeighborhoodRadioBtn { $('input', name: "3474") }
        flightDestinationMultiregionRadioBtn { $('input', name: "3475") }
        flightDestinationStateRadioBtn { $('input', name: "3476") }
        //Hotel destinations modal
        hotelDestinationAirportRadioBtn { $('input', name: "3774") }
        hotelDestinationCityRadioBtn { $('input', name: "3475") }
        hotelDestinationPoiRadioBtn { $('input', name: "3476") }
        hotelDestinationCountryRadioBtn { $('input', name: "3477") }
        hotelDestinationNeighborhoodRadioBtn { $('input', name: "3478") }
        hotelDestinationMultiregionRadioBtn { $('input', name: "3479") }
        hotelDestinationStateRadioBtn { $('input', name: "3480") }
        //Travel Guide Flights modal
        travelGuideFlightsAirportRadioBtn { $('input', name: "3962") }
        travelGuideFlightsCityRadioBtn { $('input', name: "3963") }
        travelGuideFlightsPoiRadioBtn { $('input', name: "3964") }
        travelGuideFlightsCountryRadioBtn { $('input', name: "3965") }
        travelGuideFlightsNeighborhoodRadioBtn { $('input', name: "3966") }
        travelGuideFlightsMultiregionRadioBtn { $('input', name: "3967") }
        travelGuideFlightsStateRadioBtn { $('input', name: "3968") }
        //Travel Guide Hotels modal
        travelGuideHotelsAirportRadioBtn { $('input', name: "4086") }
        travelGuideHotelsCityRadioBtn { $('input', name: "4087") }
        travelGuideHotelsPoiRadioBtn { $('input', name: "4088") }
        travelGuideHotelsCountryRadioBtn { $('input', name: "4089") }
        travelGuideHotelsNeighborhoodRadioBtn { $('input', name: "4090") }
        travelGuideHotelsMultiregionRadioBtn { $('input', name: "4091") }
        travelGuideHotelsStateRadioBtn { $('input', name: "4092") }
        //Travel Guide Airlines modal
        airlinesAirSuppliersDropdown {
            $('#mapping > div.ng-scope > div > div > single-select > isteven-multi-select > span > button')
        }
        //Travel Guide Car Rental Company modal
        carRentalCompanyDropdown {
            $('#mapping > div.ng-scope > div > div > single-select > isteven-multi-select > span > button')
        }
        //Travel Guide Filter Hotels
        travelGuideFilterHotelsAirportRadioBtn { $('input', name: "5852") }
        travelGuideFilterHotelsCityRadioBtn { $('input', name: "5853") }
        travelGuideFilterHotelsPoiRadioBtn { $('input', name: "5854") }
        travelGuideFilterHotelsCountryRadioBtn { $('input', name: "5855") }
        travelGuideFilterHotelsNeighborhoodRadioBtn { $('input', name: "5856") }
        travelGuideFilterHotelsMultiregionRadioBtn { $('input', name: "5857") }
        travelGuideFilterHotelsStateRadioBtn { $('input', name: "5858") }
        travelGuideFilterHotelsStarsDropdown {
            $('body > div.modal.fade.ng-isolate-scope.custom-css-class.in > div > div > div.modal-body.ng-scope > div:nth-child(2) > div > div > single-select > isteven-multi-select > span > button')
        }
        travelGuideFilterHotelsAffinitiesDropdown {
            $('body > div.modal.fade.ng-isolate-scope.custom-css-class.in > div > div > div.modal-body.ng-scope > div:nth-child(3) > div > div > single-select > isteven-multi-select > span > button')
        }
        travelGuideFilterHotelsHotelBrandDropdown {
            $('body > div.modal.fade.ng-isolate-scope.custom-css-class.in > div > div > div.modal-body.ng-scope > div:nth-child(4) > div > div > single-select > isteven-multi-select > span > button')
        }
        //Url mapping modal
        urlMappingField {
            $('input', placeholder: "URL")
        }
    }

    def checkUIElements() {
        posLocale.checkUIElements()
        assert mappingTypeDropdown
        assert addNewMappingBtn
        assert destinationTravelGuideOption
        assert flightOnDAirportOption
        assert flightOnDCityOption
        assert flightOriginAirportOption
        assert flightDestinationsOption
        assert flightOriginCityOption
        assert hotelDestinationsOption
        assert travelGuideFlightsOption
        assert travelGuideHotelsOption
        assert travelGuideAirlinesOption
        assert travelGuideCarRentalCompanyOption
        assert travelGuideFilterHotelsOption
        assert urlMappingOption
    }

    def listViewActionHandler(String btn) {
        switch (btn) {
            case "createBtn":
                waitFor(20, 0.5) { addNewMappingBtn }
                addNewMappingBtn.click()
                break
            case "publishOrdersBtn":
                waitFor(20, 0.5) { publishOrdersBtn }
                publishOrdersBtn.click()
                break
        }
    }

    static String templateNameUsed
    static String mappingValue1
    static String mappingValue2
    static String mappingType
    def dropdownOption
    static String selectedPosLocale
    static String selectedMappingType

    def posLocaleSelector(String posLocaleValue) {
        selectedPosLocale = posLocaleValue
        waitFor(20, 0.5) { posLocale.mappingDropdown }
        posLocale.mappingDropdown.click()
        def posLocaleDropdownOption
        posLocaleDropdownOption = $('option', label: posLocaleValue)
        waitFor(20, 0.5) { posLocaleDropdownOption }
        posLocaleDropdownOption.click()
    }

    def mappingTypeSelector(String mappingType) {
        selectedMappingType = mappingType
        switch (mappingType) {
            case "Travel Guide Car Rental Company":
                selectedMappingType = "Travel Guide CarRentalCompany"
                break
            case "Travel Guide Vacation Rentals":
                selectedMappingType = "Travel Guide VacationRentals"
                break
        }
        waitFor(20, 0.5) { mappingTypeDropdown }
        mappingTypeDropdown << selectedMappingType
        mappingTypeDropdown << Keys.ENTER
        sleep(1000)
    }

    def RequiredMappingTypeFields(String value1, String value2, String mappingTypeSelected, String templateName) {
        waitFor(20, 0.5) { modalTitle }
        templateNameUsed = templateName
        mappingType = mappingTypeSelected
        switch (mappingTypeSelected) {
            case "Destination Travel Guides":
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Flight Ond Airport":
                ondOriginField << value1
                waitFor(20, 1) { ondOriginField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                ondOriginField << Keys.ENTER
                ondDestinationField << value2
                waitFor(20, 1) { ondDestinationField.getAttribute("aria-expanded").equals("true") }
                mappingValue2 = $('li', class: "ng-scope active").text()
                ondDestinationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Flight Ond City":
                ondOriginField << value1
                waitFor(20, 1) { ondOriginField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                ondOriginField << Keys.ENTER
                ondDestinationField << value2
                waitFor(20, 1) { ondDestinationField.getAttribute("aria-expanded").equals("true") }
                mappingValue2 = $('li', class: "ng-scope active").text()
                ondDestinationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Flight Origin Airport":
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Flight Destinations":
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Flight Origin City":
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Hotel Destinations":
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Travel Guide Flights":
                mappingLocationField.click()
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Travel Guide Hotels":
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Travel Guide Airlines":
                waitFor(20, 1) { airlinesAirSuppliersDropdown }
                airlinesAirSuppliersDropdown.click()
                dropdownOption = $('span', class: "ng-binding", text: " " + value1)
                dropdownOption.click()
                mappingValue1 = value1
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Travel Guide Car Rental Company":
                waitFor(20, 1) { carRentalCompanyDropdown }
                carRentalCompanyDropdown.click()
                dropdownOption = $('span', class: "ng-binding", text: " " + value1)
                dropdownOption.click()
                mappingValue1 = value1
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Travel Guide Filter Hotels":
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Url Mapping":
                urlMappingField << value1
                mappingValue1 = value1
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Car Rental Guide":
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Car Rental Destinations":
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Car Rental Guide Airport":
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Travel Guide Airports":
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
            case "Travel Guide Vacation Rentals":
                mappingLocationField << value1
                waitFor(20, 1) { mappingLocationField.getAttribute("aria-expanded").equals("true") }
                mappingValue1 = $('li', class: "ng-scope active").text()
                mappingLocationField << Keys.ENTER
                modalTemplateField << templateName
                waitFor(20, 1) { modalTemplateField.getAttribute("aria-expanded").equals("true") }
                modalTemplateField << Keys.ENTER
                break
        }
        waitFor(20, 0.5) { modalSaveBtn }
        spinnerNotPresent()
        modalSaveBtn.click()
        spinnerNotPresent()
        def mappingPublishButton = $('button', id: "publishButton", name: templateName)
        waitFor(10,1){mappingPublishButton}
        Context.instance[templateName] = mappingPublishButton.attr("private-id")
    }

    def checkMappingCreation() {
        spinnerNotPresent()
        if (mappingType == "Flight Ond Airport" || mappingType == "Flight Ond City") {
            assert $('#container > table > tbody > tr > td:nth-child(1)').text().equals(mappingValue1)
            assert $('#container > table > tbody > tr > td:nth-child(2)').text().equals(mappingValue2)
        } else if (mappingType == "Travel Guide Filter Hotels") {
            assert $('#container > table > tbody > tr:nth-child(1) > td:nth-child(1)').text().equals(mappingValue1)
        } else {
            assert $('#container > table > tbody > tr:nth-child(1) > td.ng-binding.ng-scope').text().equals(mappingValue1)
        }
    }
}
