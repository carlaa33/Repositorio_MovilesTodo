package com.example.carla.deteccion;

/**
 * Created by carla on 12/05/18.
 */

class DataProvider {
    private String nombre;
    private String fabricante;
    private int version;
    private float rango;
    private int delay;
    private float power;

    public DataProvider(String nombre, String fabricante, int version, float rango, int delay, float power) {
        this.nombre= nombre;
        this.fabricante = fabricante;
        this.version = version;
        this.rango = rango;
        this.delay = delay;
        this.power = power;
    }
    public String getNombre(){
        return nombre;
    }

    public String getFabricante(){
        return fabricante;
    }

    public int getVersion(){
        return version;
    }

    public float getRango() {
        return rango;
    }

    public int getDelay() {
        return delay;
    }

    public float getPower() {
        return power;
    }
}
