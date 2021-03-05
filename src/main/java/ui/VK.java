package ui;

import Pages.VK_Logout;
import Pages.VK_Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VK {

    public static String login;
    public static String password;

    @Step
    public static void Login(String url) {
        Selenium.driver.get(url);

        VK_Page loginPage = new VK_Page(Selenium.driver);
        loginPage.Login_to_system();

        Selenium.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Step
    public static void Logout() {
        VK_Page logoutPage = new VK_Page(Selenium.driver);
        logoutPage.Logout();
    }

    @Step
    public static void SendSelfMessage() {
        WebElement messages = Selenium.driver.findElement(By.id("l_msg"));
        messages.click();

        Selenium.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement message = Selenium.driver.findElement(By.xpath("//*[@id='im_dialogs']/li[@data-list-id='91948442']"));
        message.click();

        WebElement messageField = Selenium.driver.findElement(By.xpath("//*[@id='im_editable0']"));
        messageField.sendKeys("Сообщение моё");

        WebElement sendButton = Selenium.driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div[3]/div[2]/div[4]/div[2]/div[4]/div[1]/button"));
        sendButton.click();

    }

    @Step
    public static void GetFiveNews() {
        Selenium.driver.get("https://vk.com/feed");

        List<String> productName = new ArrayList<>();


        for (int i = 1; i <= 6; i++) {
            List<WebElement> allProductsName = Selenium.driver.findElements(By.xpath("//*[@id=\"feed_rows\"]/div[" + i + "]/div/div/div/div/h5/a"));
            for (WebElement w : allProductsName) {
                productName.add(w.getText());
            }
        }
    }

    @Step
    public static void Scroll() {
        Selenium.driver.get("https://vk.com/feed");

        ((JavascriptExecutor) Selenium.driver).executeScript("scrollBy(0,4000);");

    }

    @Step
    public static void Clear() {
        Selenium.driver.manage().deleteAllCookies();
        ((ChromeDriver) Selenium.driver).getSessionStorage().clear();
    }

    @Step
    public static void TwoNews() {
        Selenium.driver.get("https://vk.com/feed");

        List<String> productName = new ArrayList<>();


        ((JavascriptExecutor) Selenium.driver).executeScript("scrollBy(0,4000);");
        List<WebElement> allProductsName = null;
        for (int i = 1; i <= 2; i++) {
            try {
                allProductsName = Selenium.driver.findElements(By.xpath("//*[@id=\"feed_rows\"]/div[last()-" + i + "]/div/div/div/div/h5/a"));
            } catch (Exception e) {

            }

            for (WebElement w : allProductsName) {
                productName.add(w.getText());
            }
        }
    }

}
