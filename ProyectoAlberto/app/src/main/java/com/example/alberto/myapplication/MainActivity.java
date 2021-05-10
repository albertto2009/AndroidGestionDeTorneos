package com.example.alberto.myapplication;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etusuario,etpass;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etusuario=(EditText)findViewById(R.id.etusuario);
        etpass=(EditText)findViewById(R.id.etpass);
        tv1=(TextView)findViewById(R.id.tv1);

    }

    public void segundoActivity(View v){
        String usuario=etusuario.getText().toString();
        String pass=etpass.getText().toString();

        //Los usuarios accederan con el codigo de su cuenta y su nombre a la aplicacion
        //El administrador tiene como contraseña root y usuario root
        if (usuario.equals("root")&&(pass.equals("root"))){
            Intent siguiente = new Intent(this,Main2Activity.class);
            startActivity(siguiente);

        }else {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bdtorneos", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String codigo = etusuario.getText().toString();
            Cursor fila = bd.rawQuery(
                    "select nombre from usuarios where codusu='" + codigo + "'", null
            );
            if (fila.moveToFirst()) {
                String contraseña=fila.getString(0);


                if (pass.equals(contraseña)){
                    Intent a = new Intent(this,usuarios.class);
                    a.putExtra("cod",codigo);
                    a.putExtra("contraseña",contraseña);
                    startActivity(a);
                }else
                    Toast.makeText(this, "Contraseña invalida", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "No se econtro usuario con ese codigo", Toast.LENGTH_SHORT);
                String contraseña=fila.getString(0);
                tv1.setText("Por si no recuerdas la contraseña "+contraseña);
        }
    }



}
