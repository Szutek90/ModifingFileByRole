package com.app.service;

import com.app.model.Data;
import com.app.model.Role;
import com.app.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DataProcessingServiceTest implements BeforeAllInterface {
    static DataProcessingService dataProcessingService;
    static User user1;
    static User user2;
    static Data data1;
    static Data data2;

    static Stream<Arguments> usersWithPatternArgumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new User("password1", "username1", Role.USER, 1),
                        "nissens",
                        3
                ),
                Arguments.of(new User("password2", "username2", Role.ADMINISTRATOR, 2),
                        "I am admin!",
                        -2147483648
                )
        );
    }

    @ParameterizedTest
    @MethodSource("usersWithPatternArgumentsProvider")
    @DisplayName("When processing")
    void test2(User user, String pattern, int expectedValue) {
        dataProcessingService.add(user1, data1);
        dataProcessingService.add(user2, data2);
        Assertions.assertThat(dataProcessingService.process(user, pattern)).isEqualTo(expectedValue);
    }
}
