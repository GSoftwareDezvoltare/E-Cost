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
public class ItemsOfComboBox {
    private int id;
    private String valoare;

    public ItemsOfComboBox(String valoare, int id) {
        this.id = id;
        this.valoare = valoare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValoare() {
        return valoare;
    }

    public void setValoare(String valoare) {
        this.valoare = valoare;
    }

//    @Override
//    public String toString() {
//        return id=" + id + ";
//    }

    @Override
    public String toString() {
        return valoare;
    }
    
}
