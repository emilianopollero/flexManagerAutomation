package logger.errorMessages

class ElementNotFoundErrorMsg extends Message {

    public ElementNotFoundErrorMsg(Object[] args){
        super('Element Not Found', args)
        type= 'Error'
    }

    public String getMessage() {
        "[ERROR] - ${date} - ${description}. Element: '${elementsInvolve[0].toString()}' not present on page."
    }

}
