package logger.errorMessages

/**
 * Created by j.rodriguez on 3/21/2016.
 */
class KeywordErrorMsg extends Message{

    public KeywordErrorMsg(Object[] args){
        super('Keyword Mismatch', args)
        type= 'Error'
    }

    public String getMessage() {
        return "[ERROR] - ${date} - ${description}. \r\n Resolved url: '${elementsInvolve[0].toString()}' \r\n Does not contained expected keyword: '${elementsInvolve[1].toString()}'"
    }
}
