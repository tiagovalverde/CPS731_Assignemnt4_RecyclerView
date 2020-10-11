package com.example.cps731_a4_recyclerview.Data;

import android.content.Context;

import com.example.cps731_a4_recyclerview.Book;
import com.example.cps731_a4_recyclerview.DataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookContent {

    public static final List<Book> ITEMS = new ArrayList<Book>();
    public static final Map<String, Book> ITEM_MAP = new HashMap<String, Book>();

    public static void loadContent(Context context) {
        DataProvider dp = new DataProvider();
        dp.fetchBooks(context);
        List<Book> books = dp.getBooks();

        for (int i = 0; i < books.size(); i++) {
            addItem(books.get(i).getId(), books.get(i));
        }
    }

    private static void addItem(String id, Book book) {
        ITEMS.add(book);
        ITEM_MAP.put(id, book);
    }
}