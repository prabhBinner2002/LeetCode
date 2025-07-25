package greedyAlgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionUnSorted {
    public static void main(String[] args) {
        int[] start = {0,1,3,5,5,8};
        int[] end = {6,2,4,7,9,9};

        // Sorting
        int activites[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activites[i][0] = i;
            activites[i][1] = start[i];
            activites[i][2] = end[i];
        }

        // Lambda function
        Arrays.sort(activites, Comparator.comparingDouble(o -> o[2]));

        // End time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st Activity
        maxAct = 1;
        ans.add(activites[0][0]);
        int lastEnd = activites[0][2];

        for (int i = 1; i < end.length; i++) {
            if (activites[i][1] >= lastEnd) {
                // activity select
                maxAct++;
                ans.add(activites[i][0]);
                lastEnd = activites[i][2];
            }
        }

        System.out.println("Max Activities: " + maxAct);
        System.out.println(ans);
    }
}
