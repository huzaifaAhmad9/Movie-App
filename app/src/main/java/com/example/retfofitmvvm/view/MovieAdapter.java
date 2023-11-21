package com.example.retfofitmvvm.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retfofitmvvm.R;
import com.example.retfofitmvvm.databinding.MovieListItemBinding;
import com.example.retfofitmvvm.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Use the correct DataBindingUtil.inflate method
        MovieListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.movie_list_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);
        // Use the correct method to bind the variable
        holder.movieListItemBinding.setMovie(movie);
        // ExecuteBindings is necessary for immediate binding
        holder.movieListItemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MovieListItemBinding movieListItemBinding;

        public ViewHolder(MovieListItemBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());
            this.movieListItemBinding = movieListItemBinding;

            // Set the click listener here or in the constructor
            this.movieListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle item click here
                }
            });
        }
    }
}
