package utility;

import java.util.NoSuchElementException;

public class MyQueue<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    /*******************************************************
     * creates Queue object.
     * initilizes data fields to null and 0.
     *******************************************************/
    public MyQueue() {
        first = null;
        last = null;
        size = 0;
    }

    /******************************************************
     * appends the item specified to the end of the Queue.
     * @param item in Queue.
     * @return boolean value if successful.
     *****************************************************/
    public boolean add(E item) {
        int oldSize = size;
        addAfter(item);
        size++;
        return oldSize == (size + 1);
    }

    /*****************************************************
     * appends the item specified to the end of the Queue.
     * @param item in Queue.
     ****************************************************/
    public void addAfter(E item) {
        Node<E> newNode = new Node<E>(item);
        Node<E> oldLast = last;
        last = newNode;       //Add to back

        if (isEmpty()) {
            first = newNode;
        } else {
            oldLast.next = newNode;
        }
    }

    /**********************************************
     * return true, if the queue is empty,
     * @return boolean value.
     **********************************************/
    public boolean isEmpty() {

        return first == null;
    }


    /***************************************************************
     * provides the value in front of the queue without removing it.
     * If the queue is empty, it would tell that the queue is empty.
     * @return value of the front of the Queue
     ***************************************************************/
    public E peak() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        return first.data;
    }


    /****************************************************************************
     * It removes the item in the front of the queue, if the queue is not empty
     * otherwise, if the queue is empty, it will say the queue is empty.
     * @return the item formally in the front of the queue
     ****************************************************************************/
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        E firstItem = first.data;
        first = first.next;
        size--;
        return firstItem;
    }

    /*********************************************
     * returns the number of elements in the queue.
     * @return size of queue.
     *********************************************/
    public int size() {

        return size;
    }

    /**************************************
     * displays the contents of the queue.
     * @return queue
     *************************************/
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            StringBuilder result = new StringBuilder("[" + first.data);
            for (Node<E> node = first.next; node != null; node = node.next) {
                result.append(", ").append(node.data);
            }
            return result.append("]").toString();
        }
    }

    private static class Node<E> {
        Node<E> next;
        E data;

        public Node(E data) {

            this(null, data);
        }

        public Node(Node<E> next, E data) {
            this.next = next;
            this.data = data;
        }
    }

}

