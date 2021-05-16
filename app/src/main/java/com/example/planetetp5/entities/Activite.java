package com.example.planetetp5.entities;

public class Activite {

    private static Long uid = 1L;

    private Long id;
    private String titre;
    private String description;
    private Structure structure;

    public Activite() {
        setId(uid);
        uid++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

}