package main.policies;

import main.dataStructures.DoubleLinkedList;
import main.dataStructures.DoubleLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements IEvictionPolicy<Key>{
    private DoubleLinkedList<Key> doubleLinkedList;
    private Map<Key, DoubleLinkedListNode<Key>> doubleLinkedListNodeMap;

    public LRUEvictionPolicy() {
        this.doubleLinkedList = new DoubleLinkedList<>();
        this.doubleLinkedListNodeMap = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        DoubleLinkedListNode<Key> node;
        if (this.doubleLinkedListNodeMap.containsKey(key)) {
            node = this.doubleLinkedListNodeMap.get(key);
            this.doubleLinkedList.detachNode(node);
        } else {
            node = new DoubleLinkedListNode<>(key);
        }
        this.doubleLinkedList.addNodeAtLast(node);
        this.doubleLinkedListNodeMap.putIfAbsent(key, node);
    }

    @Override
    public Key evictKey() {
        DoubleLinkedListNode<Key> node = this.doubleLinkedList.getFirstNode();
        if (node == null) {
            return null;
        }
        this.doubleLinkedList.detachNode(node);
        this.doubleLinkedListNodeMap.remove(node.getElement());
        return node.getElement();
    }
}
