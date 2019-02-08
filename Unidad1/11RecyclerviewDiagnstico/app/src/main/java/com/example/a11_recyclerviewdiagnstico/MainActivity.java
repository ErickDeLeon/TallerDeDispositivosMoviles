package com.example.a11_recyclerviewdiagnstico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] nombreAlumno = {"Erick De Leon",
            "Arleth",
            "Chava",
            "Sergio",
            "Juan",
            "Alejandra",
            "Sinahi"};
    String [] numControl = {"11111111", "2222222222", "333333333", "4444444444", "555555555", "6666666666", "7777777777"};
    String [] carrera = {"ITICS", "SISTEMAS", "IGE", "ADMON", "ARQUI", "CIVIL", "QUIMICA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        adapter = new RecyclerAdapter(nombreAlumno, numControl, carrera, this);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);
    }
}
