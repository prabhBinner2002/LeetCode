package recursionCC;

public class PrintPower {
    public static int pow(int x, int n) {
        if (n == 0) return 1;
        return x * pow(x, n - 1);
    }

    public static int optPow(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int halfPower =  optPow(x, n/2);

        int halfPowerSq = halfPower * halfPower;

        if (n  % 2 != 0) { // n is odd
            halfPowerSq = x * halfPowerSq;
        }

        return halfPowerSq;
    }

    public static void main(String[] args) {
        System.out.println(optPow(2,10));
    }
}
