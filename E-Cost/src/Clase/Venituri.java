/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

import java.math.BigDecimal;
import javafx.scene.input.DataFormat;

/**
 *
 * @author GSoftware
 */
public class Venituri {
    int tip;
    BigDecimal valoare;
    String data_inceput;
    String data_sfarsit;
    String detalii;

    public Venituri() {
    }

    public Venituri(int tip, BigDecimal valoare, String data_inceput, String data_sfarsit, String detalii) {
        this.tip = tip;
        this.valoare = valoare;
        this.data_inceput = data_inceput;
        this.data_sfarsit = data_sfarsit;
        this.detalii = detalii;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public BigDecimal getValoare() {
        return valoare;
    }

    public void setValoare(BigDecimal valoare) {
        this.valoare = valoare;
    }

    public String getData_inceput() {
        return data_inceput;
    }

    public void setData_inceput(String data_inceput) {
        this.data_inceput = data_inceput;
    }

    public String getData_sfarsit() {
        return data_sfarsit;
    }

    public void setData_sfarsit(String data_sfarsit) {
        this.data_sfarsit = data_sfarsit;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    @Override
    public String toString() {
        return "Venituri{" + "tip=" + tip + ", valoare=" + valoare + ", data_inceput=" + data_inceput + ", data_sfarsit=" + data_sfarsit + ", detalii=" + detalii + '}';
    }
    
}
