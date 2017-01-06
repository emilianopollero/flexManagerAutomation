package logger.errorMessages


class NotContainsErrorMsg extends Message {

    public NotContainsErrorMsg(Object[] args){
        super('Not Contains', args)
        type= 'Error'
    }

    public String getMessage() {
        return "[ERROR] - ${date} - ${description}. Element: ${elementsInvolve[0].toString()} does not contain Element: ${elementsInvolve[1].toString()}."
    }
}