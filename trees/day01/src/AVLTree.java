import static java.lang.Math.max;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    /**
     * Delete a key from the tree rooted at the given node.
     */
    @Override
    TreeNode<T> delete(TreeNode<T> n, T key) {
        n = super.delete(n, key);
        if (n != null) {
<<<<<<< HEAD
            // update the height of the tree using the height of the left and right child
            // return balance(n)
            n.height = height(n);
            return balance(n);
=======
            n.height = height(n);
            return balance(n);
        }
        else {
            return null;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        }
    }

    /**
     * Insert a key into the tree rooted at the given node.
     */
    @Override
    TreeNode<T> insert(TreeNode<T> n, T key) {
        n = super.insert(n, key);
        if (n != null) {
<<<<<<< HEAD
            // update the height of the tree using the height of the left and right child
            // return balance(n)
            n.height = height(n);
            return balance(n);
=======
            n.height = height(n);
            return balance(n);

>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        }
        return null;
    }

    /**
     * Delete the minimum descendant of the given node.
     */
    @Override
    TreeNode<T> deleteMin(TreeNode<T> n) {
        n = super.deleteMin(n);
        if (n != null) {
            n.height = 1 + max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    TreeNode<T> findMin(TreeNode<T> n) {
        TreeNode<T> minVal = super.min(n);
        return minVal;
    }

    // Return the height of the given node. Return -1 if null.
    private int height(TreeNode<T> n) {
        if (n == null) {
            return -1;
        }
<<<<<<< HEAD
        else {
            return max(height(n.leftChild), height(n.rightChild)) + 1;
        }
=======
        return (1 + Math.max(height(n.leftChild), height(n.rightChild)));

>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    public int height() {
        return max(height(root), 0);
    }

    // Restores the AVL tree property of the subtree. Return the head of the new subtree
    TreeNode<T> balance(TreeNode<T> n) {
<<<<<<< HEAD

        // Right Heavy
        if (balanceFactor(n) >= 2) {
            if (balanceFactor(n.rightChild) < 0) {
                // rightChild is left heavy (right.left)
                n.rightChild = rotateRight(n.rightChild);
            }
            n = rotateLeft(n); // w/o if statement, rightChild is not left heavy (right.right)
        }

        //Left Heavy
        if (balanceFactor(n) <= -2) {
            if (balanceFactor(n.leftChild) > 0) {
                // leftChild is right heavy (left.right)
                n.leftChild = rotateLeft(n.leftChild);
            }
            n = rotateRight(n); // w/o if statement, leftChild is not right heavy (left.left)
        }
        return n;
=======
        if (balanceFactor(n) >= 2) {
            if (balanceFactor(n.rightChild) < 0) {
                n.rightChild = rotateRight(n.rightChild);
            }
            n = rotateLeft(n);
        }
        if (balanceFactor(n) <= -2) {
            if (balanceFactor(n.leftChild) > 0) {
                n.leftChild = rotateLeft(n.leftChild);
            }
            n = rotateRight(n);
        }
        return n;

>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    /**
     * Returns the balance factor of the subtree. The balance factor is defined
     * as the difference in height of the left subtree and right subtree, in
     * this order. Therefore, a subtree with a balance factor of -1, 0 or 1 has
     * the AVL property since the heights of the two child subtrees differ by at
     * most one.
     */
    private int balanceFactor(TreeNode<T> n) {
        return height(n.rightChild) - height(n.leftChild);
    }

    /**
     * Perform a right rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateRight(TreeNode<T> n) {
<<<<<<< HEAD
        TreeNode<T> m, beta;
        m = n.leftChild;
        beta = m.rightChild;
        m.rightChild = n;
        n.leftChild = beta;

        n.height = height(n);
        m.height = height(m);
        return m;
=======
        TreeNode<T> x = n.leftChild;
        TreeNode<T> b = x.rightChild;
        x.rightChild = n;
        n.leftChild = b;

        n.height = height(n);
        x.height = height(x);
        return x;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    /**
     * Perform a left rotation on node `n`. Return the head of the rotated tree.
     */
    private TreeNode<T> rotateLeft(TreeNode<T> n) {
<<<<<<< HEAD
        TreeNode<T> m, beta;
        m = n.rightChild;
        beta = m.leftChild;
        m.leftChild = n;
        n.rightChild = beta;

        n.height = height(n);
        m.height = height(m);
        return m;
=======
        TreeNode<T> x = n.rightChild;
        TreeNode<T> b = x.leftChild;
        x.leftChild = n;
        n.rightChild = b;
        n.height = 1 + Math.max(height(n.rightChild), height(n.leftChild));
        x.height = 1 + Math.max(height(x.rightChild), height(x.leftChild));
        return x;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }
}
