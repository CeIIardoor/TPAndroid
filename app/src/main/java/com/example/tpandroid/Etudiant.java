package com.example.tpandroid;

import android.graphics.Bitmap;

import java.util.List;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;

    private Bitmap photo;

    private String phone;

    private List<Notes> notes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public Etudiant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.phone = "06 00 00 00 00";
        this.photo = null;
    }

    public List<Notes> getNotes() {
        return notes;
    }
}