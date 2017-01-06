package logger.errorMessages

class DescriptionErrorMsg extends Message {

    public DescriptionErrorMsg(Object[] args){
        super('Page Description Mismatch', args)
        type= 'Error'
    }

    public String getMessage() {
        return "[ERROR] - ${date} - ${description}. \r\n Expected: '${elementsInvolve[0].toString()}' \r\n Actual:   '${elementsInvolve[1].toString()}'"
    }

}
