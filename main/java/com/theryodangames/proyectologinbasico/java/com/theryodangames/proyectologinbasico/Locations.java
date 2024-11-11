package com.theryodangames.proyectologinbasico;

import androidx.appcompat.app.AppCompatActivity;
//importar librerias
import android.preference.PreferenceManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.tileprovider.tilesource.XYTileSource;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Locations extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        MapView mapView = findViewById(R.id.mapsview);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);

        //variables fijas
        double euroCentroLatitud = -33.44209630462189;
        double euroCentroLongitud = -70.65045076444945;

        GeoPoint EuroCentroPoint = new GeoPoint(euroCentroLatitud, euroCentroLongitud);
        mapView.getController().setZoom(15.0);
        mapView.getController().setCenter(EuroCentroPoint);

        Marker marcadorEuro = new Marker(mapView);
        marcadorEuro.setPosition(EuroCentroPoint);
        marcadorEuro.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marcadorEuro.setTitle("EuroCentro, Santiago de Chile");
        marcadorEuro.setSnippet("Galería de videojuegos, anime y más.");
        marcadorEuro.setIcon(getResources().getDrawable(R.drawable.pngwin1));


        mapView.getOverlays().add(marcadorEuro);

        //segundo punto de prueba
        double leonesLatitud = -33.4221008796705;
        double leonesLongitud = -70.60882341812771;

        GeoPoint GaleriaLeonesPoint = new GeoPoint(leonesLatitud, leonesLongitud);
        Marker marcadorLeones = new Marker(mapView);
        marcadorLeones.setPosition(GaleriaLeonesPoint);
        marcadorLeones.setAnchor(0.2f, 0.4f);
        marcadorLeones.setInfoWindowAnchor(0.2f, 0.0f);
        marcadorLeones.setTitle("Galeria Los Leones, Santiago de Chile");
        marcadorLeones.setSnippet("Galería de videojuegos, anime y más.");
        marcadorLeones.setIcon(getResources().getDrawable(R.drawable.pngwin1));

        mapView.getOverlays().add(marcadorLeones);

        Polyline linea = new Polyline();
        linea.addPoint(EuroCentroPoint);
        linea.addPoint(GaleriaLeonesPoint);
        linea.setColor(0xFF0000FF);
        linea.setWidth(5);
        mapView.getOverlayManager().add(linea);

    }

    public void onClickRegresar(View view){
        Intent intent = new Intent(this, Usuario.class);
        startActivity(intent);
    }




}
