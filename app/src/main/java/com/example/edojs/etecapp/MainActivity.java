package com.example.edojs.etecapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void goMenu(View view){
        Intent goMenu = new Intent(getApplicationContext(), MainMenuActivity.class);
        startActivity(goMenu);
    }



}