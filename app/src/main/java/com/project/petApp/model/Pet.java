package com.project.petApp.model;

public class Pet {
    private String petTitle;
    private String petCountry;
    private String petPrice;
    private int petPicture;

    public Pet(String petTitle, String petCountry, String petPrice, int petPicture) {
        this.petTitle = petTitle;
        this.petCountry = petCountry;
        this.petPrice = petPrice;
        this.petPicture = petPicture;
    }

    public Pet() {}

    public String getPetTitle() {
        return petTitle;
    }

    public void setPetTitle(String petTitle) {
        this.petTitle = petTitle;
    }

    public String getPetCountry() {
        return petCountry;
    }

    public void setPetCountry(String petCountry) {
        this.petCountry = petCountry;
    }

    public String getPetPrice() {
        return petPrice;
    }

    public void setPetPrice(String petPrice) {
        this.petPrice = petPrice;
    }

    public int getPetPicture() {
        return petPicture;
    }

    public void setPetPicture(int petPicture) {
        this.petPicture = petPicture;
    }
}
