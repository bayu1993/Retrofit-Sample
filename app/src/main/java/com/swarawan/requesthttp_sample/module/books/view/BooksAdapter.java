package com.swarawan.requesthttp_sample.module.books.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.swarawan.requesthttp_sample.R;
import com.swarawan.requesthttp_sample.module.books.model.Book;

import java.util.List;

/**
 * Created by rioswarawan on 11/8/17.
 */

public class BooksAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Book> books;
    private LayoutInflater inflater;
    private OnBookItemClicked bookItemClicked;

    public BooksAdapter(Context context, List<Book> books, OnBookItemClicked bookItemClicked) {
        this.context = context;
        this.books = books;
        this.inflater = LayoutInflater.from(context);
        this.bookItemClicked = bookItemClicked;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        BookViewHolder viewHolder = (BookViewHolder) holder;
        Book book = books.get(position);

        // add data to view
        viewHolder.name.setText(book.getName());
        viewHolder.authorYear.setText(book.getAuthor() + " (" + book.getYear() + ")");
        viewHolder.excerpt.setText(book.getExcerpt());
        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookItemClicked.onClicked(position);
            }
        });

        Glide.with(context)
                .load(book.getImage())
                .into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        TextView name, authorYear, excerpt;
        ImageView image;

        public BookViewHolder(View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.card);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.text_title);
            authorYear = itemView.findViewById(R.id.text_author_year);
            excerpt = itemView.findViewById(R.id.text_excerpt);
        }
    }
}
