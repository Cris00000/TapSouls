package com.example.tapsouls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginJuego extends AppCompatActivity {

    ConexionFireBase conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_juego);

        Intent intent = new Intent(this, MainActivity.class);

        EditText inputCorreo = findViewById(R.id.introducirCorreo);
        EditText inputContrasena = findViewById(R.id.introducirContrasena);

        conexion = new ConexionFireBase();

        Button botonLogin = (Button) findViewById(R.id.botonInicioSesion);


        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String correo = String.valueOf(inputCorreo.getText());
                String contrasena = String.valueOf(inputContrasena.getText());

                intent.putExtra("Correo", correo);
                intent.putExtra("Contrasena", contrasena);
                startActivity(intent);

            }
        });

    }
}