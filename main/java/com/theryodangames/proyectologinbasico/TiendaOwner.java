package com.theryodangames.proyectologinbasico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TiendaOwner extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiendaowner);
    }
    public void onClickVolver(View view) {
        //inicio de actividad en clase Usuario
        Intent intent = new Intent(this, Usuario.class);
        startActivity(intent);
    }
}
