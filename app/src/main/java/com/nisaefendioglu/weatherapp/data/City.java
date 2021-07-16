package com.nisaefendioglu.weatherapp.data;

public class City {
    private String name;
    private Double temp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public City(String name, Double temp) {
        this.name = name;
        this.temp = temp;
    }
}
