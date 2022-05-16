package com.example.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {
    boolean t;
    int i;
    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Button btnplay = findViewById(R.id.button2);
        timer = findViewById(R.id.timer);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmr();
            }
        });
    }

    public void play() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public boolean tmr(){
        t=true;
        i=0;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (t) {
                    try {
                        i++;
                        Thread.sleep(1000);
                        if(i==4){
                            play();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        public void run() {
                            timer.setText("" + i);
                        }
                    });
                }
            }
        };
        new Thread(runnable).start();
        return true;
    }
}
