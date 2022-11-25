package cl.seccion121.myapplication;

import java.io.Serializable;

public class Sucursal implements Serializable {
    private int id;
    private String nombre;
    private String direccion;
    private String encargado;

    public Sucursal(int id, String nombre, String direccion, String encargado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.encargado = encargado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }
}
