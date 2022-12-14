package com.example.tapsouls;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ConexionFireBase {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<Jugador> listaJugadores = null;
    Jugador jugador = new Jugador();

    public ConexionFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Jugadores");
    }

    public void anadirDatos(String correo, String nombre, String contrasena){
        String userID = UUID.randomUUID().toString();
        databaseReference = firebaseDatabase.getReference("Jugadores").child(userID);
        jugador = new Jugador(correo,nombre,contrasena);
        databaseReference.setValue(jugador);
        Log.d("TAG", "Usuario insertado");
    }

    public void recuperarDatos(String correo, String contrasena){

        Gson gson = new Gson();
        ArrayList<Objeto> mejorasActuales = null;
        ArrayList<Objeto> listaMejoras = null;

        Log.d("TAG", "He entrado aquí");
        databaseReference = firebaseDatabase.getReference("Jugadores");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.d("TAG", "OnChildAdded: " + snapshot.getValue());
                JsonElement jsonElement = gson.toJsonTree(snapshot.getValue());
                Jugador jugador = gson.fromJson(jsonElement, Jugador.class);
                Log.d("TAG", ""+jugador.toString());
                if(correo.equals(jugador.getCorreo())&&contrasena.equals(jugador.getContrasena())){
                    VariablesGlobales.jugador=jugador;
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public Jugador comprobarJugador(String correo,String contrasena){
        Log.d("TAG", "He entrado aquí parte 2");
        for(Jugador jugadores : listaJugadores){
            Log.d("TAG", "he entrado en este for");
            if (jugadores.getCorreo().equals(correo) && jugadores.getContrasena().equals(contrasena)){
                Log.d("TAG", "he entrado en este if");
                return jugadores;
            }
        }
        return null;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return this.listaJugadores;
    }
}
