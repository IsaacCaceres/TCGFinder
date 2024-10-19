package com.theryodangames.proyectologinbasico;

import androidx.appcompat.app.AppCompatActivity;
//importar librerias
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import android.os.Bundle;

public class InitialThread extends AppCompatActivity {

    //definir variables de utilizacion de componentes
    private TextView texto1;
    private ImageView imagen1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_thread);

        //enlazar variables con id de componentes
        texto1 = findViewById(R.id.texto1);
        imagen1 = findViewById(R.id.imagen1);
        //crear y ejecutar hilo
        Thread hilol = new Thread(new Runnable() {
            @Override
            public void run() {
                //simular una operación que dure tiempo
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                //actualizar la interfaz del usuario
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //inicio de actividad en clase Usuario
                        Intent intent = new Intent(InitialThread.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });
        hilol.start();
    }
}
