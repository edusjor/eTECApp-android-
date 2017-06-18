package com.example.edojs.etecapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class BuscarYmostrarListaActivity extends AppCompatActivity {

    private ListView lv;

    ArrayAdapter<String> adapter;

    EditText inputSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_productos);

        Log.e("error:","1");

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String listaStrProductosTodos = pref.getString("listaStrProductosTodos", "nulo");

        String[] tokens=listaStrProductosTodos.split(",");




        









        // Arreglo de codigos de proyecto.
        //String tokens[] = {"ABCD","BCD","EDFT","JGUR","AJHE","IKQ2","LKWW","W4T6","EMA1"};

        lv = (ListView) findViewById(R.id.list_view);
        lv.setTextFilterEnabled(true);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        adapter = new ArrayAdapter<String>(this,R.layout.list_item, R.id.codigo_token,tokens);
        lv.setAdapter(adapter);
        Log.e("error:","2");


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {
                Toast.makeText(getApplicationContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();

            }

        });
        Log.e("error:","3 ");

        /* Activando el filtro de busqueda */
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

                BuscarYmostrarListaActivity.this.adapter.getFilter().filter(arg0);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub

            }
        });

    }


}

