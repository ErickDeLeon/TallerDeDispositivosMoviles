package com.example.a12swipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class segundaPantalla extends AppCompatActivity {

    EditText campoNombreAlumno, campoNoControl, campoCarrera;
    Button actualizar, atras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        campoNombreAlumno = findViewById(R.id.campoNombreAlumno);
        campoNoControl = findViewById(R.id.campoNoControl);
        campoCarrera = findViewById(R.id.campoCarrera);
        actualizar = findViewById(R.id.actualizar);
        atras = findViewById(R.id.atras);

        //Recuperacion de datos del MainActivity
        final int pos = getIntent().getExtras().getInt("p");
        final String cadena = getIntent().getExtras().getString("c");


        String arreglo[] = cadena.split("&");
        String nombre = arreglo[0];
        String noControl = arreglo[1];
        String carrera = arreglo[2];
        campoNombreAlumno.setText(nombre);
        campoNoControl.setText(noControl);
        campoCarrera.setText(carrera);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarDatos(pos);
                // Toast.makeText(segundaPantalla.this, "Actualizaste los datos correctamente", Toast.LENGTH_LONG).show();
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    private void actualizarDatos(int p) {
        String cad = campoNombreAlumno.getText().toString() + "&" + campoNoControl.getText().toString()+ "&" + campoCarrera.getText().toString();
        Intent datosRetorno = new Intent();
        datosRetorno.putExtra("p", p);
        datosRetorno.putExtra("cad", cad);
        Toast.makeText(segundaPantalla.this, "Se actualizo correctamente", Toast.LENGTH_LONG).show();
        setResult(4, datosRetorno);
        finish();
    }
}
