package labs.week2.task2;

import labs.week2.task2.storage.FileStorage;

import java.util.Scanner;

public class FileManagement {
    private static final String END_COMMAND_TEXT = "END";
    private final FileStorage storage;

    public FileManagement(FileStorage storage) {
        this.storage = storage;
    }

    public void readCommands() {
        Scanner scanner = new Scanner(System.in);

        String input;
        do {
            input = scanner.nextLine();

            // Command command = CommandCreator.of(input);
            // command.execute(storage);
        } while (!END_COMMAND_TEXT.equals(input));
    }
}
