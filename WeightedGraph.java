package graph;

import java.util.*;
/**
 * Write a description of class WeightedGraph here.
 *
 * @author Michael K. Tshimanga
 * @version 4.20.2020
 */
public class WeightedGraph<E> extends Relation<E>
{
    public void addWeightedEdge(final Node<E> first, final Node<E> second, final int edgeWeight) {
        if (matrix[Arrays.asList(vertices).indexOf(second)][Arrays.asList(vertices).indexOf(first)] == 0)
            matrix[Arrays.asList(vertices).indexOf(first)][Arrays.asList(vertices).indexOf(second)] = edgeWeight;
    }
    
    public void removeDirectedEdge(final Node<E> first, final Node<E> second) {
        matrix[Arrays.asList(vertices).indexOf(first)][Arrays.asList(vertices).indexOf(second)] = 0;
    }
}
