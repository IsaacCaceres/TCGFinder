package com.theryodangames.proyectologinbasico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TiendaOwner extends AppCompatActivity {
    //Spinner rolesSpinner;
    TextView tiendaTextUser;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiendaowner);

        tiendaTextUser = findViewById(R.id.tiendaTextUser);

        //if(rolesSpinner.equals("Usuario")) {
            //inicio de actividad en clase Usuario
        //    tiendaTextUser.setVisibility(View.INVISIBLE);
        //}
    }
    public void onClickVolver(View view) {
        //inicio de actividad en clase Usuario
        Intent intent = new Intent(this, Usuario.class);
        startActivity(intent);
    }
    public void onClickFormTienda(View view){
        //inicio de actividad en clase TiendaForm
        Intent intent = new Intent(this, TiendaForm.class);
        startActivity(intent);
    }
}
