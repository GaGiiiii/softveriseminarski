/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.validation.impl;

import java.util.Date;
import rs.ac.bg.fon.ps.domain.Film;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.validation.Validator;

/**
 *
 * @author GaGiiiii
 */
public class FilmValidation implements Validator {

    @Override
    public void validate(IDomain domainObject) throws Exception {
        try {
            Film film = (Film) domainObject;
            String errors = "";

            if (film.getNaziv().isEmpty()) {
//                throw new Exception("Molimo unesite naziv filma.");
                errors += "\n- Molimo unesite naziv filma";
            }

            if (film.getZanr().isEmpty()) {
//                throw new Exception("Molimo unesite zanr filma.");
                errors += "\n- Molimo unesite zanr filma";
            }

            if (film.getReziser().isEmpty()) {
//                throw new Exception("Molimo unesite rezisera filma.");
                errors += "\n- Molimo unesite rezisera filma";
            }

            if (film.getGlumci().isEmpty()) {
//                throw new Exception("Molimo unesite glumce filma.");
                errors += "\n- Molimo unesite glumce filma";
            }

            if (film.getOpis().isEmpty()) {
//                throw new Exception("Molimo unesite opis filma.");
                errors += "\n- Molimo unesite opis filma";
            }
            
//            if(film.getDatum_izlaska().before(new Date())){
//                errors += "\n- Datum ne moze biti iz proslosti";
//            }

            if (!errors.isEmpty()) {
                throw new Exception(errors);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
