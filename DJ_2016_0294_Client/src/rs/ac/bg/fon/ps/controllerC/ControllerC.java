/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.controllerC;

import java.util.LinkedList;
import rs.ac.bg.fon.ps.communication.CommunicationWithServer;
import rs.ac.bg.fon.ps.communication.Operation;
import rs.ac.bg.fon.ps.communication.Request;
import rs.ac.bg.fon.ps.communication.Response;
import rs.ac.bg.fon.ps.domain.Dnevni_Raspored;
import rs.ac.bg.fon.ps.domain.Film;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.P_DR;
import rs.ac.bg.fon.ps.domain.Projekcija;
import rs.ac.bg.fon.ps.domain.Sala;
import rs.ac.bg.fon.ps.helpClasses.KreirajDnevniRasporedHelp;
import rs.ac.bg.fon.ps.helpClasses.PretragaHelp;

/**
 *
 * @author GaGiiiii
 */
public class ControllerC {

    private static ControllerC instance;

    private ControllerC() {
    }

    public static ControllerC getInstance() {
        if (instance == null) {
            instance = new ControllerC();
        }
        return instance;
    }

//    public LinkedList<IDomain> ucitajListuKorisnika(LinkedList<IDomain> korisnici) throws Exception {
//        SistemskeOperacije so = new UcitajListuKorisnika(korisnici);
//        so.execute();
//
//        return so.getList();
//    }
//
    public Response kreirajFilm(Film film) throws Exception {
        Request req = new Request();
        Response res = new Response();

        req.setOperation(Operation.KREIRAJ_FILM);
        req.setParameter(film);

        CommunicationWithServer.getInstance().sendRequest(req);

        return res = CommunicationWithServer.getInstance().getResponse();
    }

    public Response kreirajSalu(Sala sala) throws Exception {
        Request req = new Request();
        Response res = new Response();
        req.setOperation(Operation.KREIRAJ_SALU);
        req.setParameter(sala);

        CommunicationWithServer.getInstance().sendRequest(req);
        return res = CommunicationWithServer.getInstance().getResponse();
    }

    public LinkedList<Film> ucitajListuFilmova(LinkedList<Film> filmovi) throws Exception {
        Request req = new Request();
        req.setOperation(Operation.UCITAJ_LISTU_FILMOVA);

        CommunicationWithServer.getInstance().sendRequest(req);
        Response res = CommunicationWithServer.getInstance().getResponse();

        return filmovi = (LinkedList<Film>) res.getResponse();
    }
//

    public LinkedList<Sala> ucitajListuSala(LinkedList<Sala> sale) throws Exception {
        Request req = new Request();
        req.setOperation(Operation.UCITAJ_LISTU_SALA);

        CommunicationWithServer.getInstance().sendRequest(req);
        Response res = CommunicationWithServer.getInstance().getResponse();

        return sale = (LinkedList<Sala>) res.getResponse();
    }

    public Response kreirajProjekciju(Projekcija projekcija) throws Exception {
        Request req = new Request();
        Response res = new Response();
        req.setOperation(Operation.KREIRAJ_PROJEKCIJU);
        req.setParameter(projekcija);

        CommunicationWithServer.getInstance().sendRequest(req);

        return res = CommunicationWithServer.getInstance().getResponse();
    }

    public Response pretraziFilmove(String kriterijum, LinkedList<IDomain> list) throws Exception {
        Request req = new Request();
        Response res = new Response();
        req.setOperation(Operation.PRETRAZI_FILMOVE);
        req.setParameter(new PretragaHelp(kriterijum, list));

        CommunicationWithServer.getInstance().sendRequest(req);

        return res = CommunicationWithServer.getInstance().getResponse();
    }

    public Response obrisiFilm(Film film) throws Exception {
        Request req = new Request();
        Response res = new Response();
        req.setOperation(Operation.OBRISI_FILM);
        req.setParameter(film);

        CommunicationWithServer.getInstance().sendRequest(req);

        return res = CommunicationWithServer.getInstance().getResponse();
    }

    public Response pretraziSale(String kriterijum, LinkedList<IDomain> list) throws Exception {
        Request req = new Request();
        Response res = new Response();
        req.setOperation(Operation.PRETRAZI_SALE);
        req.setParameter(new PretragaHelp(kriterijum, list));

        CommunicationWithServer.getInstance().sendRequest(req);

        return res = CommunicationWithServer.getInstance().getResponse();
    }

    public Response pretraziProjekcije(String kriterijum, LinkedList<IDomain> list) throws Exception {
        Request req = new Request();
        Response res = new Response();
        req.setOperation(Operation.PRETRAZI_PROJEKCIJE);
        req.setParameter(new PretragaHelp(kriterijum, list));

        CommunicationWithServer.getInstance().sendRequest(req);

        return res = CommunicationWithServer.getInstance().getResponse();
    }

    public LinkedList<Projekcija> ucitajListuProjekcija(LinkedList<Projekcija> projekcije) throws Exception {
        Request req = new Request();
        req.setOperation(Operation.UCITAJ_LISTU_PROJEKCIJA);

        CommunicationWithServer.getInstance().sendRequest(req);
        Response res = CommunicationWithServer.getInstance().getResponse();

        return projekcije = (LinkedList<Projekcija>) res.getResponse();
    }

    public Response izmeniProjekciju(Projekcija projekcija) throws Exception {
        Request req = new Request();
        Response res = new Response();
        req.setOperation(Operation.IZMENI_PROJEKCIJU);
        req.setParameter(projekcija);

        CommunicationWithServer.getInstance().sendRequest(req);
        return res = CommunicationWithServer.getInstance().getResponse();
    }

    public Response kreirajDnevniRaspored(KreirajDnevniRasporedHelp kdrh) throws Exception {
        Request req = new Request();
        req.setOperation(Operation.KREIRAJ_DNEVNI_RASPORED_SA_PROJEKCIJAMA);
        req.setParameter(kdrh);

        CommunicationWithServer.getInstance().sendRequest(req);
        Response res = new Response();

        return res = CommunicationWithServer.getInstance().getResponse();
    }

    public LinkedList<Dnevni_Raspored> ucitajListuDnevnihRasporeda(LinkedList<Dnevni_Raspored> dnevniRasporedi) throws Exception {
        Request req = new Request();
        req.setOperation(Operation.UCITAJ_LISTU_DNEVNIH_RASPOREDA);

        CommunicationWithServer.getInstance().sendRequest(req);
        Response res = CommunicationWithServer.getInstance().getResponse();

        return dnevniRasporedi = (LinkedList<Dnevni_Raspored>) res.getResponse();
    }

    public LinkedList<P_DR> ucitajListuPDR(LinkedList<P_DR> pdrs) throws Exception {
        Request req = new Request();
        req.setOperation(Operation.UCITAJ_LISTU_P_DR);

        CommunicationWithServer.getInstance().sendRequest(req);
        Response res = CommunicationWithServer.getInstance().getResponse();

        return pdrs = (LinkedList<P_DR>) res.getResponse();
    }
//

    public Response izmeniDnevniRaspored(KreirajDnevniRasporedHelp kdrh) throws Exception {
        Request req = new Request();
        req.setOperation(Operation.IZMENI_DNEVNI_RASPORED);
        req.setParameter(kdrh);

        CommunicationWithServer.getInstance().sendRequest(req);
        Response res = new Response();

        return res = CommunicationWithServer.getInstance().getResponse();
    }

}
