/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.validation.impl;

import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Korisnik;
import rs.ac.bg.fon.ps.validation.Validator;

/**
 *
 * @author GaGiiiii
 */
public class UserValidation implements Validator {

    @Override
    public void validate(IDomain domainObject) throws Exception {
        try {
            Korisnik k = (Korisnik) domainObject;
            if (k.getUsername().isEmpty()) {
                throw new Exception("Username ne moze biti prazan.");
            }
            if (k.getPassword().isEmpty()) {
                throw new Exception("Sifra ne moze biti prazna");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
