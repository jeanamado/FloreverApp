package com.example.florever;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class video extends AppCompatActivity {
     VideoView videoView;

    @Override

    /*Codigo realizado por: Lucia Lazo Portugal
    Con este codigo se quiere reproducir el video en una nueva actividad
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoView);

        Uri path = Uri.parse("android.resource://com.example.florever/" + R.raw.florever_video);

        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.setVideoURI(path);
        videoView.start();
    }

    public void onClickvolver(View view) {
        Intent a = new Intent( video.this, MainActivity.class);
        startActivity(a); }
}
