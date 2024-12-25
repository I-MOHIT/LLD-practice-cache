package main.commands;

import main.OutputPrinter;
import main.exceptions.InvalidCommandException;
import main.factories.CacheFactory;
import main.models.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    private OutputPrinter outputPrinter;
    private CacheFactory cacheFactory;
    private Map<String, CommandExecutor> commandExecutorMap;

    public CommandExecutorFactory(OutputPrinter outputPrinter, CacheFactory cacheFactory) {
        this.outputPrinter = outputPrinter;
        this.cacheFactory = cacheFactory;
        this.commandExecutorMap = new HashMap<>();
        this.commandExecutorMap.put(ExitCommandExecutor.COMMAND_NAME, new ExitCommandExecutor(outputPrinter, cacheFactory));
        this.commandExecutorMap.put(CreateCacheCommandExecutor.COMMAND_NAME, new CreateCacheCommandExecutor(outputPrinter, cacheFactory));
        this.commandExecutorMap.put(GetValueFromKeyCommandExecutor.COMMAND_NAME, new GetValueFromKeyCommandExecutor(outputPrinter, cacheFactory));
        this.commandExecutorMap.put(PutKeyValueCommandExecutor.COMMAND_NAME, new PutKeyValueCommandExecutor(outputPrinter, cacheFactory));
    }

    public OutputPrinter getOutputPrinter() {
        return outputPrinter;
    }

    public void setOutputPrinter(OutputPrinter outputPrinter) {
        this.outputPrinter = outputPrinter;
    }

    public CacheFactory getCacheFactory() {
        return cacheFactory;
    }

    public void setCacheFactory(CacheFactory cacheFactory) {
        this.cacheFactory = cacheFactory;
    }

    public Map<String, CommandExecutor> getCommandExecutorMap() {
        return commandExecutorMap;
    }

    public void setCommandExecutorMap(Map<String, CommandExecutor> commandExecutorMap) {
        this.commandExecutorMap = commandExecutorMap;
    }

    public CommandExecutor getCommandExecutor(Command command) {
        if (!this.commandExecutorMap.containsKey(command.getCommandName())) {
            throw new InvalidCommandException();
        }
        return this.commandExecutorMap.get(command.getCommandName());
    }
}
