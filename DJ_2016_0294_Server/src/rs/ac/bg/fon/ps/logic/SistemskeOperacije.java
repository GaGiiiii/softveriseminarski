/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.logic;

import java.util.LinkedList;
import rs.ac.bg.fon.ps.database.Database;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.validation.Validator;

/**
 *
 * @author GaGiiiii
 */
public abstract class SistemskeOperacije {

    protected Validator validator;
    protected Database database;
    protected IDomain domainObject;
    protected LinkedList<IDomain> list;
    protected boolean ret;

    public SistemskeOperacije() {
        database = new Database();
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    protected void checkPreconditions() throws Exception {
        if (validator != null) {
            validator.validate(domainObject);
        }
    }

    protected void connectStorage() throws Exception {
        getDatabase().connect();
    }

    protected void disconnectStorage() throws Exception {
        getDatabase().disconnect();
    }

    protected abstract void operation() throws Exception;

    public void execute() throws Exception {
        connectStorage();
        checkPreconditions();
        try {
            operation();
            getDatabase().commit();
        } catch (Exception ex) {
            getDatabase().rollback();
            throw ex;
        } finally {
            disconnectStorage();
        }
    }

    public IDomain getDomainObject() {
        return domainObject;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public void setDomainObject(IDomain domainObject) {
        this.domainObject = domainObject;
    }

    public LinkedList<IDomain> getList() {
        return list;
    }

    public void setList(LinkedList<IDomain> list) {
        this.list = list;
    }
}
