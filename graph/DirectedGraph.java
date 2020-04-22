package graph;

import java.util.*;
/**
 * Write a description of class DirectedGraph here.
 *
 * @author Michael K. Tshimanga
 * @version 4.20.2020
 */
public class DirectedGraph<E> extends Relation<E>
{
    public void addDirectedEdge(final Node<E> first, final Node<E> second) {
        if (matrix[Arrays.asList(vertices).indexOf(second)][Arrays.asList(vertices).indexOf(first)] == 0)
            matrix[Arrays.asList(vertices).indexOf(first)][Arrays.asList(vertices).indexOf(second)] = 1;
    }
    
    public void removeDirectedEdge(final Node<E> first, final Node<E> second) {
        matrix[Arrays.asList(vertices).indexOf(first)][Arrays.asList(vertices).indexOf(second)] = 0;
    }
}
