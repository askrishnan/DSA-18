import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.sqrt;

public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
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
    }
}

