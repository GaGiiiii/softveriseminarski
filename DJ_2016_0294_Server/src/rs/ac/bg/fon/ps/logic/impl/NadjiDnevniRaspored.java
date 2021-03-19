/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.logic.impl;

import java.util.LinkedList;
import rs.ac.bg.fon.ps.domain.Dnevni_Raspored;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;

/**
 *
 * @author GaGiiiii
 */
public class NadjiDnevniRaspored extends SistemskeOperacije {

    public NadjiDnevniRaspored(Dnevni_Raspored dnevniRaspored) {
        super();
        domainObject = dnevniRaspored;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> dnevniRasporedi = new LinkedList<>();
        UcitajListuDnevnihRasporeda ulp = new UcitajListuDnevnihRasporeda(dnevniRasporedi);
        ulp.execute();
        dnevniRasporedi = ulp.getList();

        for (IDomain dnevniRaspored : dnevniRasporedi) {
            Dnevni_Raspored drr = (Dnevni_Raspored) dnevniRaspored;
            if (domainObject.getId().equals(drr.getId())) {
                domainObject = drr;

                return;
            }
        }
    }
}
