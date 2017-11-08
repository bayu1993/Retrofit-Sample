package com.swarawan.requesthttp_sample.module.books.presenter;

import com.swarawan.requesthttp_sample.module.books.model.Book;

/**
 * Created by rioswarawan on 11/8/17.
 */

public interface OnSingleBookResult {
    void onSuccess(Book books);

    void onError(String message);
}
