package com.app.model;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", role=" + role +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return id == user.id && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(password);
        result = 31 * result + Objects.hashCode(role);
        result = 31 * result + id;
        return result;
    }
}
