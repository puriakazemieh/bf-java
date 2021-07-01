package com.example.batmanfilm.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.batmanfilm.R;
import com.example.batmanfilm.adapter.AdapterMovie;
import com.example.batmanfilm.adapter.AdapterRatings;
import com.example.batmanfilm.database.MovieDatabase;
import com.example.batmanfilm.model.DetailModel;
import com.example.batmanfilm.model.MoveDataModel;
import com.example.batmanfilm.model.RatingsItem;
import com.example.batmanfilm.util.isconnect;
import com.example.batmanfilm.viewmodel.DetailViewModel;
import com.example.batmanfilm.viewmodel.HomeViewModel;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailActivity extends AppCompatActivity {
    private String idOroduct;
    private ImageView poster;
    private TextView Title, Year, Rated, Released, Runtime, Genre, Director, Writer, Actors, Plot, Language, Country, Awards;
    private RecyclerView recyclerView;
    private TextView Metascore, imdbRating, imdbVotes, imdbID, Type, DVD, BoxOffice, Production, Website, Response;
    private DetailViewModel detailViewModel;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private AdapterRatings adapterRatings;
    private  MovieDatabase database;
    private int ratingSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailViewModel = new DetailViewModel();
        database = new MovieDatabase(this);
        idOroduct = getIntent().getStringExtra("id");
        //  Toast.makeText(this, idOroduct + "", Toast.LENGTH_SHORT).show();
        setView();

        if (isconnect.isNetworkAvilable(getApplicationContext())) {
            observe();
        } else {
            datafromDb();

        }
    }

    private void setView() {
        poster = findViewById(R.id.poster);
        Title = findViewById(R.id.title);
        Year = findViewById(R.id.year);
        Rated = findViewById(R.id.rated);
        Released = findViewById(R.id.relesed);
        Runtime = findViewById(R.id.runtime);
        Genre = findViewById(R.id.genre);
        Director = findViewById(R.id.director);
        Writer = findViewById(R.id.writer);
        Actors = findViewById(R.id.actors);
        Plot = findViewById(R.id.plot);
        Language = findViewById(R.id.language);
        Country = findViewById(R.id.country);
        Awards = findViewById(R.id.awards);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));


        Metascore = findViewById(R.id.metascore);
        imdbRating = findViewById(R.id.imdbRating);
        imdbVotes = findViewById(R.id.imdbVotes);
        imdbID = findViewById(R.id.imdbID);
        Type = findViewById(R.id.type);
        DVD = findViewById(R.id.dvd);
        BoxOffice = findViewById(R.id.boxOffice);
        Production = findViewById(R.id.production);
        Website = findViewById(R.id.website);
    }

    private void observe() {
        detailViewModel.latestProduct(idOroduct).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<DetailModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(DetailModel moveDataModel) {

                        ratingSize = moveDataModel.getRatings().size();

                        adapterRatings = new AdapterRatings(moveDataModel.getRatings());
                        recyclerView.setAdapter(adapterRatings);

                        detailModel(moveDataModel);

                        SaveToDB task = new SaveToDB();
                        task.execute(moveDataModel);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("sssssss  ", e.getMessage() + "");
                        // Toast.makeText(DetailActivity.this, "moveDataModel.getTitle()", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void datafromDb() {
        DetailModel resultItems1 = database.showDetail(idOroduct);
        detailModel(resultItems1);


        List<RatingsItem> resultItems = database.showDetilraiting(idOroduct);
       /* DetailModel bookModel = new DetailModel();
        bookModel.setResult(resultItems);*/

        adapterRatings = new AdapterRatings(resultItems);
        recyclerView.setAdapter(adapterRatings);
    }

    public void detailModel(DetailModel moveDataModel) {
        Picasso.get().load(moveDataModel.getPoster()).placeholder(R.drawable.ic_launcher_background).into(poster);
        Title.setText("Title: " + moveDataModel.getTitle());
        Year.setText("Year: " + moveDataModel.getYear());
        Rated.setText("Rated: " + moveDataModel.getRated());
        Released.setText("Released: " + moveDataModel.getReleased());
        Runtime.setText("Runtime: " + moveDataModel.getRuntime());
        Genre.setText("Genre: " + moveDataModel.getGenre());
        Director.setText("Director: " + moveDataModel.getDirector());
        Writer.setText("Writer: " + moveDataModel.getWriter());
        Actors.setText("Actors: " + moveDataModel.getActors());
        Plot.setText("Plot: " + moveDataModel.getPlot());
        Language.setText("Language: " + moveDataModel.getLanguage());
        Country.setText("Country: " + moveDataModel.getCountry());
        Awards.setText("Awards: " + moveDataModel.getTitle());


        Metascore.setText("Metascore: " + moveDataModel.getMetascore());
        imdbRating.setText("imdbRating: " + moveDataModel.getImdbRating());
        imdbVotes.setText("imdbVotes: " + moveDataModel.getImdbVotes());
        imdbID.setText("imdbID: " + moveDataModel.getImdbID());
        Type.setText("Type: " + moveDataModel.getType());
        DVD.setText("DVD: " + moveDataModel.getActors());
        BoxOffice.setText("BoxOffice: " + moveDataModel.getBoxOffice());
        Production.setText("Production: " + moveDataModel.getProduction());
        Website.setText("Website: " + moveDataModel.getWebsite());
        Awards.setText("Awards: " + moveDataModel.getAwards());
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    public class SaveToDB extends AsyncTask<DetailModel, DetailModel, Boolean> {

        @Override
        protected Boolean doInBackground(DetailModel... detailModels) {

            DetailModel resultItem1 = detailModels[0];
            database.addMoviewDetil(resultItem1);

            for (int i = 0; i < detailModels[0].getRatings().size(); i++) {
                RatingsItem resultItem = detailModels[0].getRatings().get(i);
                database.addMoviewDetilraiting(resultItem, idOroduct,ratingSize);
            }


            return true;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            database.close();
        }
    }
}