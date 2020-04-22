import graph.*;
import java.util.*;
/**
 * @author Michael K. Tshimanga
 * @version 4.20.2020
 */
public class Main
{
    public static Graph<Integer> createRandomUnweightedGraphIter(int n) {
        Graph<Integer> graph = new Graph<>();
        for (int i = 0; i < n; i++)
            graph.addNode("" + ((new Random()).nextInt(n)+1));
        while (graph.getAllNodes().size() < n)
            graph.addNode("" + ((new Random()).nextInt(n)+1));
        for (Node<Integer> vertex : graph.getAllNodes())
            graph.addUndirectedEdge(vertex, (Node<Integer>) graph.getAllNodes().toArray()[(new Random()).nextInt(graph.getAllNodes().size())]);
        return graph;
    }
    public static Graph<Integer> createLinkedList(int n) {
        Graph<Integer> graph = createRandomUnweightedGraphIter(n);
        for (int i = 0; i < n - 1; i++)
            graph.addUndirectedEdge((Node<Integer>) graph.getAllNodes().toArray()[i], (Node<Integer>) graph.getAllNodes().toArray()[i+1]);
        return graph;
    }
    public static ArrayList<Node<Integer>> BFTRecLinkedList(final Graph graph) {
        return GraphSearch.BFTRec(graph);
    }
    public static ArrayList<Node<Integer>> BFTIterLinkedList(final Graph graph) {
        return GraphSearch.BFTIter(graph);
    }
    
    public static DirectedGraph<Integer> createRandomDAGIter(final int n) {
        DirectedGraph<Integer> graph = new DirectedGraph<>();
        for (int i = 0; i < n; i++)
            graph.addNode("" + ((new Random()).nextInt(n)+1));
        while (graph.getAllNodes().size() < n)
            graph.addNode("" + ((new Random()).nextInt(n)+1));
        for (Node<Integer> vertex : graph.getAllNodes())
            graph.addDirectedEdge(vertex, (Node<Integer>) graph.getAllNodes().toArray()[(new Random()).nextInt(graph.getAllNodes().size())]);
        return graph;
    }
    
    public static WeightedGraph<Integer> createRandomCompleteWeightedGraph(final int n) {
        WeightedGraph<Integer> graph = new WeightedGraph<>();
        for (int i = 0; i < n; i++)
            graph.addNode("" + ((new Random()).nextInt(n)+1));
        while (graph.getAllNodes().size() < n)
            graph.addNode("" + ((new Random()).nextInt(n)+1));
        for (int row = 0; row < graph.getMatrix().length; row++)
            for (int col = 0; col < graph.getMatrix()[row].length; col++)
                if (row != col)
                    graph.addWeightedEdge((Node<Integer>) graph.getAllNodes().toArray()[row], (Node<Integer>) graph.getAllNodes().toArray()[col], (new Random()).nextInt(n) + 1);
        return graph;
    }
    public static WeightedGraph<Integer> createLinkedList(final int n) {
        WeightedGraph<Integer> graph = createRandomCompleteWeightedGraph(n);
        for (int i = 0; i < n - 1; i++)
            graph.addWeightedEdge((Node<Integer>) graph.getAllNodes().toArray()[i], (Node<Integer>) graph.getAllNodes().toArray()[i+1], (new Random()).nextInt(n) + 1);
        return graph;
    }
    
    public static HashMap<Node, Integer> dijkstras(final Node start) {
        return null;
    }
}
