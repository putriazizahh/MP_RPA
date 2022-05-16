package com.example.splashscreen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount;
  /*  private int player1Points;
    private int player2Points;
    private TextView textViewPlayer1, textviewPlayer2;*/
    private boolean chooseSign = true;
    private String playerOneSign, playerTwoSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /*textViewPlayer1 = findViewById(R.id.playerOneScore);
        textviewPlayer2 = findViewById(R.id.playerTwoScore);*/

        if (chooseSign) dialogChooseSide();
        else startGame();

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    private void dialogChooseSide() {
        AlertDialog.Builder chooseSideDialog = new AlertDialog.Builder(this);
        chooseSideDialog.setCancelable(false);
        chooseSideDialog.setTitle("Choose your side");
        chooseSideDialog.setPositiveButton("X", (dialogInterface, i) ->
                readyToPlay(dialogInterface, "X", "0"));
        chooseSideDialog.setNegativeButton("0", (dialogInterface, i) ->
                readyToPlay(dialogInterface, "0", "X"));
        chooseSideDialog.create().show();
    }

    private void readyToPlay(DialogInterface dialogInterface, String signOne, String signTwo) {
        dialogInterface.dismiss();
        playerOneSign = signOne;
        playerTwoSign = signTwo;
        chooseSign = false;
        startGame();
    }

    private void startGame(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                String buttonID = "btn_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (player1Turn) {
            ((Button) v).setText(playerOneSign);
        } else {
            ((Button) v).setText(playerTwoSign);
        }

        roundCount++;


        if(checkForWin()) {
            if (player1Turn) {
                Toast.makeText(this, "Player 1 Wins ", Toast.LENGTH_SHORT).show();
                nextLevel();
            }else {
                Toast.makeText(this, "Player 2 Wins ", Toast.LENGTH_SHORT).show();
                nextLevel();
            }
        } else if (roundCount == 9) {
            draw();
            draw();
        } else {
            player1Turn = !player1Turn;
        }
    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1]) &&
                    field[i][0].equals(field[i][2]) &&
                    !field[i][0].equals("")){
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i]) &&
                    field[0][i].equals(field[2][i]) &&
                    !field[0][i].equals("")){
                return true;
            }
        }

        if (field[0][0].equals(field[1][1]) &&
                field[0][0].equals(field[2][2]) &&
                !field[0][0].equals("")){
            return true;
        }

        if (field[0][2].equals(field[1][1]) &&
                field[0][2].equals(field[2][0]) &&
                !field[0][2].equals("")){
            return true;
        }
        return false;
    }

    /*private void player1Wins() {
        player1Points++;
        Toast.makeText(this, "Player 1 Wins ", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void player2Wins() {
        player2Points++;
        Toast.makeText(this, "Player 2 Wins ", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }*/

    private void draw(){
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    /*private void updatePointsText(){
        textViewPlayer1.setText(Integer.toString(player1Points));
        textviewPlayer2.setText(Integer.toString(player2Points));
    }*/

    private void resetBoard(){
        for (int i = 0 ; i < 3; i++){
            for(int j = 0; j < 3; j++){
                buttons[i][j].setText("");
            }
        }
        roundCount = 0;
        player1Turn = true;
    }

    private void resetGame() {
       /* player1Points=0;
        player2Points=0;*/
        /*updatePointsText();*/
        resetBoard();
        dialogChooseSide();
    }

    public void nextLevel() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount",roundCount);
        /*outState.putInt("player1Points",player1Points);
        outState.putInt("player2Points",player2Points);*/
        outState.putBoolean("player1Turn",player1Turn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        roundCount = savedInstanceState.getInt("roundCount");
        /*player1Points = savedInstanceState.getInt("player1Points");
        player2Points = savedInstanceState.getInt("player2Points");*/
        player1Turn = savedInstanceState.getBoolean("player1Turn");
    }
}
