package com.app.model;


import com.app.file_operator.FileMapOperator;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.ToString;

/**
 * The Data class represents a collection of data loaded from multiple files,
 * using a specified FileMapOperator to handle file operations.
 * It provides methods to modify the content of all loaded data and to count occurrences
 * of a specified pattern in the data.
 */
@ToString
public class Data {
    private final Map<String, String> datas;
    private final FileMapOperator<String> fileOperator;

    /**
     * Constructs a Data object by loading data from the specified set of filenames.
     *
     * @param filenames a set of filenames to be loaded.
     * @param fileOperator a FileMapOperator used to load data from the files.
     */
    public Data(Set<String> filenames, FileMapOperator<String> fileOperator) {
        datas = new HashMap<>();
        this.fileOperator = fileOperator;
        for (var filename : filenames) {
            datas.putAll(fileOperator.load(filename));
        }
    }

    /**
     * Modifies the content of all loaded data to match the specified pattern.
     * The modified data is then saved back to their respective files.
     *
     * @param pattern the pattern to set as the content for all loaded data.
     */
    public void modifyAll(String pattern) {
        for (var data : datas.entrySet()) {
            datas.put(data.getKey(), pattern);
            fileOperator.save(data.getKey(), data.getValue());
        }
    }

    /**
     * Counts the number of data entries whose content matches the specified pattern.
     *
     * @param pattern the pattern to match against the content of the data entries.
     * @return the number of data entries that match the pattern.
     */
    public int countPattern(String pattern) {
        var counter = 0;
        for (var entry : datas.entrySet()) {
            counter = entry.getValue().matches(pattern) ? counter + 1 : counter;
        }
        return counter;
    }
}

