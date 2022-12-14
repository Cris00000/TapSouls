package com.example.tapsouls;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroJuego extends AppCompatActivity {

    ConexionFireBase conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_juego);

        EditText inputCorreo = findViewById(R.id.introducirCorreo);
        EditText inputUsuario = findViewById(R.id.introducirCorreo);
        EditText inputContrasena = findViewById(R.id.introducirContrasena);

        conexion = new ConexionFireBase();

        Button botonRegistro = (Button) findViewById(R.id.botonRegistrarse);

        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String correo = String.valueOf(inputCorreo.getText());
                String usuario = String.valueOf(inputUsuario.getText());
                String contrasena = String.valueOf(inputContrasena.getText());



            }
        });
    }
}