package bitManipulationCC;

public class Basics {
    public static void main(String[] args) {
        System.out.println(5 & 6); // 4
        System.out.println(5 | 6); // 7
        System.out.println(~5); // -6
        System.out.println(~0); // -1
        System.out.println(~2); // -3
        System.out.println(5 << 2); // 20 One left shift means multiplying the nb with 2 once.
        System.out.println(6 >> 1); // 3
    }
}
