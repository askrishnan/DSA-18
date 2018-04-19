import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problems {

    public static int leastSum(int[] A) {
<<<<<<< HEAD
        // runtime O(NlogN)
        AVLTree<Integer> avl = new AVLTree<>();
        TreeNode<Integer> min;
        String num1 = "";
        String num2 = "";

        for (int as : A) {
            avl.addDup(as);
        }
        int size = avl.size-1;
        while (size >= 0) {
            min = avl.findMin(avl.root); //O(logN)
            avl.root = avl.deleteMin(avl.root); //O(logN)
            if (size%2 == 0) {
                num1 = num1 + min.key;
            }
            else {
                num2 = num2 + min.key;
            }
            size--;
        }

        int intNum1, intNum2;
        intNum1 = integerToString(num1);
        intNum2 = integerToString(num2);

        return intNum1 + intNum2;
    }

    static private int integerToString(String num){
        int intNum;
        if (num.equals("")) {
            intNum = 0;
        }
        else {
            intNum = Integer.parseInt(num);
        }
        return intNum;
    }
=======
        int[] bins = new int[10];
        int first = 0, second = 0;

        for (int i = 0; i < A.length; i++) {
            bins[A[i]]++;
        }

        boolean a = true;

        for (int i = 0; i < bins.length; i++ ) {
            if (bins[i] > 0) {
                while (bins[i] > 0) {
                    if (a) {
                        first = first * 10 + i;
                    } else {
                        second = second * 10 + i;
                    }
                    a = !(a);
                    bins[i]--;
                }
            }
        }
        return first + second; }
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
}
