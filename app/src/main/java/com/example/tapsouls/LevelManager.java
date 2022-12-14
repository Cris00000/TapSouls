package com.example.tapsouls;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;

public class LevelManager implements Serializable {

    private ArrayList<Enemigo> niveles = new ArrayList<Enemigo>();

    public LevelManager(){
        niveles.add(0,new Enemigo(1,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.add(1, new Enemigo(2,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.add(2, new Enemigo(3,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.add(3, new Enemigo(4,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.add(4,new Enemigo(5,"Pepito",500,R.drawable.goblin,6,1, 40));

        niveles.add(5,new Enemigo(6,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.add(6, new Enemigo(7,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.add(7, new Enemigo(8,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.add(8, new Enemigo(9,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.add(9,new Enemigo(  10,"Pepito",500,R.drawable.goblin,6,1, 40));

        niveles.add(10,new Enemigo(11,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.add(11, new Enemigo(12,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.add(12, new Enemigo(13,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.add(13, new Enemigo(14,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.add(14,new Enemigo(15,"Pepito",500,R.drawable.goblin,6,1, 40));

        niveles.add(15,new Enemigo(16,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.add(16, new Enemigo(17,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.add(17, new Enemigo(18,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.add(18, new Enemigo(19,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.add(19,new Enemigo(20,"Pepito",500,R.drawable.goblin,6,1, 40));

        niveles.add(20,new Enemigo(21,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.add(21, new Enemigo(22,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.add(22, new Enemigo(23,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.add(23, new Enemigo(24,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.add(24,new Enemigo(25,"Pepito",500,R.drawable.goblin,6,1, 40));
    }

    public LevelManager(ArrayList<Enemigo> niveles) {

        this.niveles = niveles;
    }

    public void inicializarNiveles(){
        niveles.set(0,new Enemigo(1,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.set(1, new Enemigo(2,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.set(2, new Enemigo(3,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.set(3, new Enemigo(4,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.set(4,new Enemigo(5,"Pepito",500,R.drawable.goblin,6,1, 40));

        niveles.set(5,new Enemigo(6,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.set(6, new Enemigo(7,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.set(7, new Enemigo(8,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.set(8, new Enemigo(9,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.set(9,new Enemigo(  10,"Pepito",500,R.drawable.goblin,6,1, 40));

        niveles.set(10,new Enemigo(11,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.set(11, new Enemigo(12,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.set(12, new Enemigo(13,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.set(13, new Enemigo(14,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.set(14,new Enemigo(15,"Pepito",500,R.drawable.goblin,6,1, 40));

        niveles.set(15,new Enemigo(16,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.set(16, new Enemigo(17,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.set(17, new Enemigo(18,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.set(18, new Enemigo(19,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.set(19,new Enemigo(20,"Pepito",500,R.drawable.goblin,6,1, 40));

        niveles.set(20,new Enemigo(21,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.set(21, new Enemigo(22,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.set(22, new Enemigo(23,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.set(23, new Enemigo(24,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.set(24,new Enemigo(25,"Pepito",500,R.drawable.goblin,6,1, 40));
    }

    public void inicializarNivel1(){
        niveles.set(0,new Enemigo(1,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.set(1, new Enemigo(2,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.set(2, new Enemigo(3,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.set(3, new Enemigo(4,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.set(4,new Enemigo(5,"Pepito",500,R.drawable.goblin,6,1, 40));
    }

    public void inicializarNivel2(){
        niveles.set(5,new Enemigo(6,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.set(6, new Enemigo(7,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.set(7, new Enemigo(8,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.set(8, new Enemigo(9,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.set(9,new Enemigo(  10,"Pepito",500,R.drawable.goblin,6,1, 40));

    }

    public void inicializarNivel3(){
        niveles.set(10,new Enemigo(11,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.set(11, new Enemigo(12,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.set(12, new Enemigo(13,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.set(13, new Enemigo(14,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.set(14,new Enemigo(15,"Pepito",500,R.drawable.goblin,6,1, 40));
    }

    public void inicializarNivel4(){
        niveles.set(15,new Enemigo(16,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.set(16, new Enemigo(17,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.set(17, new Enemigo(18,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.set(18, new Enemigo(19,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.set(19,new Enemigo(20,"Pepito",500,R.drawable.goblin,6,1, 40));
    }

    public void inicializarNivel5(){
        niveles.set(20,new Enemigo(21,"Shrek",120,R.drawable.goblin,2,0, 10));
        niveles.set(21, new Enemigo(22,"Boomer",200,R.drawable.goblin,3,1, 15));
        niveles.set(22, new Enemigo(23,"Mauricio",250,R.drawable.goblin,2,2, 20));
        niveles.set(23, new Enemigo(24,"Shrek",120,R.drawable.goblin,2,0, 25));
        niveles.set(24,new Enemigo(25,"Pepito",500,R.drawable.goblin,6,1, 40));
    }


    public Enemigo comprobacionEnemigoActual(){
        boolean vivo=false;
        for(Enemigo enemigo : niveles){
            if (enemigo.getSalud()>0 && vivo==false){
                vivo=true;
                return enemigo;
            }

        }

        if (vivo==false){
            inicializarNiveles();
            return comprobacionEnemigoActual();
        }
        return null;
    }

    public ArrayList<Enemigo> getNiveles() {
        return niveles;
    }

    public void setNiveles(ArrayList<Enemigo> niveles) {
        this.niveles = niveles;
    }
}
