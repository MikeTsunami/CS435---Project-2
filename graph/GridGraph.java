package graph;
import java.util.*;
import java.lang.reflect.*;
/**
 * Write a description of class GridGraph here.
 *
 * @author Michael K. Tshimanga
 * @version 4.20.2020
 */
public class GridGraph<E>
{
    class GridNode<T> extends Node<T> {
        final int x;
        final int y;
        
        public GridNode(T value, int x, int y) {
            super(value);
            this.x = x;
            this.y = y;
        }
        
        public boolean equals(Object other) {
            return value.equals(((GridNode<T>) other).value) && x == ((GridNode<T>) other).x && y == ((GridNode<T>) other).y;
        }
    }
    HashSet<GridNode<E>> vertices;
    int matrix[][];
    
    public GridGraph() {
        vertices = new LinkedHashSet<>();
        matrix = new int[0][0];
    }
    
    public void addGridNode(final int x, final int y, final String nodeVal) {
        try {
            vertices.add(new GridNode<>(parseObject(nodeVal, getType()), x, y));
        } catch (ReflectiveOperationException ex) {
        }
        addToMatrix();
    }
    @SuppressWarnings("unchecked")
    private Class<E> getType() {
        Class<?> clazz = this.getClass();
        Type type = clazz.getGenericSuperclass();
        while (!(type instanceof ParameterizedType) && clazz != GridGraph.class) {
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
    
    public void addUndirectedEdge(final GridNode<E> first, final GridNode<E> second) {
        matrix[Arrays.asList(vertices).indexOf(first)][Arrays.asList(vertices).indexOf(second)] = matrix[Arrays.asList(vertices).indexOf(second)][Arrays.asList(vertices).indexOf(first)] = 1;
    }
    
    public void removeUndirectedEdge(final Node<E> first, final Node<E> second) {
        matrix[Arrays.asList(vertices).indexOf(first)][Arrays.asList(vertices).indexOf(second)] = matrix[Arrays.asList(vertices).indexOf(second)][Arrays.asList(vertices).indexOf(first)] = 0;
    }
    
    public HashSet<GridNode<E>> getAllNodes() {
        return vertices;
    }
}
