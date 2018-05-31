package mx.edu.ittepic.sqlyrecyclerview;

/**
 * Created by carla on 25/02/18.
 */

public class Datos {
    private String clave,nombre,salario;

    public Datos(String clave, String nombre, String salario) {
        this.clave=clave;
        this.nombre = nombre;
        this.salario= salario;
    }
    public String getClave() {
        return clave;
    }
    public String getNombre() {
        return nombre;
    }
    public String getSalario() {
        return salario;
    }
}
