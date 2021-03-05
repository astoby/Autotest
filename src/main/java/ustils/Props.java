package ustils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {
    protected static FileInputStream fileInputStream;

    public static Properties getPROPERTIES() {
        return PROPERTIES;
    }

    protected static Properties PROPERTIES;

    static {
        try {
            fileInputStream = new FileInputStream("src/main/resources/config/Login_Password.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getTestProperty(String key) {
        return PROPERTIES.getProperty(key);
    }
}
