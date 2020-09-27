package com.example.mahe.mapunitygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.mahe.mapunitygame.R.id.score;

public class CitiesLevels extends AppCompatActivity {
    int score1;
    int score2;
    int score3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities_levels);
        Button b1= (Button) findViewById(R.id.button1);
        Button b2= (Button) findViewById(R.id.button2);
        Button b3= (Button) findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent citiesgame1= new Intent(getApplicationContext(),CitiesGame1.class);
                startActivity(citiesgame1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent citiesgame2 = new Intent(getApplicationContext(),CitiesGame2.class);
                startActivity(citiesgame2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent citiesgame2 = new Intent(getApplicationContext(),CitiesGame3.class);
                startActivity(citiesgame2);
            }
        });

        final TextView t1 = (TextView) findViewById(R.id.textView1);
        final TextView t2 = (TextView) findViewById(R.id.textView2);
        final TextView t3 = (TextView) findViewById(R.id.textView3);
        final ImageButton ib1 = (ImageButton) findViewById(R.id.imageButton1);
        final ImageButton ib2 = (ImageButton) findViewById(R.id.imageButton2);
        final ImageButton ib3 = (ImageButton) findViewById(R.id.imageButton3);


        SharedPreferences prefs1 = getSharedPreferences("myPrefs1", 0);
        SharedPreferences prefs2 = getSharedPreferences("myPrefs2", 0);
        SharedPreferences prefs3 = getSharedPreferences("myPrefs3", 0);
        int sc1=0,sc2=0,sc3=0;

        sc1 = prefs1.getInt("scores1", sc1);
        if (sc1>score1) {
            t1.setText(String.valueOf(sc1));
            score1=sc1;
        }
        sc2 = prefs2.getInt("scores2", sc2);
        if (sc2>score2) {
            t2.setText(String.valueOf(sc2));
            score2=sc2;
        }
        sc3 = prefs3.getInt("scores3", sc3);
        if (sc3>score3) {
            t3.setText(String.valueOf(sc3));
            score3=sc3;
        }
       ib1.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    int sc1=0;
                    SharedPreferences prefs1 = getSharedPreferences("myPrefs1", 0);
                    sc1 = prefs1.getInt("scores1", sc1);
                    if (sc1>score1) {
                        t1.setText(String.valueOf(sc1));
                        score1=sc1;
                    }



                }
            });

        ib2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int sc2=0;
                SharedPreferences prefs2 = getSharedPreferences("myPrefs2", 0);
                sc2 = prefs2.getInt("scores2", sc2);
                if (sc2>score2) {
                    t2.setText(String.valueOf(sc2));
                    score2=sc2;
                }


            }
        });
        ib3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                int sc3=0;
                SharedPreferences prefs3 = getSharedPreferences("myPrefs3", 0);
                sc3 = prefs3.getInt("scores3", sc3);
                if (sc3>score3) {
                    t3.setText(String.valueOf(sc3));
                    score3=sc3;
                }


            }
        });

    }
}

