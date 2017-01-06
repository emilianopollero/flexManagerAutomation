package logger

import logger.errorMessages.Message

class ConsoleLogger implements ILogger {
    static allowed = ['Error', 'Warning']

    public void logMessage(Message logMessage){
        if (allowed.contains(logMessage.getType()))
            println logMessage.getMessage()
    }
}
