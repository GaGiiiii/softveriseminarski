/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.ps.view.forms.ServerForm;

/**
 *
 * @author GaGiiiii
 */
public class StartServerThread extends Thread {

    ServerForm serverForm;
    ServerSocket serverSocket;
    ArrayList<Socket> connectedUsers;

    public StartServerThread(ServerForm sf) {
        this.serverForm = sf;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9000);
            connectedUsers = new ArrayList<>();
            serverForm.serverStarted();
            System.out.println("Server started");

            while (true) {
                Socket s = serverSocket.accept();
                connectedUsers.add(s);
                CommunicationWithClient cwc = new CommunicationWithClient(s, serverForm);
                cwc.start();
            }

        } catch (IOException ex) {
            if (ex instanceof SocketException) {
                System.out.println("Server is closed");
            } else {
                Logger.getLogger(StartServerThread.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    public void stopServer() {
        try {
            for (Socket socket : connectedUsers) {
                System.out.println(socket);
                socket.close();
            }
            serverSocket.close();
            serverForm.serverStopped();
        } catch (IOException ex) {
            Logger.getLogger(StartServerThread.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
