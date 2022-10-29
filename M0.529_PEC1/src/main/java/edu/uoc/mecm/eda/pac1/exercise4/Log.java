package edu.uoc.mecm.eda.pac1.exercise4;

/**
 * This class implements the Log entity
 *
 * @author Carles Pairot Gavaldà
 */
public class Log<E> {

    /**
     * Private class which stores a node of the data structure
     */
    private class Node {
        // Data Stored in each Node of the Linked List
        E data;
        // Pointer to the next node in the Linked List
        Node next;

        // Node class constructor used to initializes
        // the data in each Node
        Node (E data) {
            this.data = data;
        }
    }


    /**
     * Head node
     */
    private Node head;

    /**
     * Tail node
     */
    private Node tail;

    /**
     * Log's current size
     */
    private int size = 0;

    /**
     * Log maximum capacity
     */
    private int capacity = 0;

    /**
     * Log constructor
     * @param capacity Log's maximum capacity
     */
    public Log (int capacity) {
    }

    /**
     * Add an element to the log
     * @param element Element to add
     * @throws CapacityException If capacity exceeded
     */
    public void add (E element) throws CapacityException {
    }

    /**
     * Getting the head element
     * @return The head element
     * @throws CapacityException If log is empty
     */
    public E get() throws CapacityException {
        return null;
    }

    /**
     * Retrieving the head element without deleting
     * @return The head element
     * @throws CapacityException If log is empty
     */
    public E peek() throws CapacityException {
        return null;
    }

    /**
     * Check whether the log is empty
     * @return True if empty
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Return the log's size
     * @return Log size
     */
    public int size() {
        return -1;
    }

    /**
     * Clear the log
     */
    public void clear() {
    }
}
