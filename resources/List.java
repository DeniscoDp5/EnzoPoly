package utils;
import java.util.Iterator;
import utils.Node;

public class List<T> implements Iterable<T>{
    Node<T> head;
    Node<T> tail;
    int size;

    public List(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public T getHead(){
        if (this.head != null){
            return this.head.getValue();
        }else{
            return null;
        }
    }
    public T getTail(){
        if (this.tail != null){
            return this.tail.getValue();
        }else{
            return null;
        }
    }
    public void add(T value){
        if(this.head == null){
            this.head = new Node<T>(value);
            this.tail = this.head;
        }else{
            this.tail.setNext(new Node<T>(value));
            this.tail = this.tail.getNext();
        }
        this.size++;
    }
    public int getSize(){
        return this.size;
    }

    /**
     * This method tells if an object is inserted in the the list
     * @param obj the object to search in the list
     * @return true if obj is in false otherwise
     */
    public boolean isIn(T obj){
        Iterator<T> it = this.iterator();

        if(it == null){
            return false;
        }
        T x = it.next();

        while(x != null && !x.equals(obj)){
            x=it.next();
        }
        if(x == null){
            return false;
        }else{
            return true;
        }
    }
    /**
     * This metod merge 2 list. the head is the head of the first list and the tail is the tail of the second
     * this.tail.next() = list2.head
     * @param list2 the list to add ad the tail of this 
     */
    public void merge(List<T> list2){
        int size2 = list2.getSize();
        this.tail.setNext(list2.head);

        this.tail= list2.tail;
        this.size = this.size + size2;
    }

    @Override
    public Iterator<T> iterator(){  //TODO: Improve this implementation
        Node<T> l = this.head;
        Iterator<T> it = new Iterator<T>(){
            Node<T> currentNode = l;

            @Override
            public boolean hasNext(){
                throw new UnsupportedOperationException();
                /* if(this.getCurrentNode().getNext() != null){
                    return true;
                }
                return false; */
            }
            @Override
            public T next(){
                if(this.currentNode == null){
                    return null;
                }
                T value = this.getCurrentNode().getValue();
                this.currentNode = this.getCurrentNode().getNext();

                return value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Node<T> getCurrentNode(){
                return this.currentNode;
            }
        };
        return it;
    }
}