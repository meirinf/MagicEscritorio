package sample;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mireia on 30/10/16.
 */
public class Carta implements Serializable {

    String nombre;
    String tipo;
    String color;
    String imagen;
    String texto;
    String rareza;

    public Carta() {

    }

    // Getters

    public String getRareza() {
        return rareza;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public String getTexto() {
        return texto;
    }

    public String getColor() {
        return color;
    }

    // Setters

    public void setRareza(String rareza) {
        this.rareza = rareza;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

// ToString

    @Override
    public String toString() {
        return "Carta{"+"titulo="+nombre+"}";
    }
}
