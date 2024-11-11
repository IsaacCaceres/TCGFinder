package com.theryodangames.proyectologinbasico;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Usuario extends AppCompatActivity {
    //variables
    DataHelper dbHelper;

    @Override
    //definir actividad para interfaz activity_usuario
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        //Creo un MediaPlayer para reproducir el sonido
        MediaPlayer mediaPlayer = MediaPlayer.create(Usuario.this, R.raw.pokemonhomemenutheme);
        //Inicio la reproducción
        mediaPlayer.start();
        //Listener para liberar recursos cuando sonido termine
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release(); //Libero recursos cuando el sonido termine
            }
        });

        dbHelper = new DataHelper(this);
        LinearLayout containerTiendas = findViewById(R.id.containerTiendas);

        List<Tienda> tiendas = dbHelper.cargarTiendas();

        for (Tienda tienda : tiendas) {
            TextView tvTienda = new TextView(this);
            tvTienda.setText(
                            tienda.getNombre() +
                            "\nDirección: " + tienda.getDireccion() +
                            "\nComuna: " + tienda.getComuna()
            );
            containerTiendas.addView(tvTienda);
        }
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
