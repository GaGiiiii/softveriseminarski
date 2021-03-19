/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.controller;

import java.util.LinkedList;
import rs.ac.bg.fon.ps.domain.Film;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Projekcija;
import rs.ac.bg.fon.ps.domain.Sala;
import rs.ac.bg.fon.ps.helpClasses.KreirajDnevniRasporedHelp;
import rs.ac.bg.fon.ps.logic.SistemskeOperacije;
import rs.ac.bg.fon.ps.logic.impl.IzmeniDnevniRaspored;
import rs.ac.bg.fon.ps.logic.impl.IzmeniProjekciju;
import rs.ac.bg.fon.ps.logic.impl.KreirajDnevniRaspored;
import rs.ac.bg.fon.ps.logic.impl.KreirajFilm;
import rs.ac.bg.fon.ps.logic.impl.KreirajProjekciju;
import rs.ac.bg.fon.ps.logic.impl.KreirajSalu;
import rs.ac.bg.fon.ps.logic.impl.ObrisiFilm;
import rs.ac.bg.fon.ps.logic.impl.PretraziFilmove;
import rs.ac.bg.fon.ps.logic.impl.PretraziProjekcije;
import rs.ac.bg.fon.ps.logic.impl.PretraziSale;
import rs.ac.bg.fon.ps.logic.impl.UcitajListuDnevnihRasporeda;
import rs.ac.bg.fon.ps.logic.impl.UcitajListuFilmova;
import rs.ac.bg.fon.ps.logic.impl.UcitajListuKorisnika;
import rs.ac.bg.fon.ps.logic.impl.UcitajListuPDR;
import rs.ac.bg.fon.ps.logic.impl.UcitajListuProjekcija;
import rs.ac.bg.fon.ps.logic.impl.UcitajListuSala;

/**
 *
 * @author GaGiiiii
 */
public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public LinkedList<IDomain> ucitajListuKorisnika(LinkedList<IDomain> korisnici) throws Exception {
        SistemskeOperacije so = new UcitajListuKorisnika(korisnici);
        so.execute();

        return so.getList();
    }

    public IDomain kreirajFilm(Film film) throws Exception {
        SistemskeOperacije so = new KreirajFilm(film);
        so.execute();

        return so.getDomainObject();
    }

    public IDomain kreirajSalu(Sala sala) throws Exception {
        SistemskeOperacije so = new KreirajSalu(sala);
        so.execute();

        return so.getDomainObject();
    }

    public LinkedList<IDomain> ucitajListuFilmova(LinkedList<IDomain> filmovi) throws Exception {
        SistemskeOperacije so = new UcitajListuFilmova(filmovi);
        so.execute();

        return so.getList();
    }

    public LinkedList<IDomain> ucitajListuSala(LinkedList<IDomain> sale) throws Exception {
        SistemskeOperacije so = new UcitajListuSala(sale);
        so.execute();

        return so.getList();
    }

    public IDomain kreirajProjekciju(Projekcija projekcija) throws Exception {
        SistemskeOperacije so = new KreirajProjekciju(projekcija);
        so.execute();

        return so.getDomainObject();
    }

    public LinkedList<IDomain> pretraziFilmove(String kriterijum, LinkedList<IDomain> list) throws Exception {
        SistemskeOperacije so = new PretraziFilmove(kriterijum, list);
        so.execute();

        return so.getList();
    }

    public boolean obrisiFilm(Film film) throws Exception {
        SistemskeOperacije so = new ObrisiFilm(film);
        so.execute();

        return so.isRet();
    }

    public LinkedList<IDomain> pretraziSale(String kriterijum, LinkedList<IDomain> list) throws Exception {
        SistemskeOperacije so = new PretraziSale(kriterijum, list);
        so.execute();

        return so.getList();
    }

    public LinkedList<IDomain> pretraziProjekcije(String kriterijum, LinkedList<IDomain> list) throws Exception {
        SistemskeOperacije so = new PretraziProjekcije(kriterijum, list);
        so.execute();

        return so.getList();
    }

    public LinkedList<IDomain> ucitajListuProjekcija(LinkedList<IDomain> projekcije) throws Exception {
        SistemskeOperacije so = new UcitajListuProjekcija(projekcije);
        so.execute();

        return so.getList();
    }

    public IDomain izmeniProjekciju(Projekcija projekcija) throws Exception {
        SistemskeOperacije so = new IzmeniProjekciju(projekcija);
        so.execute();

        return so.getDomainObject();
    }

    public IDomain kreirajDnevniRaspored(KreirajDnevniRasporedHelp kdrh) throws Exception {
        SistemskeOperacije so = new KreirajDnevniRaspored(kdrh);
        so.execute();

        return so.getDomainObject();
    }

    public LinkedList<IDomain> ucitajListuDnevnihRasporeda(LinkedList<IDomain> dnevniRasporedi) throws Exception {
        SistemskeOperacije so = new UcitajListuDnevnihRasporeda(dnevniRasporedi);
        so.execute();

        return so.getList();
    }

    public LinkedList<IDomain> ucitajListuPDR(LinkedList<IDomain> pdrs) throws Exception {
        SistemskeOperacije so = new UcitajListuPDR(pdrs);
        so.execute();

        return so.getList();
    }

    public IDomain izmeniDnevniRaspored(KreirajDnevniRasporedHelp kdrh) throws Exception {
        SistemskeOperacije so = new IzmeniDnevniRaspored(kdrh);
        so.execute();

        return so.getDomainObject();
    }

}
