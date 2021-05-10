package com.example.planetetp5;

public class Donnee {

    String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};
    String[] planet = {"Natation", "Equitation", "Velo", "Danse", "Marche", "Course", "Football", "Karate", "Basketball"};
    String[] image = {"Venez nager !", "Hee Hee", "Venez drifter !", "Baila baila", "Ca use", "Fatigue wlh", "Siuuuuu", "Woutchaaaa !", "Splaaaaash !"};
    com.example.planetetp5.ListeActivite la;
    com.example.planetetp5.ListeParcours lp;
    com.example.planetetp5.ListePatient lpt;
    public Donnee(ListeActivite listeActivite) {
        la = listeActivite;
    }
    public Donnee(com.example.planetetp5.ListeParcours listeParcours) {
        lp = listeParcours;
    }
    public Donnee(com.example.planetetp5.ListePatient listePatient) {
        lpt = listePatient;
    }

    private String images;
    private String planetes;
    private String tailles;



    Donnee (String planete, String taille, String image){
        images=image;
        planetes = planete;
        tailles = taille;
    }

    public String getPlanete() {

        return planetes;
    }

    public String getTailles() {

        return tailles;
    }

    public String getImages() {

        return images;
    }

}