import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstTest {

//    @Test
    public static void test() throws SQLException, ClassNotFoundException {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map1 = new HashMap<String, String>();
        Map<String, String> map2 = new HashMap<String, String>();

        map1.put("userid", "1");
        map1.put("salary", "1000");
        map1.put("company", "1");

        map2.put("userid", "2");
        map2.put("salary", "2000");
        map2.put("company", "2");

        list.add(map1);
        list.add(map2);

        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = list.get(i);

            System.out.println("salary:" + map.get("salary"));
//            for (Map.Entry<String, String> entry : map.entrySet()) {
//                System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
//            }
        }
    }
}
