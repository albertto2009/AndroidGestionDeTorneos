package com.example.alberto.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AdminTorneos extends AppCompatActivity {
    private EditText etcodtorneo,etpremiotorneo;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_torneos);
        etcodtorneo=(EditText)findViewById(R.id.etcodtorneo);
        etpremiotorneo=(EditText)findViewById(R.id.etpremiotorneo);
        spinner=(Spinner)findViewById(R.id.spinner);
        String tipos[]={"League of legends","Counter Strike","Dota 2","Starcraft"};
        ArrayAdapter <String>adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,tipos);
        spinner.setAdapter(adapter);

    }

    public void volverAdmin(View v){
        Intent volver= new Intent(this,Main2Activity.class);
        startActivity(volver);
    }

    public void crearTorneo(View v){
       AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"bdtorneos",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod=etcodtorneo.getText().toString();
        String premio=etpremiotorneo.getText().toString();
        String tipo=spinner.getSelectedItem().toString();
        ContentValues registro=new ContentValues();
        registro.put("codtorneo",cod);
        registro.put("tipo",tipo);
        registro.put("premio",premio);
        bd.insert("torneos",null,registro);
        bd.close();
        Toast.makeText(this, "Torneo almacenado corerctamente", Toast.LENGTH_SHORT).show();


    }

}
