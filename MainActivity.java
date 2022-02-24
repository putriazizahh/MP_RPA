package com.example.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnhome(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void btnshorts(View view) {
        Intent intent = new Intent(MainActivity.this, Shorts.class);
        startActivity(intent);
    }

    public void btnsubs(View view) {
        Intent intent = new Intent( MainActivity.this, Subscriptions.class);
        startActivity(intent);
    }

    public void btnlbr(View view) {
        Intent intent = new Intent(MainActivity.this, Library.class);
        startActivity(intent);
    }

}
