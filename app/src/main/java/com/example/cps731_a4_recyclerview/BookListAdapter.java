package com.example.cps731_a4_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {
    private final ArrayList<Book> bookList;
    private LayoutInflater inflater;
    private Context context;

    public BookListAdapter(Context context, ArrayList<Book> bookList) {
        this.bookList = bookList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public BookListAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.books_list_item, parent, false);
        return new BookViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull BookListAdapter.BookViewHolder holder, final int position) {
        Book book = bookList.get(position);
        holder.itemTitleView.setText(book.getName());
        holder.itemDescView.setText(book.getCategory() + " > " + book.getSubCategory());

        // load online image
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);
        Glide.with(this.context)
                .load(this.bookList.get(position).getImageURL())
                .apply(requestOptions)
                .into(holder.itemImgView);

        // add click listener to recycler view item
        holder.itemContainerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO to navigate to the book details activity
                Toast.makeText(context, bookList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    /**
     * ViewHolder class
     */
    class BookViewHolder extends RecyclerView.ViewHolder {
        public final LinearLayout itemContainerView;
        public final TextView itemTitleView;
        public final TextView itemDescView;
        public final ImageView itemImgView;
        final BookListAdapter adapter;

        BookViewHolder(View itemView, BookListAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            itemContainerView = itemView.findViewById(R.id.rv_book_item);
            itemTitleView = itemView.findViewById(R.id.txtViewTitle);
            itemDescView = itemView.findViewById(R.id.txtViewDescription);
            itemImgView = itemView.findViewById(R.id.imgView);
        }
    }
}
