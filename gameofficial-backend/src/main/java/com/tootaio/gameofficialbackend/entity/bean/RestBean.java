package com.tootaio.gameofficialbackend.entity.bean;

import lombok.Data;

@Data
public class RestBean<T> {
    private boolean success;
    private int pageSize;
    private int pageNumber;
    private int totalRecords;
    private T message;

    private RestBean(boolean success, T message) {
        this.success = success;
        this.message = message;
    }

    private RestBean(boolean success, T message, int pageSize, int pageNumber, int totalRecords) {
        this.success = success;
        this.message = message;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.totalRecords = totalRecords;
    }

    public static <T> RestBean<T> success() {
        return new RestBean<>(true, null);
    }

    public static <T> RestBean<T> success(T data) {
        return new RestBean<>(true, data);
    }

    public static <T> RestBean<T> success(T data, int pageSize, int pageNumber, int totalRecords) {
        return new RestBean<>(true, data, pageSize, pageNumber, totalRecords);
    }

    public static <T> RestBean<T> failure() {
        return new RestBean<>(false, null);
    }

    public static <T> RestBean<T> failure(T data) {
        return new RestBean<>(false, data);
    }
}
