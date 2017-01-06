package logger.errorMessages

class ElementPresentErrorMsg extends Message {

    public ElementPresentErrorMsg(Object[] args){
        super('Element Not Found', args)
        type= 'Error'
    }

    public String getMessage() {
        "[ERROR] - ${date} - ${description}. Element: '${elementsInvolve[0].toString()}' is present on page."
    }

}
