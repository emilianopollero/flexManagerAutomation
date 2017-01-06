package logger.errorMessages

class NotEqualsErrorMsg extends Message {

    public NotEqualsErrorMsg(Object[] args){
        super('Elements Not Equals', args)
        type= 'Error'
    }

    public String getMessage() {
        return "[ERROR] - ${date} - ${description}. \r\n Actual:   '${elementsInvolve[0].toString()}' \r\n Expected: '${elementsInvolve[1].toString()}'"
    }

}
