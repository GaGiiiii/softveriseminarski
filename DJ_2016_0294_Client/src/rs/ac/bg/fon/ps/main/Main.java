/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ps.view.forms.LoginForm;

/**
 *
 * @author GaGiiiii
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        new LoginForm().setVisible(true);
    }
}