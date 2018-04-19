<<<<<<< HEAD
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.sqrt;
=======
import java.util.HashMap;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144

public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
<<<<<<< HEAD
        // TODO
        int length = points.length;
        int numBoom = 0;
        int dist = 0;
        for (int j = 0; j < length; j++) {
            HashMap<Integer, Integer> map = new HashMap<>(length);
            for (int i = 0; i < length; i++) {
                if (i != j) {
                    int[] p1 = points[j];
                    int[] p2 = points[i];
                    int d1 = p1[0] - p2[0];
                    int d2 = p1[1] - p2[1];
                    dist = (d1 * d1) + (d2 * d2);

                    if (map.containsKey(dist)) {
                        int v = map.get(dist) + 1;
                        map.replace(dist, v);
                    }
                    else {
                        map.put(dist, 1);
                    }
                }
            }
            Collection<Integer> list = map.values();
            for (int val: list)
            {
                numBoom += val * (val - 1);
            }
        }
        return numBoom;
=======
        // Make a hashmap with all of the distances
        HashMap<Double, Integer> distance_map = new HashMap<Double, Integer>();
        int number_of_boomerangs = 0;

        for (int i = 0; i < points.length; i++) {
            // Clear it for each subarray
            // for each set of ponts, calculate the distances and put them in the map.
            for (int j = 0; j < points.length; j++) {
                double distance = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));

                if (distance_map.get(distance) == null) {
                    distance_map.put(distance, 1);
                }
                else {
                    Integer current = distance_map.get(distance);
                    distance_map.put(distance, current + 1 );
                }
            }
            // Count up all of the valid ones.
            for (Double distance_value : distance_map.keySet()) {
                int value = distance_map.get(distance_value);
                if (distance_value > 0.0 && value >= 2) {
                    number_of_boomerangs += value * (value -1);
                }
            }
            // Clear it at the end for the next one.
            distance_map.clear();

        }


        return number_of_boomerangs;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }
}

