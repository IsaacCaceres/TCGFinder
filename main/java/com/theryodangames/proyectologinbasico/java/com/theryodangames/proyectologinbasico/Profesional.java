package com.theryodangames.proyectologinbasico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Profesional extends AppCompatActivity{
    LinearLayout newsContainer;

    @Override
    //definir actividad para interfaz activity_usuario
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesional);

        //Configuramos el video para la reproduccion local
        VideoView videoView = findViewById(R.id.videoView);
        //Construimos una URI del video
        String videoPath = "android.resource://"+ getPackageName() + "/" + R.raw.pokemontcgtrailerexpansion;
        //Convierto la cadena en un URI
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        //Agrego controles de reproducción del video
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        //Vinculamos el controlador de video para mostrar en la app
        mediaController.setAnchorView(videoView);
        videoView.start();

        //Configuracion del WebView para cargar video de Yotube
        WebView webView = findViewById(R.id.noticiasContainer);
        //Obtengo la configuración del WebView
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //Agrego la URL del Video en formato embed
        String videoUrl = "https://vandal.elespanol.com/noticias/videojuegos";
        //Cargo el webView en la app
        webView.setWebViewClient(new WebViewClient());
        //Cargar la URL en el video del webView
        webView.loadUrl(videoUrl);

    }


    public void onClickBuscar(View view) {
        //inicio de actividad en clase Usuario
        Intent intent = new Intent(this, Usuario.class);
        startActivity(intent);
    }
}
