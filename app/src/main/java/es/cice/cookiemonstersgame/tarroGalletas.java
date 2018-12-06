package es.cice.cookiemonstersgame;

/**
 * Created by SGU Group 2
 */

public class tarroGalletas {
    private int contadorGalletas;

    private static final tarroGalletas INSTANCE =new tarroGalletas();

    private tarroGalletas(){}

    public static tarroGalletas getInstance(){
        return INSTANCE;
    }
    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }

    public void comeGalleta(int cantidad){
        contadorGalletas-=cantidad;
    }
    public void ponGalletas(int cantidad){
        contadorGalletas+=cantidad;
    }

    public int getContadorGalletas() {
        return contadorGalletas;
    }
}
