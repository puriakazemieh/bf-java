package com.example.batmanfilm.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.batmanfilm.R;
import com.example.batmanfilm.adapter.AdapterMovie;
import com.example.batmanfilm.database.MovieDatabase;
import com.example.batmanfilm.helper.app;
import com.example.batmanfilm.model.MoveDataModel;
import com.example.batmanfilm.model.SearchItem;
import com.example.batmanfilm.util.isconnect;
import com.example.batmanfilm.viewmodel.HomeViewModel;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterMovie adapterMovie;
    private HomeViewModel homeViewModel;



    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MovieDatabase movieDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeViewModel = new HomeViewModel();
        recyclerView = findViewById(R.id.rc);
        movieDatabase=new MovieDatabase(this);

        if (isconnect.isNetworkAvilable(getApplicationContext())) {
            observe();
        } else {
            datafromDb();

        }

    }

    private void observe() {
        homeViewModel.latestProduct().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<MoveDataModel>() {
                    @Override
                    public void onSubscribe( Disposable d) {

                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess( MoveDataModel moveDataModel) {
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
                        adapterMovie = new AdapterMovie(moveDataModel);
                        recyclerView.setAdapter(adapterMovie);

                        saveInToDB task = new saveInToDB();
                        task.execute(moveDataModel);


                        Log.e("ffff  ",moveDataModel.search.toString());
                    }

                    @Override
                    public void onError( Throwable e) {


                        Toast.makeText(HomeActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("ffff  ",e.getMessage());
                    }
                });

    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();

    }


    private void datafromDb() {
        List<SearchItem> resultItems = movieDatabase.showHome();
        MoveDataModel bookModel = new MoveDataModel();
        bookModel.setSearch(resultItems);

        app.l(resultItems.size() + "");

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        adapterMovie = new AdapterMovie(bookModel);
        recyclerView.setAdapter(adapterMovie);

    }

    public class saveInToDB extends AsyncTask<MoveDataModel, MoveDataModel, Boolean> {

        @Override
        protected Boolean doInBackground(MoveDataModel... flowers) {
            for (int i = 0; i < flowers[0].getSearch().size(); i++) {
                SearchItem resultItem = flowers[0].getSearch().get(i);
                try {
                    InputStream inputStream = new URL(resultItem.getPoster()).openStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    resultItem.setPicture(bitmap);
                } catch (Exception e) {
                    app.l("   dddddddd   " + e.getMessage());
                }
                movieDatabase.addMoviewHome(resultItem);

            }
            return true;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            movieDatabase.close();
        }
    }
}