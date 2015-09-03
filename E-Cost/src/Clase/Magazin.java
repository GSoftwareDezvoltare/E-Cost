/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

/**
 *
 * @author GSoftware
 */
public class Magazin {
    private int id;
    private String denumire;

    public Magazin() {
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Magazin(int id, String denumire) {
        this.id = id;
        this.denumire = denumire;
    }
}
