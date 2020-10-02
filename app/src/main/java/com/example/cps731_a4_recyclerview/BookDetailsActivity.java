package com.example.cps731_a4_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class BookDetailsActivity extends AppCompatActivity {
    // Data
    Book book;

    // Views
    ImageView imgViewCover;
    TextView txtViewTitle;
    TextView txtViewCategory;
    TextView txtViewAuthor;
    TextView txtViewPublicationDate;
    TextView txtViewAbstract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        // initialize activity state and references
        this.findLayoutViews();
        this.displayBackButton();
        this.book = this.getBookFromIntent();
        this.populateViews();
    }

    private void displayBackButton() {
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button
    }

    private Book getBookFromIntent() {
        if(getIntent().getExtras() != null) {
            return (Book) getIntent().getSerializableExtra("book");
        } else {
            return null;
        }
    }

    private void findLayoutViews() {
        imgViewCover = findViewById(R.id.imageViewCover);
        txtViewTitle = findViewById(R.id.txtBookName);
        txtViewCategory = findViewById(R.id.txtCategory);
        txtViewAuthor = findViewById(R.id.txtAuthorName);
        txtViewPublicationDate = findViewById(R.id.txtPublicationDate);
        txtViewAbstract = findViewById(R.id.txtAbstract);
    }

    private void populateViews() {
        if(this.book != null) {
            this.fetchBookCoverImage();
            this.txtViewTitle.setText(this.book.getName());
            this.txtViewPublicationDate.setText(this.book.getPublicationDate());
            this.txtViewAbstract.setText(this.book.getAbstract());
            this.txtViewAuthor.setText(this.book.getAuthors().get(0));
            this.txtViewCategory.setText(this.book.getCategory() + " > " + this.book.getSubCategory());
        }
    }

    private void fetchBookCoverImage() {
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);
        Glide.with(this)
                .load(this.book.getImageURL())
                .apply(requestOptions)
                .into(this.imgViewCover);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}