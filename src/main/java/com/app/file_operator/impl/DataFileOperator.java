package com.app.file_operator.impl;


import com.app.file_operator.FileMapOperator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The DataFileOperator class implements the FileMapOperator interface for operations on files.
 * It provides methods to load the contents of a file into a map and to save content to a file.
 */
public class DataFileOperator implements FileMapOperator<String> {

    /**
     * Loads the content of the specified file into a map.
     * The map will contain a single entry where the key is the filename and the value is the file content as a single string.
     *
     * @param filename the name of the file to be loaded.
     * @return a map containing the filename as the key and the file content as the value.
     * @throws IllegalStateException if an I/O error occurs while reading the file.
     */
    @Override
    public Map<String, String> load(String filename) {
        try (var lines = Files.lines(Paths.get(filename))) {
            var data = new HashMap<String, String>();
            data.put(filename, lines.collect(Collectors.joining()));
            return data;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Saves the specified content to the specified file.
     *
     * @param filename the name of the file where the content will be saved.
     * @param content  the content to be saved in the file.
     * @throws IllegalStateException if an I/O error occurs while writing to the file.
     */
    @Override
    public void save(String filename, String content) {
        try {
            Files.write(Paths.get(filename), content.getBytes());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}


