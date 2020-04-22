import graph.*;
import java.util.*;
/**
 * Write a description of class TopSort here.
 *
 * @author Michael K. Tshimanga
 * @version 4.20.2020
 */
public class TopSort
{
    private static int[] visited = new int[0];
    
    public static ArrayList<Node<Integer>> Kahns(final DirectedGraph<Integer> graph) {
        Map<Integer, Integer> degree = new HashMap<>();
        ArrayList<Node<Integer>> output = new ArrayList<>();
        for (Node<Integer> node : graph.getAllNodes())
            degree.put(node.value, 0);
        for (int row = 0; row < graph.getMatrix().length; row++)
            for (int col = 0; col < graph.getMatrix()[row].length; col++)
                if (graph.getMatrix()[row][col] == 1)
                    degree.replace(((Node<Integer>) graph.getAllNodes().toArray()[col]).value, degree.get(((Node<Integer>) graph.getAllNodes().toArray()[col]).value) + 1);
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry entry : degree.entrySet())
            if (((Integer) entry.getValue()).equals(new Integer(0)))
                queue.add((Integer) entry.getKey());
        while (!queue.isEmpty()) {
            output.add(new Node<>(queue.peek()));
            for (int col = 0; col < graph.getMatrix()[Arrays.asList((Node<Integer>[]) graph.getAllNodes().toArray()).indexOf(new Node<>(queue.peek()))].length; col++)
                if (graph.getMatrix()[Arrays.asList((Node<Integer>[]) graph.getAllNodes().toArray()).indexOf(new Node<>(queue.peek()))][col] == 1)
                    if (degree.get(((Node<Integer>) graph.getAllNodes().toArray()[col]).value) > 0)
                        degree.replace(((Node<Integer>) graph.getAllNodes().toArray()[col]).value, degree.get(((Node<Integer>) graph.getAllNodes().toArray()[col]).value) - 1);
                    else
                        queue.add(((Node<Integer>) graph.getAllNodes().toArray()[col]).value);
            queue.remove();
        }
        return output;
    }
    public static ArrayList<Node<Integer>> mDFS(final DirectedGraph<Integer> graph) {
        return null;
    }
}
