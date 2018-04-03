import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Space: O(N*N!)
 * Time: O(N!)
 */

public class Permutations {

    private static void backtrack(LinkedList<Integer> curr, Set<Integer> unused, List<List<Integer>> subsets) {
        if (unused.isEmpty())
            subsets.add(new LinkedList<>(curr));
        for (int u : new LinkedList<>(unused)) {
            curr.addLast(u);
            unused.remove(u);
            backtrack(curr, unused, subsets);
            unused.add(u);
            curr.removeLast();
        }
    }

    public static List<List<Integer>> permutations(List<Integer> A) {
        // TODO
        List<List<Integer>> permutations = new LinkedList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        Set<Integer> unused = new HashSet<>(A);
        unused.addAll(A); //sets don't store duplicates
        backtrack(curr, unused, permutations);
        return permutations;
    }

}
