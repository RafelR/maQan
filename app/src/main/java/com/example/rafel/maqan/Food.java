package com.example.rafel.maqan;

public class Food {


    private String name;
    private String jenis;
    private String karbohidrat;
    private String protein;
    private String lemak;
    private String image;

    public void setName(String name) {
        this.name = name;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setKarbohidrat(String karbohidrat) {
        this.karbohidrat = karbohidrat;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public void setLemak(String lemak) {
        this.lemak = lemak;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getJenis() {
        return jenis;
    }

    public String getKarbohidrat() {
        return karbohidrat;
    }

    public String getProtein() {
        return protein;
    }

    public String getLemak() {
        return lemak;
    }

    public String getImage() {
        return image;
    }

    public Food(String name, String jenis, String karbohidrat, String protein, String lemak, String image) {
        this.name = name;
        this.jenis = jenis;
        this.karbohidrat = karbohidrat;
        this.protein = protein;
        this.lemak = lemak;
        this.image = image;
    }
}
