package app.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyun
 * @description
 * @date 2020/2/2 3:55 PM
 */
public class BasePage {
    public static AndroidDriver driver;

    public static WebElement findElement(By by){
        // todo: 递归更好，这里暂时只能处理一次异常
        try {
            return driver.findElement(by);
        }catch (Exception e){
            handleAlert();

            return driver.findElement(by);
        }
    }

    public static void findElementAndClick(By by){
        // todo: 递归更好，这里暂时只能处理一次异常
        try {
            driver.findElement(by).click();
        }catch (Exception e){
            handleAlert();

            driver.findElement(by).click();
        }
    }

    private static void handleAlert() {
        List<By> alertBoxs = new ArrayList<>();
        alertBoxs.add(By.id("com.xueqiu.android:id/tv_agree"));
        // alertBoxs.add(By.xpath("bbb"));

        alertBoxs.forEach(alert -> {
            By adsLocator = alert;
            List<WebElement> ads = driver.findElements(adsLocator);
            if (ads.size() >= 1) {
                ads.get(0).click();
            }
        });
    }
}
