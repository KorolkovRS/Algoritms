package lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(1,2);
        graph.addEdge(0,4);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(7,8);
        graph.addEdge(7,5);
        graph.addEdge(4,5);
        graph.addEdge(0,2);

        FirstPath fp  = new BreadthFirstPath(graph, 0);
        System.out.println(fp.pathTo(2));
        fp = new DepthFirstPath(graph, 0);
        System.out.println(fp.pathTo(2));
    }
}
