import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

    /**
     * Divide & Conquer
     * 1) Base Case: If the length of the list of buildings equals 1.
     * 2) Divide: Split into L, R
     * 3) Conquer: Sort L, R
     * 4) Combine: Merge L, R, adding only points that do not overlap
     *
     * Runtime: O(NlogN)
     *      O(log(N)) -> number of levels when splitting
     *      O(N) -> going through and comparing each element when merging the split halves
     *
     */

    static class Point {
        int x, y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Building {
        private int l, r, h;
        Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        List<Point> skyline = new ArrayList<>();

        if (B.length == 1) {
            Building building = B[0];
            Point p1 = new Point(building.l, building.h);
            Point p2 = new Point(building.r, 0);
            skyline.add(p1);
            skyline.add(p2);
            return skyline;
        }

        int mid = (B.length + 1) / 2;
        Building[] left = Arrays.copyOfRange(B, 0, mid);
        Building[] right = Arrays.copyOfRange(B, mid, B.length);
        List<Point> left_sky = skyline(left);
        List<Point> right_sky = skyline(right);

        return merge(left_sky, right_sky);
    }


    public static List<Point> merge(List<Point> left, List<Point> right) {
        List<Point> skyline = new ArrayList<>();

        // x and y values for adding points to the skyline
        int x, y;

        // markers to loop through and compare values in left and right
        int i = 0;
        int j = 0;

        // heights, for comparison
        int h1 = 0;
        int h2 = 0;

        while (i < left.size() && j < right.size()) {
            Point l = left.get(i);
            Point r = right.get(j);

            if (l.x < r.x) {
                h1 = l.y;
                x = l.x;
                y = Math.max(h1, h2); // getting rid of anything that's too low
                Point p = new Point(x, y);
                skyline = skylineCreator(skyline, p);
                i++;
            }
            else {
                h2 = r.y;
                x = r.x;
                y = Math.max(h1, h2); // getting rid of anything that's too low
                Point p = new Point(x, y);
                skyline = skylineCreator(skyline, p);
                j++;
            }
        }
        while (i < left.size()) {
            skyline.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            skyline.add(right.get(j));
            j++;
        }
        return skyline;
    }

    public static List<Point> skylineCreator(List<Point> skyline, Point p1) {
        // adds points to the skyline if they don't overlap with current x/y values

        if (skyline.isEmpty()) {
            skyline.add(p1);
            return skyline;
        }
        Point k = skyline.get(skyline.size()-1);
        if (p1.y == k.y) {
            return skyline;
        }
        else if (p1.x == k.x) {
            if (p1.y < k.y) {
                return skyline;
            }
            else {
                skyline.remove(skyline.size()-1);
                skyline.add(p1);
            }
        }
        else {
            skyline.add(p1);

        }
        return skyline;
    }
    }


