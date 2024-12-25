package main.commands;

import main.OutputPrinter;
import main.exceptions.InvalidCommandException;
import main.factories.CacheFactory;
import main.models.Cache;
import main.models.Command;

public class CreateCacheCommandExecutor<Key, Value> extends CommandExecutor{
    public static final String COMMAND_NAME = "create_cache";

    public CreateCacheCommandExecutor(OutputPrinter outputPrinter, CacheFactory<Key, Value> cacheFactory) {
        super(outputPrinter, cacheFactory);
    }

    @Override
    public boolean validateCommand(Command command) {
        if(!command.getCommandName().equals(COMMAND_NAME) || command.getParams().size() != 1) {
            throw new InvalidCommandException();
        }
        return true;
    }

    @Override
    public void executeCommand(Command command) {
        int capacity = Integer.parseInt(command.getParams().getFirst());
        this.cacheFactory.createCache(capacity);
        this.outputPrinter.createCache(capacity);
    }
}
