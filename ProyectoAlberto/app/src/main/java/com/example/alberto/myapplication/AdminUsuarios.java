package com.example.alberto.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminUsuarios extends AppCompatActivity {
    private EditText etcodigousuario,etnombreusuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_usuarios);
        etcodigousuario=(EditText)findViewById(R.id.etcodigousuario);
        etnombreusuario=(EditText)findViewById(R.id.etnombreusuario);
    }

    public void volverAdminusuario(View v){
        Intent volver= new Intent(this,Main2Activity.class);
        startActivity(volver);
    }

    public void crearUsuario(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdtorneos", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues vusuario = new ContentValues();
        String codusu=etcodigousuario.getText().toString();
        String nombre=etnombreusuario.getText().toString();
        vusuario.put("codusu",codusu);
        vusuario.put("nombre",nombre);
        bd.insert("usuarios",null,vusuario);
        bd.close();
        Toast.makeText(this, "Datos de usuario almacenados correctamente", Toast.LENGTH_SHORT).show();
    }


}
