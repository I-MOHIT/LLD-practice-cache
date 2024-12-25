package main.commands;

import main.OutputPrinter;
import main.exceptions.InvalidCommandException;
import main.factories.CacheFactory;
import main.models.Command;

public class ExitCommandExecutor<Key, Value> extends CommandExecutor{
    public static final String COMMAND_NAME = "exit";

    public ExitCommandExecutor(OutputPrinter outputPrinter, CacheFactory<Key, Value> cacheFactory) {
        super(outputPrinter, cacheFactory);
    }

    @Override
    public boolean validateCommand(Command command) {
        if(!command.getCommandName().equals(COMMAND_NAME) || !command.getParams().isEmpty()) {
            throw new InvalidCommandException();
        }
        return true;
    }

    @Override
    public void executeCommand(Command command) {
        outputPrinter.exit();
    }
}
