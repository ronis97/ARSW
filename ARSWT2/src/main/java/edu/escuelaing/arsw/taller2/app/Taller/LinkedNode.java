package edu.escuelaing.arsw.taller2.app.Taller;

public class LinkedNode<T> {
    private T node;
    private LinkedNode<T> next;

    public LinkedNode(T element){
        this.node = element;
        this.next = null;
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }
}
