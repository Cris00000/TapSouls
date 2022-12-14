package com.example.tapsouls;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConexionFireBase {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Jugador jugador;

    public ConexionFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Jugadores");
    }

    public void anadirDatos(String correo, String nombre, String contrasena){
        jugador = new Jugador(correo,nombre,contrasena);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(jugador);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
