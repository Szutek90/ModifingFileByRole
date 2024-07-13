package com.app.file_operator;

import com.app.file_operator.impl.UserFileOperator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserFileOperatorTest {
    @Test
    @DisplayName("When loading users from file")
    void test() {
        var fileOperator = new UserFileOperator();
        var users = fileOperator.load("src/test/resources/users.csv");
        Assertions.assertThat(users).hasSize(3);
    }
}
