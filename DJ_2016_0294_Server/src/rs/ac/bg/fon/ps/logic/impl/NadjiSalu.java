/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.logic.impl;

import java.util.LinkedList;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Sala;
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;

/**
 *
 * @author GaGiiiii
 */
public class NadjiSalu extends SistemskeOperacije {

    public NadjiSalu(Sala sala) {
        super();
        domainObject = sala;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> sale = database.getAll(Sala.class, "", "");
        for (IDomain sala : sale) {
            Sala salica = (Sala) sala;
            if (domainObject.getId().equals(salica.getId())) {
                domainObject = salica;

                return;
            }
        }
    }
}
