package labs.week2.task2.files;

import java.time.LocalDate;

public class ContentFile extends File {
    private String content;
    private LocalDate lastModificationDate;

    public ContentFile(String name, String location, LocalDate timestamp) {
        super(name, location, timestamp);
    }

    @Override
    public File copy(String location) {
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }

        System.out.printf("%s/%s was copied to %s/%s\n",
                this.getName(), this.getLocation(), this.getName(), location);
        return new ContentFile(this.getName(), location, this.getTimestamp());
    }

    public void modify(String data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.content = data;
        this.lastModificationDate = LocalDate.now();
        System.out.println("%s");
    }

    @Override
    public String toString() {
        return "Name: " + getLocation() + '/' + getName() +
                (isDeleted() ? "Deleted" : "Not deleted") + '\n' +
                "Creation date: " + getTimestamp() + '\n' +
                "Last modification date: " + lastModificationDate;
    }
}
