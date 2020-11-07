package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activeUser=0;
    boolean gameRunning = true;
    int gameState[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int[][] winningDimensions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playMethod(View view)
    {
        ImageView img = (ImageView) view;
      Button btn = (Button) findViewById(R.id.button);

        if(gameState[Integer.parseInt(img.getTag().toString())]==-1 && gameRunning ){
        img.setTranslationY(-500);
        Log.i("tag",img.getTag().toString());
        if(activeUser==0) {
            img.setImageResource(R.drawable.red);
            gameState[Integer.parseInt(img.getTag().toString())]=activeUser;
            if(checkWinner()) {
                Toast.makeText(getApplicationContext(), "Red Won", Toast.LENGTH_LONG).show();
                gameRunning = false;
                Log.i("Btn","Pressed");
              btn.setVisibility(View.VISIBLE);
            }
            activeUser=1;
        }
        else{
            img.setImageResource(R.drawable.yellow);
            gameState[Integer.parseInt(img.getTag().toString())]=activeUser;
            if(checkWinner()) {
                {
                    gameRunning=false;
                    Toast.makeText(getApplicationContext(), "Yellow Won", Toast.LENGTH_LONG).show();
                     btn.setVisibility(View.VISIBLE);
                }
            }
            activeUser=0;
        }
        img.animate().translationY(30).rotation(3600).setDuration(1000);}
        else
        {
            Toast.makeText(getApplication(),"You Can not Make changes to the Previous inputs",Toast.LENGTH_LONG).show();
        }
    }
    private boolean checkWinner(){
        for(int i=0;i<8;i+=1)
        {

            if((gameState[winningDimensions[i][0]]==gameState[winningDimensions[i][1]]) && (gameState[winningDimensions[i][0]]==gameState[winningDimensions[i][2]]) && gameState[winningDimensions[i][2]]!=-1 )
            return true;
        }
        return false;
    }


public void Replay(View view){
        Button btn  = (Button) findViewById(R.id.button);
    GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
    for(int i=0; i<gridLayout.getChildCount(); i++) {
        ImageView child = (ImageView)gridLayout.getChildAt(i);
        // do stuff with child view
        child.setImageDrawable(null);
    }
}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
