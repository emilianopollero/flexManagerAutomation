package env

import groovyx.net.http.HttpResponseException

import static groovyx.net.http.ContentType.*
import cucumber.runtime.ScenarioImpl
import groovyx.net.http.RESTClient
import logger.Logger
import logger.errorMessages.ScenarioFailedMsg
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriverException
import services.CompareImages
import services.Context
import common.utils.FlexManagerPropertyReader


import javax.imageio.ImageIO
import java.awt.image.BufferedImage

import static cucumber.api.groovy.Hooks.*
import geb.Browser

def theBrowser = new Browser()

//Set the new instance of the scenario to the logger
Before() { scenario ->
    Logger.getInstance().updateScenarioReference((ScenarioImpl) scenario)
}

//Adds a custom log when any scenario fails
After() { scenario ->
    if (scenario.failed) {
        Logger.getInstance().addMessage(new ScenarioFailedMsg((String) scenario.name))
    }
}

//Add ScreenShoot and Url of the page, when scenario fails, to the report
After('@UI') { scenario ->
    if (scenario.failed) {
        try {
            scenario.embed(((TakesScreenshot) theBrowser.driver).getScreenshotAs(OutputType.BYTES), "image/png")
            scenario.write("<div style=\"background-color:white\"><p>URL:  <a href='$theBrowser.driver.currentUrl'>$theBrowser.driver.currentUrl</a></p></div>")
        } catch (WebDriverException e) {
        }
    }
}

After('@Screenshots') { scenario ->
    if (scenario.failed) {
        try {
            if (new File(CompareImages.lastDiffImage).exists()) {
                BufferedImage img1 = ImageIO.read(new File(CompareImages.lastBaselineImage))
                BufferedImage img2 = ImageIO.read(new File(CompareImages.lastActualImage))
                scenario.write("Baseline Image - Size: ${img1.getWidth()}x${img1.getHeight()}")
                scenario.embed(CompareImages.pngImageToByte(CompareImages.lastBaselineImage), "image/png")
                scenario.write("Actual Image - Size: ${img2.getWidth()}x${img2.getHeight()}")
                scenario.embed(CompareImages.pngImageToByte(CompareImages.lastActualImage), "image/png")
                scenario.write("Generated Diff Image:")
                scenario.embed(CompareImages.pngImageToByte(CompareImages.lastDiffImage), "image/png")
            } else {
                scenario.write("Scenario Failed before Image verification.")
                scenario.embed(((TakesScreenshot) theBrowser.driver).getScreenshotAs(OutputType.BYTES), "image/png")
            }
            scenario.write("<div style=\"background-color:white\"><p>URL:  <a href='$theBrowser.driver.currentUrl'>$theBrowser.driver.currentUrl</a></p></div>")
            scenario.write("<div style=\"background-color:white\"><p>SessionId:  ${theBrowser.driver.manage().getCookieNamed('JSESSIONID')}</p></div>")
            scenario.write("<div style=\"background-color:white\"><p>Logging:  ${theBrowser.driver.manage().getCookieNamed('logging')}</p></div>")
        } catch (WebDriverException e) {
        }
        CompareImages.clearAll()
    }
}

//Add Source Code of the page, when scenario fails, to the report
After('@none') { scenario ->
    if (scenario.failed) {
        try {
            def HTMLsourcecode = groovy.xml.XmlUtil.escapeXml(theBrowser.driver.getPageSource())
            scenario.write('''<div style="background-color:white"><details><summary>Page Source Code</summary><p>''' + HTMLsourcecode + '</p></details>')
        } catch (WebDriverException e) {
        }
    }
}

After() { scenario ->
    if (scenario.failed){
        String url = "http://flex-manager-grails.us-west-2.test.expedia.com/"
        def client = new RESTClient(url)
        def resp = client.post(
                path: '/api/login',
                body: [username: FlexManagerPropertyReader.instance.getProperty("admin.username"), password:FlexManagerPropertyReader.instance.getProperty("admin.password")], requestContentType: JSON
        )
        client.headers['Authorization'] = "Bearer" + " " + resp.responseData.access_token
        Context.instance.each {
            if (it.key.toString().contains("AUTOMATION_TEST_TEMPLATE")) {
                try {
                    String templatePublishPath = "/api/pages/" + it.value + "/publish/"
                    client.post(path: templatePublishPath)
                    String templateDeletePath = "/api/pages/" + it.value
                    client.delete(path: templateDeletePath)
                } catch (HttpResponseException e) {
                    println("Template not present, nothing to delete")
                }
            } else if (it.key.toString().contains("automationMappingTestTemplatePolleroDoNotTouch")) {
                try {
                    String mappingPublishPath = "/api/mapping/" + it.value + "/publish/"
                    client.post(path: mappingPublishPath)
                    String mappingDeletePath = "/api/mapping/" + it.value
                    client.delete(path: mappingDeletePath)
                } catch (HttpResponseException e) {
                    println("Mapping not present, nothing to delete")
                }
            } else {
                try {
                    String contentPublishPath = "/api/content/" + it.value + "/publish"
                    client.post(path: contentPublishPath)
                    String contentDeletePath = "/api/content/" + it.value
                    client.delete(path: contentDeletePath)
                } catch (HttpResponseException e) {
                    println("Content not present, nothing to delete")
                }
            }
        }
    }
}