package labs.week2.task2;

import java.time.LocalDate;

public abstract class File {
    private final String name;
    private final String location;
    private final LocalDate timestamp;
    private boolean isDeleted;

    public File(String name, String location, LocalDate timestamp) {
        this.name = name;
        this.location = location;
        this.timestamp = timestamp;
    }

    public void move(String location) {

    }

    public void copy(String location) {

    }

    public void delete() {

    }

    public void execute() {

    }

    public void modify(String data) {

    }

    public void getInfo() {
        
    }
}
