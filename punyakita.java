package com.example.coba;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText troops1, troops2;
    TextView result;
    CheckBox ranged1, melee1, ranged2, melee2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        troops1 = (EditText) findViewById(R.id.troops1);
        troops2 = (EditText) findViewById(R.id.troops2);
        result = (TextView) findViewById(R.id.result);
        ranged1 = (CheckBox) findViewById(R.id.ranged1);
        ranged2 = (CheckBox) findViewById(R.id.ranged2);
        melee1 = (CheckBox) findViewById(R.id.melee1);
        melee2 = (CheckBox) findViewById(R.id.melee2);
    }

    public class menu {
        int attack, defense, health, price, troops;

        public menu(int a, int d, int h, int p, int t) {
            this.attack = a;
            this.defense = d;
            this.health = h;
            this.price = p;
            this.troops = t;
        }
    }

    public void enter(View v) {
        menu P1 = null, P2 = null;

        if (ranged1.isChecked() && !melee1.isChecked()) {
            P1 = new menu(90, 30, 45, 130, Integer.parseInt(troops1.getText().toString()));
        } else if (melee1.isChecked() && !ranged1.isChecked()) {
            P1 = new menu(45, 75, 70, 100, Integer.parseInt(troops1.getText().toString()));
        }
        if (ranged2.isChecked()) {
            P2 = new menu(90, 30, 45, 130, Integer.parseInt(troops2.getText().toString()));
        } else if (melee2.isChecked()) {
            P2 = new menu(45, 75, 70, 100, Integer.parseInt(troops2.getText().toString()));
        }

        int lose1 = 0, lose2 = 0;
        double losee2 = ((P1.attack * P1.troops) - (P2.defense * P2.troops)) / P2.health;
        lose2 = (int) losee2;
        if (lose2 < 0) {
            lose2 = 0;
        }
        P2.troops = P2.troops - lose2;
        if (P2.troops < 0) {
            P2.troops = 0;
        }
        if ((P2.troops > 0) &&! (ranged1.isChecked() && melee2.isChecked())) {
            lose1 = Math.round((P2.attack * P2.troops) / P1.health);
            if (lose1 < 0) {
                lose1 = 0;
            }
            P1.troops = P1.troops - lose1;
            if (P1.troops < 0) {
                P1.troops = 0;
            }
        }
        result.setText("P1 : Lose " + lose1 + " troops, remaining " + P1.troops + " troops." +
                        "\n" + "P2 : Lose " + lose2 + " troops, remaining " + P2.troops + " troops");
        result.setGravity(Gravity.CENTER);
    }
}
