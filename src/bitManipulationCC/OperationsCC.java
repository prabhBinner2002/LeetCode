package bitManipulationCC;

import java.sql.SQLOutput;

public class OperationsCC {
    public static void getIthBit(int n,int i) {
        int bitMask = (1 << i);
        int result = (n & bitMask) == 0 ? 0 : 1;
        System.out.println(result);
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
//        if (newBit == 0) {
//            return clearIthBit(n, i);
//        } else {
//            return setIthBit(n, i);
//        }

        n = clearIthBit(n , i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    public static int clearLastIBits(int n, int i) {
        int bitMask = (~0 << i);
        return n & bitMask;
    }

    public static int clearRangeOfBits(int n, int i, int j) {
        int part1 = -1 << (j + 1);
//        int part2 = ~(-1 << i);
        int part2 = (1 << i) - 1;
        int bitMask = part1 | part2;

        return n & bitMask;
    }

    public static void main(String[] args) {
        System.out.println(clearRangeOfBits(31, 1, 3));
    }
}
