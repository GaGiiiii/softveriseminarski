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
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;

/**
 *
 * @author GaGiiiii
 */
public class ObrisiFilm extends SistemskeOperacije {

    public ObrisiFilm(Film film) {
        super();
        domainObject = film;
    }

    @Override
    protected void operation() throws Exception {
        Film film = (Film) domainObject;
        LinkedList<IDomain> projekcije = database.getAll(Projekcija.class, "film_id=" + film.getFilm_id(), "");
        for (IDomain projekcija : projekcije) {
            database.remove(projekcija);
//            IZBRISI I P_DR za ove projekcije===================================================================================================
        }
        
        ret = database.remove(domainObject);
    }
}
