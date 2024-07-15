package com.app.file_operator;

import java.util.Set;

/**
 * The FileSetOperator interface defines a method for loading data from a file,
 * where the data is represented as a set of objects of type T.
 *
 * @param <T> the type of elements in the set.
 */
public interface FileSetOperator<T> {

    /**
     * Loads the content of the specified file into a set.
     * The implementation defines how the file content is parsed and represented as a set.
     *
     * @param filename the name of the file to be loaded.
     * @return a set containing the data loaded from the file.
     * @throws IllegalStateException if an I/O error occurs while reading the file.
     */
    Set<T> load(String filename);
}
