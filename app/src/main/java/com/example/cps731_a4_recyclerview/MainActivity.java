package com.example.cps731_a4_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Book> books;
    private RecyclerView booksRecyclerView;
    private BookListAdapter booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        initializeBookRecyclerView();
    }

    private void initializeBookRecyclerView() {
        booksRecyclerView = findViewById(R.id.recycler_view_books);
        booksAdapter = new BookListAdapter(this, books);
        booksRecyclerView.setAdapter(booksAdapter);
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadData() {
        DataProvider dp = new DataProvider();
        dp.fetchBooks(this);
        books = dp.getBooks();
    }
}