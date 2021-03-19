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
import rs.ac.bg.fon.ps.validation.impl.FilmValidation;

/**
 *
 * @author GaGiiiii
 */
public class KreirajFilm extends SistemskeOperacije {

    public KreirajFilm(Film film) {
        super();
        film.setDatum_izlaska(new java.sql.Date(film.getDatum_izlaska().getTime()));
        domainObject = film;
        validator = new FilmValidation();
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> filmovi = null;
        SistemskeOperacije so = new UcitajListuFilmova(filmovi);
        so.execute();
        filmovi = so.getList();

        for (IDomain domainObject : filmovi) {
            Film filmFromDB = (Film) domainObject;
            Film filmToInsert = (Film) this.domainObject;

            if (filmToInsert.equals(filmFromDB)) {
                throw new Exception("Uneti film vec postoji u bazi!");
            }
        }

        domainObject = database.insert(domainObject);
    }

}
