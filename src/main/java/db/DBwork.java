package db;

import db.DbConnection;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Assert;

import java.sql.SQLException;

public class DBwork {
    @Step
    @Description
    public static void assertTrue(boolean condition) {
        Assert.assertTrue(condition);
    }

    @Step
    public static void AddToDB(String table, String columns, String values) throws SQLException, ClassNotFoundException {
        DbConnection.executeUpdate("Insert into " + table + "(" + columns + ") values (" + values + ");");

    }
}
