import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
<<<<<<< HEAD
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Collections.sort(values);
        midAdd(bst, values, 0, values.size()-1);

        return bst;
    }

    public static BinarySearchTree<Integer> midAdd(BinarySearchTree<Integer> bst, List<Integer> vals, int lo, int hi) {
        if (lo>hi) {
            return bst;
        }

        int mid = (lo+hi)/2;
        bst.add(vals.get(mid));
        midAdd(bst, vals, lo, mid-1);
        midAdd(bst, vals, mid+1, hi);

        return bst;
=======
<<<<<<< HEAD
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
=======
        // TODO
        return new BinarySearchTree<>();
>>>>>>> 1c26bfec866394d2c6a63434e361921836ce41ab
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        // TODO
        return false;
    }
}
