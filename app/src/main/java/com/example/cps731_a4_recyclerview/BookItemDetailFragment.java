package com.example.cps731_a4_recyclerview;

import android.app.Activity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cps731_a4_recyclerview.Data.BookContent;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A fragment representing a single BookItem detail screen.
 * This fragment is either contained in a {@link BookItemListActivity}
 * in two-pane mode (on tablets) or a {@link BookItemDetailActivity}
 * on handsets.
 */
public class BookItemDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private Book mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BookItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = BookContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bookitem_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.txtBookName)).setText(this.mItem.getName());
            ((TextView) rootView.findViewById(R.id.txtCategory)).setText(this.mItem.getCategory() + " > " + this.mItem.getSubCategory());
            ((TextView) rootView.findViewById(R.id.txtPublicationDate)).setText(this.mItem.getPublicationDate());
            ((TextView) rootView.findViewById(R.id.txtBookName)).setText(this.mItem.getName());
            ((TextView) rootView.findViewById(R.id.txtAbstract)).setText(this.mItem.getAbstract());

            RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);
            Glide.with(this)
                    .load(this.mItem.getImageURL())
                    .apply(requestOptions)
                    .into(((ImageView) rootView.findViewById(R.id.imageViewCover)));
        }

        return rootView;
    }
}