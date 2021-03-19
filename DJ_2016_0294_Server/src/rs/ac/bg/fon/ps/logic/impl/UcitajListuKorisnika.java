/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.logic.impl;

import java.util.LinkedList;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Korisnik;
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;

/**
 *
 * @author GaGiiiii
 */
public class UcitajListuKorisnika extends SistemskeOperacije {

    public UcitajListuKorisnika(LinkedList<IDomain> korisnici) {
        super();
        list = korisnici;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> korisnici = database.getAll(Korisnik.class, "", "");
        list = korisnici;
    }

}
