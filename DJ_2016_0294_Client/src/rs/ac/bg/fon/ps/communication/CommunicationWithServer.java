/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GaGiiiii
 */
public class CommunicationWithServer {

    private Socket socket;

    private static CommunicationWithServer instance;

    private CommunicationWithServer() throws Exception {
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
//            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Server je ugasen.");
        }
    }

    public static CommunicationWithServer getInstance() throws Exception {
        if (instance != null) {
//            System.out.println(instance.socket.isClosed() + "A");
//            System.out.println(instance.socket.isConnected() + "B");
        }
        if (instance == null || instance.socket.isClosed()) {
            instance = new CommunicationWithServer();
        }

        return instance;
    }

    public void sendRequest(Request req) throws Exception {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(req);
        } catch (IOException ex) {
            instance = null;
            throw new Exception("Server je ugasen.");
        }
    }

    public Response getResponse() {
        ObjectInputStream ois = null;
        Response res = new Response();

        try {
            ois = new ObjectInputStream(socket.getInputStream());
            res = (Response) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }
}
