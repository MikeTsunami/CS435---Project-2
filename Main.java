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
        return graph;
    }
    public static Graph<Integer> createLinkedList(int n) {
        Graph<Integer> graph = createRandomUnweightedGraphIter(n);
        for (int i = 0; i < n - 1; i++)
            graph.addUndirectedEdge((Graph<Integer>.Node<Integer>) graph.getAllNodes().toArray()[i], (Graph<Integer>.Node<Integer>) graph.getAllNodes().toArray()[i+1]);
        return graph;
    }
    public ArrayList<Graph<Integer>.Node<Integer>> BFTIterLinkedList(final Graph graph) {
        return (new GraphSearch(graph)).BFTIter(graph);
    }
}
