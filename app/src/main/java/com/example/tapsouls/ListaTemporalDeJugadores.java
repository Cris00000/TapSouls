package com.example.tapsouls;

public class ListaTemporalDeJugadores {
    Jugador[] jugadores = new Jugador[10];
    public ListaTemporalDeJugadores(){
        jugadores[0]=new Jugador("Pepito@pepito.com", "Pepito", "1234");
        jugadores[1]=new Jugador("sdafsdaf","Pepita", "1234");
        jugadores[2]=new Jugador("asdfjkshakf", "Mauricio", "1234");
        jugadores[3]=new Jugador("sdfsadfsaf","Shrek", "1234");
        jugadores[4]=new Jugador("dsklafjksdf","Fiona", "1234");
        jugadores[5]=new Jugador("dsklafjksdf","Pepito", "1234");
        jugadores[6]=new Jugador("dsklafjksdf","Pepita", "1234");
        jugadores[7]=new Jugador("dsklafjksdf","Mauricio", "1234");
        jugadores[8]=new Jugador("dsklafjksdf","Shrek", "1234");
        jugadores[9]=new Jugador("dsklafjksdf","Fiona", "1234");
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }
}
