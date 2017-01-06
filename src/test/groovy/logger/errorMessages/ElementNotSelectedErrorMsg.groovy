package logger.errorMessages

class ElementNotSelectedErrorMsg extends Message {

    public ElementNotSelectedErrorMsg(Object[] args){
        super('Element Not Selected', args)
        type= 'Error'
    }

    public String getMessage() {
        return "[ERROR] - ${date} - ${description}. Element: '${elementsInvolve[0].toString()}'."
    }

}
