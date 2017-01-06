manager.listener.logger.println("Analizing the fail percentage...")
def results = manager.build.testResultAction
if (results != null) {
    int total = results.getTotalCount()
    int failed = results.getFailCount()
    if (failed != 0) {
        int failedPercentage = (failed * 100) / total
        int failureThreshold = Integer.parseInt(manager.envVars['FailureThreshold'])
        if (failedPercentage > failureThreshold) {
            manager.buildFailure()
            manager.addErrorBadge("A total of ${failed} (${failedPercentage}%) tests failed.")
        } else {
            manager.addWarningBadge("Warning. A total of ${failed} (${failedPercentage}%) tests failed.")
            manager.build.@result = hudson.model.Result.SUCCESS
        }
    } else {
        manager.build.@result = hudson.model.Result.SUCCESS
        manager.addBadge("success.gif", "All tests passed!")
    }
} else {
    manager.build.@result = hudson.model.Result.SUCCESS
    manager.addBadge("success.gif", "All tests passed!")
}