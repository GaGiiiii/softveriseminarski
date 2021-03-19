/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author GaGiiiii
 */
public class Film implements IDomain, Serializable {

    private Long film_id;
    private String naziv;
    private String zanr;
    private int trajanje;
    private double cena_karte;
    private String reziser;
    private String glumci;
    private Date datum_izlaska;
    private String opis;

    public Film() {
    }

    public Film(Long film_id, String naziv, String zanr, int trajanje, double cena_karte, String reziser, String glumci, Date datum_izlaska, String opis) {
        this.film_id = film_id;
        this.naziv = naziv;
        this.zanr = zanr;
        this.trajanje = trajanje;
        this.cena_karte = cena_karte;
        this.reziser = reziser;
        this.glumci = glumci;
        this.datum_izlaska = datum_izlaska;
        this.opis = opis;
    }

    public Long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Long film_id) {
        this.film_id = film_id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public double getCena_karte() {
        return cena_karte;
    }

    public void setCena_karte(double cena_karte) {
        this.cena_karte = cena_karte;
    }

    public String getReziser() {
        return reziser;
    }

    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public String getGlumci() {
        return glumci;
    }

    public void setGlumci(String glumci) {
        this.glumci = glumci;
    }

    public Date getDatum_izlaska() {
        return datum_izlaska;
    }

    public void setDatum_izlaska(Date datum_izlaska) {
        this.datum_izlaska = datum_izlaska;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String getTableName() {
        return "film";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long aLong) {
        film_id = aLong;
    }

    @Override
    public String getAttributeNamesForInsert() {
        return "naziv,zanr,trajanje,cena_karte,reziser,glumci,datum_izlaska,opis";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'" + naziv + "', '" + zanr + "', " + trajanje + ", " + cena_karte + ", '" + reziser + "', '" + glumci + "', '" + datum_izlaska + "', '" + opis + "'";
    }

    @Override
    public Long getId() {
        return film_id;
    }

    @Override
    public String getIdName() {
        return "film_id";
    }

    @Override
    public LinkedList<IDomain> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<IDomain> list = new LinkedList<>();
        while (rs.next()) {
            Long id = rs.getLong("film_id");
            String naziv = rs.getString("naziv");
            String zanr = rs.getString("zanr");
            int trajanje = rs.getInt("trajanje");
            double cena = rs.getDouble("cena_karte");
            String reziser = rs.getString("reziser");
            String glumci = rs.getString("glumci");
            Date datum = new java.util.Date(rs.getDate("datum_izlaska").getTime());
            String opis = rs.getString("opis");

            Film film = new Film(id, naziv, zanr, trajanje, cena, reziser, glumci, datum, opis);
            list.add(film);
        }

        return list;
    }

    @Override
    public String setQueryForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM `film`";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Film other = (Film) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.naziv;
    }

}
