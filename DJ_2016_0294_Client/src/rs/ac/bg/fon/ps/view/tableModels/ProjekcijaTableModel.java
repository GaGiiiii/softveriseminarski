/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.tableModels;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.Film;
import rs.ac.bg.fon.ps.domain.Projekcija;
import rs.ac.bg.fon.ps.domain.Sala;

/**
 *
 * @author GaGiiiii
 */
public class ProjekcijaTableModel extends AbstractTableModel {

    private final List<Projekcija> projekcije;
    private String[] columnNames = new String[]{"VREME", "FILM", "SALA"};
    private Class[] columnClasses = new Class[]{String.class, Film.class, Sala.class};

    public ProjekcijaTableModel(List<Projekcija> projekcije) {
        this.projekcije = projekcije;
    }

    @Override
    public int getRowCount() {
        return projekcije == null ? 0 : projekcije.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Projekcija projekcija = projekcije.get(rowIndex);

        switch (columnIndex) {
            case 0:
                Date vreme = projekcija.getVreme();
                Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
                calendar.setTime(vreme);   // assigns calendar to given date 
                return String.format("%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
            case 1:
                return projekcija.getFilm();
            case 2:
                return projekcija.getSala();
            default:
                return null;
        }
    }

    public Object getValueAtRow(int rowIndex) {
        return projekcije.get(rowIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Projekcija projekcija = projekcije.get(rowIndex);

        switch (columnIndex) {
            case 0:
                projekcija.setVreme((Date) aValue);
                break;
            case 1:
                projekcija.setFilm((Film) aValue);
                break;
            case 2:
                projekcija.setSala((Sala) aValue);
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
