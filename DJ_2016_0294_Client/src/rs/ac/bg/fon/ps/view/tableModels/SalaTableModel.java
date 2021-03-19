/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.tableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.Sala;

/**
 *
 * @author GaGiiiii
 */
public class SalaTableModel extends AbstractTableModel {

    private final List<Sala> sale;
    private String[] columnNames = new String[]{"NAZIV", "BROJ MESTA", "VIP MESTA", "KLIMA", "3D"};
    private Class[] columnClasses = new Class[]{String.class, Integer.class, Boolean.class, Boolean.class, Boolean.class};

    public SalaTableModel(List<Sala> sale) {
        this.sale = sale;
    }

    @Override
    public int getRowCount() {
        return sale == null ? 0 : sale.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sala sala = sale.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return sala.getNaziv();
            case 1:
                return sala.getBroj_mesta();
            case 2:
                return sala.isVip_mesta();
            case 3:
                return sala.isKlima();
            case 4:
                return sala.isHas3D();
            default:
                return null;
        }
    }

    public Object getValueAtRow(int rowIndex) {
        return sale.get(rowIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Sala sala = sale.get(rowIndex);

        switch (columnIndex) {
            case 0:
                sala.setNaziv((String) aValue);
                break;
            case 1:
                sala.setBroj_mesta((int) aValue);
                break;
            case 2:
                sala.setVip_mesta((Boolean) aValue);
                break;
            case 3:
                sala.setKlima((Boolean) aValue);
                break;
            case 4:
                sala.setHas3D((Boolean) aValue);
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
