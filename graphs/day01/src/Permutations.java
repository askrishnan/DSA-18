import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
// Time : O(n!)
// Space : O(n)
public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> perms = new LinkedList<>();
        LinkedList<Integer> current = new LinkedList<>();
        Set<Integer> unused = new HashSet<>(A);
        backtrack(current, unused, perms);
        return perms;
    }
}
