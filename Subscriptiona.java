package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Subscriptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriptions);

    VideoView video;
    Button play;
    MediaController mediaController;

    video = findViewById(R.id.video);
    play = findViewById(R.id.play);
    mediaController = new MediaController(this);

    play.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.nct127);
            video.setVideoURI(uri);
            video.setMediaController(mediaController);
            mediaController.setAnchorView(video);
            video.start();
        }

        public void btnhome(View view) {
            Intent intent = new Intent(Subscriptions.this, MainActivity.class);
            startActivity(intent);
        }

        public void btnshorts(View view) {
            Intent intent = new Intent(Subscriptions.this, Shorts.class);
            startActivity(intent);
        }

        public void btnsubs(View view) {
            Intent intent = new Intent(Subscriptions.this, Subscriptions.class);
            startActivity(intent);
        }

        public void btnlbr(View view) {
            Intent intent = new Intent(Subscriptions.this, Library.class);
            startActivity(intent);
        }
    });
    }
}
