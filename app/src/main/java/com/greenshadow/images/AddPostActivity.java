package com.greenshadow.images;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddPostActivity extends AppCompatActivity {

    int MY_PERMISSIONS_REQUEST_CAMERA = 2;
    int MY_PERMISSIONS_REQUEST_AUDIO = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isInternetConnected()) {
                    Snackbar.make(view, "No internet connection", Snackbar.LENGTH_LONG)
                            .show();
                }
                else{
                    //TODO:Add post submission logic
                }
            }
        });
        Button addPhotoButton = (Button)findViewById(R.id.postAddPhotoButton);
        addPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                requestCameraPermission();
            }
        });
        Button addAudioButton = (Button)findViewById(R.id.postAddAudioButton);
        addAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                requestAudioPermission();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean isInternetConnected(){
        ConnectivityManager cm = (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    public void requestCameraPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);

            }
        }

    }

    public void requestAudioPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO)) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECORD_AUDIO},
                        MY_PERMISSIONS_REQUEST_AUDIO);

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECORD_AUDIO},
                        MY_PERMISSIONS_REQUEST_AUDIO);

            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            // Checks if camera permission granted
            case 2: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    addPhoto();
                } else {

                }
                return;
            }
            case 3: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    addAudio();
                } else {

                }
                return;
            }
        }
    }

    public void addPhoto(){
        Toast.makeText(this,"Add photo stub",Toast.LENGTH_LONG).show();
    }

    public void addAudio(){
        Toast.makeText(this,"Add audio stub",Toast.LENGTH_LONG).show();
    }

}
