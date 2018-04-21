import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

// Runtime: O(V*(logV + (E/V)logV))


public class MCCR {
    public static int MCCR(EdgeWeightedGraph G) {
        IndexPQ pq = new IndexPQ(G.numberOfV());
        Iterator<Integer> v = G.vertices.iterator();
        int[] distTo = new int[G.numberOfV()];
        boolean[] visited = new boolean[G.numberOfV()];
        int total = 0;

        // fills pq
        for (Iterator<Integer> it = v; it.hasNext(); ) {
            int i = it.next();
            pq.insert(i, Integer.MAX_VALUE);
        }

        while (!pq.isEmpty()) {
            int u = pq.delMin();
            visited[u] = true;
            for (Edge e : G.edges(u)) {
                int other = e.other(u); //finds other vertex on edge
                if (distTo[other] == 0) {
                    distTo[other] = Integer.MAX_VALUE;
                }
                if (e.weight() <  distTo[other] && !visited[other]) {
                    distTo[other] = e.weight(); //adds/changes weight in distance to
                    pq.decreaseKey(other, e.weight());
                }
            }
        }

        for (int edge : distTo) {
            if (edge != Integer.MAX_VALUE)
            {
                total += edge;
            }
        }
        return total;
    }
}



