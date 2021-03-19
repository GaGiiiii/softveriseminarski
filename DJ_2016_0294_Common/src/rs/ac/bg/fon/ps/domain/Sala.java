/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author GaGiiiii
 */
public class Sala implements IDomain, Serializable {

    private Long sala_id;
    private String naziv;
    private int broj_mesta;
    private boolean vip_mesta;
    private boolean klima;
    private boolean has3D;

    public Sala() {
    }

    public Sala(Long sala_id, String naziv, int broj_mesta, boolean vip_mesta, boolean klima, boolean has3D) {
        this.sala_id = sala_id;
        this.naziv = naziv;
        this.broj_mesta = broj_mesta;
        this.vip_mesta = vip_mesta;
        this.klima = klima;
        this.has3D = has3D;
    }

    public Long getSala_id() {
        return sala_id;
    }

    public void setSala_id(Long sala_id) {
        this.sala_id = sala_id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBroj_mesta() {
        return broj_mesta;
    }

    public void setBroj_mesta(int broj_mesta) {
        this.broj_mesta = broj_mesta;
    }

    public boolean isVip_mesta() {
        return vip_mesta;
    }

    public void setVip_mesta(boolean vip_mesta) {
        this.vip_mesta = vip_mesta;
    }

    public boolean isKlima() {
        return klima;
    }

    public void setKlima(boolean klima) {
        this.klima = klima;
    }

    public boolean isHas3D() {
        return has3D;
    }

    public void setHas3D(boolean has3D) {
        this.has3D = has3D;
    }

    @Override
    public String getTableName() {
        return "sala";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long aLong) {
        sala_id = aLong;
    }

    @Override
    public String getAttributeNamesForInsert() {
        return "naziv,broj_mesta,vip_mesta,klima,has3D";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'" + naziv + "', '" + broj_mesta + "', " + vip_mesta + ", " + klima + ", " + has3D + "";
    }

    @Override
    public Long getId() {
        return sala_id;
    }

    @Override
    public String getIdName() {
        return "sala_id";
    }

    @Override
    public LinkedList<IDomain> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<IDomain> list = new LinkedList<>();
        while (rs.next()) {
            Long id = rs.getLong("sala_id");
            String naziv = rs.getString("naziv");
            int brojMesta = rs.getInt("broj_mesta");
            boolean vip_mesta = rs.getBoolean("vip_mesta");
            boolean klima = rs.getBoolean("klima");
            boolean has3D = rs.getBoolean("has3D");

            Sala sala = new Sala(id, naziv, brojMesta, vip_mesta, klima, has3D);
            list.add(sala);
        }

        return list;
    }

    @Override
    public String setQueryForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM `sala`";
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Sala other = (Sala) obj;
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }

}
