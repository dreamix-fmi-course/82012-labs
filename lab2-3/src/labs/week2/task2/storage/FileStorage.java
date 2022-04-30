package labs.week2.task2.storage;

import labs.week2.task2.files.File;

import java.util.HashMap;
import java.util.Map;

public class FileStorage {
    private final Map<String, File> files = new HashMap<>();

    public void addFile(File file) {
        files.put(file.getLocation() + '/' + file.getName(), file);
    }

    public void removeFile(String filePath) {
        files.remove(filePath);
    }

    public File getFile(String filePath) {
        return files.get(filePath);
    }


}