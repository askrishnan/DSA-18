package divide_and_conquer;

/**
 * 1) Base Case: when the values surrounding the point are all lower
 * 2) Divide: Split the array in half; Use only the half where values are leading to the peak
 * 3) Conquer: Find the maximum values in the middle column and check the values surrounding them to make sure they are smaller
 * 4) Combine:
 */

public class PeakFinding {

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakOneD(int i, int[] nums) {
        if (i > 0 && nums[i] < nums[i - 1])
            return -1; //definitely not a peak, less than prev value
        if (i < nums.length - 1 && nums[i] < nums[i + 1])
            return 1; //building up to a peak
        return 0; // if nums[i] >= nums[i+1]  or nums[i] >= nums[i-1]
    }

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakX(int x, int y, int[][] nums) {
        if (x > 0 && nums[y][x] < nums[y][x - 1])
            return -1; //definitely not a x peak, less than prev value
        if (x < nums[0].length - 1 && nums[y][x] < nums[y][x + 1])
            return 1; //building up to x peak
        return 0; // values surrounding nums[y][x] are both lower, x peak
    }

    // Return -1 if up is higher, 1 if down is higher, 0 if peak
    private static int peakY(int x, int y, int[][] nums) {
        if (y > 0 && nums[y][x] < nums[y - 1][x])
            return -1; //definitely not a y peak, less than prev value
        if (y < nums.length - 1 && nums[y][x] < nums[y + 1][x])
            return 1; //building up to y peak
        return 0; // values surrounding nums[y][x] are both lower, y peak
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
                maxIndex = y; // finding the index value for the maximum value of y
        }
        return maxIndex;
    }


    public static int findOneDPeak(int[] nums) {
        // O(logN)
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) { // recurses while the lo value is below the hi value
            int mid = (hi + lo)/2;
            int peakHalf = peakOneD(mid, nums);
            if (peakHalf == -1) {
                hi = mid; // if the middle is less than the previous value, the peak is in the first half
            }
            else if (peakHalf == 1) {
                lo = mid + 1; // if the middle is greater than the previous value, the peak is in the second half
            }
            else if (peakHalf == 0) {
                return mid; // the peak, breaks recursion
            }
        }
        return -1;
    }

    public static int[] findTwoDPeak(int[][] nums) {
        // setting lo and hi values for x and y
        int xLo = 0;
        int xHi = nums.length;
        int yLo = 0;
        int yHi = nums.length;
        int[] finPeak;
        boolean middleX = true; // checks from middle of x values
        while (xLo < xHi && yLo < yHi) {
            if (middleX) {
                int midX = (xHi + xLo) / 2; // finds middle column
                int yMax = maxYIndex(midX, yLo, yHi, nums);
                int peakCheck = peakX(midX, yMax, nums);
                if (peakCheck == -1) {
                    xHi = midX; // x value before nums[yMax][midX] is bigger, so peak is in first half of x
                }
                else if (peakCheck == 1) {
                    xLo = midX + 1; // x value after nums[yMax][midX] is bigger, so peak is in second half of x
                }
                else if (peakCheck == 0) {
                    finPeak = new int[]{yMax, midX}; // values surrounding nums[yMax][midX] are all lower, peak
                    return finPeak;
                }
            }
            else {
                int midY = (yHi + yLo) / 2; // finds middle column
                int xMax = maxXIndex(midY, xLo, xHi, nums); // finding max x value in selected half of nums
                int peakCheck = peakY(xMax, midY, nums); // checking y values around x max
                if (peakCheck == -1) {
                    yHi = midY; // y value before nums[midY][xMax] is bigger, so peak is in first half of y
                }
                else if (peakCheck == 1) {
                    yLo = midY + 1; // y value after nums[midY][xMax] is bigger, so peak is in second half of y
                }
                else if (peakCheck == 0) {
                    finPeak = new int[]{midY, xMax};  // values surrounding nums[midY][xMax] are all lower, peak
                    return finPeak;
                }
            }
            middleX = !middleX; // switches between checking from the center of x and y
        }
        finPeak = new int[]{nums.length/2, nums.length/2};
        return finPeak;
    }

}
