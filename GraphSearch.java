import java.util.*;
/**
 * @author Michael K. Tshimanga
 * @version 3.30.2020
 */
public class GraphSearch
{
    private final Graph<?> graph;
    private Object[] visited;
    
    public GraphSearch(Graph<?> graph) {
        this.graph = graph;
        visited = new Object[0];
    }
    
    public <E> void DFSRec(E goal) {
        visited = new Object[0];
        for (Object vertex : graph.getAllNodes().toArray())
            if (!Arrays.asList(visited).contains(vertex))
                DFSRec((Graph<E>.Node<E>) vertex, (new Graph<E>()).new Node<>(goal));
    }
    private <E> void DFSRec(final Graph<E>.Node<E> start, final Graph<E>.Node<E> end) {
        Object[] temp = new Object[visited.length+1];
        for (int i = 0; i < visited.length; i++)
            temp[i] = visited[i];
        temp[visited.length] = start;
        visited = temp;
        if (!start.equals(end))
            for (int col = 0; col < graph.getMatrix()[Arrays.asList(graph.getAllNodes().toArray()).indexOf(start)].length; col++)
                if (graph.getMatrix()[Arrays.asList(graph.getAllNodes().toArray()).indexOf(start)][col] == 1)
                    if (!Arrays.asList(visited).contains(graph.getAllNodes().toArray()[col]))
                        DFSRec((Graph<E>.Node<E>) graph.getAllNodes().toArray()[col], end);
    }
    
    public <E> ArrayList<Graph<E>.Node<E>> DFSIter(E goal) {
        ArrayList<Graph<E>.Node<E>> list = null;
        visited = new Object[0];
        for (Object vertex : graph.getAllNodes().toArray())
            if (!Arrays.asList(visited).contains(vertex))
                list = DFSIter((Graph<E>.Node<E>) vertex, (new Graph<E>()).new Node<>(goal));
        return list;
    }
    private <E> ArrayList<Graph<E>.Node<E>> DFSIter(final Graph<E>.Node<E> start, final Graph<E>.Node<E> end) {
        ArrayList<Graph<E>.Node<E>> list = new ArrayList<>();
        Stack<Graph<E>.Node<E>> S = new Stack<>();
        Object[] temp = new Object[visited.length+1];
        for (int i = 0; i < visited.length; i++)
            temp[i] = visited[i];
        temp[visited.length] = start;
        visited = temp;
        S.push(start);
        while (!S.isEmpty()) {
            Graph<E>.Node<E> curr = S.pop();
            if (!curr.equals(end)) {
                for (int col = 0; col < graph.getMatrix()[Arrays.asList(graph.getAllNodes().toArray()).indexOf(curr)].length; col++)
                    if (graph.getMatrix()[Arrays.asList(graph.getAllNodes().toArray()).indexOf(curr)][col] == 1)
                        if (!Arrays.asList(visited).contains(graph.getAllNodes().toArray()[col])) {
                            list.add(curr);
                            temp = new Object[visited.length+1];
                            for (int i = 0; i < visited.length; i++)
                                temp[i] = visited[i];
                            temp[visited.length] = graph.getAllNodes().toArray()[col];
                            visited = temp;
                            S.push((Graph<E>.Node<E>) graph.getAllNodes().toArray()[col]);
                        }
            }
        }
        return list;
    }
    
    public <E> void BFTRec(final Graph<E> graph) {
        visited = new Object[0];
        for (Object vertex : graph.getAllNodes().toArray())
            if (!Arrays.asList(visited).contains(vertex))
                BFTRec((Graph<E>.Node<E>) vertex, new LinkedList<Graph<E>.Node<E>>());
    }
    private <E> void BFTRec(final Graph<E>.Node<E> vertex, Queue<Graph<E>.Node<E>> Q) {
        Object[] temp = new Object[visited.length+1];
        for (int i = 0; i < visited.length; i++)
            temp[i] = visited[i];
        temp[visited.length] = vertex;
        visited = temp;
        Q.add(vertex);
        Graph<E>.Node<E> node = Q.remove();
        for (int col = 0; col < graph.getMatrix()[Arrays.asList(graph.getAllNodes().toArray()).indexOf(node)].length; col++)
            if (graph.getMatrix()[Arrays.asList(graph.getAllNodes().toArray()).indexOf(node)][col] == 1)
                if (!Arrays.asList(visited).contains(graph.getAllNodes().toArray()[col]))
                    BFTRec((Graph<E>.Node<E>) graph.getAllNodes().toArray()[col], Q);
    }
    public <E> ArrayList<Graph<E>.Node<E>> BFTIter(final Graph<E> graph) {
        ArrayList<Graph<E>.Node<E>> list = new ArrayList<>();
        visited = new Object[0];
        Queue<Graph<E>.Node<E>> Q = new LinkedList<>();
        for (Object vertex : graph.getAllNodes().toArray())
            if (!Arrays.asList(visited).contains(vertex)) {
                Object[] temp = new Object[visited.length+1];
                for (int i = 0; i < visited.length; i++)
                    temp[i] = visited[i];
                temp[visited.length] = vertex;
                visited = temp;
                Q.add((Graph<E>.Node<E>) vertex);
                while (!Q.isEmpty()) {
                    Graph<E>.Node<E> curr = Q.remove();
                    for (int col = 0; col < graph.getMatrix()[Arrays.asList(graph.getAllNodes().toArray()).indexOf(curr)].length; col++)
                        if (graph.getMatrix()[Arrays.asList(graph.getAllNodes().toArray()).indexOf(curr)][col] == 1)
                            if (!Arrays.asList(visited).contains(graph.getAllNodes().toArray()[col])) {
                                list.add((Graph<E>.Node<E>) graph.getAllNodes().toArray()[col]);
                                temp = new Object[visited.length+1];
                                for (int i = 0; i < visited.length; i++)
                                    temp[i] = visited[i];
                                temp[visited.length] = graph.getAllNodes().toArray()[col];
                                visited = temp;
                                Q.add((Graph<E>.Node<E>) graph.getAllNodes().toArray()[col]);
                            }
                }
            }
        return list;
    }
}
