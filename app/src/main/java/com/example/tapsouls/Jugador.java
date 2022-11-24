package com.example.tapsouls;

public class Jugador {
    private String usuario;
    private String contrasena;
    private int monedas;
    private int nivel;
    private Objeto objetos[];

    public Jugador(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.monedas = 0;
        this.nivel = 0;
    }

    public Jugador(String usuario, String contrasena, int monedas, int nivel){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.monedas = monedas;
        this.nivel = nivel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Objeto[] getObjetos() {
        return objetos;
    }
}
