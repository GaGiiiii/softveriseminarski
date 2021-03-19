/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.logic.impl;

import java.util.LinkedList;
import rs.ac.bg.fon.ps.domain.Film;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Korisnik;
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;

/**
 *
 * @author GaGiiiii
 */
public class UcitajListuFilmova extends SistemskeOperacije {

    public UcitajListuFilmova(LinkedList<IDomain> filmovi) {
        super();
        list = filmovi;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> filmovi = database.getAll(Film.class, "", "");
        list = filmovi;
        System.out.println(list);
    }

}
