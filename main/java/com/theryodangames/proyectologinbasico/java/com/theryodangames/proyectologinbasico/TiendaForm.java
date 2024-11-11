package com.theryodangames.proyectologinbasico;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TiendaForm extends AppCompatActivity {

    EditText etRut, etNombre, etDireccion, etComuna;
    DataHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiendaform);

        dbHelper = new DataHelper(this);

        etRut = findViewById(R.id.etRut);
        etNombre = findViewById(R.id.etNombre);
        etDireccion = findViewById(R.id.etDireccion);
        etComuna = findViewById(R.id.etComuna);
        Button btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int rut = Integer.parseInt(etRut.getText().toString());
                    String nombre = etNombre.getText().toString();
                    String direccion = etDireccion.getText().toString();
                    String comuna = etComuna.getText().toString();

                    dbHelper.agregarTienda(rut, nombre, direccion, comuna);

                    Toast.makeText(TiendaForm.this, "Tienda guardada exitosamente", Toast.LENGTH_SHORT).show();

                    // Limpia los campos
                    etRut.setText("");
                    etNombre.setText("");
                    etDireccion.setText("");
                    etComuna.setText("");

                } catch (Exception e) {
                    Toast.makeText(TiendaForm.this, "Error al guardar la tienda", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
