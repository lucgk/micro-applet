package com.micro.applet;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 企业微信加好友
 *
 * @author liuhui
 * @version 1.0, 2021/3/22 14:23
 */
public class addFriends {

    public static AndroidDriver initDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appPackage", "com.tencent.wework");
        desiredCapabilities.setCapability("deviceName", "127.0.0.1:62001");
//        desiredCapabilities.setCapability("platformVersion", "7");
        desiredCapabilities.setCapability("appActivity", "com.tencent.wework.launch.WwMainActivity");
        desiredCapabilities.setCapability("resetKeyboard", true);
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
// 这里Url为服务端url driver即为服务端链接的移动设备驱动者
        return  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

    }

    public static void addFriend() throws  Exception {
        AndroidDriver driver = initDriver();
        WebElement search = driver.findElementById("com.tencent.wework:id/i6n");
        search.click();
        Thread.sleep(1000);
        WebElement editText = driver.findElementById("com.tencent.wework:id/gpg");
        editText.sendKeys("18244975178");
        Thread.sleep(5000);
        WebElement info = driver.findElementById("com.tencent.wework:id/e6d");
        info.click();
        Thread.sleep(30000);
    }

    public static void main(String[] args) throws Exception {
         addFriend();
    }
}
