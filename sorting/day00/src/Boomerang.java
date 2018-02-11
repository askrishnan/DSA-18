import java.util.HashMap;

public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
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
    }
}

