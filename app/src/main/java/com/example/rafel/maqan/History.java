package com.example.rafel.maqan;

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

    public String getDate() {
        return date;
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

    public void setDate(String date) {
        this.date = date;
    }

    Food breakfast;
    Food lunch;
    Food dinner;
    String date;

    public History(String date, Food breakfast,Food lunch, Food dinner){
        this.date = date;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }
}
