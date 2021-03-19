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
public class UcitajListuDnevnihRasporeda extends SistemskeOperacije{
    
    public UcitajListuDnevnihRasporeda(LinkedList<IDomain> rasporedi) {
        super();
        list = rasporedi;
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> rasporedi = database.getAll(Dnevni_Raspored.class, "", "datum ASC");
        list = rasporedi;
    }
}
