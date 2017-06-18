package com.example.edojs.etecapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ElegirCentroDistribucionActivity extends AppCompatActivity {


    private ListView lv1;
    List<String> myList = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_centro_distribucion);

        try {
            for (int i=0; i<20; i++){
                myList.add("Item Numero: "+i);
            }


            lv1 = (ListView) findViewById(R.id.listView_CentrosDeDistribucion);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
            lv1.setAdapter(adapter);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {

                }
            });
        }catch (Exception e){
            Log.e("Error","Error");

        }
    }



////////////////////////////////////////////////////////////////

    @Override
    public void onBackPressed()
    {
        // Añade más funciones si fuese necesario
        super.onBackPressed();  // Invoca al método
        Intent menu = new Intent(getApplicationContext(), MainMenuActivity.class);
        startActivity(menu);
    }
}
