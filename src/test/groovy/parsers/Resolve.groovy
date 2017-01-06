package parsers

class Resolve {

    String canonicalPath
    String templateId

    String lob

    String locationId
    String locationName
    String locationType
    String locationParentId
    String locationCode

    String destinationId
    String destinationName
    String destinationType
    String desttinationParentId
    String destinationCode

    String starRatingCode
    String starRatingDescription

    String carrierCode
    String carrierName

    String supplierCode
    String supplierName

    String pageType
   
    String propsDestination
    String propsTemplateId
    String pageName
    String lineOfBusiness

    Resolve(def jsonData) {
        canonicalPath = jsonData?.canonicalPath

        templateId = jsonData?.templateId

        lob = jsonData?.searchContext?.lob

        locationId = jsonData.searchContext?.location?.id
        locationName = jsonData.searchContext?.location?.name
        locationType = jsonData.searchContext?.location?.type
        locationParentId = jsonData.searchContext?.location?.parentId
        locationCode = jsonData.searchContext?.location?.code

        destinationId = jsonData.searchContext?.destination?.id
        destinationName = jsonData.searchContext?.destination?.name
        destinationType = jsonData.searchContext?.destination?.type
        desttinationParentId = jsonData.searchContext?.destination?.parentId
        destinationCode = jsonData.searchContext?.destination?.code

        starRatingCode  = jsonData.searchContext?.starRating?.code
        starRatingDescription = jsonData.searchContext?.starRating?.description

        carrierCode = jsonData.searchContext?.airCarrier?.code
        carrierName = jsonData.searchContext?.airCarrier?.name

        supplierCode = jsonData.searchContext?.carSupplier?.code
        supplierName = jsonData.searchContext?.carSupplier?.name

        pageType = jsonData.searchContext?.pageType

        propsDestination = jsonData.trackingContext?.props?.destination
        propsTemplateId = jsonData.trackingContext?.props?.templateId

        pageName = jsonData.trackingContext?.pageName

        lineOfBusiness = jsonData.trackingContext?.lineOfBusiness
    }

    String getCanonicalPath() {
        this.canonicalPath
    }

    String getTemplateId() {
        this.templateId
    }

    String getLob() {
        this.lob
    }

    String getLocationId() {
        this.locationId
    }

    String getLocationName() {
        this.locationName
    }

    String getLocationType() {
        this.locationType
    }

    String getLocationParentId() {
        this.locationParentId
    }

    String getLocationCode() {
        this.locationCode
    }

    String getDestinationId() {
        this.destinationId
    }

    String getDestinationName() {
        this.destinationName
    }

    String getDestinationType() {
        this.destinationType
    }

    String getDesttinationParentId() {
        this.desttinationParentId
    }

    String getDestinationCode() {
        this.destinationCode
    }

    String getStarRatingCode() {
        this.starRatingCode
    }

    String getStarRatingDescription() {
        this.starRatingDescription
    }

    String getCarrierCode() {
        this.carrierCode
    }

    String getCarrierName() {
        this.carrierName
    }

    String getSupplierCode() {
        this.supplierCode
    }

    String getSupplierName() {
        this.supplierName
    }

    String getPageType() {
        this.pageType
    }

    String getPropsDestination() {
        this.propsDestination
    }

    String getPropsTemplateId() {
        this.propsTemplateId
    }

    String getPageName() {
        this.pageName
    }

    String getLineOfBusiness() {
        this.lineOfBusiness
    }
}