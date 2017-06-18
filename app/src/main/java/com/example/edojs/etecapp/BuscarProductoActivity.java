package com.example.edojs.etecapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BuscarProductoActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_producto);


    }

    public void guardarPlainText(){
        editText = (EditText)findViewById(R.id.editText);
        if (editText.getText().toString() !=""){
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("ProductoABuscar", editText.getText().toString());
            editor.commit();
        }
        Toast toast2 = Toast.makeText(getApplicationContext(),editText.getText().toString(), Toast.LENGTH_LONG);
        toast2.show();
    }




    public void continuar(View view){
        guardarPlainText();

        Intent intent = new Intent(this, ElegirTipoDeOrdenamientoYPeticionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
