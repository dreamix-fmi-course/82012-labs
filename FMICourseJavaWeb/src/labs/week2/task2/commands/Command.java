package labs.week2.task2.commands;

import labs.week2.task2.storage.FileStorage;

public abstract class Command {
    private final String[] arguments;

    protected Command(String[] arguments) {
        this.arguments = arguments;
    }

    public abstract void execute(FileStorage storage);

    public String[] getArguments() {
        return arguments;
    }
}
