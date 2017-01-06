package logger.errorMessages

class ScenarioFailedMsg extends Message {

    public ScenarioFailedMsg(Object[] args){
        super('Scenario Failed', args)
        type= 'Cucumber'
    }

    public String getMessage() {
        String res = "${description}: ${elementsInvolve[0].toString()}."
        return res
    }

}
