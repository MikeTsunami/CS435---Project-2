package graph;


/**
 * Class that represents a vertex
 *
 * @author Michael K. Tshimanga
 * @version 4.20.2020
 */
public class Node<E>
{
    /** Value of the given vertex */
    public final E value;
    
    /**
     * Public constructor
     * @param value the value to give to the vertex
     */
    public Node(E value) {
        this.value = value;
    }
    
    /**
     * Method to see if two Node objects are equal
     * @param other the object to compare to
     * @return true if both objects are equal to each other else false
     */
    public boolean equals(Object other) {
        return value.equals(((Node<E>) other).value);
    }
}
