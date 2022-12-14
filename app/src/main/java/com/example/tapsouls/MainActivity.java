package com.example.tapsouls;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_main);

        ConexionFireBase cb = new ConexionFireBase();

        Bundle bundle = getIntent().getExtras();
        String correo = bundle.getString("Correo");
        String contrasena = bundle.getString("Contrasena");

        cb.recuperarDatos(correo, contrasena);
        Log.d("TAG", ""+cb.getListaJugadores());

        Jugador jugador = VariablesGlobales.jugador;

        TextView nombreJugador = (TextView) findViewById(R.id.nombreJugador);
        TextView nivel = (TextView) findViewById(R.id.nivel);
        TextView monedas = (TextView) findViewById(R.id.monedas);

        nombreJugador.setText(jugador.getUsuario());
        nivel.setText(String.valueOf(jugador.getNivel()));
        monedas.setText(String.valueOf(jugador.getMonedas()));

        Button mejoras = (Button) findViewById(R.id.mejoras);
        Button jugar = (Button) findViewById(R.id.jugar);
        Button clasificacion = (Button) findViewById(R.id.botonClasificacion);

        mejoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.contenedor , Mejoras.class,null);
                transaction.commit();
            }
        });

        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.contenedor , JuegoPrincipal.class,null);
                transaction.commit();
            }
        });

        clasificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.contenedor , Clasificacion.class,null);
                transaction.commit();
            }
        });


    }
}