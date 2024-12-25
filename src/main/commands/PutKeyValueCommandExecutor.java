package main.commands;

import main.OutputPrinter;
import main.exceptions.InvalidCommandException;
import main.factories.CacheFactory;
import main.models.Command;

public class PutKeyValueCommandExecutor<Key, Value> extends CommandExecutor{
    public static final String COMMAND_NAME = "put_key_value";

    public PutKeyValueCommandExecutor(OutputPrinter outputPrinter, CacheFactory<Key, Value> cacheFactory) {
        super(outputPrinter, cacheFactory);
    }

    @Override
    public boolean validateCommand(Command command) {
        if(!command.getCommandName().equals(COMMAND_NAME) || command.getParams().size() != 2) {
            throw new InvalidCommandException();
        }
        return true;
    }

    @Override
    public void executeCommand(Command command) {
        Key key = (Key) command.getParams().getFirst();
        Value value = (Value) command.getParams().get(1);
        this.cacheFactory.getCache().put(key, value);
        System.out.println("The key " + key + ", value " + value + " pair has been inserted in the cache");
    }
}
