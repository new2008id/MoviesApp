package com.example.movies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavouriteActivity extends AppCompatActivity {
    private RecyclerView recyclerViewFavourite;
    private MoviesAdapter moviesAdapter;
    private FavouriteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favourite);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recyclerViewFavourite), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        moviesAdapter = new MoviesAdapter();
        recyclerViewFavourite.setAdapter(moviesAdapter);
        viewModel = new ViewModelProvider(this).get(FavouriteViewModel.class);
        moviesAdapter.setOnMovieClickListener(new MoviesAdapter.OnMovieClickListener() {
            @Override
            public void onMovieClick(Movie movie) {
                Intent intent = MovieDetailActivity.newIntent(FavouriteActivity.this, movie);
                startActivity(intent);
            }
        });
        recyclerViewFavourite.setLayoutManager(new GridLayoutManager(this, 2));

        viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                moviesAdapter.setMovies(movies);
            }
        });

    }

    public static Intent newIntent(Context context) {
        return new Intent(context, FavouriteActivity.class);
    }

    private void initViews() {
        recyclerViewFavourite = findViewById(R.id.recyclerViewFavourite);
    }
}