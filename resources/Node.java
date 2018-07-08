package utils;
public class Node<T>{
    Node<T> next;
    Node<T> previus;
    T value;

    public Node(T value){
        this.value = value;
        this.next = null;
        this.previus = null;
    }

    public void setNext(Node<T> node ){
        this.next = node;
        node.setPrevius(this);
    }
    public Node<T> getNext(){
        return this.next;
    }
    public void setPrevius(Node<T> node){
        this.previus = node;
    }
    public Node<T> getPrevius(){
        return this.previus;
    }
    public T getValue(){
        return this.value;
    }
}