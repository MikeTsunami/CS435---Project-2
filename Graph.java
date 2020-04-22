package graph;

import java.util.*;
/**
 * Class that represents a set of vertices that are connected to each other via undirected edges
 *
 * @author Michael K. Tshimanga
 * @version 4.20.2020
 */
public class Graph<E> extends Relation<E>
{
    /**
     * Method to connect two vertices via an undirected edge
     * @param first the first vertex to connect
     * @param second the second vertex to connect
     */
    public void addUndirectedEdge(final Node<E> first, final Node<E> second) {
        matrix[Arrays.asList(vertices).indexOf(first)][Arrays.asList(vertices).indexOf(second)] = matrix[Arrays.asList(vertices).indexOf(second)][Arrays.asList(vertices).indexOf(first)] = 1;
    }
    
    /**
     * Method to disconnect two vertices
     * @param first the first vertex to disconnect
     * @param second the second vertex to disconnect
     */
    public void removeUndirectedEdge(final Node<E> first, final Node<E> second) {
        matrix[Arrays.asList(vertices).indexOf(first)][Arrays.asList(vertices).indexOf(second)] = matrix[Arrays.asList(vertices).indexOf(second)][Arrays.asList(vertices).indexOf(first)] = 0;
    }
}
