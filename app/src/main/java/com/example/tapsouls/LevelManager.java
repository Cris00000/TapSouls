package com.example.tapsouls;

import android.util.Log;

import java.util.logging.Level;

public class LevelManager {

    private Enemigo niveles[][] = new Enemigo[5][5];

    public LevelManager(){
        niveles[0][0]=new Enemigo("Shrek",120,R.drawable.goblin,2,0, 10);
        niveles[0][1]=new Enemigo("Boomer",200,R.drawable.goblin,3,1, 15);
        niveles[0][2]=new Enemigo("Mauricio",250,R.drawable.goblin,2,2, 20);
        niveles[0][3]=new Enemigo("Shrek",120,R.drawable.goblin,2,0, 25);
        niveles[0][4]=new Enemigo("Pepito",500,R.drawable.goblin,6,1, 40);

        niveles[1][0]=new Enemigo("Pepe",120,R.drawable.goblin,2,0,30);
        niveles[1][1]=new Enemigo("Goblin",200,R.drawable.goblin,3,1, 35);
        niveles[1][2]=new Enemigo("Paco",250,R.drawable.goblin,2,2, 40);
        niveles[1][3]=new Enemigo("Shrek",120,R.drawable.goblin,2,0, 45);
        niveles[1][4]=new Enemigo("Pepa",500,R.drawable.goblin,6,1, 80);

        niveles[2][0]=new Enemigo("asfdsf",120,R.drawable.goblin,2,0, 50);
        niveles[2][1]=new Enemigo("Bodgaewromer",200,R.drawable.goblin,3,1, 55);
        niveles[2][2]=new Enemigo("qrewr",250,R.drawable.goblin,2,2, 60);
        niveles[2][3]=new Enemigo("Shrretryhek",120,R.drawable.goblin,2,0, 75);
        niveles[2][4]=new Enemigo("dfghdf",500,R.drawable.goblin,6,1, 120);

        niveles[3][0]=new Enemigo("dgfhsdfv",120,R.drawable.goblin,2,0, 80);
        niveles[3][1]=new Enemigo("acdfsfc",200,R.drawable.goblin,3,1, 85);
        niveles[3][2]=new Enemigo("asdfs",250,R.drawable.goblin,2,2, 90);
        niveles[3][3]=new Enemigo("Shfdgsdfgrek",120,R.drawable.goblin,2,0, 95);
        niveles[3][4]=new Enemigo("adgdg",500,R.drawable.goblin,6,1, 200);

        niveles[4][0]=new Enemigo("asdfs",120,R.drawable.goblin,2,0, 100);
        niveles[4][1]=new Enemigo("asfdfcas",200,R.drawable.goblin,3,1, 105);
        niveles[4][2]=new Enemigo("adfsfsa",250,R.drawable.goblin,2,2, 110);
        niveles[4][3]=new Enemigo("afsf",120,R.drawable.goblin,2,0, 115);
        niveles[4][4]=new Enemigo("afdvsd",500,R.drawable.goblin,6,1, 300);
    }

    public LevelManager(Enemigo[][] niveles) {
        this.niveles = niveles;
    }

    public void inicializarNiveles(){
        niveles[0][0]=new Enemigo("Shrek",120,R.drawable.goblin,2,0, 10);
        niveles[0][1]=new Enemigo("Boomer",200,R.drawable.goblin,3,1, 15);
        niveles[0][2]=new Enemigo("Mauricio",250,R.drawable.goblin,2,2, 20);
        niveles[0][3]=new Enemigo("Shrek",120,R.drawable.goblin,2,0, 25);
        niveles[0][4]=new Enemigo("Pepito",500,R.drawable.goblin,6,1, 40);

        niveles[1][0]=new Enemigo("Pepe",120,R.drawable.goblin,2,0,30);
        niveles[1][1]=new Enemigo("Goblin",200,R.drawable.goblin,3,1, 35);
        niveles[1][2]=new Enemigo("Paco",250,R.drawable.goblin,2,2, 40);
        niveles[1][3]=new Enemigo("Shrek",120,R.drawable.goblin,2,0, 45);
        niveles[1][4]=new Enemigo("Pepa",500,R.drawable.goblin,6,1, 80);

        niveles[2][0]=new Enemigo("asfdsf",120,R.drawable.goblin,2,0, 50);
        niveles[2][1]=new Enemigo("Bodgaewromer",200,R.drawable.goblin,3,1, 55);
        niveles[2][2]=new Enemigo("qrewr",250,R.drawable.goblin,2,2, 60);
        niveles[2][3]=new Enemigo("Shrretryhek",120,R.drawable.goblin,2,0, 75);
        niveles[2][4]=new Enemigo("dfghdf",500,R.drawable.goblin,6,1, 120);

        niveles[3][0]=new Enemigo("dgfhsdfv",120,R.drawable.goblin,2,0, 80);
        niveles[3][1]=new Enemigo("acdfsfc",200,R.drawable.goblin,3,1, 85);
        niveles[3][2]=new Enemigo("asdfs",250,R.drawable.goblin,2,2, 90);
        niveles[3][3]=new Enemigo("Shfdgsdfgrek",120,R.drawable.goblin,2,0, 95);
        niveles[3][4]=new Enemigo("adgdg",500,R.drawable.goblin,6,1, 200);

        niveles[4][0]=new Enemigo("asdfs",120,R.drawable.goblin,2,0, 100);
        niveles[4][1]=new Enemigo("asfdfcas",200,R.drawable.goblin,3,1, 105);
        niveles[4][2]=new Enemigo("adfsfsa",250,R.drawable.goblin,2,2, 110);
        niveles[4][3]=new Enemigo("afsf",120,R.drawable.goblin,2,0, 115);
        niveles[4][4]=new Enemigo("afdvsd",500,R.drawable.goblin,6,1, 300);
    }

    public void inicializarNivel1(){
        niveles[0][0]=new Enemigo("Shrek",120,R.drawable.goblin,2,0, 10);
        niveles[0][1]=new Enemigo("Boomer",200,R.drawable.goblin,3,1, 15);
        niveles[0][2]=new Enemigo("Mauricio",250,R.drawable.goblin,2,2, 20);
        niveles[0][3]=new Enemigo("Shrek",120,R.drawable.goblin,2,0, 25);
        niveles[0][4]=new Enemigo("Pepito",500,R.drawable.goblin,6,1, 40);
    }

    public void inicializarNivel2(){
        niveles[1][0]=new Enemigo("Pepe",120,R.drawable.goblin,2,0,30);
        niveles[1][1]=new Enemigo("Goblin",200,R.drawable.goblin,3,1, 35);
        niveles[1][2]=new Enemigo("Paco",250,R.drawable.goblin,2,2, 40);
        niveles[1][3]=new Enemigo("Shrek",120,R.drawable.goblin,2,0, 45);
        niveles[1][4]=new Enemigo("Pepa",500,R.drawable.goblin,6,1, 80);
    }

    public void inicializarNivel3(){
        niveles[2][0]=new Enemigo("asfdsf",120,R.drawable.goblin,2,0, 50);
        niveles[2][1]=new Enemigo("Bodgaewromer",200,R.drawable.goblin,3,1, 55);
        niveles[2][2]=new Enemigo("qrewr",250,R.drawable.goblin,2,2, 60);
        niveles[2][3]=new Enemigo("Shrretryhek",120,R.drawable.goblin,2,0, 75);
        niveles[2][4]=new Enemigo("dfghdf",500,R.drawable.goblin,6,1, 120);
    }

    public void inicializarNivel4(){
        niveles[3][0]=new Enemigo("dgfhsdfv",120,R.drawable.goblin,2,0, 80);
        niveles[3][1]=new Enemigo("acdfsfc",200,R.drawable.goblin,3,1, 85);
        niveles[3][2]=new Enemigo("asdfs",250,R.drawable.goblin,2,2, 90);
        niveles[3][3]=new Enemigo("Shfdgsdfgrek",120,R.drawable.goblin,2,0, 95);
        niveles[3][4]=new Enemigo("adgdg",500,R.drawable.goblin,6,1, 200);
    }

    public void inicializarNivel5(){
        niveles[4][0]=new Enemigo("asdfs",120,R.drawable.goblin,2,0, 100);
        niveles[4][1]=new Enemigo("asfdfcas",200,R.drawable.goblin,3,1, 105);
        niveles[4][2]=new Enemigo("adfsfsa",250,R.drawable.goblin,2,2, 110);
        niveles[4][3]=new Enemigo("afsf",120,R.drawable.goblin,2,0, 115);
        niveles[4][4]=new Enemigo("afdvsd",500,R.drawable.goblin,6,1, 300);
    }


    public Enemigo comprobacionEnemigoActual(){
        boolean vivo=false;
        for(int i = 0; i<niveles.length;i++){
            for(Enemigo enemigo : niveles[i]){
                if (enemigo.getSalud()>0 && vivo==false){
                    vivo=true;
                    return enemigo;
                }
            }
        }

        if (vivo==false){
            inicializarNiveles();
            return comprobacionEnemigoActual();
        }
        return null;
    }

    public Enemigo[][] getNiveles() {
        return niveles;
    }

    public void setNiveles(Enemigo[][] niveles) {
        this.niveles = niveles;
    }
}
