package com.example.tapsouls;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConexionFireBase {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public void conectar(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Jugadores");
    }

}
