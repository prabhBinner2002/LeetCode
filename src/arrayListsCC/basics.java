package arrayListsCC;

import java.util.ArrayList;

public class basics {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); // O(1)
        list.add(2); // O(1)
//        System.out.println(list); // [1, 2]
        int ele = list.get(1);
//        System.out.println(ele);
//        list.remove(0);
        list.set(1, 10);
        System.out.println(list.contains(0)); // false
        list.add(0, 0);
        System.out.println(list);

    }
}
