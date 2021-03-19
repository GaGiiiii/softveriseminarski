/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ps.communication.CommunicationWithServer;
import rs.ac.bg.fon.ps.communication.Operation;
import rs.ac.bg.fon.ps.communication.Request;
import rs.ac.bg.fon.ps.communication.Response;
import rs.ac.bg.fon.ps.domain.Dnevni_Raspored;
import rs.ac.bg.fon.ps.domain.Film;
import rs.ac.bg.fon.ps.domain.Projekcija;
import rs.ac.bg.fon.ps.helpClasses.KreirajDnevniRasporedHelp;
import rs.ac.bg.fon.ps.view.tableModels.ProjekcijaTableModel;

/**
 *
 * @author GaGiiiii
 */
public class KreirajDnevniRasporedForm extends javax.swing.JDialog {

    ProjekcijaTableModel projekcijeTableModel;

    public KreirajDnevniRasporedForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Kreiranje filma");
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        datum = new javax.swing.JTextField();
        kreirajBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        projekcijeTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("KREIRANJE DNEVNOG RASPOREDA");

        jLabel8.setText("Datum (dd-mm-yyyy)");

        kreirajBtn.setText("KREIRAJ");
        kreirajBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kreirajBtnActionPerformed(evt);
            }
        });

        projekcijeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(projekcijeTable);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Izaberite projekcije");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datum, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kreirajBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(11, 11, 11)
                .addComponent(jLabel10)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kreirajBtn)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kreirajBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kreirajBtnActionPerformed
        try {
            Date date2 = null;
            try {
                String date = datum.getText();
                date2 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(this, "Pogresan format datuma", "Greska prilikom kreiranja dnevnog rasporeda", JOptionPane.ERROR_MESSAGE);

                return;
            }

            int[] selectedRows = projekcijeTable.getSelectedRows();
            LinkedList<Projekcija> projekcije = new LinkedList<>();

            if (selectedRows.length == 0) {
                JOptionPane.showMessageDialog(this, "Niste izabrali projekcije", "Greska prilikom kreiranja dnevnog rasporeda", JOptionPane.ERROR_MESSAGE);

                return;
            } else {
                for (int i = 0; i < selectedRows.length; i++) {
                    Projekcija projekcija = (Projekcija) projekcijeTableModel.getValueAtRow(selectedRows[i]);
                    projekcije.add(projekcija);
                    System.out.println(projekcija.getFilm().getNaziv());
                }
                System.out.println(projekcije);
            }

            Dnevni_Raspored dr = new Dnevni_Raspored(Long.MIN_VALUE, date2);
            KreirajDnevniRasporedHelp kdrh = new KreirajDnevniRasporedHelp(dr, projekcije);

            Request req = new Request();
            req.setOperation(Operation.KREIRAJ_DNEVNI_RASPORED_SA_PROJEKCIJAMA);
            req.setParameter(kdrh);

            CommunicationWithServer.getInstance().sendRequest(req);
            Response res = CommunicationWithServer.getInstance().getResponse();

            if (res.getException() == null) {
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio dnevni raspored", "Uspesno kreiran dnevni raspored", JOptionPane.INFORMATION_MESSAGE);
                emptyFields();
            } else {
                JOptionPane.showMessageDialog(this, res.getException().getMessage(), "Neuspesno kreiranje dnevnog rasporeda", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska prilikom kreiranja dnevnog rasporeda", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }//GEN-LAST:event_kreirajBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField datum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton kreirajBtn;
    private javax.swing.JTable projekcijeTable;
    // End of variables declaration//GEN-END:variables

    private void emptyFields() {
        datum.setText("");
    }

    private void init() {
//        projekcijeTable.setRowSelectionAllowed(true);

        try {
            Request req = new Request();
            req.setOperation(Operation.UCITAJ_LISTU_PROJEKCIJA);

            CommunicationWithServer.getInstance().sendRequest(req);
            Response res = CommunicationWithServer.getInstance().getResponse();
            LinkedList<Projekcija> projekcije = (LinkedList<Projekcija>) res.getResponse();

            projekcijeTableModel = new ProjekcijaTableModel(projekcije);
            projekcijeTable.setModel(projekcijeTableModel);
        } catch (Exception ex) {
            Logger.getLogger(KreirajDnevniRasporedForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
