/**
 * Created by carla on 27/02/18.
 */
package com.example.carla.recyclerview;
public class Alumnos {

    private String nombre;
    private String numControl;
    private String carrera;
    private int foto;


    public Alumnos(){

    }

    public Alumnos(String nombre, String numControl, String carrera, int foto) {
        this.nombre = nombre;
        this.numControl = numControl;
        this.carrera = carrera;
        this.foto = foto;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumControl() {
        return numControl;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getFoto() {
        return foto;
    }
}
