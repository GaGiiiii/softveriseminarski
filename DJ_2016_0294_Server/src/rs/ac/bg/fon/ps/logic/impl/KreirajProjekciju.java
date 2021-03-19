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
import rs.ac.bg.fon.ps.validation.impl.ProjekcijaValidation;

/**
 *
 * @author GaGiiiii
 */
public class KreirajProjekciju extends SistemskeOperacije {

    public KreirajProjekciju(Projekcija projekcija) {
        super();
        projekcija.setVreme(new java.sql.Timestamp(projekcija.getVreme().getTime()));
        domainObject = projekcija;
        validator = new ProjekcijaValidation();
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> projekcije = null;
        SistemskeOperacije so = new UcitajListuProjekcija(projekcije);
        so.execute();
        projekcije = so.getList();
        
        for (IDomain domainObject : projekcije) {
            Projekcija projekcijaFromDB = (Projekcija) domainObject;
            Projekcija projekcijaToInsert = (Projekcija) this.domainObject;

            if (projekcijaToInsert.equals(projekcijaFromDB)) {
                throw new Exception("Postoji projekcija u zadatom terminu.");
            }
        }

        domainObject = database.insert(domainObject);
    }
}
