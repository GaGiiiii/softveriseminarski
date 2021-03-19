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
public class Dnevni_Raspored implements IDomain, Serializable {

    private Long dnevni_raspored_id;
    private Date datum;

    public Dnevni_Raspored() {
    }

    public Dnevni_Raspored(Long dnevni_raspored_id, Date datum) {
        this.dnevni_raspored_id = dnevni_raspored_id;
        this.datum = datum;
    }

    public Long getDnevni_raspored_id() {
        return dnevni_raspored_id;
    }

    public void setDnevni_raspored_id(Long dnevni_raspored_id) {
        this.dnevni_raspored_id = dnevni_raspored_id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String getTableName() {
        return "dnevni_raspored";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long aLong) {
        dnevni_raspored_id = aLong;
    }

    @Override
    public String getAttributeNamesForInsert() {
        return "datum";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'" + datum + "'";
    }

    @Override
    public Long getId() {
        return dnevni_raspored_id;
    }

    @Override
    public String getIdName() {
        return "dnevni_raspored_id";
    }

    @Override
    public LinkedList<IDomain> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<IDomain> list = new LinkedList<>();
        while (rs.next()) {
            Long id = rs.getLong("dnevni_raspored_id");
            Date datum = new java.util.Date(rs.getDate("datum").getTime());

            Dnevni_Raspored dnevniRaspored = new Dnevni_Raspored(id, datum);
            list.add(dnevniRaspored);
        }

        return list;
    }

    @Override
    public String setQueryForUpdate() {
        return "UPDATE `dnevni_raspored` SET datum = '" + datum
                + "' WHERE dnevni_raspored_id = " + getId();
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM `dnevni_raspored`";
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
        final Dnevni_Raspored other = (Dnevni_Raspored) obj;
        if (!Objects.equals(this.datum, other.datum) || (Objects.equals(this.datum, other.datum) && other.getId().equals(this.getId()))) {
            return false;
        }
        return true;
    }

}
