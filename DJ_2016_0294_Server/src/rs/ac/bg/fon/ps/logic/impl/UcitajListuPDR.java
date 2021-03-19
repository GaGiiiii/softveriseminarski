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
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;

/**
 *
 * @author GaGiiiii
 */
public class UcitajListuPDR extends SistemskeOperacije {

    public UcitajListuPDR(LinkedList<IDomain> pdrs) {
        super();
        list = pdrs;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> pdrs = database.getAll(P_DR.class, "", "");
        for (IDomain pdr : pdrs) {
            P_DR pdr2 = (P_DR) pdr;

            NadjiProjekciju np = new NadjiProjekciju(pdr2.getProjekcija());
            np.execute();
            pdr2.setProjekcija((Projekcija) np.getDomainObject());

            NadjiDnevniRaspored ndr = new NadjiDnevniRaspored(pdr2.getDnevniRaspored());
            ndr.execute();
            pdr2.setDnevniRaspored((Dnevni_Raspored) ndr.getDomainObject());
        }

        list = pdrs;
    }
}
