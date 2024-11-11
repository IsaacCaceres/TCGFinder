package com.theryodangames.proyectologinbasico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataHelper extends SQLiteOpenHelper {

    // Constructor simplificado solo con contexto
    public DataHelper(Context context) {
        super(context, "tiendas_db", null, 1); // Nombre y versión de la base de datos
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tiendastcg(id INTEGER PRIMARY KEY AUTOINCREMENT, rut INTEGER, nombre TEXT, direccion TEXT, comuna TEXT, nota INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tiendastcg");
        onCreate(db);
    }

    // Inserción de una tienda
    public void agregarTienda(int rut, String nombre, String direccion, String comuna) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("rut", rut);
        values.put("nombre", nombre);
        values.put("direccion", direccion);
        values.put("comuna", comuna);
        db.insert("tiendastcg", null, values);
        db.close();
    }

    // Carga de todas las tiendas
    public List<Tienda> cargarTiendas() {
        List<Tienda> tiendas = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tiendastcg", null);

        if (cursor.moveToFirst()) {
            do {
                Tienda tienda = new Tienda(
                        cursor.getInt(0),      // id
                        cursor.getInt(1),      // rut
                        cursor.getString(2),   // nombre
                        cursor.getString(3),   // direccion
                        cursor.getString(4)   // comuna
                );
                tiendas.add(tienda);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tiendas;
    }
}

