package com.example.tapsouls;

public class Jugador {
    private String usuario;
    private String contrasena;
    private int monedas;
    private int nivel;
    private Objeto mejoras[];
    private int ataque;
    private int salud;
    private int imagen;

    public Jugador(String usuario, String contrasena){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.monedas = 0;
        this.nivel = 0;
        this.ataque = 5;
        this.salud = 100;
        this.imagen = R.drawable.caballero;
    }

    public Jugador(String usuario, String contrasena, int monedas, int nivel, int salud, int ataque, int imagen){
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.monedas = monedas;
        this.nivel = nivel;
        this.salud = salud;
        this.ataque = ataque;
        this.imagen = imagen;
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

    public Objeto[] getMejoras() {
        return mejoras;
    }

    public void setMejoras(Objeto[] mejoras) {
        this.mejoras = mejoras;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void obtenerRecompensa(int cantidad){
        this.monedas+=cantidad;
    }

    public void subirNivel(){
        this.nivel+=1;
    }
}
