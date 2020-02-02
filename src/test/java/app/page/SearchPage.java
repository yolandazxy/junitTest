package app.page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaoyun
 * @description
 * @date 2020/2/1 8:30 PM
 */
public class SearchPage extends BasePage{
    private By inputBox = By.id("com.xueqiu.android:id/search_input_text");

    public SearchPage search(String keyWord){
        //输入搜索内容
        findElement(inputBox).sendKeys(keyWord);
        //选中搜索下拉框，跳转搜索结果页面
        //findElementAndClick(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"));
        //el7.click();
        return this;
    }

    public Float getCurrentPrice() {
        MobileElement el8 = (MobileElement) findElement(By.id("com.xueqiu.android:id/current_price"));
        return Float.valueOf(el8.getText());
    }

    public App cancel(){
        findElementAndClick(By.id("com.xueqiu.android:id/action_close"));
        return new App();
    }
}
