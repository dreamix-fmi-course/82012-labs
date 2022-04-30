package labs.week2.task2.commands;

import labs.week2.task2.storage.FileStorage;

import java.util.Arrays;

public class DeleteCommand extends Command {

    public DeleteCommand(String[] arguments) {
        super(arguments);
    }

    @Override
    public void execute(FileStorage storage) {
        Arrays.stream(getArguments())
                .forEach(storage::removeFile);
    }
}
