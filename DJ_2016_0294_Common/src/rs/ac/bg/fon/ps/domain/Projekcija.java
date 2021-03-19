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
public class Projekcija implements IDomain, Serializable {

    private Long projekcija_id;
    private Date vreme;
    private Film film;
    private Sala sala;

    public Projekcija() {
    }

    public Projekcija(Long projekcija_id, Date vreme, Film film, Sala sala) {
        this.projekcija_id = projekcija_id;
        this.vreme = vreme;
        this.film = film;
        this.sala = sala;
    }

    public Long getProjekcija_id() {
        return projekcija_id;
    }

    public void setProjekcija_id(Long projekcija_id) {
        this.projekcija_id = projekcija_id;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String getTableName() {
        return "projekcija";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long aLong) {
        projekcija_id = aLong;
    }

    @Override
    public String getAttributeNamesForInsert() {
        return "vreme,film_id,sala_id";

    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'" + vreme + "', " + film.getId() + ", " + sala.getId();
    }

    @Override
    public Long getId() {
        return projekcija_id;
    }

    @Override
    public String getIdName() {
        return "projekcija_id";
    }

    @Override
    public LinkedList<IDomain> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<IDomain> list = new LinkedList<>();
        while (rs.next()) {
            Long id = rs.getLong("projekcija_id");
            Date vreme = new java.util.Date(rs.getTimestamp("vreme").getTime());
            Film film = new Film();
            film.setFilm_id(rs.getLong("film_id"));
            Sala sala = new Sala();
            sala.setSala_id(rs.getLong("sala_id"));

            Projekcija projekcija = new Projekcija(id, vreme, film, sala);
            list.add(projekcija);
        }

        return list;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE projekcija SET vreme = '" + vreme
                + "', film_id = " + getFilm().getId() + ", sala_id = "
                + getSala().getId()
                + " WHERE projekcija_id = " + getId();
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM `projekcija`";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        final Projekcija other = (Projekcija) obj;

        final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
        int otherTrajanje = other.getFilm().getTrajanje();
        long currentTime = other.getVreme().getTime();

        Date currentTimeDate = new Date(currentTime);
        Date afterAddingMins = new Date(currentTime + (otherTrajanje * ONE_MINUTE_IN_MILLIS));

//        System.out.println(currentTimeDate);
//        System.out.println(afterAddingMins);
//        System.out.println(this.vreme);
//        System.out.println(this.vreme.compareTo(currentTimeDate) >= 0 && this.vreme.compareTo(afterAddingMins) <= 0);
        if (this.getSala().getId().equals(other.getSala().getId()) && !this.getId().equals(other.getId())) {
            if (this.vreme.compareTo(currentTimeDate) >= 0 && this.vreme.compareTo(afterAddingMins) <= 0) {
                // Znaci da sam upao izmedju projekcije i ne moze
                return true;
            } else {
                return false;
            }
        }

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (!Objects.equals(this.vreme, other.vreme)) {
            return false;
        }

        return true;
    }

}
