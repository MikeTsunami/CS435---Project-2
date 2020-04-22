package graph;
import java.util.*;
import java.lang.reflect.*;
/**
 * Write a description of class Relation here.
 *
 * @author Michael K. Tshimanga
 * @version 4.20.2020
 */
public class Relation<E>
{
    HashSet<Node<E>> vertices;
    int matrix[][];
    
    /**
     * Public constructor
     */
    public Relation() {
        vertices = new LinkedHashSet<>();
        matrix = new int[0][0];
    }
    
    /**
     * Method to add a new vertex to the graph
     * @param nodeVal the new vertex to add
     */
    public void addNode(final String nodeVal) {
        try {
            vertices.add(new Node<>(parseObject(nodeVal, getType())));
        } catch (ReflectiveOperationException ex) {
        }
        addToMatrix();
    }
    @SuppressWarnings("unchecked")
    private Class<E> getType() {
        Class<?> clazz = this.getClass();
        Type type = clazz.getGenericSuperclass();
        while (!(type instanceof ParameterizedType) && clazz != Relation.class) {
             clazz = clazz.getSuperclass();
             type = clazz.getGenericSuperclass();
        }
        ParameterizedType param = (ParameterizedType) type;
        Type first = param.getActualTypeArguments()[0];
        return (Class<E>) first;
    }
    private E parseObject(String s, Class<E> clazz) throws ReflectiveOperationException {
        return clazz.getConstructor(new Class[] {String.class}).newInstance(s);
    }
    private void addToMatrix() {
        int temp[][] = new int[matrix.length+1][matrix.length+1];
        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[row].length; col++)
                temp[row][col] = matrix[row][col];
        for (int col = 0; col < temp[matrix.length].length; col++)
            temp[matrix.length][col] = 0;
        for (int row = 0; row < temp.length; row++)
            temp[row][temp[row].length-1] = 0;
        matrix = temp;
    }
    
    /**
     * Mehod that returns a HashSet containing all the vertices
     * @return the HashSet containing all the vertices
     */
    public final HashSet<Node<E>> getAllNodes() {
        return vertices;
    }
    public final int[][] getMatrix() {
        return matrix;
    }
}
