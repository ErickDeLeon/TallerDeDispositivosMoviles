package com.example.a55provedoresdecontenidos;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    TextView txtResultados;
    DatabaseReference myRef;
    int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRef = FirebaseDatabase.getInstance().getReference("llamada");

        if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.INTERNET)) {
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.INTERNET}, MY_PERMISSIONS_REQUEST_READ_CONTACTS); }
        }
        txtResultados = findViewById(R.id.salida);
        if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, android.Manifest.permission.READ_CALL_LOG)) {
            } else {

                ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.READ_CALL_LOG}, MY_PERMISSIONS_REQUEST_READ_CONTACTS); }
        }

        String[] projection = new String[]{
                CallLog.Calls.TYPE,
                CallLog.Calls.NUMBER};

        Uri llamadasUri = CallLog.Calls.CONTENT_URI;

        ContentResolver cr = getContentResolver();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            return;
        }
        Cursor cur = cr.query(llamadasUri, projection, null, null, null);

        if (cur.moveToFirst())
        {
            int tipo;
            String tipoLlamada = "";
            String telefono;

            int colTipo = cur.getColumnIndex(CallLog.Calls.TYPE);
            int colTelefono = cur.getColumnIndex(CallLog.Calls.NUMBER);

            txtResultados.setText("");

            do
            {
                tipo = cur.getInt(colTipo);
                telefono = cur.getString(colTelefono);

                if(tipo == CallLog.Calls.INCOMING_TYPE)
                    tipoLlamada = "RECIBIDAS";
                else if(tipo == CallLog.Calls.OUTGOING_TYPE)
                    tipoLlamada = "REALIZADAS";
                else if(tipo == CallLog.Calls.MISSED_TYPE)
                    tipoLlamada = "PERDIDAS";

                addCallRegister(tipoLlamada,telefono);
                txtResultados.append(tipoLlamada + " - " + telefono + "\n");

            } while (cur.moveToNext());
        }
    }
    public void addCallRegister(String tipo, String telefono){
        if(!TextUtils.isEmpty(telefono)){
            String id = myRef.push().getKey();
            Llamada call = new Llamada(id, tipo, telefono);
            myRef.child(id).setValue(call);
        }

    }
}

