package com.example.edojs.etecapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class GetProductosActivity extends AppCompatActivity {

    String data = "";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_productos);
        //displayView();
    }/*
    private void displayView() {

        ////////////////////////////////////////////////////////////////
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String serverIP = pref.getString("serverIp", "nulo");
        String idPaciente = pref.getString("idPaciente", "nulo");


        String JsonURL = "http://" + serverIP + "/mavenproject1/webapi/crearCita/consultar?idPaciente="+idPaciente;

        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest arrayreq = new JsonArrayRequest(JsonURL,

                new Response.Listener<JSONArray>() {

                    // Takes the response from the JSON request
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int j = 0; j < response.length(); j++){

                                String dato = response.getString(j);
                                String[] parted = dato.split(",");

                            }

                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            //editor.putString("estados", "string");

                            editor.commit();

                            Intent buscarProductos = new Intent(getApplicationContext(), MostrarTipodeProductoActivity.class);
                            startActivity(buscarProductos);

                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );
        requestQueue.add(arrayreq);
    }*/
}
