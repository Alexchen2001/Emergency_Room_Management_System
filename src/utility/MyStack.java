package utility;

import java.util.NoSuchElementException;

public class MyStack<E> {
    private Node<E> first;   //Top of the stack
    private Node<E> last;    // bottom of the stack
    private int size;

    /*******************************************************
     * creates Stack object.
     * initilizes Nodes to null and  size to 0.
     *******************************************************/
    public MyStack() {
        first = null;
        last = null;
        size = 0;
    }

    /**********************************************
     * return true, if the stack is empty,
     * @return boolean value.
     *********************************************/
    public boolean isEmpty() {

        return first == null;
    }


    /*****************************************************************
     * gets the top element in the stack if the stack is not empty.
     * @return the top (first) element of the Stack
     ***************************************************************/
    public E peak() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is Empty");
        }
        return first.data;
    }

    /***************************************************************************
     * removes the top (first) element of the stack, if the stack is not empty.
     * @return the top element of the stack
     ***************************************************************************/
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is Empty");
        }
        E lastItem = first.data;
        first = first.next;
        size--;
        return lastItem;
    }

    /************************************************
     * places given element on the top of the stack.
     * @param item in stack
     * @return the top of the stack
     ********************************************8**/
    public E push(E item) {
        Node<E> newNode = new Node(first, item);
        first = newNode;
        if (isEmpty()) {
            last = newNode;
        }
        size++;
        return first.data;

    }

    /*********************************************
     * returns the number of elements in the stack.
     * @return size of stack.
     *********************************************/
    public int size() {

        return size;
    }

    /*****************************************
     * displays the contents of the stack.
     * @return String representation of stack
     *****************************************/
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            ArrayList<E> list = new ArrayList<E>(size);
            for (Node<E> node = first; node != null; node = node.next) {
                list.add(node.data);
            }
            int lastIndex = size - 1;
            StringBuilder result = new StringBuilder("[" + list.get(lastIndex));
            for (int i = lastIndex - 1; i >= 0; i--) {
                result.append(", ").append(list.get(i));
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
