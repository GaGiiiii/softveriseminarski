/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.logic.impl;

import java.util.LinkedList;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Projekcija;
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;

/**
 *
 * @author GaGiiiii
 */
public class PretraziProjekcije extends SistemskeOperacije {

    private String kriterijum;

    public PretraziProjekcije(String kriterijum, LinkedList<IDomain> projekcije) {
        super();
        this.kriterijum = kriterijum;
        list = projekcije;
    }

    @Override
    protected void operation() throws Exception {;
        LinkedList<IDomain> projekcije = new LinkedList<>();
        SistemskeOperacije so = new UcitajListuProjekcija(projekcije);
        so.execute();
        projekcije = so.getList();

        LinkedList<IDomain> projekcijeGood = new LinkedList<>();

        System.out.println(projekcije);

        for (IDomain projekcija : projekcije) {
            Projekcija projekcijica = (Projekcija) projekcija;

            System.out.println(projekcijica.getFilm());
            System.out.println(projekcijica.getSala());

            if (projekcijica.getFilm().getNaziv().toLowerCase().contains(kriterijum.toLowerCase())
                    || projekcijica.getSala().getNaziv().toLowerCase().contains(kriterijum.toLowerCase())) {
                projekcijeGood.add(projekcijica);
            }
        }

        list = projekcijeGood;
    }

}
