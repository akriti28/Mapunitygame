package com.example.mahe.mapunitygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class CitiesGame3 extends AppCompatActivity {
    int i;
    int score=0;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities_game3);
        String next[] = {};
        final ArrayList<String[]> list3 =new ArrayList<String[]>();
        final Intent citieslevels = new Intent(getApplicationContext(), CitiesLevels.class);
        final TextView t1 = (TextView) findViewById(R.id.textView1);
        final TextView t2 = (TextView) findViewById(R.id.textView2);
        final TextView t0 = (TextView) findViewById(R.id.textView0);
        final EditText e1 = (EditText) findViewById(R.id.editText);
        final Button b = (Button) findViewById(R.id.button1);
        final TextView sc = (TextView)  findViewById(R.id.score);
        final Button idk = (Button) findViewById(R.id.button2);
        final Button hint = (Button) findViewById(R.id.button3);
        CSVReader reader = null;//Specify asset file name
        try {
            reader = new CSVReader(new InputStreamReader(getAssets().open("citiesL3.csv")));
        } catch (IOException e) {
            e.printStackTrace();
        }
//in open();
        for(;;) {
            try {
                next = reader.readNext();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(next != null) {
                list3.add(next);
            } else {
                break;
            }
        }
        Random rand = new Random();
        i = rand.nextInt(3819) + 1;
        t1.setText(list3.get(i)[1]);
        t2.setText(list3.get(i)[2]);



        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                if (e1.getText().toString().equalsIgnoreCase(list3.get(i)[0].toString()))
                {
                    if (flag==1) { flag=0; e1.setHint("Enter here"); }
                    t0.setText("Correct city!");
                    e1.setText("");
                    score=score+10;
                    sc.setText(String.valueOf(score));
                    SharedPreferences prefs3 = getSharedPreferences("myPrefs3", 0);
                    SharedPreferences.Editor editor = prefs3.edit();
                    editor.putInt("scores3", score);
                    editor.commit();
                }
                else if (flag!=1 && e1.getText().toString().equalsIgnoreCase(list3.get(i)[4].toString()))
                {
                    t0.setText("Correct country! The city is " +list3.get(i)[0].toString());
                    e1.setText("");
                    score=score+5;
                    sc.setText(String.valueOf(score));
                    SharedPreferences prefs3 = getSharedPreferences("myPrefs1", 0);
                    SharedPreferences.Editor editor = prefs3.edit();
                    editor.putInt("scores3", score);
                    editor.commit();


                }
                else
                {
                    if (flag==1) { flag=0; e1.setHint("Enter here"); }
                    t0.setText("Wrong! It's " + list3.get(i)[0].toString() + ", " + list3.get(i)[4].toString()); e1.setText("");
                  /*  score=score-5;
                    sc.setText(String.valueOf(score));
                    SharedPreferences prefs3 = getSharedPreferences("myPrefs3", 0);
                    SharedPreferences.Editor editor = prefs3.edit();
                    editor.putInt("scores3", score);
                    editor.commit(); */

                }
                Random rand = new Random();
                i = rand.nextInt(3819) + 1;
                t1.setText(list3.get(i)[1]);
                t2.setText(list3.get(i)[2]);

            }


        });

        /*   String sc1 =sc.getText().toString();
           Bundle bundle = new Bundle();
           bundle.putString("scores",sc1);
           citieslevels.putExtras(bundle);
*/

        idk.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (flag==1) { flag=0; e1.setHint("Enter here"); }
               // t0.setText("It's " + list3.get(i)[0].toString() + ", " + list3.get(i)[4].toString());
                t0.setText(" ");
                e1.setText("");
                Random rand = new Random();
                i = rand.nextInt(3819) + 1;
                t1.setText(list3.get(i)[1]);
                t2.setText(list3.get(i)[2]);

            }


        });

        hint.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                t0.setText("It's in " + list3.get(i)[4].toString());
                e1.setHint("Enter city only!");

                flag=1;

            }


        });

    }


}
