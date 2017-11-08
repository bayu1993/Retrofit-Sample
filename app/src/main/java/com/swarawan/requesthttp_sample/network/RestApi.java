package com.swarawan.requesthttp_sample.network;

import com.swarawan.requesthttp_sample.module.books.model.Book;
import com.swarawan.requesthttp_sample.module.books.model.Books;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rioswarawan on 11/8/17.
 */

public interface RestApi {

    @GET("/api/books")
    Call<Books> getAllBooks();

    @GET("/api/book/{id}")
    Call<Book> getBook(@Path("id") String id);
}
