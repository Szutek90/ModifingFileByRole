package com.app.file_operator.impl;

import com.app.file_operator.FileSetOperator;
import com.app.model.User;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * The UserFileOperator class implements the FileSetOperator interface for operations on files containing User objects.
 * It provides a method to load the contents of a file into a set of User objects.
 */
public class UserFileOperator implements FileSetOperator<User> {

    /**
     * Loads the content of the specified file into a set of User objects.
     * Each line in the file represents a User object, which is parsed and added to the set.
     *
     * @param filename the name of the file to be loaded.
     * @return a set of User objects parsed from the file.
     * @throws IllegalStateException if an I/O error occurs while reading the file or if a User object cannot be parsed.
     */
    @Override
    public Set<User> load(String filename) {
        try (var lines = Files.lines(Paths.get(filename))) {
            var users = new HashSet<User>();
            for (var line : lines.toList()) {
                users.add(User.parse(line));
            }
            return users;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}

