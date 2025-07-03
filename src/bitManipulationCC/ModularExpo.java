package bitManipulationCC;

public class ModularExpo {
    public static int getModularExpo(int a, int n, int M) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = (a * ans) % M;
            }
            a = (a * a) % M;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getModularExpo(3,2,4));
    }
}
