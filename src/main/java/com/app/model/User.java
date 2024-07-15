package com.app.model;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * The User class represents a user with a username, password, role, and unique ID.
 * It provides methods to parse a user from a string and to check if a user has a specific role.
 */
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class User {
    private final String password;
    private final String username;
    private final Role role;
    private final int id;

    /**
     * Parses a User object from a string representation.
     * The string should be formatted as "password;username;role;id".
     *
     * @param line the string representation of the user.
     * @return a User object parsed from the string.
     */
    public static User parse(String line) {
        var splitted = line.split(";");
        return new User(splitted[0], splitted[1], Role.valueOf(splitted[2]),
                Integer.parseInt(splitted[3]));
    }

    /**
     * Checks if the user has the same role as the specified role.
     *
     * @param role the role to check against the user's role.
     * @return true if the user's role matches the specified role, false otherwise.
     */
    public boolean hasTheSameRole(Role role) {
        return this.role.equals(role);
    }
}
