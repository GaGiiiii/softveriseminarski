/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.helpClasses;

import java.io.Serializable;
import java.util.LinkedList;
import rs.ac.bg.fon.ps.domain.IDomain;

/**
 *
 * @author GaGiiiii
 */
public class PretragaHelp implements Serializable {

    private String kriterijum;
    private LinkedList<IDomain> list;

    public PretragaHelp() {
    }

    public PretragaHelp(String kriterijum, LinkedList<IDomain> list) {
        this.kriterijum = kriterijum;
        this.list = list;
    }

    public LinkedList<IDomain> getList() {
        return list;
    }

    public void setList(LinkedList<IDomain> list) {
        this.list = list;
    }

    public String getKriterijum() {
        return kriterijum;
    }

    public void setKriterijum(String kriterijum) {
        this.kriterijum = kriterijum;
    }

}
