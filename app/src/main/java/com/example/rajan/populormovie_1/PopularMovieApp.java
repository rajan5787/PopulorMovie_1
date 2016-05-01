package com.example.rajan.populormovie_1;

import android.app.Application;

import com.example.rajan.populormovie_1.data.AppConstants;


public class PopularMovieApp extends Application{

    @Override
    public void onCreate() {

        if(AppConstants.MOVIE_DB_API_KEY.equalsIgnoreCase(AppConstants.DUMMY_API_MSG)){
           // throw new ValidAPIKeyException("Please enter your 'The Movie DB' API key in " + AppConstants.class.getSimpleName() + ".java file.");
        }

        super.onCreate();
    }
}
