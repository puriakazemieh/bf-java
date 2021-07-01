package com.example.batmanfilm.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.batmanfilm.helper.app;
import com.example.batmanfilm.helper.router;
import com.example.batmanfilm.model.DetailModel;
import com.example.batmanfilm.model.RatingsItem;
import com.example.batmanfilm.model.SearchItem;

import java.util.ArrayList;
import java.util.List;

public class MovieDatabase extends SQLiteOpenHelper {


    public MovieDatabase(@Nullable Context context) {
        super(context, router.DATABASE.DB_NAME, null, router.DATABASE.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(router.DATABASE.CREATE_TABLE_DETAIL_QUERY);
            db.execSQL(router.DATABASE.CREATE_TABLE_HOME_QUERY);
            db.execSQL(router.DATABASE.CREATE_TABLE_RATING_QUERY);
        } catch (SQLException e) {
            app.l(e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(router.DATABASE.DROP_QUERY_DETAIL);
        db.execSQL(router.DATABASE.DROP_QUERY_HOME);
        db.execSQL(router.DATABASE.DROP_QUERY_RAITNG);
        this.onCreate(db);
    }

    public void addMoviewHome(SearchItem searchItem) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(router.DATABASE.type, searchItem.getType());
        contentValues.put(router.DATABASE.year, searchItem.getYear());
        contentValues.put(router.DATABASE.imdbID, searchItem.getImdbID());
        contentValues.put(router.DATABASE.poster, searchItem.getPoster());
        contentValues.put(router.DATABASE.title, searchItem.getTitle());


        try {
            String d = "select * from " + router.DATABASE.TABLE_MOVIE_HOME + " where  " + router.DATABASE.imdbID + " = '" + searchItem.getImdbID() + "' ";
            Cursor cursor = db.rawQuery(d, null);

            if (cursor.getCount() == 0) {
                db.insert(router.DATABASE.TABLE_MOVIE_HOME, null, contentValues);
                app.l("qqqqqq     " + router.DATABASE.imdbID + "  " + searchItem.getImdbID());

            }


         /*   db.rawQuery(" INSERT INTO "+router.DATABASE.TABLE_NAME+" VALUES ( '"
                    + router.DATABASE.PRODUCT_ID + "', '"
                    + router.DATABASE.product_title + "', '"
                    + router.DATABASE.product_regular_price + "', '"
                    + router.DATABASE.product_sale_price + "', '"
                    + router.DATABASE.product_url + "', '"
                    + router.DATABASE.product_picture + "', '"
                    + router.DATABASE.PHOTO + "' "
                    + " ) ", null);*/

            //app.l("wwww     " + router.DATABASE.imdbID + "  " + searchItem.getImdbID());
            //  app.l(contentValues+"");

        } catch (Exception e) {
            app.l("ee " + e.getMessage());
        }
    }


    public List<SearchItem> showHome() {
        List<SearchItem> dataModelList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(router.DATABASE.GET_HOME_QUERY, null);

        while (cursor.moveToNext()) {

            SearchItem resultItem = new SearchItem();

            resultItem.setTitle(cursor.getString(cursor.getColumnIndex(router.DATABASE.title)));
            resultItem.setYear(cursor.getString(cursor.getColumnIndex(router.DATABASE.year)));
            resultItem.setImdbID(cursor.getString(cursor.getColumnIndex(router.DATABASE.imdbID)));
            resultItem.setPoster(cursor.getString(cursor.getColumnIndex(router.DATABASE.poster)));
            resultItem.setType(cursor.getString(cursor.getColumnIndex(router.DATABASE.type)));

            dataModelList.add(resultItem);
            app.l(dataModelList.size() + "  qqq");
        }
        return dataModelList;
    }


    public void addMoviewDetil(DetailModel detailModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(router.DATABASE.type, detailModel.getType());
        contentValues.put(router.DATABASE.year, detailModel.getYear());
        contentValues.put(router.DATABASE.imdbID, detailModel.getImdbID());
        contentValues.put(router.DATABASE.poster, detailModel.getPoster());
        contentValues.put(router.DATABASE.writer, detailModel.getWriter());
        contentValues.put(router.DATABASE.genre, detailModel.getGenre());
        contentValues.put(router.DATABASE.country, detailModel.getCountry());
        contentValues.put(router.DATABASE.dVD, detailModel.getDVD());
        contentValues.put(router.DATABASE.awards, detailModel.getAwards());
        contentValues.put(router.DATABASE.response, detailModel.getResponse());
        contentValues.put(router.DATABASE.actors, detailModel.getActors());
        contentValues.put(router.DATABASE.director, detailModel.getDirector());
        contentValues.put(router.DATABASE.plot, detailModel.getPlot());
        contentValues.put(router.DATABASE.released, detailModel.getReleased());
        contentValues.put(router.DATABASE.production, detailModel.getProduction());
        contentValues.put(router.DATABASE.rated, detailModel.getRated());
        contentValues.put(router.DATABASE.language, detailModel.getLanguage());
        contentValues.put(router.DATABASE.runtime, detailModel.getRuntime());
        contentValues.put(router.DATABASE.imdbVotes, detailModel.getImdbVotes());
        contentValues.put(router.DATABASE.imdbRating, detailModel.getImdbRating());
        contentValues.put(router.DATABASE.website, detailModel.getWebsite());
        contentValues.put(router.DATABASE.boxOffice, detailModel.getBoxOffice());
        contentValues.put(router.DATABASE.metascore, detailModel.getMetascore());
        contentValues.put(router.DATABASE.title, detailModel.getTitle());


        try {
            String d = "select * from " + router.DATABASE.TABLE_MOVIE_DETAIL + " where  " + router.DATABASE.imdbID + " = '" + detailModel.getImdbID() + "' ";
            Cursor cursor = db.rawQuery(d, null);

            if (cursor.getCount() == 0) {
                db.insert(router.DATABASE.TABLE_MOVIE_DETAIL, null, contentValues);
                app.l("qqqqqq     " + router.DATABASE.imdbID + "  " + detailModel.getImdbID());

            }


        } catch (Exception e) {
            app.l("ee " + e.getMessage());
        }
    }

    public DetailModel showDetail(String id) {
        // List<DetailModel> dataModelList = new ArrayList<>();
        String d = "select * from " + router.DATABASE.TABLE_MOVIE_DETAIL + " where  " + router.DATABASE.imdbID + " = '" + id + "' ";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(d, null);

        DetailModel resultItem = new DetailModel();
        while (cursor.moveToNext()) {

            resultItem.setTitle(cursor.getString(cursor.getColumnIndex(router.DATABASE.title)));
            resultItem.setYear(cursor.getString(cursor.getColumnIndex(router.DATABASE.year)));
            resultItem.setImdbID(cursor.getString(cursor.getColumnIndex(router.DATABASE.imdbID)));
            resultItem.setPoster(cursor.getString(cursor.getColumnIndex(router.DATABASE.poster)));
            resultItem.setType(cursor.getString(cursor.getColumnIndex(router.DATABASE.type)));
            resultItem.setWriter(cursor.getString(cursor.getColumnIndex(router.DATABASE.writer)));
            resultItem.setGenre(cursor.getString(cursor.getColumnIndex(router.DATABASE.genre)));
            resultItem.setCountry(cursor.getString(cursor.getColumnIndex(router.DATABASE.country)));
            resultItem.setAwards(cursor.getString(cursor.getColumnIndex(router.DATABASE.awards)));
            resultItem.setResponse(cursor.getString(cursor.getColumnIndex(router.DATABASE.response)));
            resultItem.setActors(cursor.getString(cursor.getColumnIndex(router.DATABASE.actors)));
            resultItem.setDirector(cursor.getString(cursor.getColumnIndex(router.DATABASE.director)));
            resultItem.setPlot(cursor.getString(cursor.getColumnIndex(router.DATABASE.plot)));
            resultItem.setReleased(cursor.getString(cursor.getColumnIndex(router.DATABASE.released)));
            resultItem.setProduction(cursor.getString(cursor.getColumnIndex(router.DATABASE.production)));
            resultItem.setRated(cursor.getString(cursor.getColumnIndex(router.DATABASE.rated)));
            resultItem.setLanguage(cursor.getString(cursor.getColumnIndex(router.DATABASE.language)));
            resultItem.setRuntime(cursor.getString(cursor.getColumnIndex(router.DATABASE.runtime)));
            resultItem.setImdbVotes(cursor.getString(cursor.getColumnIndex(router.DATABASE.imdbVotes)));
            resultItem.setImdbRating(cursor.getString(cursor.getColumnIndex(router.DATABASE.imdbRating)));
            resultItem.setWebsite(cursor.getString(cursor.getColumnIndex(router.DATABASE.website)));
            resultItem.setBoxOffice(cursor.getString(cursor.getColumnIndex(router.DATABASE.boxOffice)));
            resultItem.setMetascore(cursor.getString(cursor.getColumnIndex(router.DATABASE.metascore)));

        }
        return resultItem;
    }


    public void addMoviewDetilraiting(RatingsItem ratingsItem, String id, int ratingSize) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(router.DATABASE.value, ratingsItem.getValue());
        contentValues.put(router.DATABASE.source, ratingsItem.getSource());
        contentValues.put(router.DATABASE.imdbID, id);


        try {

            String d = "select * from " + router.DATABASE.TABLE_MOVIE_RAITNG + " where  " + router.DATABASE.imdbID + " = '" + id + "' ";
            Cursor cursor = db.rawQuery(d, null);

            if (cursor.getCount() < ratingSize) {

                db.insert(router.DATABASE.TABLE_MOVIE_RAITNG, null, contentValues);
                app.l("addMoviewDetilraiting     " + router.DATABASE.imdbID + "  " + id);
            }
            // }

        } catch (Exception e) {
            app.l("ee " + e.getMessage());
        }
    }


    public List<RatingsItem> showDetilraiting(String id) {
        List<RatingsItem> dataModelList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        String GET_RAITNG_QUERY = "SELECT * FROM " + router.DATABASE.TABLE_MOVIE_RAITNG
                + " where  " + router.DATABASE.imdbID + " = '" + id + "' ";
        Cursor cursor = db.rawQuery(GET_RAITNG_QUERY, null);

        while (cursor.moveToNext()) {

            RatingsItem resultItem = new RatingsItem();

            resultItem.setValue(cursor.getString(cursor.getColumnIndex(router.DATABASE.value)));
            resultItem.setSource(cursor.getString(cursor.getColumnIndex(router.DATABASE.source)));
            resultItem.setImdbID(cursor.getString(cursor.getColumnIndex(router.DATABASE.imdbID)));

            dataModelList.add(resultItem);
            app.l(dataModelList.size() + "  qqq");
        }
        return dataModelList;
    }
}
