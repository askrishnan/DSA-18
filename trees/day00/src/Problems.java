import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
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
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        // TODO
        return false;
    }
}
