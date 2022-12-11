package com.example.tapsouls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Jugador jugador = new Jugador("Prueba", "1234", 150, 17, 250, 5, R.drawable.caballero);
        TextView nombreJugador = (TextView) findViewById(R.id.nombreJugador);
        TextView nivel = (TextView) findViewById(R.id.nivel);
        TextView monedas = (TextView) findViewById(R.id.monedas);

        nombreJugador.setText(jugador.getUsuario());
        nivel.setText(String.valueOf(jugador.getNivel()));
        monedas.setText(String.valueOf(jugador.getMonedas()));

        Button clasificacion = (Button) findViewById(R.id.inventario);
        Button jugar = (Button) findViewById(R.id.jugar);

        clasificacion.setOnClickListener(new View.OnClickListener() {
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




    }
}