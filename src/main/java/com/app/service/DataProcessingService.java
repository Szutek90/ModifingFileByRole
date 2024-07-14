package com.app.service;

import com.app.model.Data;
import com.app.model.Role;
import com.app.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DataProcessingService {
    private final Map<User, Data> datas;

    public DataProcessingService() {
        datas = new HashMap<>();
    }


    public void add(User user, Data data) {
        datas.put(user, data);
    }

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
