package logger

import logger.errorMessages.Message

class FileLogger implements ILogger {
    File file = new File('./build/CucumberTestRun.log')
    static allowed = ['Warning', 'Error', 'Cucumber']

    public void logMessage(Message logMessage){
        if (allowed.contains(logMessage.getType())) {
            file.append(logMessage.getMessage() + "\r\n")
        }
    }
}
