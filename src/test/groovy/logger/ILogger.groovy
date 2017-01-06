package logger

import logger.errorMessages.Message

interface ILogger {

    void logMessage(Message msg)

}