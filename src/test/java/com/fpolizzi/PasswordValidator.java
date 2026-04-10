package com.fpolizzi;

import java.util.function.Predicate;

/**
 * Created by fpolizzi on 10.04.26
 */
public class PasswordValidator implements Predicate<String> {

    @Override
    public boolean test(String password) {

        if (password == null || password.isBlank()) {
            return false;
        }

        return false;
    }
}
