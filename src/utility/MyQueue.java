package utility;

import java.util.NoSuchElementException;

public class MyQueue<E> {

        private Node<E> first;
        private Node<E> last;
        private int     size;

        public MyQueue(){
            first = null;
            last = null;
            size = 0;
        }

        public boolean add(E item){
            int oldSize = size;
            addAfter(item);
            size++;
            return oldSize == (size+ 1);
        }

        public void addAfter(E item){
            Node<E> newNode = new Node<E>(item);
            Node<E> oldLast = last;
            last = newNode;       //Add to back

            if(isEmpty()){
                first = newNode;
            }else{
                oldLast.next = newNode;
            }
        }

        /**********************************************
         * return true, if the queue is empty,
         * @return boolean value.
         *********************************************/
        public boolean isEmpty(){

            return first == null;
        }

        public E peak(){
            if(isEmpty()){
                throw new NoSuchElementException("Queue is Empty");
            }
            return first.data;
        }
/*
        public static void rearrange(Node<Integer> list){
            Node<Integer> newList = new Node<Integer>();

            int size = .size();
        }
*/
        public E remove(){
            if(isEmpty()){
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
        public int size(){

            return size;
        }

        /**************************************
         * displays the contents of the queue.
         * @return queue
         *************************************/

        public String toString(){
            if (isEmpty()){
                return "[]";
            }else{
                StringBuilder result = new StringBuilder("[" + first.data);
                for (Node<E> node = first. next; node != null; node = node.next){
                    result.append(", ").append(node.data);
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

