import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import reportScreeshots.CustomChromeDriver
import org.openqa.selenium.Dimension

FirefoxProfile firefoxProfile = new FirefoxProfile()
firefoxProfile.setAcceptUntrustedCertificates(true)
firefoxProfile.setAssumeUntrustedCertificateIssuer(false)
firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
        "text/csv,application/pdf,application/csv,application/vnd.ms-excel");
firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
firefoxProfile.setPreference("browser.download.manager.useWindow", false);
firefoxProfile.setPreference("browser.helperApps.deleteTempFileOnExit", true);
firefoxProfile.setPreference("webdriver.load.strategy", "unstable")
firefoxProfile.setPreference("browser.popups.showPopupBlocker", true)
firefoxProfile.setPreference("app.update.auto", false);
firefoxProfile.setPreference("app.update.enabled", false);

ChromeOptions chromeOptions = new ChromeOptions()
chromeOptions.addArguments("--start-maximized")
Dimension d = new Dimension(1920,1080)
//chromeOptions.addArguments("window-size=1920,1080")
// Use firefox as the default
driver = {
    def driver = new FirefoxDriver(firefoxProfile)
    driver.manage().window().maximize()
    driver.manage().window().setSize(d)
    driver
}

environments {

    // run as “gradlew  cucumber -Dgeb.env=chrome”
    chrome {
        driver = { new CustomChromeDriver(chromeOptions) }
    }
}

waiting {
    presets {
        slowest {
            timeout = 30
            retryInterval = 0.1
        }
        medium {
            timeout = 15
            retryInterval = 0.1
        }
        normal {
            timeout = 5
            retryInterval = 0.1
        }
        quick {
            timeout = 0
        }
    }
}