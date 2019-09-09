package vn.edu.tdtu.example3.movies;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.tdtu.example3.R;

public class MovieActivity extends AppCompatActivity {
    List<Movie> movies = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        // Lookup the recyclerview in activity layout
        recyclerView = findViewById(R.id.rvMovies);

        // Create adapter passing in the sample user data
        MoviesAdapter mAdapter = new MoviesAdapter(movies);
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(mAdapter);
        // Set layout manager to position the items
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        // Initialize contacts
        populateMovieDetails();
        mAdapter.notifyDataSetChanged();

//        recyclerView.addOnItemTouchListener(new RecyclerItemListener(getApplicationContext(),
////                recyclerView, new RecyclerItemListener.RecyclerTouchListener() {
////            @Override
////            public void onClickItem(View v, int position) {
////                Toast.makeText(getApplicationContext(), "Clicked: " +
////                        movies.get(position).getMovieName(), Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onLongClickItem(View v, int position) {
////                Toast.makeText(getApplicationContext(), "Long Pressed: " +
////                        movies.get(position).getMovieName(), Toast.LENGTH_SHORT).show();
////
////            }
////        }));
    }

    private void populateMovieDetails() {
        movies.add(new Movie("The Shawshank Redemption", "Crime, Drama", 1994, 9.2));
        movies.add(new Movie("The Godfather", "Crime, Drama", 1972, 9.2));
        movies.add(new Movie("The Godfather: Part II", "Crime, Drama", 1974, 9.0));
        movies.add(new Movie("The Dark Knight", "Action, Crime, Drama", 2008, 9.0));
        movies.add(new Movie("12 Angry Men", "Crime, Drama", 1974, 8.9));
    }

}