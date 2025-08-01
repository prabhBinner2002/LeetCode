package hashing;

import java.util.*;

public class InterationHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("UK", 100);
        map.put("Canada", 100);
        map.put("US", 110);
        map.put("Mexico", 120);
        map.put("India", 130);
        map.put("Scotland", 110);

        // Iterate
        Set<String> keys = map.keySet();
        System.out.println(keys); // [Canada, UK, Mexico, Scotland, US, India] -> No order

        for (String key : keys) {
            System.out.println(key + " : " + map.get(key));
        }

        System.out.println(".".repeat(20));

        // EntrySet()
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
