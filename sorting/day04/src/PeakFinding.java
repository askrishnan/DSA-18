public class PeakFinding {

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakOneD(int i, int[] nums) {
        if (i > 0 && nums[i] < nums[i - 1])
            return -1;
        if (i < nums.length - 1 && nums[i] < nums[i + 1])
            return 1;
        return 0;
    }

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakX(int x, int y, int[][] nums) {
        if (x > 0 && nums[y][x] < nums[y][x - 1])
            return -1;
        if (x < nums[0].length - 1 && nums[y][x] < nums[y][x + 1])
            return 1;
        return 0;
    }

    // Return -1 if up is higher, 1 if down is higher, 0 if peak
    private static int peakY(int x, int y, int[][] nums) {
        if (y > 0 && nums[y][x] < nums[y - 1][x])
            return -1;
        if (y < nums.length - 1 && nums[y][x] < nums[y + 1][x])
            return 1;
        return 0;
    }

    // These two functions return the index of the highest value along the X or Y axis, with the given
    // value for the other axis. Searches between hi (exclusive) and lo (inclusive)
    private static int maxXIndex(int y, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int x = lo; x < hi; x++) {
            if (maxIndex == -1 || nums[y][x] > nums[y][maxIndex])
                maxIndex = x;
        }
        return maxIndex;
    }

    private static int maxYIndex(int x, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int y = lo; y < hi; y++) {
            if (maxIndex == -1 || nums[y][x] > nums[maxIndex][x])
                maxIndex = y;
        }
        return maxIndex;
    }


    public static int findOneDPeak(int[] nums) {
        // O(log(n))
        return findOneDPeakRecursive(nums, 0, nums.length);
    }

    public static int findOneDPeakRecursive(int [] nums, int low, int high) {
        // Check that it is in the array.
        if (high < low) {
            return -1;
        }

        int mid = (high + low)/2;
        // Conquer
        int placement = peakOneD(mid, nums);
        // Divide/Combine
        if (placement == -1) {
            return findOneDPeakRecursive(nums, low, mid);
        }
        else if (placement == 1) {
            return findOneDPeakRecursive(nums, mid + 1, high);
        }
        else {
            return mid;
        }
    }

    public static int[] findTwoDPeak(int[][] nums) {
        // O(N)
        return findTwoDPeakRecursive(nums, 0, nums[0].length, 0, nums.length, true);
    }

    public static int[] findTwoDPeakRecursive(int [][] nums, int xLow, int xHigh, int yLow, int yHigh, boolean xCol) {

        if (xLow > xHigh || yLow > yHigh) {
            return null;
        }
        if (xCol) {
            int xMid = (xLow + xHigh) / 2;
            int yMax = maxYIndex(xMid, yLow, yHigh, nums);
            // Conquer
            int xPeak = peakX(xMid, yMax, nums);
            // Divide/Combine
            if (xPeak == -1) {
                return findTwoDPeakRecursive(nums, xLow, xMid, yLow, yHigh, false);
            } else if (xPeak == 1) {
                return findTwoDPeakRecursive(nums, xMid + 1, xHigh, yLow, yHigh, false);
            } else {
                return new int[]{yMax, xMid};
            }
        } else {
            int yMid = (xLow + xHigh) / 2;
            int xMax = maxXIndex(yMid, xLow, xHigh, nums);
            int yPeak = peakY(xMax, yMid, nums);
            if (yPeak == -1) {
                return findTwoDPeakRecursive(nums, xLow, xHigh, yLow, yMid, true);
            } else if (yPeak == 1) {
                return findTwoDPeakRecursive(nums, xLow, xHigh, yMid + 1, yHigh, true);
            } else {
                return new int[]{yMid, xMax};
            }
        }
    }}