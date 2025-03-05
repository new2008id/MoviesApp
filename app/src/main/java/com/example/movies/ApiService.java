package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    //    @GET("movie?rating.kp=7-10&sortField=votes.kp&sortType=-1&limit=1&year=2025&type=movie&token=MXTGTC1-GWVMXHR-NYNPSHM-XRJ4XCN")
    @GET("movie?rating.kp=3-8&sortField=votes.kp&sortType=-1&limit=30&year=2024&type=movie&token=5RBED7A-V444WWE-QKBP08F-T8BA14K")
    Single<MovieResponse> loadMovies(
            @Query("page") int page
//            @Query("search") String rating
    );

    //    @GET("movie?token=MXTGTC1-GWVMXHR-NYNPSHM-XRJ4XCN&field=id")
    @GET("movie/{idFilms}?token=5RBED7A-V444WWE-QKBP08F-T8BA14K")
    Single<TrailerResponse> loadTrailers(
            @Path("idFilms") int idFilms
    );

    //
    @GET("review?token=5RBED7A-V444WWE-QKBP08F-T8BA14K&field=movieId")
    Single<ReviewResponse> loadReviews(
            @Query("movieId") int id
    );
}
