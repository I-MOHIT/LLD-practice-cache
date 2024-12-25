package main;

import main.commands.CommandExecutorFactory;
import main.factories.CacheFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        OutputPrinter outputPrinter = new OutputPrinter();
        CacheFactory<Object, Object> cacheFactory = new CacheFactory<>();
        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(outputPrinter, cacheFactory);

        new InteractiveMode(commandExecutorFactory, outputPrinter).process();
    }
}