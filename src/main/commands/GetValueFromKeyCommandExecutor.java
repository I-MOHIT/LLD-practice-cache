package main.commands;

import main.OutputPrinter;
import main.exceptions.InvalidCommandException;
import main.factories.CacheFactory;
import main.models.Command;

public class GetValueFromKeyCommandExecutor<Key, Value> extends CommandExecutor{
    public static final String COMMAND_NAME = "get_value_from_key";

    public GetValueFromKeyCommandExecutor(OutputPrinter outputPrinter, CacheFactory<Key, Value> cacheFactory) {
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
        Key key = (Key) command.getParams().getFirst();
        Value value = (Value) this.cacheFactory.getCache().get(key);
        System.out.println("The key " + key + " in the cache has the value " + value);
    }
}
