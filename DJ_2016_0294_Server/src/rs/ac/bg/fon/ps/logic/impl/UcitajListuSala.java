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
public class UcitajListuSala extends SistemskeOperacije {

    public UcitajListuSala(LinkedList<IDomain> sale) {
        super();
        list = sale;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> sale = database.getAll(Sala.class, "", "");
        list = sale;
        System.out.println(list);
    }
}
