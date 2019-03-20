package com.example.administrator.movieonline;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> MovieList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View MovieView;
        ImageView MovieImage;
        TextView MovieName;
        TextView MovieType;
        TextView RleaseTime;

        public ViewHolder(View view) {
            super(view);
            MovieView = view;
            MovieImage= (ImageView) view.findViewById(R.id.movie_poster);
            MovieName = (TextView) view.findViewById(R.id.movie_name);
            MovieType = (TextView) view.findViewById(R.id.movie_class);
            RleaseTime = (TextView) view.findViewById(R.id.release_time);
        }
    }

    public MovieAdapter(List<Movie> List) {
        MovieList = List;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.MovieView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Movie movie = MovieList.get(position);
                //Deal with the activity transform with intent

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = MovieList.get(position);
        //holder.MovieImage.setImageResource();
        holder.MovieName.setText("");
        holder.MovieType.setText("");
        holder.RleaseTime.setText("");

    }

    @Override
    public int getItemCount() {
        return MovieList.size();
    }
}
