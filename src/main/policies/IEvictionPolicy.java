package main.policies;

public interface IEvictionPolicy<Key> {
    public abstract void keyAccessed(Key key);
    public abstract Key evictKey();
}
