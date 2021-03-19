/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.logic.impl;

import java.util.LinkedList;
import rs.ac.bg.fon.ps.domain.Film;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Projekcija;
import rs.ac.bg.fon.ps.domain.Sala;
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;

/**
 *
 * @author GaGiiiii
 */
public class UcitajListuProjekcija extends SistemskeOperacije {

    public UcitajListuProjekcija(LinkedList<IDomain> projekcije) {
        super();
        list = projekcije;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> projekcije = database.getAll(Projekcija.class, "", "");
        for (IDomain projekcija : projekcije) {
            Projekcija projekcija2 = (Projekcija) projekcija;
            NadjiFilm nf = new NadjiFilm(projekcija2.getFilm());
            nf.execute();
            projekcija2.setFilm((Film) nf.getDomainObject());

            NadjiSalu ns = new NadjiSalu(projekcija2.getSala());
            ns.execute();
            projekcija2.setSala((Sala) ns.getDomainObject());
        }

        list = projekcije;
    }
}
