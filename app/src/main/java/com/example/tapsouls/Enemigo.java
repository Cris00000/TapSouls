package com.example.tapsouls;

public class Enemigo {
    private String nombre;
    private int salud;
    private int imagen;
    private int ataque;
    private int defensa;
    private int recompensa;

    public Enemigo(String nombre, int salud, int imagen, int ataque, int defensa, int recompensa) {
        this.nombre = nombre;
        this.salud = salud;
        this.imagen = imagen;
        this.ataque = ataque;
        this.defensa = defensa;
        this.recompensa = recompensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }

    public void recibirDano(int ataqueJugador, int defensaEnemigo, int saludEnemigo){
        if (defensaEnemigo<ataqueJugador){
            if (saludEnemigo<=0){
                saludEnemigo=0;
            } else {
                saludEnemigo -= (ataqueJugador - defensaEnemigo);
                this.salud = saludEnemigo;
            }
        }
    }
}
