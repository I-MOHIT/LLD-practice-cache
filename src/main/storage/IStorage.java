package main.storage;

public interface IStorage<Key, Value> {
    public abstract Value get(Key key);
    public abstract void put(Key key, Value value);
    public abstract void remove(Key key);
    public abstract boolean isStorageFull();
}
