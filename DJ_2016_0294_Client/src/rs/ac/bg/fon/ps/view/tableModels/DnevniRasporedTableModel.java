/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.tableModels;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.Dnevni_Raspored;

/**
 *
 * @author GaGiiiii
 */
public class DnevniRasporedTableModel extends AbstractTableModel {

    private final List<Dnevni_Raspored> dnevniRasporedi;
    private String[] columnNames = new String[]{"DATUM"};
    private Class[] columnClasses = new Class[]{Date.class};

    public DnevniRasporedTableModel(List<Dnevni_Raspored> dnevniRasporedi) {
        this.dnevniRasporedi = dnevniRasporedi;
    }

    @Override
    public int getRowCount() {
        return dnevniRasporedi == null ? 0 : dnevniRasporedi.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dnevni_Raspored dnevniRaspored = dnevniRasporedi.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return dnevniRaspored.getDatum();
            default:
                return null;
        }
    }

    public Object getValueAtRow(int rowIndex) {
        return dnevniRasporedi.get(rowIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Dnevni_Raspored dnevniRaspored = dnevniRasporedi.get(rowIndex);

        switch (columnIndex) {
            case 0:
                dnevniRaspored.setDatum((Date) aValue);
                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}
