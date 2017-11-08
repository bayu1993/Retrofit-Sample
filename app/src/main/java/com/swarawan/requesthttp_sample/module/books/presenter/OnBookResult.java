package com.swarawan.requesthttp_sample.module.books.presenter;

import com.swarawan.requesthttp_sample.module.books.model.Book;

import java.util.List;

/**
 * Created by rioswarawan on 11/8/17.
 */

public interface OnBookResult {

    void onSuccess(List<Book> books);

    void onError(String message);
}
