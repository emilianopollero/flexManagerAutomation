package logger.errorMessages

class TitleErrorMsg extends Message {

    public TitleErrorMsg(Object[] args){
        super('Title Mismatch', args)
        type= 'Error'
    }

    public String getMessage() {
        return "[ERROR] - ${date} - ${description}. \r\n Expected: '${elementsInvolve[0].toString()}' \r\n Actual:   '${elementsInvolve[1].toString()}'"
    }

}
