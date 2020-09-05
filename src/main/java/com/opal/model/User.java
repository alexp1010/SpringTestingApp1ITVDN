package com.opal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String name;
    String lastName;
    int age;

    public static String makeFriends(User user1, User user2) {
        return String.format("%s and %s are friends!", user1.getName(), user2.getName());
    }

    public static String getUserName() {
        throw new UnsupportedOperationException("No implementation!!!");
    }

    public static void waitInQueue() {
        try {
            Thread.sleep(30L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
