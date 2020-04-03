import java.util.*;
import java.lang.reflect.*;
/**
 * Class that represents a set of vertices that are connected to each other via undirected edges
 *
 * @author Michael K. Tshimanga
 * @version 3.30.2020
 */
public class Graph<E>
{
    /**
     * Class that represents a vertex
     * @author Michael K. Tshimanga
     */
    class Node<T> {
        /** Value of the given vertex */
        final T value;
        
        /**
         * Public constructor
         * @param value the value to give to the vertex
         */
        public Node(T value) {
            this.value = value;
        }
        
        /**
         * Method to see if two Node objects are equal
         * @param other the object to compare to
         * @return true if both objects are equal to each other else false
         */
        public boolean equals(Object other) {
            return value.equals(((Node<T>) other).value);
        }
    }
    private Object[] vertices;
    private int matrix[][];
    
    /**
     * Public constructor
     * @param vertices any amount of vertices you want to initially add to the graph
     */
    public Graph(Object... vertices) {
        boolean count = true;
        for (int i = 0; i < vertices.length; i++)
            if (count(vertices, (Node<E>) vertices[i]) > 1) {
                count = false;
                break;
            }
        if (count) {
            this.vertices = vertices;
            matrix = new int[this.vertices.length][this.vertices.length];
            for (int row = 0; row < matrix.length; row++)
                for (int col = 0; col < matrix[row].length; col++)
                    matrix[row][col] = 0;
        }
    }
    private int count(Object[] arr, Node<E> nodeVal) {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            if (((Node<E>) arr[i]).equals(nodeVal))
                count++;
        return count;
    }
    
    /**
     * Method to add a new vertex to the graph
     * @param nodeVal the new vertex to add
     */
    public void addNode(final Node<E> nodeVal) {
        if (vertices.length == 0) {
            vertices = new Object[1];
            vertices[0] = nodeVal;
            matrix = new int[vertices.length][vertices.length];
            for (int row = 0; row < matrix.length; row++)
                for (int col = 0; col < matrix[row].length; col++)
                    matrix[row][col] = 0;
        } else if (count(vertices, nodeVal) == 0) {
            Object[] temp = new Object[vertices.length+1];
            for (int i = 0; i < vertices.length; i++)
                temp[i] = vertices[i];
            temp[vertices.length] = nodeVal;
            vertices = temp;
            int tempMatrix[][] = new int[matrix.length+1][matrix.length+1];
            for (int row = 0; row < matrix.length; row++)
                for (int col = 0; col < matrix[row].length; col++)
                    tempMatrix[row][col] = matrix[row][col];
            for (int col = 0; col < tempMatrix[matrix.length].length; col++)
                tempMatrix[matrix.length][col] = 0;
            for (int row = 0; row < tempMatrix.length; row++)
                tempMatrix[row][tempMatrix[row].length-1] = 0;
            matrix = tempMatrix;
        }
    }
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
    /**
     * Mehod that returns a HashSet containing all the vertices
     * @return the HashSet containing all the vertices
     */
    public HashSet<Object> getAllNodes() {
        return new LinkedHashSet<>(Arrays.asList(vertices));
    }
    public int[][] getMatrix() {
        int matrix[][] = new int[this.matrix.length][this.matrix.length];
        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[row].length; col++)
                matrix[row][col] = this.matrix[row][col];
        return matrix;
    }
}
