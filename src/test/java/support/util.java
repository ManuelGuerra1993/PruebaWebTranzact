package support;

import definitions.hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class util extends hooks {

    public static WebDriverWait wait;

    public util() {
        wait = new WebDriverWait(driver,30);
    }

    public static void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)");
    }
}
