package labs.week2.task2.files;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ExecutableFile extends File {
    private List<String> requiredResources;
    private LocalDate lastExecutionDate;

    public ExecutableFile(String name, String location, LocalDate timestamp) {
        super(name, location, timestamp);
    }

    @Override
    public File copy(String location) {
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }

        return new ExecutableFile(this.getName(), location, this.getTimestamp());
    }

    public void execute() {
        lastExecutionDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Name: " + getLocation() + '/' + getName() +
                (isDeleted() ? "Deleted" : "Not deleted") + '\n' +
                "Creation date: " + getTimestamp() + '\n' +
                "Last execution date: " + lastExecutionDate +
                "Required resources:\n" +
                String.join(System.lineSeparator(), requiredResources);
    }
}
