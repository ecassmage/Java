import java.io.File;
import java.util.Scanner;

public class DijkstraSP {
    private double[] distTo;
    private Edge[] edgeTo;
    private Heap2540_SP pq;

    // Find the shortest paths in G emanating from node s.
    public DijkstraSP(Graph G, int s) {
        distTo = new double[G.V];
        //record the distances from source s to all other nodes
        edgeTo = new Edge[G.V]; // the best edge to the node
        for (int v = 0; v < G.V; v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        // relax vertices in order of distance from s
        pq = new Heap2540_SP();
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.removeMin();
            for (Edge e : G.edgesOf[v])
                relax(e);
        }
    }

    // relax edge e and update pq if changed
    private void relax(Edge e) {
        int v = e.from(), w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            pq.put(w, distTo[w]);
        }
    }

    public static void main(String[] args) throws Exception{
        Graph G = new Graph(new Scanner(new File("graph1000.txt")));
        int s = 0;
        long startTime = System.currentTimeMillis();
        DijkstraSP sp = new DijkstraSP(G, s);
        System.out.println(System.currentTimeMillis()-startTime);
        for (int t = 0;  (sp.distTo.length < 25 ? sp.distTo.length: 25) > t; t++) { // print the first a few shortest paths
            if (sp.distTo[t] < Double.POSITIVE_INFINITY) {
                System.out.printf("%d => %d (%.2f)  ", s, t, sp.distTo[t]);
                String path = t + "";
                for (Edge e = sp.edgeTo[t]; e != null; e =sp. edgeTo[e.from()]) {
                    path = e.from() + "->(" + e.weight() + ")->" + path;
                }
                System.out.println(path);
            } else
                System.out.printf("no path");
        }
    }
}