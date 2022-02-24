package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Shorts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shorts);
    }
    public void btnhome(View view) {
        Intent intent = new Intent(Shorts.this, MainActivity.class);
        startActivity(intent);
    }

    public void btnshorts(View view) {
        Intent intent = new Intent(Shorts.this, Shorts.class);
        startActivity(intent);
    }

    public void btnsubs(View view) {
        Intent intent = new Intent( Shorts.this, Subscriptions.class);
        startActivity(intent);
    }

    public void btnlbr(View view) {
        Intent intent = new Intent(Shorts.this, Library.class);
        startActivity(intent);
    }
}
