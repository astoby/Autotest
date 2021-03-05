package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.Selenium;
import ustils.Props;


import java.util.concurrent.TimeUnit;

public class VK_Page {

    private WebDriver driver;

    @FindBy(id = "index_email")
    private WebElement userName;
    @FindBy(id = "index_pass")
    private WebElement password;
    @FindBy(className = "index_login_button")
    private WebElement loginButton;

    @FindBy(id = "top_profile_link")
    private WebElement top_profile_link;
    @FindBy(id = "top_logout_link")
    private WebElement top_logout_link;


    @FindBy(xpath = "//*[@id='im_dialogs']/li[@data-list-id='91948442']")
    private WebElement message;




    public VK_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void Login_to_system() {
        userName.sendKeys(Props.getTestProperty("login"));
        password.sendKeys(Props.getTestProperty("password"));
        loginButton.click();
    }


    public void Logout() {
        top_profile_link.click();
        Selenium.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        top_logout_link.click();
    }

}
