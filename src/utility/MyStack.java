package utility;

import java.util.NoSuchElementException;

public class MyStack<E> {
    private Node<E> first;   //Top of the stack
    private Node<E> last;    // bottom of the stack
    private int     size;

    public MyStack(){
        first = null;
        last = null;
        size = 0;
    }


    public E peak(){
        if(isEmpty()){
            throw new NoSuchElementException("Stack is Empty");
        }
        return first.data;
    }

    public E pop(){
        if(isEmpty()){
            throw new NoSuchElementException("Stack is Empty");
        }
        E lastItem = first.data;
        first = first.next;
        size--;
        return lastItem;
    }


    public E push(E item){
        Node<E> newNode = new Node(first,item);
        first = newNode;
        if(isEmpty()){
            last = newNode;
        }
        size++;
        return first.data;

    }


    /**********************************************
     * return true, if the stack is empty,
     * @return boolean value.
     *********************************************/
    public boolean isEmpty(){

        return first == null;
    }

    /*********************************************
     * returns the number of elements in the stack.
     * @return size of stack.
     *********************************************/
    public int size(){

        return size;
    }

    /**************************************
     * displays the contents of the stack.
     * @return stack
     *************************************/

    public String toString(){
        if (isEmpty()){
            return "[]";
        }else{
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

    private static class Node<E>{
        Node<E> next;
        E       data;

        public Node(E data){
            this(null, data);
        }

        public Node(Node<E> next, E data){
            this.next = next;
            this.data = data;
        }
    }

}
