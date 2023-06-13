package edu.escuelaing.arsw.taller2.app.Taller;

import java.io.Serializable;
import java.util.*;

public class LinkedList<GenericDataType> implements List<GenericDataType>, Deque<GenericDataType>, Cloneable, Serializable {

    private LinkedNode<GenericDataType> head;
    private LinkedNode<GenericDataType> end;
    private int size;

    /**
     * Constructor basico de una linked list, cabeza y cola inicializadas en nulo
     */
    public LinkedList() {
        this.head = null;
        this.end = null;
        this.size = 0;
    }

    public LinkedNode<GenericDataType> getHead() {
        return head;
    }

    public void setHead(LinkedNode<GenericDataType> head) {
        this.head = head;
    }

    public LinkedNode<GenericDataType> getEnd() {
        return end;
    }

    public void setEnd(LinkedNode<GenericDataType> end) {
        this.end = end;
    }


    /**
     * Tamano de una lista enlazada
     * @return cantidad de elementos en la lista
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Agrega un elemento a la lista enlazada
     * @param genericDataType El dato que se agrega a la lista
     * @return Si NO fue posible agregar el elemento
     */
    @Override
    public boolean add(GenericDataType genericDataType) {
        if (isEmpty()){
            head = new LinkedNode<GenericDataType>(genericDataType);
            end = head;
            head.setNext(end);
        }
        else{
            LinkedNode<GenericDataType> newNode = new LinkedNode<GenericDataType>(genericDataType);
            end.setNext(newNode);
            end = newNode;
        }
        size ++;
        return false;
    }

    /**
     * Retorna el iterador de la lista enlazada
     * @return El iterador
     */
    @Override
    public Iterator<GenericDataType> iterator() {
        return new Iterator<GenericDataType>() {
            LinkedNode<GenericDataType> first = head;

            public boolean hasNext() {
                return first != null;
            }

            public GenericDataType next() {
                if (hasNext()) {
                    GenericDataType node = first.getNode();
                    first = first.getNext();
                    return node;
                }
                return null;
            }

        };
    }

    /**
     * Retorna si la lista se encuentra vacia o no
     * @return True o false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean offerFirst(GenericDataType genericDataType) {
        return false;
    }

    @Override
    public boolean offerLast(GenericDataType genericDataType) {
        return false;
    }

    @Override
    public GenericDataType removeFirst() {
        return null;
    }

    @Override
    public GenericDataType removeLast() {
        return null;
    }

    @Override
    public GenericDataType pollFirst() {
        return null;
    }

    @Override
    public GenericDataType pollLast() {
        return null;
    }

    @Override
    public GenericDataType getFirst() {
        return null;
    }

    @Override
    public GenericDataType getLast() {
        return null;
    }

    @Override
    public GenericDataType peekFirst() {
        return null;
    }

    @Override
    public GenericDataType peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(GenericDataType genericDataType) {
        return false;
    }

    @Override
    public GenericDataType remove() {
        return null;
    }

    @Override
    public GenericDataType poll() {
        return null;
    }

    @Override
    public GenericDataType element() {
        return null;
    }

    @Override
    public GenericDataType peek() {
        return null;
    }

    @Override
    public void push(GenericDataType genericDataType) {

    }

    @Override
    public GenericDataType pop() {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }



    @Override
    public Iterator descendingIterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }



    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends GenericDataType> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends GenericDataType> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public GenericDataType get(int index) {
        return null;
    }

    @Override
    public GenericDataType set(int index, GenericDataType element) {
        return null;
    }

    @Override
    public void add(int index, GenericDataType element) {

    }

    @Override
    public GenericDataType remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<GenericDataType> listIterator() {
        return null;
    }

    @Override
    public ListIterator<GenericDataType> listIterator(int index) {
        return null;
    }

    @Override
    public List<GenericDataType> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void addFirst(Object o) {

    }

    @Override
    public void addLast(Object o) {

    }



}