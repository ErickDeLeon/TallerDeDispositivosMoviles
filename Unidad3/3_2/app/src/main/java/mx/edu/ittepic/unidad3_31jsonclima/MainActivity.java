package mx.edu.ittepic.unidad3_31jsonclima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AsyncResponse  {

    ConexionWeb conexionWeb;
    TextView serie1,serie2, nombreSerie;
    EditText elegirSerie;
    Button consultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serie1=findViewById(R.id.series1);
        serie2=findViewById(R.id.series2);
        nombreSerie = findViewById(R.id.serie);
        consultar = findViewById(R.id.button);
        elegirSerie = findViewById(R.id.escogerSerie);
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CargarClima();
            }
        });
    }
    public void CargarClima() {
        try {
            conexionWeb = new ConexionWeb(MainActivity.this);
           String cad = "http://www.omdbapi.com/?t="+elegirSerie.getText().toString()+"&apikey=f8f6866f";

            URL direcciopn = new URL(cad);
            conexionWeb.execute(direcciopn);
        } catch (MalformedURLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void procesarRespuesta(String r) {
        try {

            JSONObject object = new JSONObject(r);

            serie1.setText("Titulo: " +object.getString("Title")+"\n\nAño: "+object.getString("Year")+"\nLanzamiento: "+object.getString("Released")+"\nGenero: "+object.get("Genre"));

            serie2.setText("\n\n"+"Actores: "+object.getString("Actors")+"\nTiempo: "+object.getString("Runtime")+"\nLenguaje: "+object.getString("Language")+"\nPaís: "+object.getString("Country")+"\nDiector: "+object.getString("Director")+"\nPremios: "+object.getString("Awards"));

        }catch (JSONException e){
            System.out.println(""+e);
        }


    }
}
