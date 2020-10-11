package com.example.cps731_a4_recyclerview;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Generates and/or Loads any data to be used by the application
 */
public class DataProvider {
    private final String BOOKS_FILENAME = "books.json";
    private ArrayList<Book> books;

    public DataProvider() {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void fetchBooks(Context context) {
        try {
            JSONArray booksJSON = new JSONArray(Utils.loadJSONFromAsset(context, BOOKS_FILENAME));

            for (int i = 0; i < booksJSON.length(); i++) {
                JSONObject bookJSON = booksJSON.getJSONObject(i);
                JSONArray authorsJSON = bookJSON.getJSONArray("authors");

                ArrayList<String> authors = new ArrayList<>();
                for (int j = 0; j < authorsJSON.length(); j++ ) {
                    authors.add(authorsJSON.getString(j));
                }

                books.add(new Book(
                        bookJSON.getString("id"),
                        bookJSON.getString("name"),
                        authors,
                        bookJSON.getString("category"),
                        bookJSON.getString("subCategory"),
                        bookJSON.getString("publicationDate"),
                        bookJSON.getDouble("price"),
                        bookJSON.getString("amazonURL"),
                        bookJSON.getString("imageURL"),
                        bookJSON.getString("abstract"))
                );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
