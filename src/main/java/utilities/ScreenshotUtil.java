package utilities;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotUtil {
	static WebDriver driver;
	static ScreenshotUtil screenshot;
	
public ScreenshotUtil(WebDriver driver) {
	ScreenshotUtil.driver=driver;
	
	
}

public static String captureScreenshot(WebDriver driver, String Name) throws IOException  {
	TakesScreenshot ts = (TakesScreenshot) driver;
	
File src = ts.getScreenshotAs(OutputType.FILE);


String path = System.getProperty("user.dir") + "/screenshots/" 
              + Name + "_" + System.currentTimeMillis() + ".png";
File dest = new File(path);
FileUtils.copyFile(src, dest);
	 return path; 
}

public static String customizeScreenshot(WebDriver driver,
        WebElement element,
        String caseName) throws IOException {

    String folderPath = System.getProperty("user.dir") + "/screenshotscustomize";
    File folder = new File(folderPath);
    if (!folder.exists()) folder.mkdirs();

    // Scroll element to center
    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", element);

    try { Thread.sleep(1000); } catch (InterruptedException e) {}

    Screenshot screenshot = new AShot()
            .shootingStrategy(ShootingStrategies.viewportPasting(200))
            .coordsProvider(new WebDriverCoordsProvider())
            .takeScreenshot(driver, element);

    String path = folderPath + "/" + caseName + "_" + System.currentTimeMillis() + ".png";

    ImageIO.write(screenshot.getImage(), "png", new File(path));

    return path;
}  



public static String takeFullPageScreenshot(WebDriver driver, String testcaseName) throws IOException {

    String folderPath = System.getProperty("user.dir") + "/screenshots_full";
    File folder = new File(folderPath);
    folder.mkdirs();

    Screenshot screenshot = new AShot()
            .shootingStrategy(ShootingStrategies.viewportPasting(1000))  // scroll delay
            .takeScreenshot(driver);

    String path = folderPath + "/" + testcaseName + "_" + System.currentTimeMillis() + ".png";

    ImageIO.write(screenshot.getImage(), "PNG", new File(path));

    System.out.println("Full page screenshot saved: " + path);
	return path;
}

}
