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
     * Log constructor. Explicit.
     *
     * @param capacity Log's maximum capacity
     */
    public Log (int capacity) {
        this.capacity = capacity;
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    /**
     * Adds an element to the log.
     *
     * @param element Element to add
     * @throws CapacityException If capacity exceeded
     */
    public void add (E element) throws CapacityException {
        if (this.capacity == this.size)
        {
            throw new CapacityException("Buffer Overflow");
        }

        if (this.size == 0)
        {
            this.head = new Node(element);
            this.head.next = null;
            this.tail = this.head;
        }
        else
        {
            this.tail.next = new Node(element);
            this.tail = this.tail.next;
        }
        this.size++;
    }

    /**
     * Getting the head element
     * @return The head element
     * @throws CapacityException If log is empty
     */
    public E get() throws CapacityException {
        if (this.size == 0)
        {
            throw new CapacityException("Empty Buffer");
        }

        E ret = this.head.data;
        this.head = this.head.next;
        this.size--;
        return ret;
    }

    /**
     * Retrieving the head element without deleting
     * @return The head element
     * @throws CapacityException If log is empty
     */
    public E peek() throws CapacityException {
        if (this.size == 0)
        {
            throw new CapacityException("Empty Buffer");
        }

        return this.head.data;
    }

    /**
     * Check whether the log is empty
     * @return True if empty
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Return the log's size
     * @return Log size
     */
    public int size() {
        return this.size;
    }

    /**
     * Clear the log
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
