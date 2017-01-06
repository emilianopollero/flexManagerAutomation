package logger.errorMessages


class ConnectionNotSuccessMsg extends Message {

    public ConnectionNotSuccessMsg(Object[] args) {
        super('Connection status code was not successful', args)
        type = 'Error'
    }

    public String getMessage() {
        "[ERROR] - ${date} - ${description}. Status code value was ${elementsInvolve[0].toString()}."
    }
}