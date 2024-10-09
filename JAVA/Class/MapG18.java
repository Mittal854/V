
import java.util.*;

public class MapG18 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("ram", 1);
        map.put("rama", 3);
        map.put("raman", 2);
        map.put("ravan", 4);
        map.put("ramanan", 5);
        map.put("ramak", 6);
        System.out.println(map);
        map.put("ramana", 1);
        System.out.println(map);
        if (!map.containsKey("ram")) {
            map.put("ram", 9);
        }
        System.out.println(map);
        if (!map.containsValue(4)) {
            map.put("ram", 9);
        }
        System.out.println(map);
        map.putIfAbsent("ramaha", 10);
        System.out.println(map);
        map.remove("ramaha");
        System.out.println(map);
        map.remove("ram", 1);
        System.out.println(map);
        for (Map.Entry vari : map.entrySet()) {
            System.out.println(vari.getKey() + " " + vari.getValue());
        }
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        for (Integer val : map.values()) {
            System.out.println(val);
        }
    }
}
