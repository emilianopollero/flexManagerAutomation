package logger

import cucumber.runtime.ScenarioImpl
import logger.errorMessages.Message

class ReportLogger implements ILogger {
    private ScenarioImpl scenarioInstance
    static allowed = ['Error', 'Warning']

    public void setScenarioInstance(ScenarioImpl scenario){
        scenarioInstance = scenario
    }

    public void logMessage(Message logMessage){
        if (allowed.contains(logMessage.getType())) {
            scenarioInstance.write(logMessage.getMessage())
        }
    }

}
