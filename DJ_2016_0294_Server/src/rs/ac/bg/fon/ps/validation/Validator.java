/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.validation;

import rs.ac.bg.fon.ps.domain.IDomain;

/**
 *
 * @author GaGiiiii
 */
public interface Validator {

    public void validate(IDomain domainObject) throws Exception;
}
