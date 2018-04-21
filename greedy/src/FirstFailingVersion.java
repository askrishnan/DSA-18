public class FirstFailingVersion {

    public static long firstBadVersion(long n, IsFailingVersion isBadVersion) {
        return recursiveBad(0, n, isBadVersion);
    }

    public static long recursiveBad (long first, long last, IsFailingVersion isBadVersion) {
        if(first+1 >= last) {
            if (isBadVersion.isFailingVersion(first)) {
                return first;
            }
            else if(isBadVersion.isFailingVersion(last)) {
                return last;
            }
            else {
                return -1;
            }
        }
        // split it and recurse!
        long mid = first + (last - first)/2;
        if (isBadVersion.isFailingVersion(mid)){
            return recursiveBad(first, mid, isBadVersion);
        }
        else {
            return recursiveBad(mid, last, isBadVersion);
        }
    }
}
