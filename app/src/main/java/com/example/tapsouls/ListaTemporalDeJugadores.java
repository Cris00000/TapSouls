package com.example.tapsouls;

public class ListaTemporalDeJugadores {
    Jugador[] jugadores = new Jugador[10];
    public ListaTemporalDeJugadores(){
        jugadores[0]=new Jugador("Pepito", "1234");
        jugadores[1]=new Jugador("Pepita", "1234");
        jugadores[2]=new Jugador("Mauricio", "1234");
        jugadores[3]=new Jugador("Shrek", "1234");
        jugadores[4]=new Jugador("Fiona", "1234");
        jugadores[5]=new Jugador("Pepito", "1234");
        jugadores[6]=new Jugador("Pepita", "1234");
        jugadores[7]=new Jugador("Mauricio", "1234");
        jugadores[8]=new Jugador("Shrek", "1234");
        jugadores[9]=new Jugador("Fiona", "1234");
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }
}
