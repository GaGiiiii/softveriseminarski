/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.tableModels;

import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.Film;

/**
 *
 * @author GaGiiiii
 */
public class FilmTableModel extends AbstractTableModel {

    private final List<Film> filmovi;
    private String[] columnNames = new String[]{"NAZIV", "ZANR", "TRAJANJE", "CENA", "REZISER", "GLUMCI", "DATUM IZLASKA", "OPIS"};
    private Class[] columnClasses = new Class[]{String.class, String.class, Integer.class, Double.class, String.class, String.class, Date.class, String.class};

    public FilmTableModel(List<Film> filmovi) {
        this.filmovi = filmovi;
    }

    @Override
    public int getRowCount() {
        return filmovi == null ? 0 : filmovi.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Film film = filmovi.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return film.getNaziv();
            case 1:
                return film.getZanr();
            case 2:
                return film.getTrajanje();
            case 3:
                return film.getCena_karte();
            case 4:
                return film.getReziser();
            case 5:
                return film.getGlumci();
            case 6:
                return film.getDatum_izlaska();
            case 7:
                return film.getOpis();
            default:
                return null;
        }
    }

    public Object getValueAtRow(int rowIndex) {
        return filmovi.get(rowIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Film film = filmovi.get(rowIndex);

        switch (columnIndex) {
            case 0:
                film.setNaziv((String) aValue);
                break;
            case 1:
                film.setZanr((String) aValue);
                break;
            case 2:
                film.setTrajanje((int) aValue);
                break;
            case 3:
                film.setCena_karte((double) aValue);
                break;
            case 4:
                film.setReziser((String) aValue);
                break;
            case 5:
                film.setGlumci((String) aValue);
                break;
            case 6:
                film.setDatum_izlaska((Date) aValue);
                break;
            case 7:
                film.setOpis((String) aValue);
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
