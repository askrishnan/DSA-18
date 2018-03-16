package divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

public class RadioTowers {
    public static class Tower {
        public double x;
        public double y;

        public Tower(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static double getDist(Tower t1, Tower t2) {
        double xDiff = t1.x - t2.x;
        double yDiff = t1.y - t2.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    private static boolean isWithin(Tower t1, Tower t2, int dist) {
        return getDist(t1, t2) <= dist;
    }

    // Strip contains a list of Towers sorted by x-coordinate, whose y-coordinates all fall in a 2-mile strip
    // Return true if no two towers are within 1 mile
    public static boolean checkStrip(List<Tower> strip) {
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < Math.min(strip.size(), i + 8); j++) {
                if (isWithin(strip.get(i), strip.get(j), 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Return true if no two towers are within distance 1 of each other
    public static boolean validTowers(List<Tower> Lx, List<Tower> Ly) {
        assert Lx.size() == Ly.size();
        // Base cases : If you cut down so low that there are less than two towers remaining or the two left
        // are far enough apart, you should be all set.
        if (Lx.size() < 2) {
            return true;
        }
        if (Lx.size() == 2) {
            return !(isWithin(Lx.get(0), Lx.get(1), 1));
        }
        // Make a bunch of lists. This is divide I guess
        List<Tower> x_low = new ArrayList<>();
        List<Tower> x_high = new ArrayList<>();
        List<Tower> y_low = new ArrayList<>();
        List<Tower> y_high = new ArrayList<>();
        double y_midpoint = Ly.get(Ly.size()/2).y;
        List<Tower> section = new ArrayList<>();

        for (Tower tower : Lx) {
            if (tower.y <= y_midpoint) {
                x_low.add(tower);
            } else {
                x_high.add(tower);
            }
        }
        for (Tower tower : Ly) {
            if (tower.y <= y_midpoint) {
                y_low.add(tower);
            } else {
                y_high.add(tower);
            }
        }
        // Conquer/Merge solutions, but like all at once
        if (!validTowers(x_low, y_low)) {
            return false;
        }

        if (!validTowers(x_high, y_high)) {
            return false;
        }

        for (Tower tower : Lx) {
            if (tower.y >= y_midpoint - 1 && tower.y <= y_midpoint + 1) {
                section.add(tower); } }
        return checkStrip(section);
        }

}
