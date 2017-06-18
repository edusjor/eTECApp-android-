package com.example.edojs.etecapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class ElegirTipoDeOrdenamientoYPeticionActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_tipo_de_ordenamiento);
    }

    public void guardarString(String nombre, String dato){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(nombre, dato);
        editor.commit();
    }



    public void parametroDeBusquedaAlfabetico(View view){
        guardarString("paramDeBusqueda", "Alfabetico");
    }
    public void parametroDeBusquedaPrecio(View view){
        guardarString("paramDeBusqueda", "Precio");
    }




    public void tipoDeBusquedaBinaria(View view){
        guardarString("tipoDeBisqueda", "Binaria");
    }
    public void tipoDeBusquedaInterpolacion(View view){
        guardarString("tipoDeBusqueda", "Interpolacion");
    }




    public void tipoDeOrdenamientoAscendente(View view){
        guardarString("tipoDeOrdenamiento", "Ascendente");
    }
    public void tipoDeOrdenamientoDescendente(View view){
        guardarString("tipoDeOrdenamiento", "Descendente");
    }



    public void btnBubleSort(View view){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        Log.e("Entro","btnBSrt");
        getJsonProductos();
        String sinordenar = pref.getString("listaStrProductosTodos", "nulo");
        String[] ordenada = BubleSort.bubble_srtPRECIO(sinordenar);

        editor.putString("listaStrProductosTodos", "");
        editor.commit();
        String tipoDeOrdenamiento = pref.getString("tipoDeOrdenamiento", "nulo");

        if (tipoDeOrdenamiento=="Ascendente") {
            String listaOrdenada = "";
            for (int i = 0; i < ordenada.length; i++) {

                if (i + 1 < ordenada.length) {
                    listaOrdenada = listaOrdenada + ordenada[i] + ",";
                } else
                    listaOrdenada = listaOrdenada + ordenada[i];
            }

            editor.putString("listaStrProductosTodos", listaOrdenada);
            editor.commit();
        }
        if (tipoDeOrdenamiento=="Descendente") {
            String listaOrdenada = "";
            for (int i = 0; i < ordenada.length; i++) {

                if (i + 1 < ordenada.length) {
                    listaOrdenada = ","+ordenada[i]+ listaOrdenada;
                } else
                    listaOrdenada = ordenada[i]+ listaOrdenada;
            }

            editor.putString("listaStrProductosTodos", listaOrdenada);
            editor.commit();
        }



        Intent buscarYmostrarenLista = new Intent(getApplicationContext(), BuscarYmostrarListaActivity.class);
        startActivity(buscarYmostrarenLista);
    }






    public void getJsonProductos() {

        ////////////////////////////////////////////////////////////////
        ///
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String serverIP = pref.getString("serverIp", "nulo");



        String JsonURL = "http://"+serverIP+"/PruebaP3-2/ProductosResources/productos/getProductos";

        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest arrayreq = new JsonArrayRequest(JsonURL,

                new Response.Listener<JSONArray>() {

                    // Takes the response from the JSON request
                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            String lista="";
                            for (int j = 0; j < response.length(); j++){

                                JSONObject productos = response.getJSONObject(j);

                                // Get the current student (json object) data
                                String precio = productos.getString("precio");
                                String descripcion = productos.getString("descripcion");
                                String nombre_producto = productos.getString("nombre_producto");
                                String ID_producto = productos.getString("ID_producto");

                                if (j+1 < response.length()){
                                    lista= lista+ID_producto+";"+nombre_producto+";"+descripcion+";"+precio+",";
                                }else
                                    lista= lista+ID_producto+";"+nombre_producto+";"+descripcion+";"+precio;
                            }

                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("listaStrProductosTodos", lista);
                            editor.commit();



                            Log.e("Lista: ", lista);

                            Toast toast2 = Toast.makeText(getApplicationContext(),lista, Toast.LENGTH_LONG);
                            toast2.show();

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
    }


}





