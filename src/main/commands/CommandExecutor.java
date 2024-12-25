package main.commands;

import main.OutputPrinter;
import main.factories.CacheFactory;
import main.models.Command;

public abstract class CommandExecutor {
    OutputPrinter outputPrinter;
    CacheFactory cacheFactory;

    public CommandExecutor(OutputPrinter outputPrinter, CacheFactory cacheFactory) {
        this.outputPrinter = outputPrinter;
        this.cacheFactory = cacheFactory;
    }

    public abstract boolean validateCommand(Command command);
    public abstract void executeCommand(Command command);
}
