package com.app.file_operator;

import java.util.Map;

public interface FileMapOperator <T>{
    Map<T, T> load(String filename);
    void save(String filename, String content);
}
