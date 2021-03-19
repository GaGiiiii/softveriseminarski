/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author GaGiiiii
 */
public class P_DR implements IDomain, Serializable {

    private Long p_dr_id;
    private Projekcija projekcija;
    private Dnevni_Raspored dnevniRaspored;

    public P_DR() {
    }

    public P_DR(Long p_dr_id, Projekcija projekcija, Dnevni_Raspored dnevniRaspored) {
        this.p_dr_id = p_dr_id;
        this.projekcija = projekcija;
        this.dnevniRaspored = dnevniRaspored;
    }

    public Long getP_dr_id() {
        return p_dr_id;
    }

    public void setP_dr_id(Long p_dr_id) {
        this.p_dr_id = p_dr_id;
    }

    public Projekcija getProjekcija() {
        return projekcija;
    }

    public void setProjekcija(Projekcija projekcija) {
        this.projekcija = projekcija;
    }

    public Dnevni_Raspored getDnevniRaspored() {
        return dnevniRaspored;
    }

    public void setDnevniRaspored(Dnevni_Raspored dnevniRaspored) {
        this.dnevniRaspored = dnevniRaspored;
    }

    @Override
    public String getTableName() {
        return "p_dr";
    }

    @Override
    public boolean isAutoincrement() {
        return true;
    }

    @Override
    public void setObjectId(long aLong) {
        p_dr_id = aLong;
    }

    @Override
    public String getAttributeNamesForInsert() {
        return "projekcija_id,dnevni_raspored_id";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return projekcija.getId() + ", " + dnevniRaspored.getId();
    }

    @Override
    public Long getId() {
        return p_dr_id;
    }

    @Override
    public String getIdName() {
        return "p_dr_id";
    }

    @Override
    public LinkedList<IDomain> getListFromRs(ResultSet rs) throws Exception {
        LinkedList<IDomain> list = new LinkedList<>();
        while (rs.next()) {
            Long id = rs.getLong("p_dr_id");

            Projekcija projekcija = new Projekcija();
            projekcija.setProjekcija_id(rs.getLong("projekcija_id"));

            Dnevni_Raspored dnevniRaspored = new Dnevni_Raspored();
            dnevniRaspored.setDnevni_raspored_id(rs.getLong("dnevni_raspored_id"));

            P_DR pdr = new P_DR(id, projekcija, dnevniRaspored);
            list.add(pdr);
        }

        return list;
    }

    @Override
    public String setQueryForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String prepareQueryForSelect() {
        return "SELECT * FROM `P_DR`";
    }

}
