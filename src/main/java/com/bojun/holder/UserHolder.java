package com.bojun.holder;

public class UserHolder {

    private static final ThreadLocal<Integer> userThreadLocal = new ThreadLocal<>();

    public static Integer get() {
        return userThreadLocal.get();
    }

    public static void set(Integer userId) {
        userThreadLocal.set(userId);
    }

    public static void remove() {
        userThreadLocal.remove();
    }
}
