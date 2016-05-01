package com.example.rajan.populormovie_1.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.rajan.populormovie_1.R;
import com.example.rajan.populormovie_1.data.AppConstants;
import com.example.rajan.populormovie_1.data.AppURLs;
import com.example.rajan.populormovie_1.httphelper.VolleyHelper;
import com.example.rajan.populormovie_1.model.Movie;
import com.example.rajan.populormovie_1.utilities.Utils;

public class DetailActivity extends BaseActivity {

    private ImageLoader imageLoader;
    private Movie selectedMovie;
    private NetworkImageView imgVBackdrop;
    private TextView tvMovieOverView, tvMovieTitle, tvRatingTitle, tvReleaseDate;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_detail);

        selectedMovie = getIntent().getParcelableExtra(AppConstants.INTENT_KEY_MOVIE_DETAIL);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {

        imageLoader = VolleyHelper.getInstance(mContext).getImageLoader();

        imgVBackdrop = (NetworkImageView) findViewById(R.id.imgVBackdrop);
        tvMovieOverView = (TextView) findViewById(R.id.tvMovieOverView);
        tvMovieTitle = (TextView) findViewById(R.id.tvMovieTitle);
        tvRatingTitle = (TextView) findViewById(R.id.tvRatingTitle);
        tvReleaseDate = (TextView) findViewById(R.id.tvReleaseDate);

        imgVBackdrop.setDefaultImageResId(R.drawable.no_preview_available);
        if (selectedMovie != null && !Utils.isStringEmpty(selectedMovie.getBackdropPath())) {
            String url = AppURLs.MOVIE_DB_POSTER_BASE_URL + selectedMovie.getBackdropPath();
            imgVBackdrop.setImageUrl(url, imageLoader);
        }

        tvMovieTitle.setText(selectedMovie.getOriginalTitle());

        if (!Utils.isStringEmpty(selectedMovie.getOverview())) {
            tvMovieOverView.setText(selectedMovie.getOverview());
        } else {
            tvMovieOverView.setText(getString(R.string.no_review));
        }


        String ratings = mContext.getString(R.string.rating_title) + " " + selectedMovie.getVoteAverage() + "/10";
        tvRatingTitle.setText(ratings);


        String date = getString(R.string.release_date_title) + " ";

        if (!Utils.isStringEmpty(selectedMovie.getReleaseDate())) {
            date = date + selectedMovie.getReleaseDate();
        } else {
            date = date + getString(R.string.not_available);
        }

        tvReleaseDate.setText(date);
    }

    @Override
    public void setListeners() {

    }

}

