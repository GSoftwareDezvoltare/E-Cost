/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import java.math.BigDecimal;

/**
 *
 * @author TechSolutions
 */
public class Produs {
    int id;
    String cumparator;
    String denumire;
    int produs_cumparat;
    BigDecimal pret_produs;
    String persoana_folosit;
    String data_cumparare;
    String categorie;
    int magazin;
    String metoda_plata;

    public Produs() {
    }

    public Produs(int id, String cumparator, String denumire, int produs_cumparat, BigDecimal pret_produs, String persoana_folosit, String data_cumparare, String categorie, int magazin, String metoda_plata) {
        this.id = id;
        this.cumparator = cumparator;
        this.denumire = denumire;
        this.produs_cumparat = produs_cumparat;
        this.pret_produs = pret_produs;
        this.persoana_folosit = persoana_folosit;
        this.data_cumparare = data_cumparare;
        this.categorie = categorie;
        this.magazin = magazin;
        this.metoda_plata = metoda_plata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCumparator() {
        return cumparator;
    }

    public void setCumparator(String cumparator) {
        this.cumparator = cumparator;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getProdus_cumparat() {
        return produs_cumparat;
    }

    public void setProdus_cumparat(int produs_cumparat) {
        this.produs_cumparat = produs_cumparat;
    }

    public BigDecimal getPret_produs() {
        return pret_produs;
    }

    public void setPret_produs(BigDecimal pret_produs) {
        this.pret_produs = pret_produs;
    }

    public String getPersoana_folosit() {
        return persoana_folosit;
    }

    public void setPersoana_folosit(String persoana_folosit) {
        this.persoana_folosit = persoana_folosit;
    }

    public String getData_cumparare() {
        return data_cumparare;
    }

    public void setData_cumparare(String data_cumparare) {
        this.data_cumparare = data_cumparare;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getMagazin() {
        return magazin;
    }

    public void setMagazin(int magazin) {
        this.magazin = magazin;
    }

    public String getMetoda_plata() {
        return metoda_plata;
    }

    public void setMetoda_plata(String metoda_plata) {
        this.metoda_plata = metoda_plata;
    }

    @Override
    public String toString() {
        return "Produs{" + "id=" + id + ", cumparator=" + cumparator + ", denumire=" + denumire + ", produs_cumparat=" + produs_cumparat + ", pret_produs=" + pret_produs + ", persoana_folosit=" + persoana_folosit + ", data_cumparare=" + data_cumparare + ", categorie=" + categorie + ", magazin=" + magazin + ", metoda_plata=" + metoda_plata + '}';
    }
    
    
}
