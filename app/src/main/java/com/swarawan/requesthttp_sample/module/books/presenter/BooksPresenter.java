package com.swarawan.requesthttp_sample.module.books.presenter;

import android.content.Context;

import com.swarawan.requesthttp_sample.module.books.model.Book;
import com.swarawan.requesthttp_sample.module.books.model.Books;
import com.swarawan.requesthttp_sample.network.NetworkService;
import com.swarawan.requesthttp_sample.network.RestApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rioswarawan on 11/8/17.
 */

public class BooksPresenter {

    private RestApi api;

    public BooksPresenter() {
        this.api = NetworkService.create();
    }

    public void getAllBooks(final OnBookResult responseHandler) {
        this.api.getAllBooks().enqueue(new Callback<Books>() {
            @Override
            public void onResponse(Call<Books> call, Response<Books> response) {
                responseHandler.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<Books> call, Throwable t) {
                responseHandler.onError(t.getMessage());
            }
        });
    }

    public void getBook(String bookId, final OnSingleBookResult responseHandler) {

        bookId = "1";       // Dummy data from apiary only consume id = 1

        this.api.getBook(bookId).enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                responseHandler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                responseHandler.onError(t.getMessage());
            }
        });
    }
}
