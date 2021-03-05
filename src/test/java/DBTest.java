import db.DbConnection;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import java.io.IOException;
import java.sql.SQLException;

import db.DBwork;

public class DBTest {
    String url;

    //@Test
    @Step
    @Description(value = "MyTest")
    public static void DBtest() throws SQLException, ClassNotFoundException, IOException {


        //String xml = Utils.readFromFile("C:\\Users\\Vovan\\IdeaProjects\\TestFramework\\src\\test\\resources\\test.xml")
        //        .replaceAll("NEED_REPLACE_TO_UIID", UUID.randomUUID().toString());


        Integer firstList = Integer.parseInt(DbConnection.executeQuery("SELECT count(*) FROM clients").get(0).get("count").toString());

        DBwork.AddToDB("Clients","UserId, Salary, Company", "3,'3','L'");

        Integer secondList = Integer.parseInt(DbConnection.executeQuery("SELECT count(*) FROM clients").get(0).get("count").toString());
        //
        DBwork.assertTrue(firstList+1 == secondList);
    }
}
