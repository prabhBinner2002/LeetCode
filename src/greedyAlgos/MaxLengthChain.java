package greedyAlgos;

import java.util.*;

public class MaxLengthChain {
    public static void main(String[] args) {
        int[][] pairs = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}};

        // Sorting
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        // Picked First Pair
        int chainLength = 1;
        int lastSelectedPairEnd = pairs[0][1]; // Chain End, Last Selected Pair End

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastSelectedPairEnd) {
                chainLength++;
                lastSelectedPairEnd = pairs[i][1];
            }
        }

        System.out.println("Max Chain Length: " + chainLength);
    }
}
