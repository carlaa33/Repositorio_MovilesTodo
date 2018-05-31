package com.example.carla.card_view;

/**
 * Created by carla on 25/02/18.
 */

public class DataProvider {
    // 1.1. Definir campos de clase para los elementos del CardView
    private String title;
    private String shortdesc;
    private double rating;
    private int image;

    // 1.2. Generar el constructor

    public DataProvider(String title, String shortdesc, double rating, int image) {
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.image = image;
    }

    // 1.3. Generar los métodos getter.


    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {
        return rating;
    }

    public int getImage() {
        return image;
    }
}
