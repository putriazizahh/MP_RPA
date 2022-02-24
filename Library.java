package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Library extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
    }
    public void btnhome(View view) {
        Intent intent = new Intent(Library.this, MainActivity.class);
        startActivity(intent);
    }

    public void btnshorts(View view) {
        Intent intent = new Intent(Library.this, Shorts.class);
        startActivity(intent);
    }

    public void btnsubs(View view) {
        Intent intent = new Intent( Library.this, Subscriptions.class);
        startActivity(intent);
    }

    public void btnlbr(View view) {
        Intent intent = new Intent(Library.this, Library.class);
        startActivity(intent);
    }
}
