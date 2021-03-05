import io.qameta.allure.Description;
import org.junit.Test;
import ui.Selenium;
import ui.VK;

import java.io.IOException;
import java.sql.SQLException;

public class SeondTest {

    @Test
    @Description
    public void test() throws SQLException, ClassNotFoundException, IOException {

        try {
            Selenium.setup();
            VK.Login("https://vk.com/");
            VK.SendSelfMessage();
            VK.TwoNews();
            VK.GetFiveNews();
            VK.Scroll();
            VK.Logout();
            VK.Clear();
        }catch (Exception e){

        }
        finally {
            Selenium.driver.close();
        }


    }


}
