/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.forms;

import javax.swing.JOptionPane;
import rs.ac.bg.fon.ps.communication.Response;
import rs.ac.bg.fon.ps.controllerC.ControllerC;
import rs.ac.bg.fon.ps.domain.Sala;

/**
 *
 * @author GaGiiiii
 */
public class KreirajSaluForm extends javax.swing.JDialog {

    /**
     * Creates new form KreirajFilmForm
     */
    public KreirajSaluForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Kreiranje filma");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        naziv = new javax.swing.JTextField();
        brojMesta = new javax.swing.JTextField();
        kreirajBtn = new javax.swing.JButton();
        vipMesta = new javax.swing.JComboBox<>();
        klima = new javax.swing.JComboBox<>();
        has3D = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("KREIRANJE SALE");

        jLabel2.setText("Broj mesta");

        jLabel3.setText("Naziv");

        jLabel4.setText("3D");

        jLabel5.setText("Vip mesta");

        jLabel6.setText("Klima");

        kreirajBtn.setText("KREIRAJ");
        kreirajBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kreirajBtnActionPerformed(evt);
            }
        });

        vipMesta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DA", "NE" }));

        klima.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DA", "NE" }));

        has3D.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DA", "NE" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(kreirajBtn)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(has3D, 0, 108, Short.MAX_VALUE)
                                .addComponent(klima, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vipMesta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(brojMesta)
                                .addComponent(naziv)))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(naziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(brojMesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(vipMesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(klima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(has3D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(kreirajBtn)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kreirajBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kreirajBtnActionPerformed
        try {
            String nazivf = naziv.getText();

            int brojMesta = -1;
            try {
                brojMesta = Integer.parseInt(this.brojMesta.getText());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "Broj mesta mora biti broj", "Greska prilikom kreiranja", JOptionPane.ERROR_MESSAGE);

                return;
            }

            boolean vipMesta = false;
            if (this.vipMesta.getSelectedItem().equals("DA")) {
                vipMesta = true;
            }

            boolean has3D = false;
            if (this.has3D.getSelectedItem().equals("DA")) {
                has3D = true;
            }
            
            System.out.println(this.has3D.getSelectedItem());

            boolean klima = false;
            if (this.klima.getSelectedItem().equals("DA")) {
                klima = true;
            }

            Sala sala = new Sala(Long.MAX_VALUE, nazivf, brojMesta, vipMesta, klima, has3D);
            Response res = ControllerC.getInstance().kreirajSalu(sala);

            if (res.getException() == null) {
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio salu", "Uspesno kreirana sala", JOptionPane.INFORMATION_MESSAGE);
                emptyFields();
            } else {
                JOptionPane.showMessageDialog(this, res.getException().getMessage(), "Neuspesno kreiranje sale", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska prilikom kreiranja", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }//GEN-LAST:event_kreirajBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField brojMesta;
    private javax.swing.JComboBox<String> has3D;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> klima;
    private javax.swing.JButton kreirajBtn;
    private javax.swing.JTextField naziv;
    private javax.swing.JComboBox<String> vipMesta;
    // End of variables declaration//GEN-END:variables

    private void emptyFields() {
        naziv.setText("");
        brojMesta.setText("");
    }
}
