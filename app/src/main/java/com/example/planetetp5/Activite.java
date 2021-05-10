package com.example.planetetp5;

public class Activite {

    String[] duree = {"49", "12", "128", "68", "144", "12", "52", "5", "23"};
    String[] titre = {"Natation", "Equitation", "Velo", "Danse", "Marche", "Course", "Football", "Karate", "Basketball"};
    String[] description = {"Venez nager !", "Hee Hee", "Venez drifter !", "Baila baila", "Ca use", "Fatigue wlh", "Siuuuuu", "Woutchaaaa !", "Splaaaaash !"};
    ListeActivite l;
    public Activite(ListeActivite listeActivite) {
        l = listeActivite;
    }

    private String descriptions;
    private String titres;
    private String durees;



    Activite(String titre, String description, String duree){
        titres=titre;
        descriptions = description;
        durees = duree;
    }

    public String getTitres() {

        return titres;
    }

    public String getDescriptions() {

        return descriptions;
    }

    public String getDurees() {

        return durees;
    }

}