package recursionCC.assignmentQsCC;

public class KthGrammerSymbol {
    public static int kthGrammar(int n, int k) {
        if (k == 1) return 0;

        int parent = kthGrammar(n - 1, (k + 1)/2);

        if (parent == 0) {
            if ((k & 1) == 1) return 0;
            else return 1;
        } else {
            if ((k & 1) == 1) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(3, 3));
    }
}
