package hashing;

import java.util.HashMap;

public class HashMapBB {
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> map = new HashMap<>();

        // Insert - O(1)
        map.put("UK", 100);
        map.put("Canada", 100);
        map.put("US", 110);
        System.out.println(map); // {Canada=100, UK=100, US=110} no order for insertion

        // Get - O(1)
        int population = map.get("UK");
        System.out.println(population); // 100
        System.out.println(map.get("Mexico")); // "null" as Mexico is not a key in map

        // ContainsKey - O(1)
        System.out.println(map.containsKey("Mexico")); // false
        System.out.println(map.containsKey("US")); // true

        // Remove - O(1)
        int val = map.remove("US");
        System.out.println(val); // 110
        System.out.println(map.remove("US")); // "null" as US is already removed

        // Size - O(1)
        System.out.println(map.size()); // 2

        // IsEmpty - O(1)
        System.out.println(map.isEmpty()); // false

        // Clear - O(1)
        map.clear();
        System.out.println(map.isEmpty()); // true
    }
}
