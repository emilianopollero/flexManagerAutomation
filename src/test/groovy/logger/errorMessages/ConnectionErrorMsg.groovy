package logger.errorMessages

class ConnectionErrorMsg extends Message {

    public ConnectionErrorMsg(Object[] args){
        super('Connection Issue', args)
        type= 'Error'
    }

    public String getMessage() {
        "[ERROR] - ${date} - ${description}. ${elementsInvolve[0].toString()}."
    }

}
