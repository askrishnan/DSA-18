import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        BinarySearchTree<Integer> solution = new BinarySearchTree<>();
        Collections.sort(values);
        minimalHeightRec(solution, values, 0, values.size() - 1);
        return solution;
    }

    public static void minimalHeightRec(BinarySearchTree<Integer> solution, List<Integer> values, int first, int last) {

        if (first > last) { return; }
        if (first == last) {
            solution.add(values.get(first));
            return; }
        // Literally just do binary search, but like with a tree.
        int midpoint = (first + last)/2;
        solution.add(values.get(midpoint));
        minimalHeightRec(solution, values, first, midpoint);
        minimalHeightRec(solution, values, midpoint + 1, last);
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        // TODO
        return false;
    }
}
