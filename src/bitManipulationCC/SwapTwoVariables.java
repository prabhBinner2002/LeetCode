package bitManipulationCC;

public class SwapTwoVariables {
    public static void swapVariables(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + " " + b);
    }

    public static void main(String[] args) {
        swapVariables(2,3);
    }
}
