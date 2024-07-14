package com.app.model;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class User {
    private final String password;
    private final String username;
    private final Role role;
    private final int id;

    public static User parse(String line) {
        var splitted = line.split(";");
        return new User(splitted[0], splitted[1], Role.valueOf(splitted[2]),
                Integer.parseInt(splitted[3]));
    }

    public boolean hasTheSameRole(Role role) {
        return this.role.equals(role);
    }

}
