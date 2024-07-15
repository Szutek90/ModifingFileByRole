package com.app.service;

import com.app.model.Data;
import com.app.model.Role;
import com.app.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * The DataProcessingService class is responsible for managing and processing data associated with users.
 * It provides methods to add user data and to process data based on user roles.
 */
@Slf4j
public class DataProcessingService {
    private final Map<User, Data> datas;

    /**
     * Constructs a DataProcessingService object with an empty data map.
     */
    public DataProcessingService() {
        datas = new HashMap<>();
    }

    /**
     * Adds a user and their associated data to the service.
     *
     * @param user the user whose data is to be added.
     * @param data the data associated with the user.
     */
    public void add(User user, Data data) {
        datas.put(user, data);
    }

    /**
     * Processes the data for a given user based on their role and a specified pattern.
     * <ul>
     *     <li>If the user has the ADMINISTRATOR role, the method modifies all data entries to match the pattern.</li>
     *     <li>If the user has the USER role, the method counts occurrences of the pattern in all data entries and logs the count.</li>
     * </ul>
     *
     * @param user    the user whose data is to be processed.
     * @param pattern the pattern to be used for modification or counting.
     * @return the count of pattern occurrences if the user has the USER role, Integer.MIN_VALUE if the user has the ADMINISTRATOR role.
     * @throws IllegalStateException if no data is found for the specified user.
     */
    public int process(User user, String pattern) {
        var data = datas.get(user);
        var counter = 0;
        if (data == null) {
            throw new IllegalStateException("No data found for user " + user);
        }
        for (var entry : datas.entrySet()) {
            if (user.hasTheSameRole(Role.ADMINISTRATOR)) {
                entry.getValue().modifyAll(pattern);
            } else if (user.hasTheSameRole(Role.USER)) {
                counter += entry.getValue().countPattern(pattern);
            }
        }
        if (user.hasTheSameRole(Role.USER)) {
            log.info(String.valueOf(counter));
            return counter;
        }
        return Integer.MIN_VALUE;
    }
}