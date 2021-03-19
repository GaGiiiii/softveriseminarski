/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.validation.impl;

import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Projekcija;
import rs.ac.bg.fon.ps.validation.Validator;

/**
 *
 * @author GaGiiiii
 */
public class ProjekcijaValidation implements Validator {

    @Override
    public void validate(IDomain domainObject) throws Exception {
        try {
            Projekcija p = (Projekcija) domainObject;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
