package com.example.movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Videos {
    @SerializedName("name")
    private List<Trailer> results;

    public Videos(List<Trailer> results) {
        this.results = results;
    }

    public List<Trailer> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "Videos{" +
                "results=" + results +
                '}';
    }
}
