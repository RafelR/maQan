package com.example.rafel.maqan.model;

public class Food {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public double getKarbohidrat() {
        return karbohidrat;
    }

    public void setKarbohidrat(double karbohidrat) {
        this.karbohidrat = karbohidrat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getLemak() {
        return lemak;
    }

    public void setLemak(double lemak) {
        this.lemak = lemak;
    }

    public double getKalori() {
        return kalori;
    }

    public void setKalori(double kalori) {
        this.kalori = kalori;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String name="-";
    private String jenis="-";
    private double karbohidrat=0;
    private double protein=0;
    private double lemak=0;
    private double kalori=0;
    private String image="-";

    public Food(String name, String jenis, double karbohidrat, double protein, double lemak, String image, double kalori) {
        this.name = name;
        this.jenis = jenis;
        this.karbohidrat = karbohidrat;
        this.protein = protein;
        this.lemak = lemak;
        this.image = image;
        this.kalori = kalori;
    }

    public Food(){

    }
}
