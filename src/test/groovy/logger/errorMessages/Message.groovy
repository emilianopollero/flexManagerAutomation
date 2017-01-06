package logger.errorMessages

import org.codehaus.groovy.runtime.StackTraceUtils

import java.text.SimpleDateFormat

abstract class Message {
    protected String description
    protected String type
    protected String[] elementsInvolve
    protected String date

    public Message(String errorDescription, Object[] args){
        description= errorDescription
        elementsInvolve= args
        date = getDate()
    }

    public abstract String getMessage()

    private static String getDate(){
        Date now = new Date()
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.dd.MM 'at' hh:mm:ss")
        return ft.format(now)
    }

    private static String getRootCause(Throwable exception){
        if (exception) {
            return StackTraceUtils.extractRootCause(exception).toString()
        }
        else {
            return ''
        }
    }

    public String getType(){
        return type
    }

}