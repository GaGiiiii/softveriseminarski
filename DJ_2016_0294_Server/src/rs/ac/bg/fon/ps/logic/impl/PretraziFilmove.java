/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.logic.impl;

import java.util.LinkedList;
import rs.ac.bg.fon.ps.domain.Film;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;

/**
 *
 * @author GaGiiiii
 */
public class PretraziFilmove extends SistemskeOperacije {

    private String kriterijum;

    public PretraziFilmove(String kriterijum, LinkedList<IDomain> filmovi) {
        super();
        this.kriterijum = kriterijum;
        list = filmovi;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> filmovi = database.getAll(Film.class, "", "");
        LinkedList<IDomain> filmoviGood = new LinkedList<>();

        for (IDomain film : filmovi) {
            Film filmic = (Film) film;

            if (filmic.getNaziv().toLowerCase().contains(kriterijum.toLowerCase())) {
                filmoviGood.add(filmic);
            }
        }

        list = filmoviGood;
    }

}
