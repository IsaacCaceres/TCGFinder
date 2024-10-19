package com.theryodangames.proyectologinbasico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //definimos atributos
    private EditText usuarioEditTxt;
    private EditText contrasenaEditTxt;
    private Spinner spinnerOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazar atributos con ids del Activity
        usuarioEditTxt = findViewById(R.id.usuario);
        contrasenaEditTxt = findViewById(R.id.contrasenha);
        spinnerOpciones = findViewById(R.id.spinnerRoles);

        //Arreglo para el spinner
        String[] roles = {"Administrador de Tienda", "Usuario", "Profesional"};

        //Creamos un ArrayAdapter para poblar el spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        //asignar el arrayadapter al spinner
        spinnerOpciones.setAdapter(adapter);
    }

    //método para Boton ingreso de datos e ir a vista
    public void onClickAcceder(View view){
        //declarar variables para obtener datos
        String user = usuarioEditTxt.getText().toString().trim();
        String password = contrasenaEditTxt.getText().toString().trim();
        String rolesSpinner = spinnerOpciones.getSelectedItem().toString();
        //verificar vacio
        if(user.isEmpty()){
            Toast.makeText(this,"Ingresa un nombre de usuario", Toast.LENGTH_SHORT).show();
        }
        //verifico credenciales
        if(user.equals("ryutachi") && rolesSpinner.equals("Usuario")){
            //inicio de actividad en clase Usuario
            Intent intent = new Intent(this, Usuario.class);
            startActivity(intent);
        }else if (rolesSpinner.equals("Administrador de Tienda")){
            Intent intent = new Intent(this, TiendaOwner.class);
            startActivity(intent);
        } else if (rolesSpinner.equals("Profesional")) {
            Intent intent = new Intent(this, Profesional.class);
            startActivity(intent);
        } else {
            Toast.makeText(this,"Usuario y contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}