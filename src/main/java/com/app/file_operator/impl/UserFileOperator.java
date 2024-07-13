package com.app.file_operator.impl;

import com.app.file_operator.FileSetOperator;
import com.app.model.User;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class UserFileOperator implements FileSetOperator<User> {

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
