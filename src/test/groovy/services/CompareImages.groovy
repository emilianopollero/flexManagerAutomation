package services

import geb.navigator.Navigator

import java.awt.image.BufferedImage
import javax.imageio.ImageIO;
import java.awt.Color

class CompareImages {
    private static int highlight = 255 * 65536 + 153 * 256 + 204
    private static int highlightMissing = Color.lightGray.getRGB()
    private static BufferedImage img1
    private static BufferedImage img2
    public static String lastBaselineImage = ''
    public static String lastActualImage = ''
    public static String lastDiffImage = ''
    public static double lastDiffPercentage = 0.0

    public static double getDiffPercentage(String image1, String image2, double threshHold, String diffName) {
        lastBaselineImage = image1
        lastActualImage = image2
        lastDiffImage = diffName
        BufferedImage diffImg = generateEmptyDiffImage(image1, image2)
        double percentage = -0.1
        long diff = 0
        int pixelsChanged = 0
        for (int y in 0..diffImg.getHeight() - 1) {
            for (int x in 0..diffImg.getWidth() - 1) {
                if (getPixelDiff(x,y)>=0) {
                    long pixelDiff = getPixelDiff(x,y)
                    diff += pixelDiff
                    if (pixelDiff != 0) {
                        diffImg.setRGB(x, y, highlight)
                        pixelsChanged++
                    } else {
                        diffImg.setRGB(x, y, img1.getRGB(x, y))
                    }
                } else {
                    pixelsChanged++
                    diffImg.setRGB(x, y, highlightMissing)
                }
            }
        }
        percentage = pixelsChanged * 100.0 / (diffImg.getWidth() * diffImg.getHeight())
        if (percentage > threshHold) {
            generateDiffImage(diffImg, diffName)
        }
        lastDiffPercentage = percentage
        percentage
    }

    private static long getPixelDiff(int x, int y){
        try {
            int rgb1 = img1.getRGB(x, y)
            int rgb2 = img2.getRGB(x, y)
            return calculatePixelDiff(rgb1, rgb2)
        }
        catch (Throwable t) {
            return -1.0
        }
    }

    static long calculatePixelDiff(int rgb1, int rgb2){
        int r1 = (rgb1 >> 16) & 0xff
        int g1 = (rgb1 >> 8) & 0xff
        int b1 = (rgb1) & 0xff
        int r2 = (rgb2 >> 16) & 0xff
        int g2 = (rgb2 >> 8) & 0xff
        int b2 = (rgb2) & 0xff
        long pixelDiff = 0
        pixelDiff += Math.abs(r1 - r2)
        pixelDiff += Math.abs(g1 - g2)
        pixelDiff += Math.abs(b1 - b2)
        return pixelDiff
    }

    static BufferedImage generateEmptyDiffImage(String image1, String image2) {

        try {
            img1 = ImageIO.read(new File(image1))
            img2 = ImageIO.read(new File(image2))
        }
        catch (IOException e) {
            e.printStackTrace()
            return null
        }
        int bigWidth
        int bigHeight
        if (img1.getWidth() > img2.getWidth())
            bigWidth = img1.getWidth()
        else
            bigWidth = img2.getWidth()
        if (img1.getHeight() > img2.getHeight())
            bigHeight = img1.getHeight()
        else
            bigHeight = img2.getHeight()
        BufferedImage diffImg = new BufferedImage(bigWidth, bigHeight, BufferedImage.TYPE_4BYTE_ABGR)
        return diffImg

    }

    public static void cutModuleImageFromPage(BufferedImage complete, String path, Navigator currentModule){

        BufferedImage eleScreenshot = complete.getSubimage(currentModule.getX(), currentModule.getY(), currentModule.getWidth(), currentModule.getHeight())
        File saveFile= new File(path)
        File directory = new File(saveFile.getParentFile().getAbsolutePath())
        directory.mkdirs()
        ImageIO.write(eleScreenshot, "png", saveFile)

    }

    public static void generateDiffImage(BufferedImage img, String diffName) {
        int w = img.getWidth(null)
        int h = img.getHeight(null)
        final int[] p1 = img.getRGB(0, 0, w, h, null, 0, w)
        final BufferedImage out = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)
        out.setRGB(0, 0, w, h, p1, 0, w)
        File tmp = new File(diffName)
        File directory = new File(tmp.getParentFile().getAbsolutePath())
        directory.mkdirs()
        ImageIO.write(out, "png", tmp)
    }

    public static def pngImageToByte(String imagePath) {
        BufferedImage originalImage = ImageIO.read(new File(imagePath))
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ImageIO.write(originalImage, "png", baos)
        baos.flush()
        byte[] imageInByte = baos.toByteArray()
        baos.close()
        imageInByte
    }

    public static void clearAll(){
        lastBaselineImage = ''
        lastActualImage = ''
        lastDiffImage = ''
        lastDiffPercentage = 0.0
    }
}
