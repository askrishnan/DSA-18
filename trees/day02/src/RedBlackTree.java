import java.util.NoSuchElementException;


public class RedBlackTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private boolean isRed(TreeNode x) {
        return x != null && x.color == RED;
    }

    private boolean isBlack(TreeNode x) {
        return x != null && x.color == BLACK;
    }

    // ====================================
    //            Insertion Code
    // ====================================


    public boolean add(T key) {
        super.add(key);
        root.color = BLACK;
        return true;
    }


    // make a left-leaning link lean to the right
    TreeNode<T> rotateRight(TreeNode<T> h) {
<<<<<<< HEAD
        TreeNode<T> n = h.leftChild;
        TreeNode<T> x = n.rightChild;
        boolean c = h.color;
        n.rightChild = h;
        h.leftChild = x;
        h.color = n.color;
        n.color = c;
        return n;
=======
        TreeNode<T> i =  h.leftChild;
        h.leftChild = i.rightChild;
        i.rightChild = h;
        i.color = i.rightChild.color;
        i.rightChild.color = RED;
        return i;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    // make a right-leaning link lean to the left
    TreeNode<T> rotateLeft(TreeNode<T> h) {
<<<<<<< HEAD
        TreeNode<T> n = h.rightChild;
        TreeNode<T> x = n.leftChild;
        boolean c = h.color;
        n.leftChild = h;
        h.rightChild = x;
        h.color = n.color;
        n.color = c;
        return n;
=======
        TreeNode<T> i =  h.rightChild;
        h.rightChild = i.leftChild;
        i.leftChild = h;
        i.color = i.leftChild.color;
        i.leftChild.color = RED;
        return i;


>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    // flip the colors of a TreeNode and its two children
    TreeNode<T> flipColors(TreeNode<T> h) {
<<<<<<< HEAD
            h.color = !h.color;
            h.rightChild.color = !h.rightChild.color;
            h.leftChild.color = !h.leftChild.color;
=======
        // TODO

        h.color = !(h.color);
        h.leftChild.color = !(h.leftChild.color);
        h.rightChild.color = !(h.rightChild.color);
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        return h;
    }


    /**
     * fix three cases:
     *   1. h.right is red
     *   2. h.left is red, and h.left.left is red
     *   2. h.left and h.right are red
     * return balanced node
     */
    private TreeNode<T> balance(TreeNode<T> h) {
<<<<<<< HEAD
        if (isRed(h.rightChild)) {
            h = rotateLeft(h);
=======

        if (isRed(h.rightChild)) {
            h  = rotateLeft(h);
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        }
        if (isRed(h.leftChild) && isRed(h.leftChild.leftChild)) {
            h = rotateRight(h);
        }
        if (isRed(h.leftChild) && isRed(h.rightChild)) {
            h = flipColors(h);
        }
        return h;


    }


    /**
     * Recursively insert a new node into the BST
     * Runtime: O(logn)
     */
    @Override
    TreeNode<T> insert(TreeNode<T> h, T key) {
        h = super.insert(h, key);
<<<<<<< HEAD
        h = balance(h);
=======
        if (h != null) {
            h = balance(h);
        }
        // TODO: use balance to correct for the three rotation cases
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        return h;
    }


    // ====================================
    //            Deletion Code
    // ====================================


    /**
     * Removes the specified key from the tree
     * (if the key is in this tree).
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean delete(T key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return false;

        // if both children of root are black, set root to red
        if (!isRed(root.leftChild) && !isRed(root.rightChild))
            root.color = RED;

        root = delete(root, key);
        size--;
        if (!isEmpty()) root.color = BLACK;
        return true;
    }


    // the smallest key in subtree rooted at x; null if no such key
    private TreeNode<T> min(TreeNode<T> x) {
        if (x.leftChild == null) return x;
        else return min(x.leftChild);
    }

    // delete the key-value pair with the minimum key rooted at h
    TreeNode<T> deleteMin(TreeNode<T> h) {
        // OPTIONAL TODO: write this function and use it in delete(h, key)
        return h;
    }
    // delete the key-value pair with the given key rooted at h
    TreeNode<T> delete(TreeNode<T> h, T key) {
        // OPTIONAL TODO
        return h;
    }

    // ====================================
    //          LLRB Verification
    // ====================================


    // TODO: understand how the following functions can be used to verify a valid LLRB

    public boolean is23() {
        return is23(root);
    }

    // return true if this LLRB is a valid 2-3 tree
    private boolean is23(TreeNode<T> n) {
        if (n == null) return true;
        if (isRed(n.rightChild)) return false;
        if (isRed(n.leftChild) && isRed(n.leftChild.leftChild)) return false;
        return is23(n.rightChild) && is23(n.leftChild);
    }

    public boolean isBalanced() {
        return isBalanced(root) != -1;
    }

    // return -1 if the tree is not balanced. Otherwise, return the black-height of the tree
    private int isBalanced(TreeNode<T> n) {
        if (n == null) return 0;
        int lBalanced = isBalanced(n.leftChild);
        int rBalanced = isBalanced(n.rightChild);
        if (lBalanced == -1 || rBalanced == -1) return -1;
        if (isBlack(n.leftChild)) lBalanced++;
        if (isBlack(n.rightChild)) rBalanced++;
        if (lBalanced != rBalanced) return -1;
        return lBalanced;
    }

}