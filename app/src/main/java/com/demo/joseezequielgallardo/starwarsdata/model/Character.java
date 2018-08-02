package com.demo.joseezequielgallardo.starwarsdata.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Character {

    private String name;

    private String height;

    private String mass;

    @SerializedName("hair_color")
    private String hairColor;

    @SerializedName("skin_color")
    private String skinColor;

    @SerializedName("eye_color")
    private String eyeColor;

    @SerializedName("birth_year")
    private String birthYear;

    private String gender;

    private String homeWorld;

    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;

    private String created;
    private String edited;
    private String url;

    public Character(String name, String height, String mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, String homeWorld, List<String> films, List<String> species, List<String> vehicles, List<String> starships, String created, String edited, String url) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeWorld = homeWorld;
        this.films = films;
        this.species = species;
        this.vehicles = vehicles;
        this.starships = starships;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public List<String> getFilms() {
        return films;
    }

    public List<String> getSpecies() {
        return species;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public List<String> getStarships() {
        return starships;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }
}
