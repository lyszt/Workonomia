/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author joaoluis
 */
public abstract class Profession {
    String profession;
    String place;

    public Profession(String profession, String place) {
        this.profession = profession;
        this.place = place;
    }

    
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return profession;
    }
    
    
    
    
    public abstract String doJobActivity();
}

