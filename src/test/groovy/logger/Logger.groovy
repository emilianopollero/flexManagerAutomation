package logger

import cucumber.runtime.ScenarioImpl
import logger.errorMessages.Message

class Logger {

    private static Logger instance = null;
    private List<ILogger> loggers
    private ReportLogger report

    private Logger() {
        loggers = new ArrayList<ILogger>()
        registerILogger(new ConsoleLogger())
        registerILogger(new FileLogger())
        report = new ReportLogger()
        registerILogger(report)
    }

    public static synchronized Logger getInstance() {
        if (!instance) {
            instance = new Logger()
        }
        return instance
    }


    public void addMessage(Message msg) {
        loggers.each {
            it.logMessage(msg)
        }
    }

    public void registerILogger(ILogger ilogger){
        if (!loggers.contains(ilogger)){
            loggers.add(ilogger)
        }
    }

    public updateScenarioReference(ScenarioImpl scenario){
        report.setScenarioInstance(scenario)
    }

}
