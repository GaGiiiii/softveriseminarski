/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.logic.impl;

import rs.ac.bg.fon.ps.domain.P_DR;
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;

/**
 *
 * @author GaGiiiii
 */
public class ObrisiPDR extends SistemskeOperacije {

    public ObrisiPDR(P_DR pdr) {
        super();
        domainObject = pdr;
    }

    @Override
    protected void operation() throws Exception {
        P_DR pdr = (P_DR) domainObject; 
        ret = database.remove(domainObject);
    }
}
