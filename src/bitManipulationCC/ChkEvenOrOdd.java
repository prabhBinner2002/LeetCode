package bitManipulationCC;

public class ChkEvenOrOdd {
    public static void isEvenOrOdd(int n) {
        int bitMask = 1;
        String result = (n & bitMask) == 1 ? "Odd" : "Even";
        System.out.println(result);
    }

    public static void main(String[] args) {
        isEvenOrOdd(3);
    }
}
