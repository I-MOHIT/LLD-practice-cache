package main;

import main.models.Cache;

public class OutputPrinter {
    public void hello() {
        System.out.println("Hello!");
    }

    public void exit() {
        System.out.println("Bye!");
    }

    public void createCache(int capacity) {
        System.out.println("Created a cache of capacity " + capacity);
    }
}
