package edu.uoc.mecm.eda.pac1.exercise2;

import java.util.NoSuchElementException;

/**
 * Class that implements a Text Editor Buffer
 *
 * @author Carles Pairot Gavaldà
 */
public class TextEditorBuffer<Item> {

    /**
     * Defines a Node with its context and a pointer to the next Node
     */
    private class Node {
        Item item;
        Node next;
    }

    private int sizeLeft;
    private int sizeRight;
    private Node firstLeftStack;
    private Node firstRightStack;

    /**
     * Initialize the text editor buffer
     */
    public TextEditorBuffer() {
    }

    /**
     * Insert an item onto the text editor buffer
     * @param item Item to be inserted
     */
    public void insert (Item item) {
    }

    /**
     * Private method to insert on right stack
     * @param item Item to insert
     */
    private void insertOnRightStack (Item item) {
    }

    /**
     * Gets the item at the cursor
     * @return the item located at the cursor
     */
    public Item get() throws NoSuchElementException {
        return null;
    }

    /**
     * Deletes the item at the cursor
     * @return the deleted item
     */
    public Item delete() throws NoSuchElementException {
        return null;
    }

    /**
     * Move the cursor k positions to the left
     * @param k positions to move the cursor to the left
     */
    public void left (int k) {
    }

    /**
     * Move the cursor k positions to the right
     * @param k positions to move the cursor to the right
     */
    public void right (int k) {
    }

    /**
     * Text editor buffer size
     * @return text editor buffer size
     */
    public int size() {
        return -1;
    }

    /**
     * Returns a string representation of this object
     * @return String representation of this object
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Left Stack: ");
        for (Node current = firstLeftStack; current != null; current = current.next) {
            stringBuilder.append (current.item).append (" ");
        }

        stringBuilder.append("\nRight Stack: ");
        for (Node current = firstRightStack; current != null; current = current.next) {
            stringBuilder.append (current.item).append (" ");
        }

        return stringBuilder.toString();
    }
}
