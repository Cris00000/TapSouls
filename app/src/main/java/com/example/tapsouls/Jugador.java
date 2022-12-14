package com.example.tapsouls;

import android.util.Log;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String correo;
    private String usuario;
    private String contrasena;
    private int monedas;
    private int nivel;
    private Objeto listaMejoras[][] = new Objeto[3][6];
    private Objeto mejorasActuales[] = new Objeto[3];
    private int ataque;
    private int defensa;
    private int salud;
    private int imagen;
    private int dps;
    private LevelManager progresoNiveles;

    public Jugador(String correo, String usuario, String contrasena){
        this.correo=correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.monedas = 0;

        this.listaMejoras[0][0]=new Objeto("Aumentar ataque I","Aumenta el ataque 5 puntos", 150);
        this.listaMejoras[0][1]=new Objeto("Aumentar ataque II","Aumenta el ataque 10 puntos", 300);
        this.listaMejoras[0][2]=new Objeto("Aumentar ataque III","Aumenta el ataque 15 puntos", 600);
        this.listaMejoras[0][3]=new Objeto("Aumentar ataque IV","Aumenta el ataque 20 puntos", 1200);
        this.listaMejoras[0][4]=new Objeto("Aumentar ataque V","Aumenta el ataque 25 puntos", 2400);
        this.listaMejoras[0][5]=new Objeto("Agotado","Has comprado todas las mejoras de ataque que quedaban", 0);

        this.listaMejoras[1][0]=new Objeto("Aumentar defensa I","Aumenta la defensa 5 puntos", 150);
        this.listaMejoras[1][1]=new Objeto("Aumentar defensa II","Aumenta la defensa 10 puntos", 300);
        this.listaMejoras[1][2]=new Objeto("Aumentar defensa III","Aumenta la defensa 15 puntos", 600);
        this.listaMejoras[1][3]=new Objeto("Aumentar defensa IV","Aumenta la defensa 20 puntos", 1200);
        this.listaMejoras[1][4]=new Objeto("Aumentar defensa V","Aumenta la defensa 25 puntos", 2400);
        this.listaMejoras[1][5]=new Objeto("Agotado","Has comprado todas las mejoras de defensa que quedaban", 0);

        this.listaMejoras[2][0]=new Objeto("Ataque automático I","Quita 3 puntos más de vida al enemigo cada segundo", 150);
        this.listaMejoras[2][1]=new Objeto("Ataque automático II","Quita 6 puntos más de vida al enemigo cada segundo", 300);
        this.listaMejoras[2][2]=new Objeto("Ataque automático III","Quita 9 puntos más de vida al enemigo cada segundo", 600);
        this.listaMejoras[2][3]=new Objeto("Ataque automático IV","Quita 12 puntos más de vida al enemigo cada segundo", 1200);
        this.listaMejoras[2][4]=new Objeto("Ataque automático V","Quita 15 puntos más de vida al enemigo cada segundo", 2400);
        this.listaMejoras[2][5]=new Objeto("Agotado","Has comprado todas las mejoras de daño por segundo que quedaban", 0);

        this.mejorasActuales[0]=listaMejoras[0][0];
        this.mejorasActuales[1]=listaMejoras[1][0];
        this.mejorasActuales[2]=listaMejoras[2][0];

        this.nivel = 0;
        this.ataque = 500;
        this.defensa = 0;
        this.salud = 100;
        this.imagen = R.drawable.caballero;
        this.dps=10;
        this.progresoNiveles=new LevelManager();
    }

    public Jugador(String correo, String usuario, String contrasena, int monedas, int nivel, Objeto[][] listaMejoras, Objeto[] mejorasActuales, int ataque, int defensa, int salud, int imagen, int dps, LevelManager progresoNiveles) {
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

    public Objeto[] getMejorasActuales() {
        return mejorasActuales;
    }

    public void setMejorasActuales(Objeto[] mejoras) {
        this.mejorasActuales = mejoras;
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

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getDps() {
        return dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public LevelManager getProgresoNiveles() {
        return progresoNiveles;
    }

    public void setProgresoNiveles(LevelManager progresoNiveles) {
        this.progresoNiveles = progresoNiveles;
    }

    public void obtenerRecompensa(int cantidad){

        this.monedas+=cantidad;
    }

    public void subirNivel(){
        this.nivel+=1;
    }

    public void efectuarMejoraAtaque(){
        switch (this.mejorasActuales[0].getNombre()){
            case "Aumentar ataque I":
                this.ataque+=5;
                this.mejorasActuales[0]=this.listaMejoras[0][1];
                break;
            case "Aumentar ataque II":
                this.ataque+=10;
                this.mejorasActuales[0]=this.listaMejoras[0][2];
                break;
            case "Aumentar ataque III":
                this.ataque+=15;
                this.mejorasActuales[0]=this.listaMejoras[0][3];
                break;
            case "Aumentar ataque IV":
                this.ataque+=20;
                this.mejorasActuales[0]=this.listaMejoras[0][4];
                break;
            case "Aumentar ataque V":
                this.ataque+=25;
                this.mejorasActuales[0]=this.listaMejoras[0][5];
                break;
            case "Agotado":
                break;
        }

        Log.d("TAG", String.valueOf(this.ataque));

    }

    public void efectuarMejoraDefensa(){
        switch (this.mejorasActuales[1].getNombre()){
            case "Aumentar defensa I":
                this.defensa+=5;
                this.mejorasActuales[1]=this.listaMejoras[1][1];
                break;
            case "Aumentar defensa II":
                this.defensa+=10;
                this.mejorasActuales[1]=this.listaMejoras[1][2];
                break;
            case "Aumentar defensa III":
                this.defensa+=15;
                this.mejorasActuales[1]=this.listaMejoras[1][3];
                break;
            case "Aumentar defensa IV":
                this.defensa+=20;
                this.mejorasActuales[1]=this.listaMejoras[1][4];
                break;
            case "Aumentar defensa V":
                this.defensa+=25;
                this.mejorasActuales[1]=this.listaMejoras[1][5];
                break;
            case "Agotado":
                break;
        }
        Log.d("TAG", String.valueOf(this.defensa));
    }

    public void efectuarMejoraAutomatico(){
        switch (this.mejorasActuales[2].getNombre()){
            case "Ataque automático I":
                this.dps+=3;
                this.mejorasActuales[2]=this.listaMejoras[2][1];
                break;
            case "Ataque automático II":
                this.dps+=6;
                this.mejorasActuales[2]=this.listaMejoras[2][2];
                break;
            case "Ataque automático III":
                this.dps+=9;
                this.mejorasActuales[2]=this.listaMejoras[2][3];
                break;
            case "Ataque automático IV":
                this.dps+=12;
                this.mejorasActuales[2]=this.listaMejoras[2][4];
                break;
            case "Ataque automático V":
                this.dps+=15;
                this.mejorasActuales[2]=this.listaMejoras[2][5];
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
