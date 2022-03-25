package labs.week2.task2.files;

import java.time.LocalDate;

public abstract class File {
    private final String name;
    private final LocalDate timestamp;
    private String location;
    private boolean isDeleted;

    public File(String name, String location, LocalDate timestamp) {
        this.name = name;
        this.location = location;
        this.timestamp = timestamp;
    }

    public abstract File copy(String location);

    public void move(String location) {
        validateLocation(location);
        this.location = location;
    }

    public void delete() {
        isDeleted = true;
    }

    public void getInfo() {
        System.out.println(this);
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    private void validateLocation(String location) {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location cannot be null");
        }
    }
}