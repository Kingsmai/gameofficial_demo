package com.tootaio.gameofficialbackend.entity.bean;

import lombok.Data;

@Data
public class RestBean<T> {
    private boolean success;
    private T message;

    private RestBean(boolean success, T message) {
        this.success = success;
        this.message = message;
    }

    public static <T> RestBean<T> success() {
        return new RestBean<>(true, null);
    }

    public static <T> RestBean<T> success(T data) {
        return new RestBean<>(true, data);
    }

    public static <T> RestBean<T> failure() {
        return new RestBean<>(false, null);
    }

    public static <T> RestBean<T> failure(T data) {
        return new RestBean<>(false, data);
    }
}
