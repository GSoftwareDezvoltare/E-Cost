/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import java.math.BigDecimal;

/**
 *
 * @author GSoftware
 */
public class Buget {
    BigDecimal imbracaminte;
    BigDecimal incaltaminte;
    BigDecimal mancare;
    BigDecimal utilitati;
    BigDecimal abonamente;
    BigDecimal altele;
    BigDecimal sala;

    public Buget() {
    }

    public Buget(BigDecimal imbracaminte, BigDecimal incaltaminte, BigDecimal mancare, BigDecimal utilitati, BigDecimal abonamente, BigDecimal altele, BigDecimal sala) {
        this.imbracaminte = imbracaminte;
        this.incaltaminte = incaltaminte;
        this.mancare = mancare;
        this.utilitati = utilitati;
        this.abonamente = abonamente;
        this.altele = altele;
        this.sala = sala;
    }

    public BigDecimal getImbracaminte() {
        return imbracaminte;
    }

    public void setImbracaminte(BigDecimal imbracaminte) {
        this.imbracaminte = imbracaminte;
    }

    public BigDecimal getIncaltaminte() {
        return incaltaminte;
    }

    public void setIncaltaminte(BigDecimal incaltaminte) {
        this.incaltaminte = incaltaminte;
    }

    public BigDecimal getMancare() {
        return mancare;
    }

    public void setMancare(BigDecimal mancare) {
        this.mancare = mancare;
    }

    public BigDecimal getUtilitati() {
        return utilitati;
    }

    public void setUtilitati(BigDecimal utilitati) {
        this.utilitati = utilitati;
    }

    public BigDecimal getAbonamente() {
        return abonamente;
    }

    public void setAbonamente(BigDecimal abonamente) {
        this.abonamente = abonamente;
    }

    public BigDecimal getAltele() {
        return altele;
    }

    public void setAltele(BigDecimal altele) {
        this.altele = altele;
    }

    public BigDecimal getSala() {
        return sala;
    }

    public void setSala(BigDecimal sala) {
        this.sala = sala;
    }
    


    @Override
    public String toString() {
        return "Buget{" + "imbracaminte=" + imbracaminte + ", incaltaminte=" + incaltaminte + ", mancare=" + mancare + ", utilitati=" + utilitati + ", abonamente=" + abonamente + '}';
    }
    
    
    
    
}
