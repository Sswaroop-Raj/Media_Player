package com.example.media_player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    ListView listview;
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        arrayList = new ArrayList<String>();
        Field[] fields = R.raw.class.getFields();
        for(int i = 0;i< fields.length;i++){
            arrayList.add(fields[i].getName());
        }
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_2,android.R.id.text1,arrayList);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
               /*String songname = listview.getItemAtPosition(i).toString();
               Intent intent = new Intent(MainActivity.this,Activity_2.class);
               intent.putExtra("songs",arrayList.get(i));
               startActivity(intent);*/
               Bundle bundle = new Bundle();
               /*bundle.putStringArrayList("SongName", arrayList);*/

               Intent intent = new Intent(MainActivity.this,Activity_2.class);
               intent.putExtra("list", arrayList);
               intent.putExtras(bundle);
               startActivity(intent);


            }
        });


    }
}
