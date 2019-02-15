package com.example.a12swipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.util.Attributes;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvEmptyTextView;
    private RecyclerView mRecyclerView;
    private ArrayList<YoutuberModel> mDataSet;
    String nombre, nocontrol, carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEmptyTextView = findViewById(R.id.empty_view);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDataSet = new ArrayList<>();
        loadData();

        if (mDataSet.isEmpty()) {
            mRecyclerView.setVisibility(View.GONE);
            tvEmptyTextView.setVisibility(View.VISIBLE);
        } else {
            mRecyclerView.setVisibility(View.VISIBLE);
            tvEmptyTextView.setVisibility(View.GONE);
        }

        SwipeRecyclerViewAdapter mAdapter = new SwipeRecyclerViewAdapter(this, mDataSet);

        ((SwipeRecyclerViewAdapter) mAdapter).setMode(Attributes.Mode.Single);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("RecyclerView", "onScrollStateChanged");

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

            int p = data.getIntExtra("p", 10);
            String cad = data.getStringExtra("cad");
            agregarAlArreglo(p, cad);

    }

    private void agregarAlArreglo(int p, String cad) {
        Toast.makeText(MainActivity.this, "hola", Toast.LENGTH_LONG).show();
    }

    public void loadData() {

        for (int i = 0; i <= 9; i++) {
            if (i == 0) {
                nombre="ERICK DE LEON";
                nocontrol="15400781";
                carrera = "ITICS";
                mDataSet.add(new YoutuberModel(nombre, nocontrol ,carrera));
            }
            if (i == 1) {
                nombre="ARLETH ACOSTA TORRES";
                nocontrol="15400777";
                carrera = "ITICS";
                mDataSet.add(new YoutuberModel(nombre, nocontrol , carrera));
            }
            if (i == 2) {
                nombre="EMMANUEL CERVANTES DIAZ";
                nocontrol="15400655";
                carrera = "IGE";
                mDataSet.add(new YoutuberModel(nombre, nocontrol , carrera));
            }
            if (i == 3) {
                nombre="GUILLERMO MEDINA MADERA";
                nocontrol="15400487";
                carrera = "ISC";
                mDataSet.add(new YoutuberModel(nombre, nocontrol, carrera));
            }
            if (i == 4) {
                nombre="ALEJANDRA GRANDE DE UÑA";
                nocontrol="154005448";
                carrera = "ADMON";
                mDataSet.add(new YoutuberModel(nombre, nocontrol , carrera));
            }
            if (i == 5) {
                nombre="SINAHI RODRIGUEZ RUIZ";
                nocontrol="15400793";
                carrera = "";
                mDataSet.add(new YoutuberModel(nombre, nocontrol, carrera));
            }

            if (i == 6) {
                nombre="DANIELA DELGADO GUZMAN";
                nocontrol="15400784";
                carrera = "IBQ";
                mDataSet.add(new YoutuberModel(nombre, nocontrol, carrera));
            }
            if (i == 7) {
                nombre="JUAN ANTONIO LOPEZ";
                nocontrol="15400795";
                carrera = "IE";
                mDataSet.add(new YoutuberModel(nombre, nocontrol, carrera));
            }
            if (i == 8) {
                nombre="SERGIO LOPEZ ROBLES";
                nocontrol="15400785";
                carrera = "ARQ";
                mDataSet.add(new YoutuberModel(nombre, nocontrol, carrera));
            }
            if (i == 9) {
                nombre="RICARDO LOPEZ PERALES";
                nocontrol="15400712";
                carrera = "IM";
                mDataSet.add(new YoutuberModel(nombre, nocontrol, carrera));
            }


        }
    }

}
