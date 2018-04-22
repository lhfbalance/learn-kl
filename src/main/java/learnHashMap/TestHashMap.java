package learnHashMap;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("xiao", "da");


        System.out.println(map.get("xiao"));
    }

}
