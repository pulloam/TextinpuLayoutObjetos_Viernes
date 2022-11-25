package cl.seccion121.myapplication;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String rut;
    private String razon;
    private int credito;
    private Sucursal sucursal;

    public Cliente(){}

    public String toString(){
        return rut + " -> " + razon;
    }



    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Cliente(String rut, String razon, int credito) {
        this.rut = rut;
        this.razon = razon;
        this.credito = credito;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }
}
