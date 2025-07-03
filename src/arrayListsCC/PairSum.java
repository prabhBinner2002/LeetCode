package arrayListsCC;

import java.util.ArrayList;

public class PairSum {
    public static boolean pairSum1_BruteForce(ArrayList<Integer> list, int target) {
        boolean isPresent = false;
        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++)
                if (list.get(i) + list.get(j) == target) return true;

        return isPresent;
    }

    public static boolean pairSum1_OptimizedApproach(ArrayList<Integer> list, int target) {
        boolean isPresent = false;
        int lp = 0, rp = list.size() - 1;

        while (lp < rp) {
            if (list.get(lp) + list.get(rp) == target)
                return true;
            else if (list.get(lp) + list.get(rp) < target)
                lp++;
            else
                rp--;
        }

        return isPresent;
    }

    public static boolean pairSum2_2PointerApproach(ArrayList<Integer> list, int target) {
        boolean isPresent = false;
        int lp = 0, rp = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                rp = i;
                lp = i + 1;
                break;
            }
        }

        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) return true;
            else if (list.get(lp) + list.get(rp) < target) {
                if (lp + 1 == list.size() - 1) lp = 0;
                else lp++;
            } else {
                if (rp - 1 == 0) rp = list.size() - 1;
                else rp--;
            }
        }

        while (lp != rp) {
            while (lp != rp) {
                if (list.get(lp) + list.get(rp) == target) return true;
                else if (list.get(lp) + list.get(rp) < target) {
                    lp = (lp + 1) % list.size();
                } else {
                    rp = (list.size() + rp - 1) % list.size();
                }
            }
        }

        return isPresent;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 5;

        System.out.println(pairSum1_BruteForce(list, target));
        System.out.println(pairSum1_OptimizedApproach(list, target));

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(11);
        list2.add(15);
        list2.add(6);
        list2.add(8);
        list2.add(9);
        list2.add(10);

        System.out.println(pairSum2_2PointerApproach(list2, 16));
    }
}
