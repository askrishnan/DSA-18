<<<<<<< HEAD
<<<<<<< HEAD
import java.util.HashSet;
=======
>>>>>>> fa3f8b78319c86d5c534e7e4aca1060986f5e6b1
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

<<<<<<< HEAD
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
=======
public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        // TODO
        List<List<Integer>> permutations = new LinkedList<>();
>>>>>>> fa3f8b78319c86d5c534e7e4aca1060986f5e6b1
        return permutations;
=======
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
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }
}
