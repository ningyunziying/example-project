package com.ny.example.stream;

import org.junit.Assert;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntToDoubleFunction;
import java.util.function.Predicate;

public class Function {
    public class User {
        String name;
        Double age;
    }

    public User updateUser(User user, Predicate<User> predicate, Consumer<User> userConsumer) {
        if (predicate.test(user)) {
            userConsumer.accept(user);
        }
        return user;
    }

    public User updateUser(User user, int mm, Predicate<User> predicate, IntToDoubleFunction userConsumer) {
        if (predicate.test(user)) {
            user.age = userConsumer.applyAsDouble(mm);
        }
        return user;
    }

    @Test
    public void updateUserTest() {
        User user = new User();
        user = updateUser(user, r -> r.name == null, r -> r.name = "3");
        Assert.assertEquals(user.name, "3");
        List<Integer> ss = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
