package main.factories;

import main.models.Cache;
import main.policies.LRUEvictionPolicy;
import main.storage.HashMapBasedStorage;

public class CacheFactory <Key, Value>{
    private Cache<Key, Value> cache;

    public void createCache(int capacity) {
        this.cache = new Cache<Key, Value>(new HashMapBasedStorage<>(capacity), new LRUEvictionPolicy<>());
    }

    public Cache<Key, Value> getCache() {
        return cache;
    }

    public void setCache(Cache<Key, Value> cache) {
        this.cache = cache;
    }
}
