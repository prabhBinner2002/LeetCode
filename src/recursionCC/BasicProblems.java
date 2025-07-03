package recursionCC;

public class BasicProblems {
    public static void printNDec(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        printNDec(n - 1);
    }

    public static void printNInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printNInc(n - 1);
        System.out.print(n + " ");
    }

    public static int printFact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * printFact(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(printFact(3));
    }
}
