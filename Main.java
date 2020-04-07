import java.util.*;
/**
 * @author Michael K. Tshimanga
 * @version 3.30.2020
 */
public class Main
{
    public static Graph<Integer> createRandomUnweightedGraphIter(int n) {
        Graph<Integer> graph = new Graph<>();
        for (int i = 0; i < n; i++)
            graph.addNode((new Graph<Integer>()).new Node<>((new Random()).nextInt(n)+1));
        while (graph.getAllNodes().size() < n)
            graph.addNode((new Graph<Integer>()).new Node<>((new Random()).nextInt(n)+1));
        for (Object vertex : graph.getAllNodes().toArray())
            graph.addUndirectedEdge((Graph<Integer>.Node<Integer>) vertex, (Graph<Integer>.Node<Integer>) graph.getAllNodes().toArray()[(new Random()).nextInt(graph.getAllNodes().size())]);
        return graph;
    }
    public static Graph<Integer> createLinkedList(int n) {
        Graph<Integer> graph = createRandomUnweightedGraphIter(n);
        for (int i = 0; i < n - 1; i++)
            graph.addUndirectedEdge((Graph<Integer>.Node<Integer>) graph.getAllNodes().toArray()[i], (Graph<Integer>.Node<Integer>) graph.getAllNodes().toArray()[i+1]);
        return graph;
    }
    public static ArrayList<Graph<Integer>.Node<Integer>> BFTIterLinkedList(final Graph graph) {
        return (new GraphSearch(graph)).BFTIter(graph);
    }
    
    public static DirectedGraph<Integer> createRandomDAGIter(final int n) {
        DirectedGraph<Integer> graph = new DirectedGraph<>();
        for (int i = 0; i < n; i++)
            graph.addNode((new Graph<Integer>()).new Node<>((new Random()).nextInt(n)+1));
        while (graph.getAllNodes().size() < n)
            graph.addNode((new Graph<Integer>()).new Node<>((new Random()).nextInt(n)+1));
        for (Object vertex : graph.getAllNodes().toArray()) {
            Graph<Integer>.Node<Integer> second = (Graph<Integer>.Node<Integer>) graph.getAllNodes().toArray()[(new Random()).nextInt(graph.getAllNodes().size())];
            if (graph.getMatrix()[Arrays.asList(graph.getAllNodes().toArray()).indexOf(second)][Arrays.asList(graph.getAllNodes().toArray()).indexOf((Graph<Integer>.Node<Integer>) vertex)] == 0)
                graph.addDirectedEdge((Graph<Integer>.Node<Integer>) vertex, (Graph<Integer>.Node<Integer>) graph.getAllNodes().toArray()[(new Random()).nextInt(graph.getAllNodes().size())]);
        }
        return graph;
    }
}
