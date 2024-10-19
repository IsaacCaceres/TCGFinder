package com.theryodangames.proyectologinbasico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Usuario extends AppCompatActivity {
    @Override
    //definir actividad para interfaz activity_usuario
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
    }
    public void onClickVolver(View view) {
        //inicio de actividad en clase Usuario
        Intent intent = new Intent(this, Profesional.class);
        startActivity(intent);
    }
    public void onClickRevisarMapa(View view){
        Intent intent = new Intent(this, Locations.class);
        startActivity(intent);
    }

}
