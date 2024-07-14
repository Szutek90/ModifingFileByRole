package com.app.model;


import com.app.file_operator.FileMapOperator;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ToString
public class Data {
    private final Map<String, String> datas;
    private final FileMapOperator<String> fileOperator;

    public Data(Set<String> filenames, FileMapOperator<String> fileOperator) {
        datas = new HashMap<>();
        this.fileOperator = fileOperator;
        for (var filename : filenames) {
            datas.putAll(fileOperator.load(filename));
        }
    }

    public void modifyAll(String pattern) {
        for (var data : datas.entrySet()) {
            datas.put(data.getKey(), pattern);
            fileOperator.save(data.getKey(), data.getValue());
        }

    }

    public int countPattern(String pattern) {
        var counter = 0;
        for (var entry : datas.entrySet()) {
            counter = entry.getValue().matches(pattern) ? counter + 1 : counter;
        }
        return counter;
    }

}
