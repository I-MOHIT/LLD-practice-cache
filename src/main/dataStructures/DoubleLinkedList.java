package main.dataStructures;

import main.exceptions.EmptyCacheException;

public class DoubleLinkedList<E> {
    private DoubleLinkedListNode<E> dummyHead;
    private DoubleLinkedListNode<E> dummyTail;

    public DoubleLinkedList() {
        this.dummyHead = new DoubleLinkedListNode<E>(null);
        this.dummyTail = new DoubleLinkedListNode<E>(null);

        dummyHead.setNext(dummyTail);
        dummyTail.setPrev(dummyHead);
    }

    public DoubleLinkedListNode<E> getDummyHead() {
        return dummyHead;
    }

    public void setDummyHead(DoubleLinkedListNode<E> dummyHead) {
        this.dummyHead = dummyHead;
    }

    public DoubleLinkedListNode<E> getDummyTail() {
        return dummyTail;
    }

    public void setDummyTail(DoubleLinkedListNode<E> dummyTail) {
        this.dummyTail = dummyTail;
    }

    public void detachNode(DoubleLinkedListNode<E> node) {
        if (node != null) {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
    }

    public void addNodeAtLast(DoubleLinkedListNode<E> node) {
        if (node != null) {
            DoubleLinkedListNode<E> currLast = this.dummyTail.getPrev();
            currLast.setNext(node);
            node.setNext(this.dummyTail);
            this.dummyTail.setPrev(node);
            node.setPrev(currLast);
        }
    }

    public DoubleLinkedListNode<E> getFirstNode() {
        if (this.dummyHead.getNext().equals(this.dummyTail)) {
            throw new EmptyCacheException();
        }
        return this.dummyHead.getNext();
    }

    public DoubleLinkedListNode<E> getLastNode() {
        if (this.dummyTail.getPrev().equals(this.dummyHead)) {
            throw new EmptyCacheException();
        }
        return this.dummyTail.getPrev();
    }
}
