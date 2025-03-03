package com.example.movies;

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

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerViewMovies;
    private MoviesAdapter moviesAdapter;
    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerViewMovies = findViewById(R.id.recyclerViewMovies);
        moviesAdapter = new MoviesAdapter();
        recyclerViewMovies.setAdapter(moviesAdapter);
        recyclerViewMovies.setLayoutManager(new GridLayoutManager(this, 2));
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                moviesAdapter.setMovies(movies);;
//                Log.d(TAG, movies.toString());
            }
        });
        viewModel.loadMovies();

//        ApiFactory.apiService.loadMovies()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<MovieResponse>() {
//                    @Override
//                    public void accept(MovieResponse movieResponse) throws Throwable {
//                        Log.d("Movies", movieResponse.toString());
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Throwable {
//                        Log.d("Movies", throwable.toString());
//                    }
//                });
    }
}