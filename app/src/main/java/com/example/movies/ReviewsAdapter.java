package com.example.movies;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder> {
    private final String TAG = "ReviewAdapter";
    private final String TYPE_POSITIVE = "Позитивный";
    private final String TYPE_NEUTRAL = "Нейтральный";
    private final String TYPE_NEGATIVE = "Негативный";
    private List<Review> reviews = new ArrayList<>();

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.review_item, parent, false);
        return new ReviewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewsViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);
        Review review = reviews.get(position);
        holder.textViewAuthor.setText(review.getAuthor());
        holder.textViewDescription.setText(review.getReview());

        int backgroundId = android.R.color.holo_red_light;
        switch (review.getType()) {
            case TYPE_POSITIVE:
                backgroundId = android.R.color.holo_green_light;
                break;
            case TYPE_NEUTRAL:
                backgroundId = android.R.color.holo_orange_light;
                break;
        }
        int color = ContextCompat.getColor(holder.itemView.getContext(), backgroundId);
        holder.linearLayoutReview.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class ReviewsViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewAuthor;
        private final TextView textViewDescription;
        private final LinearLayout linearLayoutReview;
        public ReviewsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            linearLayoutReview = itemView.findViewById(R.id.linearLayoutReview);
        }
    }
}
