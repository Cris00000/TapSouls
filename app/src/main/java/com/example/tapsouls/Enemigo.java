package com.example.tapsouls;

import java.io.Serializable;

public class Enemigo implements Serializable {
    private int numero;
    private String nombre;
    private int salud;
    private int imagen;
    private int ataque;
    private int defensa;
    private int recompensa;

    public Enemigo(int numero, String nombre, int salud, int imagen, int ataque, int defensa, int recompensa) {
        this.numero=numero;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void recibirDano(int ataqueJugador){
        if (this.defensa<ataqueJugador){
            if (this.salud<=0){
                this.salud=0;
            } else {
                this.salud -= (ataqueJugador - this.defensa);
            }
        }
    }
}
