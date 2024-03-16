package com.developerrishit.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    //Material3.DayNight.NoActionBar
    int activePlayer = 0;
    int [] gamestate = {2,2,2,2,2,2,2,2,2};
    int winPositions [] [] ={ {0,1,2} , {3,4,5} , {6,7,8},
                              {0,3,6}, {1,4,7} , {2,5,8} ,
                              {0,4,8} , {2,4,6}};
    public void playerTap(View view){
    ImageView img = (ImageView) view;
    int tappedImage = Integer.parseInt(img.getTag().toString());
    /*if(!gameActive){
        gameReset(view);
    } */
    if(gamestate[tappedImage]==2 && gameActive){
        gamestate[tappedImage] = activePlayer;
        img.setTranslationY(-1000f);
        if(activePlayer == 0){
            img.setImageResource(R.drawable.x);
            TextView status = findViewById(R.id.status);
            status.setText("O's Turn - Tap to Play");
            activePlayer = 1;
        }
        else{
            img.setImageResource(R.drawable.o);
            TextView status = findViewById(R.id.status);
            status.setText("X's Turn - Tap to Play");
            activePlayer = 0;
        }
    img.animate().translationYBy(1000f).setDuration(300);
    }
    for( int[] winPosition : winPositions){
        if(gamestate[winPosition[0]] == gamestate[winPosition[1]] &&
                gamestate[winPosition[1]] == gamestate[winPosition[2]] &&
                 gamestate[winPosition[0]]!=2){
            gameActive = false;
            String winnerStr;
            if(gamestate[winPosition[0]]==0){
                winnerStr="X has won";
            }
            else {
                winnerStr="O has won";
            }
            TextView status = findViewById(R.id.status);
            status.setText(winnerStr);
        }
    }
    }
    public void gameReset(View view){
        gameActive = true;
        activePlayer=0;
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to Play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}