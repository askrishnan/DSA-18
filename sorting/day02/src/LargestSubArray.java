import java.util.HashMap;

public class LargestSubArray {
    static int[] largestSubarray(int[] nums) {

        int sum = 0;
        int length = nums.length;
        int[] sums = new int[length];

        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                sum -= 1;
            }
            else {
                sum += 1;
            }
            sums[i] = sum;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int finArrSize = 0;
        int endInd = 0;
        for (int i = 0; i < length; i++) {
            if (sums[i]==0) {
                finArrSize = i + 1;
                endInd = i;
            }
            else if (map.containsKey(sums[i])) {
                if (finArrSize < i - map.get(sums[i])) {
                    finArrSize = i - map.get(sums[i]);
                    endInd = i;
                }
            }
            else {
                map.put(sums[i], i);
            }
        }

        int finStart = endInd - finArrSize + 1;
        int[] finRange = {finStart, endInd};
        return finRange;
    }
}
