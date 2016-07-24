package com.tutorialscache.customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 1. Create a String array for Country Names.
    String[] countryNames = new String[]{"Australia","Canada","Italy","United Kingdom","Brazil","Hong Kong","Yemen","Japan","Zambia","Usa"};

    // 2. Create a Image array for Flags.
    int [] countryFlags = new int[]{R.drawable.austarlia,R.drawable.canada,R.drawable.italy,R.drawable.united,R.drawable.brazil,R.drawable.hongkong,R.drawable.yemen,R.drawable.japan,R.drawable.zambia,R.drawable.usa};

    // 3. Custom Adapter
    CustomAdapter customAdapter;

    ListView customListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 4. Get reference to ListView where flags and countries images will be shown.
        customListView = (ListView) findViewById(R.id.customlistview);

        //5. Get reference to Custom Adapter (which we will create in next step)
        // CustomAdapter constructor is receiving three parameters. First One is Reference of MainActivity, Second One is countryNames Array and third one is flagImages array.
        customAdapter = new CustomAdapter(getApplicationContext(),countryNames,countryFlags);

        //6. Set custom Adapter on CustomListView
        customListView.setAdapter(customAdapter);

        //7. Show Country Name by clicking on Row Item of List
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),countryNames[position],Toast.LENGTH_SHORT).show();
            }
        });

    }
}
