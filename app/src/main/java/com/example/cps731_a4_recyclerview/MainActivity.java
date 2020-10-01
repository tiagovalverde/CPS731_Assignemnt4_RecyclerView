package com.example.cps731_a4_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load app data from assets json file
        DataProvider dp = new DataProvider();
        dp.fetchBooks(this);
        books = dp.getBooks();
    }
}