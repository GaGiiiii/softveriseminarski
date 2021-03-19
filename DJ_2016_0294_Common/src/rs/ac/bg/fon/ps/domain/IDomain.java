/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author GaGiiiii
 */
public interface IDomain {

    public String getTableName();

    public boolean isAutoincrement();

    public void setObjectId(long aLong);

    public String getAttributeNamesForInsert();

    public String getAttributeValuesForInsert();

    public Long getId();

    public String getIdName();

    public LinkedList<IDomain> getListFromRs(ResultSet rs) throws Exception;

    public String setQueryForUpdate();

    public String prepareQueryForSelect();

}
