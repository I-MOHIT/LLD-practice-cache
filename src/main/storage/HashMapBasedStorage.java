package main.storage;

import main.exceptions.KeyNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements IStorage<Key, Value>{
    private Map<Key, Value> map;
    private int capacity;

    public HashMapBasedStorage(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public Map<Key, Value> getMap() {
        return map;
    }

    public void setMap(Map<Key, Value> map) {
        this.map = map;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Value get(Key key) {
        if (!this.map.containsKey(key)) {
            throw new KeyNotFoundException();
        }
        return this.map.get(key);
    }

    @Override
    public void put(Key key, Value value) {
        this.map.put(key, value);
    }

    @Override
    public void remove(Key key) {
        if (!this.map.containsKey(key)) {
            throw new KeyNotFoundException();
        }
        this.map.remove(key);
    }

    @Override
    public boolean isStorageFull() {
        return this.map.size() == this.capacity;
    }
}
