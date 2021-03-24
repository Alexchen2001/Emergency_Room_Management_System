package utility;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>{

    private Node<E> first;
    private Node<E> last;
    private int     size;

    /******************************
     * creates linked list object
     ******************************/
    public LinkedList(){
        first = null;
        last = null;
        size = 0;
    }

    /****************************************************************
     * inserts the item specified at the given index in the list.
     * @param item of item in listl
     * @return boolean value if successful.
     ****************************************************************/
    public boolean add(E item){
        int oldSize = size;
        append(item);
        size++;
        return size == (oldSize + 1);
    }

    /****************************************************************
     * inserts the item specified at the given index in the list.
     * @param index of item in listl
     * @param item in list
     ****************************************************************/
    public void add(int index, E item){
        String message = "index: " + index + ", size: " + size;
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException(message);
        }
       if(index == size){
           append(item);
       }else{
           insertBefore(index, item);
       }
       size++;
    }

    private void append( E item){
        Node<E> oldLast = last;
        Node<E> newNode = new Node<E>(oldLast, item);
        last = newNode;
        if (oldLast == null){
            first = newNode;   //Empty
        }else{
            oldLast.next = newNode;   //Not empty
        }
    }

    private void checkIndex(int index){
        String message = " index: " + index + ", size: " + size;
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException(message);
        }
    }

    /*******************************************************
     * clears list of all elements, return size back to zero.
     *******************************************************/
    public void clear(){
        first = null;
        last = null;
        size = 0;
    }

    /***********************************************************************
     * searching for an item and returns true in the array,
     * @param item to search fro in list.
     * @return boolean value
     ********************************************************************/
    public boolean contains(E item){

        return indexOf(item) != -1;
    }

    private E detach(int index){
        Node<E> current = node(index);
        Node<E> prev = current.prev;
        Node<E> next = current.next;
        E data = current.data;

        //detach from left side
        if(prev == null){
            first = next;
        }else{
            prev.next = next;
            current.prev= null;
        }

        //detach from right side
        if(next == null){
            last = prev;
        }else{
            next.prev = prev;
            current.next = null;
        }

        // garbage collection
        current.data = null;

        return data;
    }

    /******************************************
     * return the item on the specified position in the list
     * @param index of item in list.
     * @return item at index.
     *********************************************/
    public E get(int index) {
        checkIndex(index);
        Node<E> current = node(index);
        return current.data;
    }

    /***********************************************************************
     * searching for an item and returns the first occurrence in the array,
     * otherwise returns -2, if not found
     * @param item to search for in list.
     * @return location of item, if found
     ********************************************************************/
    //Problemo
    public int indexOf(E item) {
        int index = 0;
        if (!isEmpty()) {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.data.equals(item)){
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    private void insertBefore(int index, E item){
        Node<E> current = node(index);
        Node<E> prev = current.prev;
        Node<E> newNode = new Node<E>(prev, current, item);
        current.prev = newNode;

        if(prev == null){
            first = newNode;

        }else {
            prev.next = newNode;
        }
    }

    /**********************************************
     * return true, if the list is empty,
     * @return boolean value.
     *********************************************/
    public boolean isEmpty(){

        return first == null;
    }

    /**************************************************************
     * returns an object used to traverse the elements in the list.
     * @return iterator for list
     **************************************************************/
    public Iterator<E> iterator(){
        return new LinkedIterator();
    }

    public Node<E> node(int index){
        Node<E> current;
        if (index < size / 2){
            current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }else {
            current = last;
            for (int i = size -1; i > index ; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    /*****************************************************
     * removes the item at the given index in the list.
     * @param index of item in list.
     * @return old value in list.
     ***************************************************/
    public E remove(int index){
        checkIndex(index);
        E oldItem = detach(index);
        size--;
        return oldItem;
    }

    /*****************************************************
     * removes the first occurrence of the specified item
     * from the list, if present.
     * @param item to remove from list.
     * @return boolean value
     ***************************************************/
    //need to do
    public boolean remove( E item) {

        return contains(item) && item.equals(remove(indexOf(item)));
    }


    /********************************************************************
     * replaces the item at the specified position with the one passed.
     * @param index to replace list item.
     * @param item that replaces on in list.
     * @return old item in list.
     *******************************************************************/
    public E set(int index, E item){
        checkIndex(index);
        Node<E> current= node(index);
        E oldItem  =  current.data;
        current.data = item;
        return oldItem;
    }

    /*********************************************
     * returns the number of elements in the list.
     * @return size of list.
     *********************************************/
    public int size(){

        return size;
    }

    /**************************************
     * displays the contents of the list.
     * @return string representation of list
     *************************************/
    public String toString(){
        if (isEmpty()){
            return "[]";
        }else{
            StringBuilder result = new StringBuilder("[" + first.data);
            for (Node<E> node = first. next; node != null; node = node. next){
                result.append(", ").append(node.data);
            }
            return result.append("]").toString();
        }
    }

    private class LinkedIterator implements Iterator<E>{
        Node<E> current;
        int position;
        boolean isRemovable;

        public LinkedIterator(){
            current = first;
            position = 0;
            isRemovable = false;
        }

        public boolean hasNext() {
            return position < size;
        }

        public E next() {
            String message = "No such element left";
            if(!hasNext()){
                throw new NoSuchElementException(message);
            }
            E currentItem = current.data;
            current = current.next;
            position++;
            isRemovable = true;
            return currentItem;
        }

        public void remove() {
            String message = "Unable to remove";
            if(!isRemovable){
                throw new IllegalStateException(message);
            }
            LinkedList.this.remove(--position);
            isRemovable = false;

        }
    }

    // Static Inner Class: Decoupled from Outer Class (Linked List)
    private static class Node<E>{
        Node<E> prev;
        Node<E> next;
        E       data;

        public Node( Node<E> prev, E data){
            this(prev, null, data);
        }

        public Node(Node<E> prev, Node<E> next, E data){
            this.prev = prev;
            this.next = next;
            this.data = data;
        }

    }

}
