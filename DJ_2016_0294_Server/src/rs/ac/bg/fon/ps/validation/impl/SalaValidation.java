/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.validation.impl;

import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Sala;
import rs.ac.bg.fon.ps.validation.Validator;

/**
 *
 * @author GaGiiiii
 */
public class SalaValidation implements Validator {

    @Override
    public void validate(IDomain domainObject) throws Exception {
        try {
            Sala sala = (Sala) domainObject;

            if (sala.getNaziv().isEmpty()) {
                throw new Exception("Molimo unesite naziv sale.");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
