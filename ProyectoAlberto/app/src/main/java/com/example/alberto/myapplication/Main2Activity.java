package com.example.alberto.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void adminUsuarios(View v){
        Intent ausuario = new Intent(this,AdminUsuarios.class);
        startActivity(ausuario);
    }

    public void adminTorneos(View v){
        Intent atorneo = new Intent(this,AdminTorneos.class);
        startActivity(atorneo);

    }

    public void menuPrincipal(View v){
        Intent amenuprincipal = new Intent(this,MainActivity.class);
        startActivity(amenuprincipal);

    }

}
