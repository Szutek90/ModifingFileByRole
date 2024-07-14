package com.app.service;

import com.app.file_operator.impl.DataFileOperator;
import com.app.model.Data;
import com.app.model.Role;
import com.app.model.User;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

public interface BeforeAllInterface {
    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        Files.writeString(Paths.get("src/test/resources/file1.csv"), "I am admin!");
        Files.writeString(Paths.get("src/test/resources/file2.csv"), "nissens");
        Files.writeString(Paths.get("src/test/resources/file3.csv"), "nissens");
        Files.writeString(Paths.get("src/test/resources/file4.csv"), "nissens");
        DataProcessingServiceTest.dataProcessingService = new DataProcessingService();
        System.out.println("jestem z testu");
        DataProcessingServiceTest.user1 = new User("password1", "username1", Role.USER, 1);
        DataProcessingServiceTest.data1 = new Data(new HashSet<>(List.of("src/test/resources/file1.csv",
                "src/test/resources/file2.csv")), new DataFileOperator());
        DataProcessingServiceTest.user2 = new User("password2", "username2", Role.ADMINISTRATOR, 2);
        DataProcessingServiceTest.data2 = new Data(new HashSet<>(List.of("src/test/resources/file3.csv",
                "src/test/resources/file4.csv")), new DataFileOperator());
    }
}
