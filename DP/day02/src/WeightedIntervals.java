public class WeightedIntervals{

    public static int BU(int[] start, int[] end, int[] value){
        // TODO
        //Step 1
        int[] DP = new int[start.length+1]; // +1 is to include the base case
        //Step 2
        DP[start.length] = 0;
        //Step 3
        for (int i = start.length-1; i >= 0; i--) {
            //Step 4
            int k = i + 1;
            while (k < start.length && start[k] < end[i]) k++;
            int answer = Math.max(value[i] + DP[k], DP[i+1]);
        }
        DP[i+1]
        return 0;
    }


    public static int TD(int[] start, int[] end, int[] value) {
        //Step 1
        int[] DP = new int[start.length+1]; // +1 is to include the base case
        //Step 2
        DP[start.length] = 0;
        return 0;
    }

    //Step 3
    private static int recurse(int i, int[] start, int[] end, int[] value, int[] DP) {
        // Step 4
        if (DP[i] != -1) {
            return DP[i];
        }
        int k = i + 1;
        while (k < start.length && start[k] < end[i]) k++;
        int answer = Math.max(recurse(k,start, end, value,DP) + value[i], recurse(i+1, start, end, value, DP));
        DP[i] = answer;
        return DP[i];
        }
}
