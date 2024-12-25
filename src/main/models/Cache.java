package main.models;

import main.exceptions.KeyNotFoundException;
import main.policies.IEvictionPolicy;
import main.storage.IStorage;

public class Cache <Key, Value>{
    private IStorage<Key, Value> storage;
    private IEvictionPolicy<Key> evictionPolicy;

    public Cache(IStorage<Key, Value> storage, IEvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public Value get(Key key) {
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (KeyNotFoundException keyNotFoundException) {
            System.out.println("This key doesn't exist in the cache");
            return null;
        }
    }

    public void put(Key key, Value value) {
        if (this.storage.isStorageFull()) {
            // This removes the key value pair from the eviction policy double linked list and the map of key to double linked list node
            Key evictedKey = this.evictionPolicy.evictKey();
            // This removes the key value pair from the storage map
            this.storage.remove(evictedKey);
            System.out.println("Cache was full, the key " + evictedKey + " has been evicted.");
        }
        this.storage.put(key, value);
        // Mark the newly inserted key as the most recently accessed one
        this.evictionPolicy.keyAccessed(key);
    }

    public IStorage<Key, Value> getStorage() {
        return storage;
    }

    public void setStorage(IStorage<Key, Value> storage) {
        this.storage = storage;
    }

    public IEvictionPolicy<Key> getEvictionPolicy() {
        return evictionPolicy;
    }

    public void setEvictionPolicy(IEvictionPolicy<Key> evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }
}
