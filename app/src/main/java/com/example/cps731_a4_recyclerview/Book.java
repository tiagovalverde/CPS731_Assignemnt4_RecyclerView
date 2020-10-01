package com.example.cps731_a4_recyclerview;

import java.util.ArrayList;

/**
 * Data class representing a book
 */
public class Book {
    private String name;
    private ArrayList<String> authors;
    private String category;
    private String subCategory;
    private String publicationDate;
    private double price;
    private String amazonURL;
    private String imageURL;
    private String _abstract;

    public Book(
            String name,
            ArrayList<String> authors,
            String category,
            String subCategory,
            String publicationDate,
            double price, String amazonURL,
            String imageURL,
            String _abstract
    ) {
        this.name = name;
        this.authors = authors;
        this.category = category;
        this.subCategory = subCategory;
        this.publicationDate = publicationDate;
        this.price = price;
        this.amazonURL = amazonURL;
        this.imageURL = imageURL;
        this._abstract = _abstract;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public double getPrice() {
        return price;
    }

    public String getAmazonURL() {
        return amazonURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String get_abstract() {
        return _abstract;
    }
}
