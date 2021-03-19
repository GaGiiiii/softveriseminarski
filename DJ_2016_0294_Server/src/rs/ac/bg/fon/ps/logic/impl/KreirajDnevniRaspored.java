/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.logic.impl;

import java.util.LinkedList;
import rs.ac.bg.fon.ps.domain.Dnevni_Raspored;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.P_DR;
import rs.ac.bg.fon.ps.domain.Projekcija;
import rs.ac.bg.fon.ps.helpClasses.KreirajDnevniRasporedHelp;
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;

/**
 *
 * @author GaGiiiii
 */
public class KreirajDnevniRaspored extends SistemskeOperacije {

    private LinkedList<Projekcija> projekcije;

    public KreirajDnevniRaspored(KreirajDnevniRasporedHelp kdrh) {
        super();
        kdrh.getDnevni_Raspored().setDatum(new java.sql.Date(kdrh.getDnevni_Raspored().getDatum().getTime()));
        domainObject = kdrh.getDnevni_Raspored();
        projekcije = kdrh.getProjekcije();
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> dnevniRasporedi = null;
        SistemskeOperacije so = new UcitajListuDnevnihRasporeda(dnevniRasporedi);
        so.execute();
        dnevniRasporedi = so.getList();

        for (IDomain domainObject : dnevniRasporedi) {
            Dnevni_Raspored drFromDB = (Dnevni_Raspored) domainObject;
            Dnevni_Raspored drToInsert = (Dnevni_Raspored) this.domainObject;

            if (drToInsert.equals(drFromDB)) {
                throw new Exception("Postoji dnevni raspored za zadati datum.");
            }
        }

        domainObject = database.insert(domainObject);

        for (Projekcija projekcija : projekcije) {
            P_DR p_dr = new P_DR(Long.MIN_VALUE, projekcija, (Dnevni_Raspored) domainObject);
            database.insert(p_dr);
        }
    }
}
