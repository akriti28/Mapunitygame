package com.example.mahe.mapunitygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity{

    ListView list;
    String[] itemname ={
            "Cities",
            "Museums"
    };

    Integer[] imgid={
            R.drawable.cities,
            R.drawable.museums,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Selecteditem = itemname[+position];
                Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();

                if (position == 0) {
                    Intent cities = new Intent(MainActivity.this, CitiesLevels.class);
                    startActivity(cities);
                }
                // else if (position == 1) {
                //  Intent  = new Intent(MainActivity.this, newActivity.class);
                //startActivity();

            }
        });
    }
}