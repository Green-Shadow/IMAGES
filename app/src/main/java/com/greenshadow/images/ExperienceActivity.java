package com.greenshadow.images;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ExperienceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] feedDataset = {};
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.feedRecyclerView);
        FeedAdapter feedAdapter = new FeedAdapter(feedDataset);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isInternetConnected()) {
                    Snackbar.make(view, "No internet connection", Snackbar.LENGTH_LONG)
                            .show();
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), AddPostActivity.class);
                    startActivityForResult(intent, 2);
                }
            }
        });
    }

    public boolean isInternetConnected(){
        ConnectivityManager cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

}
