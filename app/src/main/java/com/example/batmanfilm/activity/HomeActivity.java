package com.example.batmanfilm.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.batmanfilm.R;
import com.example.batmanfilm.adapter.AdapterMovie;
import com.example.batmanfilm.model.MoveDataModel;
import com.example.batmanfilm.model.SearchItem;
import com.example.batmanfilm.viewmodel.HomeViewModel;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeViewModel = new HomeViewModel();
        recyclerView = findViewById(R.id.rc);


        observe();

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
                       // adapterMovie.setBannersList(moveDataModel);
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
}