package com.app.file_operator;

import java.util.Map;

/**
 * The FileMapOperator interface defines methods for loading and saving data in a file,
 * where the data is represented as a map with keys and values of type T.
 *
 * @param <T> the type of keys and values in the map.
 */
public interface FileMapOperator<T> {

    /**
     * Loads the content of the specified file into a map.
     * The implementation defines how the file content is parsed and represented as a map.
     *
     * @param filename the name of the file to be loaded.
     * @return a map containing the data loaded from the file.
     * @throws IllegalStateException if an I/O error occurs while reading the file.
     */
    Map<T, T> load(String filename);

    /**
     * Saves the specified content to the specified file.
     * The implementation defines how the content is written to the file.
     *
     * @param filename the name of the file where the content will be saved.
     * @param content  the content to be saved in the file.
     * @throws IllegalStateException if an I/O error occurs while writing to the file.
     */
    void save(String filename, String content);
}

