package env

import static cucumber.api.groovy.Hooks.*

//store tags of fails tests
After('@none') { scenario ->
    def tagsPropertiesDir = 'src/test/resources/tagsProperties'
    if (scenario.failed) {
        storeProperties('ReRunTests', getTags(scenario, tagsPropertiesDir), tagsPropertiesDir)
    }
}


def void storeProperties(String propName, String value, String dir) {
    try {
        Properties props = new Properties()
        props.setProperty(propName, value)
        File file = new File(dir + '/reRunTests.properties')
        FileOutputStream fileOut = new FileOutputStream(file)
        props.store(fileOut, "FailedTestsTags")
        fileOut.close()
    } catch (FileNotFoundException e) {
        e.printStackTrace()
    } catch (IOException e) {
        e.printStackTrace()
    }
}

String readProperties(String property, String dir) {
    File cucumber = new File(dir + '/reRunTests.properties')
    if (cucumber.exists()) {
        def props = new Properties()
        new File(dir + '/reRunTests.properties').withInputStream {
            stream -> props.load(stream)
        }
        String tagList = props.getProperty(property)
        return tagList
    } else {
        String tagList = ''
        return tagList
    }
}

String getTags(def scenario, String dir) {
    String oldTag = readProperties('ReRunTests', dir).replaceAll("@none", '')
    String newTag = scenario.properties.sourceTagNames.findAll { it =~ /@N\d+/ }.join()
    String tag
    if (oldTag.contains(newTag)) {
        return tag = oldTag
    } else if (oldTag == ''){
        return tag = newTag
    }else {
        return tag = oldTag + ',' + ' ' + newTag
    }
}