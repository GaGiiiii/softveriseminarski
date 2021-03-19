/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.ps.communication.Request;
import rs.ac.bg.fon.ps.communication.Response;
import rs.ac.bg.fon.ps.controller.Controller;
import rs.ac.bg.fon.ps.domain.Film;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Korisnik;
import rs.ac.bg.fon.ps.domain.Projekcija;
import rs.ac.bg.fon.ps.domain.Sala;
import rs.ac.bg.fon.ps.helpClasses.KreirajDnevniRasporedHelp;
import rs.ac.bg.fon.ps.helpClasses.PretragaHelp;
import rs.ac.bg.fon.ps.view.forms.ServerForm;

/**
 *
 * @author GaGiiiii
 */
public class CommunicationWithClient extends Thread {

    Socket socket;
    ServerForm serverForm;

    public CommunicationWithClient() {
    }

    public CommunicationWithClient(Socket socket, ServerForm serverForm) {
        this.socket = socket;
        this.serverForm = serverForm;
    }

    @Override
    public void run() {
        while (true) {
            Request req = getRequest();
            Response res = new Response();

            if (req != null) {
                switch (req.getOperation()) {
                    case LOGIN:
                        res = login(req, res);
                        break;
                    case KREIRAJ_FILM:
                        res = kreirajFilm(req, res);
                        break;
                    case KREIRAJ_SALU:
                        res = kreirajSalu(req, res);
                        break;
                    case UCITAJ_LISTU_FILMOVA:
                        res = ucitajListuFilmova(req, res);
                        break;
                    case UCITAJ_LISTU_SALA:
                        res = ucitajListuSala(req, res);
                        break;
                    case KREIRAJ_PROJEKCIJU:
                        res = kreirajProjekciju(req, res);
                        break;
                    case PRETRAZI_FILMOVE:
                        res = pretraziFilmove(req, res);
                        break;
                    case OBRISI_FILM:
                        res = obrisiFilm(req, res);
                        break;
                    case PRETRAZI_SALE:
                        res = pretraziSale(req, res);
                        break;
                    case PRETRAZI_PROJEKCIJE:
                        res = pretraziProjekcije(req, res);
                        break;
                    case UCITAJ_LISTU_PROJEKCIJA:
                        res = ucitajListuProjekcija(req, res);
                        break;
                    case IZMENI_PROJEKCIJU:
                        res = izmeniProjekciju(req, res);
                        break;
                    case KREIRAJ_DNEVNI_RASPORED_SA_PROJEKCIJAMA:
                        res = kreirajDnevniRaspored(req, res);
                        break;
                    case UCITAJ_LISTU_DNEVNIH_RASPOREDA:
                        res = ucitajListuDnevnihRasporeda(req, res);
                        break;
                    case UCITAJ_LISTU_P_DR:
                        res = ucitajListuPDR(req, res);
                        break;
                    case IZMENI_DNEVNI_RASPORED:
                        res = izmeniDnevniRaspored(req, res);
                        break;
                }
                sendResponse(res);
            }

        }
    }

    public void sendResponse(Response res) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(res);
        } catch (IOException ex) {
            Logger.getLogger(CommunicationWithClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Request getRequest() {
        ObjectInputStream ois = null;
        Request req = new Request();

        try {
            ois = new ObjectInputStream(socket.getInputStream());
            req = (Request) ois.readObject();
        } catch (IOException ex) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommunicationWithClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return req;
    }

    public Response login(Request req, Response res) {
        Korisnik k = (Korisnik) req.getParameter();

        if (k.getUsername().isEmpty() || k.getPassword().isEmpty()) {
            res.setException(new Exception("Polja ne mogu biti prazna."));

            return res;
        }

        LinkedList<IDomain> allUsers = null;
        boolean allGood = false;
        try {
            allUsers = Controller.getInstance().ucitajListuKorisnika(allUsers);
            for (IDomain korisnik : allUsers) {
                Korisnik k2 = (Korisnik) korisnik;
                if (k.getUsername().equals(k2.getUsername())) {
                    if (k.getPassword().equals(k2.getPassword())) {
                        res.setREsponse(k2);
                        allGood = true;
                    } else {
                        res.setException(new Exception("Pogresna sifra."));
                        allGood = true;
                    }
                }
            }
            if (!allGood) {
                res.setException(new Exception("Korisnik ne postoji u bazi."));
            }
        } catch (Exception ex) {
            res.setException(ex);
        }

        return res;
    }

    private Response kreirajFilm(Request req, Response res) {
        try {
            Film film = (Film) req.getParameter();
            IDomain domainObject = Controller.getInstance().kreirajFilm(film);

            res.setREsponse(domainObject);
        } catch (Exception e) {
            res.setException(e);
        }

        return res;
    }

    private Response kreirajSalu(Request req, Response res) {
        try {
            Sala sala = (Sala) req.getParameter();
            IDomain domainObject = Controller.getInstance().kreirajSalu(sala);

            res.setREsponse(domainObject);
        } catch (Exception e) {
            res.setException(e);
        }

        return res;
    }

    private Response ucitajListuFilmova(Request req, Response res) {
        try {
            LinkedList<IDomain> filmovi = null;
            filmovi = Controller.getInstance().ucitajListuFilmova(filmovi);
            res.setREsponse(filmovi);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationWithClient.class.getName()).log(Level.SEVERE, null, ex);
            res.setException(ex);
        }

        return res;
    }

    private Response ucitajListuSala(Request req, Response res) {
        try {
            LinkedList<IDomain> sale = null;
            sale = Controller.getInstance().ucitajListuSala(sale);
            res.setREsponse(sale);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationWithClient.class.getName()).log(Level.SEVERE, null, ex);
            res.setException(ex);
        }

        return res;
    }

    private Response kreirajProjekciju(Request req, Response res) {
        try {
            Projekcija projekcija = (Projekcija) req.getParameter();
            IDomain domainObject = Controller.getInstance().kreirajProjekciju(projekcija);

            res.setREsponse(domainObject);
        } catch (Exception e) {
            res.setException(e);
        }

        return res;
    }

    private Response pretraziFilmove(Request req, Response res) {
        try {
            LinkedList<IDomain> filmovi = null;
            PretragaHelp ph = (PretragaHelp) req.getParameter();
            filmovi = Controller.getInstance().pretraziFilmove(ph.getKriterijum(), ph.getList());
            res.setREsponse(filmovi);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationWithClient.class.getName()).log(Level.SEVERE, null, ex);
            res.setException(ex);
        }

        return res;
    }

    private Response obrisiFilm(Request req, Response res) {
        try {
            Film film = (Film) req.getParameter();
            Boolean ret = Controller.getInstance().obrisiFilm(film);

            res.setREsponse(ret);
        } catch (Exception e) {
            res.setException(e);

        }

        return res;
    }

    private Response pretraziSale(Request req, Response res) {
        try {
            LinkedList<IDomain> sale = null;
            PretragaHelp ph = (PretragaHelp) req.getParameter();
            sale = Controller.getInstance().pretraziSale(ph.getKriterijum(), ph.getList());
            res.setREsponse(sale);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationWithClient.class.getName()).log(Level.SEVERE, null, ex);
            res.setException(ex);
        }

        return res;
    }

    private Response pretraziProjekcije(Request req, Response res) {
        try {
            LinkedList<IDomain> projekcije = null;
            PretragaHelp ph = (PretragaHelp) req.getParameter();
            projekcije = Controller.getInstance().pretraziProjekcije(ph.getKriterijum(), ph.getList());
            res.setREsponse(projekcije);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationWithClient.class.getName()).log(Level.SEVERE, null, ex);
            res.setException(ex);
        }

        return res;
    }

    private Response ucitajListuProjekcija(Request req, Response res) {
        try {
            LinkedList<IDomain> projekcije = null;
            projekcije = Controller.getInstance().ucitajListuProjekcija(projekcije);
            res.setREsponse(projekcije);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationWithClient.class.getName()).log(Level.SEVERE, null, ex);
            res.setException(ex);
        }

        return res;
    }

    private Response izmeniProjekciju(Request req, Response res) {
        try {
            Projekcija projekcija = (Projekcija) req.getParameter();
            IDomain domainObject = Controller.getInstance().izmeniProjekciju(projekcija);

            res.setREsponse(domainObject);
        } catch (Exception e) {
            res.setException(e);
        }

        return res;
    }

    private Response kreirajDnevniRaspored(Request req, Response res) {
        try {
            KreirajDnevniRasporedHelp kdrh = (KreirajDnevniRasporedHelp) req.getParameter();
            IDomain domainObject = Controller.getInstance().kreirajDnevniRaspored(kdrh);

            res.setREsponse(domainObject);
        } catch (Exception e) {
            res.setException(e);
        }

        return res;
    }

    private Response ucitajListuDnevnihRasporeda(Request req, Response res) {
        try {
            LinkedList<IDomain> dnevniRasporedi = null;
            dnevniRasporedi = Controller.getInstance().ucitajListuDnevnihRasporeda(dnevniRasporedi);
            res.setREsponse(dnevniRasporedi);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationWithClient.class.getName()).log(Level.SEVERE, null, ex);
            res.setException(ex);
        }

        return res;
    }

    private Response ucitajListuPDR(Request req, Response res) {
        try {
            LinkedList<IDomain> pdrs = null;
            pdrs = Controller.getInstance().ucitajListuPDR(pdrs);
            res.setREsponse(pdrs);
        } catch (Exception ex) {
            Logger.getLogger(CommunicationWithClient.class.getName()).log(Level.SEVERE, null, ex);
            res.setException(ex);
        }

        return res;
    }

    private Response izmeniDnevniRaspored(Request req, Response res) {
        try {
            KreirajDnevniRasporedHelp kdrh = (KreirajDnevniRasporedHelp) req.getParameter();
            IDomain domainObject = Controller.getInstance().izmeniDnevniRaspored(kdrh);

            res.setREsponse(domainObject);
        } catch (Exception e) {
            res.setException(e);
        }

        return res;
    }
}
