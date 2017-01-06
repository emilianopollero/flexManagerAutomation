package reportScreeshots

import org.apache.commons.codec.binary.Base64OutputStream
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.OutputType
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriverException
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.interactions.Mouse
import org.openqa.selenium.interactions.internal.Coordinates

import javax.imageio.ImageIO
import java.awt.Graphics2D
import java.awt.image.BufferedImage

class CustomChromeDriver extends ChromeDriver {

    CustomChromeDriver(ChromeOptions options) {
        super(options)
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        //obtain first partial screenShot
        clearHover()
        BufferedImage screenshot = ImageIO.read(super.getScreenshotAs(OutputType.FILE))
        //set page dimensions
        int pageHeight = getPageHeight()
        int scrollNumber = screenshot.getHeight()
        //obtain rest of screenShot image if needed
        int position = scrollNumber
        while (pageHeight > position) {
            scrollPage(scrollNumber)
            BufferedImage partialScreenShot = ImageIO.read(super.getScreenshotAs(OutputType.FILE))
            screenshot = joinImages(screenshot, partialScreenShot, position, pageHeight)
            screenshot.flush()
            position += scrollNumber
        }
        //scroll page to the top
        scrollPage(-pageHeight)
        return outputType.convertFromBase64Png(convertToB64(screenshot))
    }

    private int getPageHeight() {
        WebElement body = super.findElement(By.xpath('/html'))
        body.getSize().getHeight()
    }

    private void clearHover(){
        Actions a = new Actions(super)
        WebElement element = super.findElement(By.id('header-alert-banner'))
        a.click(element).perform()
    }

    private void scrollPage(int pixels) {
        JavascriptExecutor jse = (JavascriptExecutor) super
        jse.executeScript("window.scrollBy(0,${pixels})")
        clearHover()
        Thread.sleep(200)
    }

    private static BufferedImage joinImages(BufferedImage img1, BufferedImage img2, int position, int pageHeight) {
        //set output image size
        int width = Math.max(img1.getWidth() - 15, img2.getWidth() - 15)
        int height = Math.min(img1.getHeight() + img2.getHeight(), pageHeight)
        //join images
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
        Graphics2D g2 = newImage.createGraphics()
        int drawPoint = Math.min(position, pageHeight - img2.getHeight())
        g2.drawImage(img2, 0, drawPoint, null)
        g2.drawImage(img1, 0, 0, null)
        g2.dispose()
        return newImage
    }

    private static def convertToB64(BufferedImage image) {
        ByteArrayOutputStream os = new ByteArrayOutputStream()
        OutputStream b64 = new Base64OutputStream(os)
        ImageIO.write(image, "png", b64)
        String result = os.toString("UTF-8")
        String base64EncodedPng = (String) result
        base64EncodedPng
    }

}