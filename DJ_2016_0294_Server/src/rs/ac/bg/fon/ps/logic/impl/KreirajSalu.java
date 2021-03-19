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
import rs.ac.bg.fon.ps.validation.impl.SalaValidation;

/**
 *
 * @author GaGiiiii
 */
public class KreirajSalu extends SistemskeOperacije {

    public KreirajSalu(Sala sala) {
        super();
        domainObject = sala;
        validator = new SalaValidation();
    }

    @Override
    protected void operation() throws Exception {
        LinkedList<IDomain> sale = null;
        SistemskeOperacije so = new UcitajListuSala(sale);
        so.execute();
        sale = so.getList();

        for (IDomain domainObject : sale) {
            Sala salaFromDB = (Sala) domainObject;
            Sala salaToInsert = (Sala) this.domainObject;

            if (salaToInsert.equals(salaFromDB)) {
                throw new Exception("Uneta sala vec postoji u bazi!");
            }
        }
        
        domainObject = database.insert(domainObject);
    }
}
