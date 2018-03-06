import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> root;
    private int size;

    public int size() {
        return size;
    }

    public boolean contains(T key) {
        return find(root, key) != null;
    }

    /**
     * Add a node to the BST. Internally calls insert to recursively find the new node's place
     */
    public boolean add(T key) {
        if (find(root, key) != null) return false;
        root = insert(root, key);
        size++;
        return true;
    }

    public void addAll(T[] keys) {
        for (T k : keys)
            add(k);
    }

    public List<T> inOrderTraversal() {
        // Worst Case Runtime: O(N) -> going through each element once
        List<T> inOrder = new LinkedList<>();
        TreeNode<T> curr = findMin(root);
        if (curr == null) {
            return inOrder;
        }

        while (findSuccessor(curr) != null) {
            inOrder.add(curr.key);
            curr = findSuccessor(curr);
        }
        inOrder.add(curr.key);
        return inOrder;
    }

    /**
     * Deletes a node from the BST using the following logic:
     * 1. If the node has a left child, replace it with its predecessor
     * 2. Else if it has a right child, replace it with its successor
     * 3. If it has no children, simply its parent's pointer to it
     */
    public boolean delete(T key) {
        TreeNode<T> toDelete = find(root, key);
        if (toDelete == null) {
            System.out.println("Key does not exist");
            return false;
        }
        TreeNode<T> deleted = delete(toDelete);
        if (toDelete == root) {
            root = deleted;
        }
        size--;
        return true;
    }

    private TreeNode<T> delete(TreeNode<T> n) {
        // Recursive base case
        if (n == null) return null;

        TreeNode<T> replacement;

        if (n.isLeaf()) {
            // Case 1: no children
            replacement = null;
        }
        else if (n.hasRightChild() != n.hasLeftChild()) {
            // Case 2: one child
            replacement = (n.hasRightChild()) ? n.rightChild : n.leftChild; // replacement is the non-null child
        }

        else {
            // Case 3: two children
            replacement = findPredecessor(n);
            delete(replacement); //replaces the replacement value
            replacement.moveChildrenFrom(n); //moves children from deleted value to its replacement
        }

        // Put the replacement in its correct place, and set the parent.
        n.replaceWith(replacement);
        return replacement;
    }

    public T findPredecessor(T key) {
        TreeNode<T> n = find(root, key);
        if (n != null) {
            TreeNode<T> predecessor = findPredecessor(n);
            if (predecessor != null)
                return predecessor.key;
        }
        return null;
    }

    public T findSuccessor(T key) {
        TreeNode<T> n = find(root, key);
        if (n != null) {
            TreeNode<T> successor = findSuccessor(n);
            if (successor != null)
                return successor.key;
        }
        return null;
    }

    // Worst Case Runtime: 0(N) for descending sorted BST
    private TreeNode<T> findPredecessor(TreeNode<T> n) {
        if (n.hasLeftChild()) {
            //finds the largest value below n
            return findMax(n.leftChild);
        }
        // includes the case if n is a rightChild that returns the parent
        else {
            TreeNode<T> temp = n;
            while(temp.isLeftChild()){
                // moves up the tree until it finds when the number is a right child (aka greater than the parent)
                temp = temp.parent;
            }
            if (temp.isRightChild()) {
                //finds n's smaller parent
                return temp.parent;
            }
        }
        // if nothing else works
        return null;
    }

    // Worst Case Runtime: 0(N) for ascending sorted BST
    private TreeNode<T> findSuccessor(TreeNode<T> n) {
        if (n.hasRightChild()) {
            //finds the smallest value above n
            return findMin(n.rightChild);
        }

        // includes the case if n is a leftChild that returns the parent
        else {
            TreeNode<T> temp = n;
            while(temp.isRightChild()){
                // moves up the tree until it finds when the number is a left child (aka less than the parent)
                temp = temp.parent;
            }
            if (temp.isLeftChild()) {
                //finds n's greater parent
                return temp.parent;
            }
        }
        // if nothing else works
        return null;
    }

    private TreeNode<T> findMin(TreeNode<T> n){
        // finds minimum of the values below n
        if (n == null) {
            return null;
        }
        if (!n.hasLeftChild()) {
            return n;
        }
        return findMin(n.leftChild);
    }

    private TreeNode<T> findMax(TreeNode<T> n){
        // finds maximum of the values below n
        if (!n.hasRightChild()) {
            return n;
        }
        return findMax(n.rightChild);
    }

    /**
     * Returns a node with the given key in the BST, or null if it doesn't exist.
     */
    private TreeNode<T> find(TreeNode<T> currentNode, T key) {
        if (currentNode == null)
            return null;
        int cmp = key.compareTo(currentNode.key);
        if (cmp < 0)
            return find(currentNode.leftChild, key);
        else if (cmp > 0)
            return find(currentNode.rightChild, key);
        return currentNode;
    }

    /**
     * Recursively insert a new node into the BST
     */
    private TreeNode<T> insert(TreeNode<T> node, T key) {
        if (node == null) return new TreeNode<>(key);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.leftChild = insert(node.leftChild, key);
            node.leftChild.parent = node;
        } else {
            node.rightChild = insert(node.rightChild, key);
            node.rightChild.parent = node;
        }
        return node;
    }
}
