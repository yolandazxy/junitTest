package app.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaoyun
 * @description
 * @date 2020/2/1 7:53 PM
 */
public class App extends BasePage{

    public static void start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        //desiredCapabilities.setCapability("app", "/Users/xiaoyun/learning/com.xueqiu.android_12.3.1_246.apk");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("noReset", false);
        desiredCapabilities.setCapability("autoGrantPermissions", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//        //速度会比较慢，找所有弹窗并点击关闭
//        By adsLocator=By.id("xxx");
//        List<WebElement> ads=driver.findElements(adsLocator);
//        if(ads.size()>=1){
//            ads.get(0).click();
//        }
    }


    public static SearchPage toSearch() {
        findElementAndClick(By.id("com.xueqiu.android:id/home_search"));
        // el4.click();
        return new SearchPage();
    }
}
