package com.example.tapsouls;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable {
    private String correo;
    private String usuario;
    private String contrasena;
    private int monedas;
    private int nivel;
    private ArrayList<Objeto> listaMejoras = new ArrayList<>();
    private ArrayList<Objeto> mejorasActuales = new ArrayList<>();
    private int ataque;
    private int defensa;
    private int salud;
    private int imagen;
    private int dps;
    private LevelManager progresoNiveles;

    public Jugador(){

    }

    public Jugador(String correo, String usuario, String contrasena){
        this.correo=correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.monedas = 0;

        this.listaMejoras.add(0, new Objeto("Aumentar ataque I","Aumenta el ataque 5 puntos", 150));
        this.listaMejoras.add(1, new Objeto("Aumentar ataque II","Aumenta el ataque 10 puntos", 300));
        this.listaMejoras.add(2, new Objeto("Aumentar ataque III","Aumenta el ataque 15 puntos", 600));
        this.listaMejoras.add(3,new Objeto("Aumentar ataque IV","Aumenta el ataque 20 puntos", 1200));
        this.listaMejoras.add(4,new Objeto("Aumentar ataque V","Aumenta el ataque 25 puntos", 2400));
        this.listaMejoras.add(5,new Objeto("Agotado","Has comprado todas las mejoras de ataque que quedaban", 0));

        this.listaMejoras.add(6,new Objeto("Aumentar defensa I","Aumenta la defensa 5 puntos", 150));
        this.listaMejoras.add(7,new Objeto("Aumentar defensa II","Aumenta la defensa 10 puntos", 300));
        this.listaMejoras.add(8,new Objeto("Aumentar defensa III","Aumenta la defensa 15 puntos", 600));
        this.listaMejoras.add(9,new Objeto("Aumentar defensa IV","Aumenta la defensa 20 puntos", 1200));
        this.listaMejoras.add(10,new Objeto("Aumentar defensa V","Aumenta la defensa 25 puntos", 2400));
        this.listaMejoras.add(11,new Objeto("Agotado","Has comprado todas las mejoras de defensa que quedaban", 0));

        this.listaMejoras.add(12,new Objeto("Ataque automático I","Quita 3 puntos más de vida al enemigo cada segundo", 150));
        this.listaMejoras.add(13,new Objeto("Ataque automático II","Quita 6 puntos más de vida al enemigo cada segundo", 300));
        this.listaMejoras.add(14,new Objeto("Ataque automático III","Quita 9 puntos más de vida al enemigo cada segundo", 600));
        this.listaMejoras.add(15,new Objeto("Ataque automático IV","Quita 12 puntos más de vida al enemigo cada segundo", 1200));
        this.listaMejoras.add(16,new Objeto("Ataque automático V","Quita 15 puntos más de vida al enemigo cada segundo", 2400));
        this.listaMejoras.add(17,new Objeto("Agotado","Has comprado todas las mejoras de daño por segundo que quedaban", 0));

        this.mejorasActuales.add(0,listaMejoras.get(0));
        this.mejorasActuales.add(1,listaMejoras.get(6));
        this.mejorasActuales.add(2,listaMejoras.get(12));

        this.nivel = 0;
        this.ataque = 500;
        this.defensa = 0;
        this.salud = 100;
        this.imagen = R.drawable.caballero;
        this.dps=10;
        this.progresoNiveles=new LevelManager();
    }

    public Jugador(String correo, String usuario, String contrasena, int monedas, int nivel, ArrayList<Objeto> listaMejoras, ArrayList<Objeto> mejorasActuales, int ataque, int defensa, int salud, int imagen, int dps, LevelManager progresoNiveles) {
        this.correo=correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.monedas = monedas;
        this.nivel = nivel;
        this.listaMejoras = listaMejoras;
        this.mejorasActuales = mejorasActuales;
        this.ataque = ataque;
        this.defensa = defensa;
        this.salud = salud;
        this.imagen = imagen;
        this.dps = dps;
        this.progresoNiveles = progresoNiveles;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public ArrayList<Objeto> getListaMejoras() {
        return listaMejoras;
    }

    public void setListaMejoras(ArrayList<Objeto> listaMejoras) {
        this.listaMejoras = listaMejoras;
    }

    public void setMejorasActuales(ArrayList<Objeto> mejorasActuales) {
        this.mejorasActuales = mejorasActuales;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public void setProgresoNiveles(LevelManager progresoNiveles) {
        this.progresoNiveles = progresoNiveles;
    }

    public ArrayList<Objeto> getMejorasActuales() {
        return mejorasActuales;
    }

    public int getAtaque() {
        return ataque;
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

    public int getDefensa() {
        return defensa;
    }

    public int getDps() {
        return dps;
    }

    public LevelManager getProgresoNiveles() {
        return progresoNiveles;
    }

    public void obtenerRecompensa(int cantidad){

        this.monedas+=cantidad;
    }

    public void subirNivel(){
        this.nivel+=1;
    }

    public void efectuarMejoraAtaque(){
        switch (this.mejorasActuales.get(0).getNombre()){
            case "Aumentar ataque I":
                this.ataque+=5;
                this.mejorasActuales.set(0, this.listaMejoras.get(1));
                break;
            case "Aumentar ataque II":
                this.ataque+=10;
                this.mejorasActuales.set(0,this.listaMejoras.get(2));
                break;
            case "Aumentar ataque III":
                this.ataque+=15;
                this.mejorasActuales.set(0,this.listaMejoras.get(3));
                break;
            case "Aumentar ataque IV":
                this.ataque+=20;
                this.mejorasActuales.set(0,this.listaMejoras.get(4));
                break;
            case "Aumentar ataque V":
                this.ataque+=25;
                this.mejorasActuales.set(0,this.listaMejoras.get(5));
                break;
            case "Agotado":
                break;
        }

        Log.d("TAG", String.valueOf(this.ataque));

    }

    public void efectuarMejoraDefensa(){
        switch (this.mejorasActuales.get(1).getNombre()){
            case "Aumentar defensa I":
                this.defensa+=5;
                this.mejorasActuales.set(1,this.listaMejoras.get(7));
                break;
            case "Aumentar defensa II":
                this.defensa+=10;
                this.mejorasActuales.set(1,this.listaMejoras.get(8));
                break;
            case "Aumentar defensa III":
                this.defensa+=15;
                this.mejorasActuales.set(1, this.listaMejoras.get(9));
                break;
            case "Aumentar defensa IV":
                this.defensa+=20;
                this.mejorasActuales.set(1,this.listaMejoras.get(10));
                break;
            case "Aumentar defensa V":
                this.defensa+=25;
                this.mejorasActuales.set(1,this.listaMejoras.get(11));
                break;
            case "Agotado":
                break;
        }
        Log.d("TAG", String.valueOf(this.defensa));
    }

    public void efectuarMejoraAutomatico(){
        switch (this.mejorasActuales.get(2).getNombre()){
            case "Ataque automático I":
                this.dps+=3;
                this.mejorasActuales.set(2,this.listaMejoras.get(13));
                break;
            case "Ataque automático II":
                this.dps+=6;
                this.mejorasActuales.set(2,this.listaMejoras.get(14));
                break;
            case "Ataque automático III":
                this.dps+=9;
                this.mejorasActuales.set(2,this.listaMejoras.get(15));
                break;
            case "Ataque automático IV":
                this.dps+=12;
                this.mejorasActuales.set(2,this.listaMejoras.get(16));
                break;
            case "Ataque automático V":
                this.dps+=15;
                this.mejorasActuales.set(2,this.listaMejoras.get(17));
                break;
            case "Agotado":
                break;
        }
        Log.d("TAG", String.valueOf(this.dps));
    }

    public void comprarMejora(int cantidad){
            this.monedas -= cantidad;
    }
}
