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
public class NadjiProjekciju extends SistemskeOperacije {

    public NadjiProjekciju(Projekcija projekcija) {
        super();
        domainObject = projekcija;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> projekcije = new LinkedList<>();
        UcitajListuProjekcija ulp = new UcitajListuProjekcija(projekcije);
        ulp.execute();
        projekcije = ulp.getList();

        for (IDomain projekcija : projekcije) {
            Projekcija projekcijica = (Projekcija) projekcija;

            if (domainObject.getId().equals(projekcijica.getId())) {
                domainObject = projekcijica;

                return;
            }
        }
    }
}
