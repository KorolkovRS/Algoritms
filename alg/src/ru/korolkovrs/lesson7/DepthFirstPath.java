package lesson7;

public class DepthFirstPath extends AbstractFirstPath {
    public DepthFirstPath(Graph g, int source) {
        super(g, source);
    }

    protected void fs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.getAdjList(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                fs(g, w);
            }
        }
    }
}
