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

public class usuarios extends AppCompatActivity {
    private EditText codusu,etcodt;
    private TextView tvinicio;
    private TextView tvtorneo,tvpremio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
        codusu=(EditText)findViewById(R.id.codusu);
        tvinicio=(TextView)findViewById(R.id.tvinicio);
        Bundle bundle=getIntent().getExtras();
        String codigo=bundle.getString("cod");
        String nombre=bundle.getString("contraseña");
        tvtorneo=(TextView)findViewById(R.id.tvtorneo);
        codusu.setText(codigo);
        tvinicio.setText("Bienvenido usuario: "+nombre);
        etcodt=(EditText)findViewById(R.id.etcodt);
        tvpremio=(TextView)findViewById(R.id.tvpremio);



    }

    public void torneo(View v){
        Bundle bundle=getIntent().getExtras();
        String nombre=bundle.getString("contraseña");
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"bdtorneos",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String codtorneo=etcodt.getText().toString();
        Cursor fila = bd.rawQuery(
                "select tipo,premio from torneos where codtorneo='"+codtorneo+"'",null
        );
        if (fila.moveToFirst()){
            Toast.makeText(this, "El usuario "+nombre+" ahora esta inscrito en el torneo de "+fila.getString(0), Toast.LENGTH_SHORT).show();
            tvtorneo.setText(fila.getString(0));
            tvpremio.setText(fila.getString(1));
        }else {
            Toast.makeText(this, "No es valido ese codigo de torneo, prueba con uno valido", Toast.LENGTH_SHORT).show();
        }

    }

    public void volver(View v){
        Intent a=new Intent(this,MainActivity.class);
        startActivity(a);
    }



}
