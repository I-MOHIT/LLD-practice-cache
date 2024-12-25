package main.dataStructures;

public class DoubleLinkedListNode <E>{
    private E element;
    private DoubleLinkedListNode<E> prev;
    private DoubleLinkedListNode<E> next;

    public DoubleLinkedListNode(E element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DoubleLinkedListNode<E> getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedListNode<E> prev) {
        this.prev = prev;
    }

    public DoubleLinkedListNode<E> getNext() {
        return next;
    }

    public void setNext(DoubleLinkedListNode<E> next) {
        this.next = next;
    }
}
