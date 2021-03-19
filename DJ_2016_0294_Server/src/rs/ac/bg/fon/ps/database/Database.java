/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.database;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;
import rs.ac.bg.fon.ps.domain.Dnevni_Raspored;
import rs.ac.bg.fon.ps.domain.Film;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Korisnik;
import rs.ac.bg.fon.ps.domain.P_DR;
import rs.ac.bg.fon.ps.domain.Projekcija;
import rs.ac.bg.fon.ps.domain.Sala;

/**
 *
 * @author GaGiiiii
 */
public class Database {

    private Connection connection;

    public void connect() throws Exception {
        if (connection == null || connection.isClosed()) {
            Properties properties = new Properties();
            String serverConfigFilePath = new File("src\\rs\\ac\\bg\\fon\\ps\\database\\config.txt").getAbsolutePath();
            properties.load(new FileInputStream(serverConfigFilePath));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        }
    }

    public void disconnect() throws Exception {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska prilikom raskidanja konekcije sa bazom!\n" + ex.getMessage());
            }
        }
    }

    public void commit() throws Exception {
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska prilikom potvrdjivanja transakcije!\n" + ex.getMessage());
            }
        }
    }

    public void rollback() throws Exception {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Greska prilikom ponistavanja transakcije!\n" + ex.getMessage());
            }
        }
    }

    public LinkedList<IDomain> getAll(Class klasa, String where, String orderBy) throws Exception {

        Statement statement = connection.createStatement();
        IDomain domain;

        if (klasa == Korisnik.class) {
            domain = new Korisnik();
        } else if (klasa == Film.class) {
            domain = new Film();
        } else if (klasa == Sala.class) {
            domain = new Sala();
        } else if (klasa == Projekcija.class) {
            domain = new Projekcija();
        } else if (klasa == Dnevni_Raspored.class) {
            domain = new Dnevni_Raspored();
        } else if (klasa == P_DR.class) {
            domain = new P_DR();
        } else {
            domain = null;
        }

        String query = domain.prepareQueryForSelect();

        if (!where.equals("")) {
            query += " where " + where;
        }

        if (!orderBy.equals("")) {
            query += " order by " + orderBy;
        }

        ResultSet rs = statement.executeQuery(query);

        return domain.getListFromRs(rs);

    }

    public IDomain update(IDomain domainObject) throws Exception {
        try {
            String upit = domainObject.setQueryForUpdate();

            System.out.println(upit);

            Statement statement = connection.createStatement();

            statement.executeUpdate(upit);
            System.out.println("Uspesno izmenjen " + domainObject.getTableName() + " u bazi!");
            return domainObject;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage() + "Greska prilikom kreiranja " + domainObject.getTableName() + " u bazi!\n");
        }
    }

    public boolean remove(IDomain domainObject) {
        try {
            String upit = "DELETE FROM " + domainObject.getTableName() + " WHERE " + domainObject.getIdName() + "= " + domainObject.getId();
            System.out.println(upit);
            Statement statement = connection.createStatement();
            statement.executeUpdate(upit);
            System.out.println("Uspesno obrisan " + domainObject.getTableName() + " iz baze!");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public IDomain insert(IDomain domainObject) throws Exception {
        try {

            String query = "INSERT INTO " + domainObject.getTableName() + " (" + domainObject.getAttributeNamesForInsert() + ") VALUES (" + domainObject.getAttributeValuesForInsert() + ")";
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            if (domainObject.isAutoincrement()) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    domainObject.setObjectId(rs.getLong(1));
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getLocalizedMessage() + "Greska prilikom kreiranja " + domainObject.getTableName() + " u bazi!\n");
        }

        return domainObject;
    }
}
