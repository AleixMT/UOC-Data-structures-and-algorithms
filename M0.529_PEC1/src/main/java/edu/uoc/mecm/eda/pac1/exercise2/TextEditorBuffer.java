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
     * Initialize the text editor buffer with an empty buffer.
     */
    public TextEditorBuffer() {
        this.sizeLeft = 0;
        this.sizeRight = 0;
        this.firstRightStack = null;
        this.firstLeftStack = null;
    }

    /**
     * Insert an item onto the text editor buffer in the cursor position, which is equivalent to insert on the left
     * stack at specification level.
     *
     * @param item Item to be inserted
     */
    public void insert (Item item) {
        Node n = new Node();
        n.item = item;  // New item in the new node.
        n.next = this.firstLeftStack;  // New node points to the first node in the left stack.
        this.firstLeftStack = n;  // New node is the first node at the left of the cursor.
        this.sizeLeft++;  // One more element at the left of the cursor.
    }

    /**
     * Private method to insert on right stack.
     *
     * @param item Item to insert
     */
    private void insertOnRightStack (Item item) {
        Node n = new Node();
        n.item = item;  // New item in the new node.
        n.next = this.firstRightStack;  // New node points to the first node in the right stack.
        this.firstRightStack = n;  // New node is the first node at the right of the cursor.
        this.sizeRight++;  // One more element at the right of the cursor.
    }

    /**
     * Gets the item at the cursor. Specifically considers the element at the cursor as the first elements at the left
     * of the cursor.
     *
     * @return the item located at the left of the cursor.
     */
    public Item get() throws NoSuchElementException {
        if (this.firstLeftStack == null)
        {
            throw new NoSuchElementException("Unable to get character.");
        }
        else
        {
            return this.firstLeftStack.item;
        }
    }

    /**
     * Deletes the item at the cursor. We consider that this deletion occurs at the left of the cursor, as when the
     * backspace key is pressed.
     *
     * @return the deleted item.
     */
    private Item deleteOnLeftStack() throws NoSuchElementException {
        if (this.firstLeftStack == null)
        {
            throw new NoSuchElementException("Unable to delete character.");
        }
        else
        {
            Item ret = this.firstLeftStack.item;
            this.firstLeftStack = this.firstLeftStack.next;
            this.sizeLeft--;
            return ret;
        }
    }

    /**
     * Deletes the item at the right position of the cursor. We consider that this deletion occurs at the right of the
     * cursor, as when the 'delete' key is pressed.
     *
     * @return the deleted item.
     */
    public Item delete() throws NoSuchElementException {
        if (this.firstRightStack == null)
        {
            throw new NoSuchElementException("Unable to delete character.");
        }
        else
        {
            Item ret = this.firstRightStack.item;
            this.firstRightStack = this.firstRightStack.next;
            this.sizeRight--;
            return ret;
        }
    }

    /**
     * Move the cursor k positions to the left.
     *
     * @param k positions to move the cursor to the left.
     */
    public void left (int k) {
        for (int i = 0; i < k; i++)
        {
            if (this.firstLeftStack == null)  // We can not go further to the left, we are at the beginning.
            {
                // Our spec does not define error when moving the cursor more places than available.
                break;
            }

            Item t = this.deleteOnLeftStack();  // We take advantage of the delete method which removes on the right.
            this.insertOnRightStack(t);  // We take advantage of the insertOnRightStack method adds to the right of the
                                         // cursor.
        }
    }

    /**
     * Move the cursor k positions to the right.
     *
     * @param k positions to move the cursor to the right.
     */
    public void right (int k) {
        for (int i = 0; i < k; i++)
        {
            if (this.firstRightStack == null)  // We can not go further to the right, we are at the beginning.
            {
                // Our spec does not define error when moving the cursor more places than available.
                break;
            }

            Item t = this.delete();  // We take advantage of the deleteOnRightStack method which removes on
                                     // the left.
            this.insert(t);  // We take advantage of the insert method adds to the left of the cursor.
        }
    }

    /**
     * Text editor buffer size.
     *
     * @return text editor buffer size.
     */
    public int size() {
        return this.sizeRight + this.sizeLeft;
    }

    /**
     * Returns a string representation of the TextEditorBuffer object of this instance.
     *
     * @return String representation of this object.
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
