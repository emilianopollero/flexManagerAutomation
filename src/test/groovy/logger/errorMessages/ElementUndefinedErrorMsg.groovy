package logger.errorMessages

class ElementUndefinedErrorMsg extends Message {

    public ElementUndefinedErrorMsg(Object[] args) {
        super('Element Undefined', args)
        type = 'Error'
    }

    public String getMessage() {
        "[ERROR] - ${date} - ${description}. There is not a: '${elementsInvolve[0].toString()}' '${elementsInvolve[1].toString()}' defined on page Object."
    }
}