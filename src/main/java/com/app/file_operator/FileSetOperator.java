package com.app.file_operator;

import java.util.Set;

public interface FileSetOperator<T>{
    Set<T> load(String filename);

}
