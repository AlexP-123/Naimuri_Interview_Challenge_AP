import java.util.*;

class Solver {
    public static void main(String[] args) {
        Dictionary d = new Dictionary(2, "abc");
        SortedSet<String> attempt = d.getValidWords("c");

        System.out.println(attempt.size());
        for (String t : attempt) {
            System.out.println(t);
        }
    }
}
