package com.example.gameclass;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class game2 extends AppCompatActivity {
    EditText t1, t2, n1,n2;
    TextView result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        t1 = findViewById(R.id.ty1);
        t2 = findViewById(R.id.ty2);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game2.character p1 = null, p2 = null;
                if (t1.getText().toString().equals("ranged")) {
                    p1 = new game2.character(90, 30, 45, 130, Integer.parseInt(n1.getText().toString()));
                } else if (t1.getText().toString().equals("melee")) {
                    p1 = new game2.character(45, 75, 70, 100, Integer.parseInt(n1.getText().toString()));
                }
                if (t2.getText().toString().equals("ranged")) {
                    p2 = new game2.character(90, 30, 45, 130, Integer.parseInt(n2.getText().toString()));
                } else if (t2.getText().toString().equals("melee")) {
                    p2 = new game2.character(45, 75, 70, 100, Integer.parseInt(n2.getText().toString()));
                }
                int lose1 = 0, lose2 = 0;
                double lose22 = ((p1.att * p1.troops) - (p2.def * p2.troops))/p2.hp;
                lose2 = (int)lose22;
                if(lose2 < 0){
                    lose2 = 0;
                }
                p2.troops = p2.troops - lose2;
                if(p2.troops < 0) {
                    p2.troops = 0;
                }
                if((p2.troops > 0) &&!(t1.equals("ranged")&&t2.equals("melee"))){
                    lose1 = Math.round((p2.att * p2.troops)/p1.hp);
                    if(lose1 < 0){
                        lose1 = 0;
                    }
                    p1.troops = p1.troops - lose1;
                    if(p1.troops < 0) {
                        p1.troops = 0;
                    }
                }
                result.setText("P1 Lose " + lose1 + " troops, with remaining of " +p1.troops+ " Troops, P2 lose " + lose2 + " Troops remaining of " + p2.troops + " Troops");
            }
        });
    }
    public class character{
        int att;
        int def;
        int hp;
        int price;
        int troops;

        public character(int a, int d, int h, int p, int t){
            this.att = a;
            this.def = d;
            this.hp = h;
            this.price = p;
            this.troops = t;
        }

        public int getAtt(){
            return att;
        }

    }


}
