/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.communication;

import java.io.Serializable;

/**
 *
 * @author GaGiiiii
 */
public class Response implements Serializable {

    private Exception exception;
    private Object response;

    public Response() {
        exception = null;
    }

    public Response(Exception exception, Object response) {
        this.exception = exception;
        this.response = response;
    }

    public Object getResponse() {
        return response;
    }

    public void setREsponse(Object response) {
        this.response = response;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
