package com.swarawan.requesthttp_sample.module.books.model;

import java.util.List;

/**
 * Created by rioswarawan on 11/8/17.
 */

public class Books {

    private boolean success;
    private String message;
    private List<Book> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Book> getData() {
        return data;
    }

    public void setData(List<Book> data) {
        this.data = data;
    }
}
