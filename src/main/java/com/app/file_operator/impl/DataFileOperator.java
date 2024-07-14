package com.app.file_operator.impl;


import com.app.file_operator.FileMapOperator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DataFileOperator implements FileMapOperator<String> {

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

    @Override
    public void save(String filename, String content) {
        try {
            Files.write(Paths.get(filename), content.getBytes());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}

