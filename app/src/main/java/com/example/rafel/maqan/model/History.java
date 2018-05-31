package com.example.rafel.maqan.model;

public class History {
    public Food getBreakfast() {
        return breakfast;
    }

    public Food getLunch() {
        return lunch;
    }

    public Food getDinner() {
        return dinner;
    }

    public void setBreakfast(Food breakfast) {
        this.breakfast = breakfast;
    }

    public void setLunch(Food lunch) {
        this.lunch = lunch;
    }

    public void setDinner(Food dinner) {
        this.dinner = dinner;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTanggal() {

        return tanggal;
    }

    private String tanggal;
    private Food breakfast = new Food();
    private Food lunch = new Food();
    private Food dinner = new Food();


    public History(String tanggal, Food breakfast,Food lunch, Food dinner){
        this.tanggal = tanggal;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }
    public History(){

    }
}
