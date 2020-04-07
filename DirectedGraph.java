import java.util.*;
/**
 * Write a description of class DirectedGraph here.
 *
 * @author Michael K. Tshimanga
 * @version 4.6.2020
 */
public class DirectedGraph<E>
{
    private Object[] vertices;
    private int[][] matrix;
    
    /**
     * Public constructor
     * @param vertices any amount of vertices you want to initially add to the graph
     */
    public DirectedGraph(Object... vertices) {
        boolean count = true;
        for (int i = 0; i < vertices.length; i++)
            if (count(vertices, (Graph<E>.Node<E>) vertices[i]) > 1) {
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
    private int count(Object[] arr, Graph<E>.Node<E> nodeVal) {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            if (((Graph<E>.Node<E>) arr[i]).equals(nodeVal))
                count++;
        return count;
    }
    
    /**
     * Method to add a new vertex to the graph
     * @param nodeVal the new vertex to add
     */
    public void addNode(final Graph<E>.Node<E> nodeVal) {
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
    public void addDirectedEdge(final Graph<E>.Node<E> first, final Graph<E>.Node<E> second) {
        matrix[Arrays.asList(vertices).indexOf(first)][Arrays.asList(vertices).indexOf(second)] = 1;
    }
    public void removeDirectedEdge(final Graph<E>.Node<E> first, final Graph<E>.Node<E> second) {
        matrix[Arrays.asList(vertices).indexOf(first)][Arrays.asList(vertices).indexOf(second)] = 0;
    }
    public HashSet<Object> getAllNodes() {
        return new LinkedHashSet<>(Arrays.asList(vertices));
    }
    public int[][] getMatrix() {
        int[][] matrix = new int[this.matrix.length][this.matrix.length];
        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[row].length; col++)
                matrix[row][col] = this.matrix[row][col];
        return matrix;
    }
}
