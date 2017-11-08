package com.swarawan.requesthttp_sample.module.books.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.swarawan.requesthttp_sample.R;
import com.swarawan.requesthttp_sample.module.books.model.Book;
import com.swarawan.requesthttp_sample.module.books.presenter.BooksPresenter;
import com.swarawan.requesthttp_sample.module.books.presenter.OnSingleBookResult;

/**
 * Created by rioswarawan on 11/8/17.
 */

public class SingleBookActivity extends AppCompatActivity {

    public static String keyBookId = "key_book_id";

    private TextView title, author, year, excerpt;
    private ImageView image;

    private BooksPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_book);

        title = findViewById(R.id.text_title);
        author = findViewById(R.id.text_author);
        year = findViewById(R.id.text_year);
        excerpt = findViewById(R.id.text_excerpt);
        image = findViewById(R.id.image);

        Intent data = getIntent();

        presenter = new BooksPresenter();
        presenter.getBook(data.getStringExtra(keyBookId), onSingleBookResult);
    }

    private OnSingleBookResult onSingleBookResult = new OnSingleBookResult() {
        @Override
        public void onSuccess(Book book) {
            title.setText(book.getName());
            author.setText(book.getAuthor());
            year.setText(book.getYear());
            excerpt.setText(book.getExcerpt());

            Glide.with(SingleBookActivity.this)
                    .load(book.getImage())
                    .into(image);
        }

        @Override
        public void onError(String message) {
            Toast.makeText(SingleBookActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };
}
