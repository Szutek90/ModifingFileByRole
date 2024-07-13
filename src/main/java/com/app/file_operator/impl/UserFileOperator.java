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
        return new HashSet<>();
    }
}
