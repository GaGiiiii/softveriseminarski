/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.logic.impl;

import java.util.LinkedList;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Sala;
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;

/**
 *
 * @author GaGiiiii
 */
public class PretraziSale extends SistemskeOperacije {

    private String kriterijum;

    public PretraziSale(String kriterijum, LinkedList<IDomain> sale) {
        super();
        this.kriterijum = kriterijum;
        list = sale;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> sale = database.getAll(Sala.class, "", "");
        LinkedList<IDomain> saleGood = new LinkedList<>();

        for (IDomain sala : sale) {
            Sala salica = (Sala) sala;

            if (salica.getNaziv().toLowerCase().contains(kriterijum.toLowerCase())) {
                saleGood.add(salica);
            }
        }

        list = saleGood;
    }

}
