package com.theryodangames.proyectologinbasico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Profesional extends AppCompatActivity{
    private LinearLayout newsContainer;

    @Override
    //definir actividad para interfaz activity_usuario
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesional);

        // Obtener el LinearLayout dentro del ScrollView
        newsContainer = findViewById(R.id.noticiasContainer);

        // Ejecutar la tarea de scraping en un hilo separado (para evitar bloquear la UI)
        new ObtenerNoticiasTask().execute();
    }

    // AsyncTask para realizar el scraping en segundo plano
    private class ObtenerNoticiasTask extends AsyncTask<Void, Void, List<String>> {

        @Override
        protected List<String> doInBackground(Void... voids) {
            List<String> noticias = new ArrayList<>();
            try {
                // Conectar a la página de The Verge: Gaming o Engadget: Gaming
                Document doc = Jsoup.connect("https://vandal.elespanol.com/noticias/videojuegos").get();

                // Seleccionar los elementos que contienen los titulares de las noticias
                Elements titulares = doc.select("h2.c-entry-box--compact__title a");  // Selector CSS para los titulares

                // Recorrer los titulares y extraer el texto
                for (Element titular : titulares) {
                    noticias.add(titular.text());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return noticias;
        }

        @Override
        protected void onPostExecute(List<String> noticias) {
            super.onPostExecute(noticias);

            if (noticias.isEmpty()) {
                Toast.makeText(Profesional.this, "No se pudieron obtener noticias", Toast.LENGTH_SHORT).show();
                return;
            }

            // Añadir las noticias obtenidas al LinearLayout
            for (String noticia : noticias) {
                TextView newsTextView = new TextView(Profesional.this);
                newsTextView.setText(noticia);
                newsTextView.setPadding(16, 16, 16, 16);
                newsTextView.setTextSize(16);
                newsContainer.addView(newsTextView);
            }
        }
    }

    public void onClickBuscar(View view) {
        //inicio de actividad en clase Usuario
        Intent intent = new Intent(this, Usuario.class);
        startActivity(intent);
    }
}
