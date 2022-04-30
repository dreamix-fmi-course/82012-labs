package labs.week2.task2.commands;

import labs.week2.task2.storage.FileStorage;

import java.util.Arrays;

public class InfoCommand extends Command {

    public InfoCommand(String[] arguments) {
        super(arguments);
    }

    @Override
    public void execute(FileStorage storage) {
        Arrays.stream(getArguments())
                .forEach(file -> storage.getFile(file).getInfo());
    }
}
