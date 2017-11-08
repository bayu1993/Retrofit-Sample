package com.swarawan.requesthttp_sample.module.books.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.swarawan.requesthttp_sample.R;
import com.swarawan.requesthttp_sample.module.books.model.Book;
import com.swarawan.requesthttp_sample.module.books.presenter.BooksPresenter;
import com.swarawan.requesthttp_sample.module.books.presenter.OnBookResult;
import com.swarawan.requesthttp_sample.network.NetworkService;
import com.swarawan.requesthttp_sample.network.RestApi;

import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {

    private RecyclerView recyclerBook;

    private List<Book> books;
    private BooksAdapter adapter;
    private BooksPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        books = new ArrayList<>();
        adapter = new BooksAdapter(this, books, onBookItemClicked);

        recyclerBook = findViewById(R.id.list_book);
        recyclerBook.setAdapter(adapter);
        recyclerBook.setLayoutManager(new LinearLayoutManager(this));

        presenter = new BooksPresenter();
        presenter.getAllBooks(onBookResult);
    }

    private OnBookResult onBookResult = new OnBookResult() {
        @Override
        public void onSuccess(List<Book> books) {
            BooksActivity.this.books.addAll(books);
            BooksActivity.this.adapter.notifyDataSetChanged();
        }

        @Override
        public void onError(String message) {
            Toast.makeText(BooksActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private OnBookItemClicked onBookItemClicked = new OnBookItemClicked() {
        @Override
        public void onClicked(int position) {
            Book book = books.get(position);
            String bookId = String.valueOf(book.getId());

            Intent intent = new Intent(BooksActivity.this, SingleBookActivity.class);
            intent.putExtra(SingleBookActivity.keyBookId, bookId);
            startActivity(intent);
        }
    };

}
