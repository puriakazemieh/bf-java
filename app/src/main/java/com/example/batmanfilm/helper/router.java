package com.example.batmanfilm.helper;

import com.example.batmanfilm.model.RatingsItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class router {

    public static final String TAG = "  batmanfilm    ";

    public static final String URL = "http://www.omdbapi.com/";

    public static final class DATABASE {

        public static final String DB_NAME = "movie";
        public static final int DB_VERSION = 1;

        public static final String TABLE_MOVIE_HOME = "moviehome";
        public static final String TABLE_MOVIE_DETAIL = "moviedetail";
        public static final String TABLE_MOVIE_RAITNG = "moviedetailraiting";

        public static final String DROP_QUERY_HOME = "DROP TABLE IF EXIST " + TABLE_MOVIE_HOME;
        public static final String DROP_QUERY_DETAIL = "DROP TABLE IF EXIST " + TABLE_MOVIE_DETAIL;
        public static final String DROP_QUERY_RAITNG = "DROP TABLE IF EXIST " + TABLE_MOVIE_RAITNG;

        public static final String GET_HOME_QUERY = "SELECT * FROM " + TABLE_MOVIE_HOME;
        public static final String GET_RAITNG_QUERY = "SELECT * FROM " + TABLE_MOVIE_RAITNG;



        public static final String type = "type";
        public static final String year = "year";
        public static final String imdbID = "imdbID";
        public static final String poster = "poster";
        public static final String title = "title";


        public static final String CREATE_TABLE_HOME_QUERY = "CREATE TABLE " + TABLE_MOVIE_HOME + "" +
                "(" + type + " TEXT not null," +
                year + " TEXT not null," +
                imdbID + " TEXT not null," +
                title + " TEXT not null," +
                poster + " TEXT not null)";

        public static final String writer = "writer";
        public static final String genre = "genre";
        public static final String country = "country";
        public static final String dVD = "dVD";
        public static final String awards = "awards";
        public static final String response = "response";
        public static final String actors = "actors";
        public static final String director = "director";
        public static final String plot = "plot";
        public static final String released = "released";
        public static final String production = "production";
        public static final String rated = "rated";
        public static final String language = "language";
        public static final String runtime = "runtime";
        public static final String imdbVotes = "imdbVotes";
        public static final String imdbRating = "imdbRating";
        public static final String website = "website";
        public static final String boxOffice = "boxOffice";
        public static final String metascore = "metascore";

        public static final String CREATE_TABLE_DETAIL_QUERY = "CREATE TABLE " + TABLE_MOVIE_DETAIL + "" +
                "(" + type + " TEXT not null," +
                year + " TEXT not null," +
                title + " TEXT not null," +
                imdbID + " TEXT not null," +
                writer + " TEXT not null," +
                genre + " TEXT not null," +
                country + " TEXT not null," +
                dVD + " TEXT not null," +
                awards + " TEXT not null," +
                response + " TEXT not null," +
                actors + " TEXT not null," +
                director + " TEXT not null," +
                plot + " TEXT not null," +
                released + " TEXT not null," +
                production + " TEXT not null," +
                rated + " TEXT not null," +
                language + " TEXT not null," +
                runtime + " TEXT not null," +
                imdbVotes + " TEXT not null," +
                imdbRating + " TEXT not null," +
                website + " TEXT not null," +
                boxOffice + " TEXT not null," +
                metascore + " TEXT not null," +
                poster + " TEXT not null)";


        public static final String value = "Value";
        public static final String source = "Source";


        public static final String CREATE_TABLE_RATING_QUERY = "CREATE TABLE " + TABLE_MOVIE_RAITNG + "" +
                "(" + value + " TEXT not null," +
                imdbID + " TEXT not null," +
                source + " TEXT not null)";
    }

}
