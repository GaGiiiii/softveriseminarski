/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.forms;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import rs.ac.bg.fon.ps.communication.Response;
import rs.ac.bg.fon.ps.controllerC.ControllerC;
import rs.ac.bg.fon.ps.domain.Dnevni_Raspored;
import rs.ac.bg.fon.ps.domain.P_DR;
import rs.ac.bg.fon.ps.domain.Projekcija;
import rs.ac.bg.fon.ps.helpClasses.KreirajDnevniRasporedHelp;
import rs.ac.bg.fon.ps.view.tableModels.DnevniRasporedTableModel;
import rs.ac.bg.fon.ps.view.tableModels.ProjekcijaTableModel;

/**
 *
 * @author GaGiiiii
 */
public class IzmeniDnevniRasporedForm extends javax.swing.JDialog {

    private ProjekcijaTableModel projekcijeTableModel;
    private DnevniRasporedTableModel dnevniRasporedTableModel;
    private Dnevni_Raspored selectedDnevniRaspored;

    public IzmeniDnevniRasporedForm(java.awt.Frame parent, boolean modal) {
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
        jScrollPane2 = new javax.swing.JScrollPane();
        dnevniRasporedTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        izmenaPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projekcijeTable = new javax.swing.JTable();
        datum = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        izmeniBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("IZMENA DNEVNOG RASPOREDA");

        dnevniRasporedTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(dnevniRasporedTable);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Izaberite dnevni raspored");

        izmenaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Izmena rasporeda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

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
        jScrollPane1.setViewportView(projekcijeTable);

        jLabel8.setText("Datum (dd-mm-yyyy)");

        izmeniBtn.setText("IZMENI");
        izmeniBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izmeniBtnActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Izaberite projekcije");

        javax.swing.GroupLayout izmenaPanelLayout = new javax.swing.GroupLayout(izmenaPanel);
        izmenaPanel.setLayout(izmenaPanelLayout);
        izmenaPanelLayout.setHorizontalGroup(
            izmenaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(izmenaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(izmenaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(izmenaPanelLayout.createSequentialGroup()
                        .addGroup(izmenaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(izmeniBtn)
                            .addGroup(izmenaPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datum, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        izmenaPanelLayout.setVerticalGroup(
            izmenaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, izmenaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(izmenaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(datum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(izmeniBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(izmenaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(izmenaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izmeniBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izmeniBtnActionPerformed
        try {
            Date date2 = null;
            try {
                String date = datum.getText();
                date2 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(this, "Pogresan format datuma", "Greska prilikom izmene dnevnog rasporeda", JOptionPane.ERROR_MESSAGE);

                return;
            }

            int[] selectedRows = projekcijeTable.getSelectedRows();
            LinkedList<Projekcija> projekcije = new LinkedList<>();

            if (selectedRows.length == 0) {
                JOptionPane.showMessageDialog(this, "Niste izabrali projekcije", "Greska prilikom izmene dnevnog rasporeda", JOptionPane.ERROR_MESSAGE);

                return;
            } else {
                for (int i = 0; i < selectedRows.length; i++) {
                    Projekcija projekcija = (Projekcija) projekcijeTableModel.getValueAtRow(selectedRows[i]);
                    projekcije.add(projekcija);
                }
            }

            selectedDnevniRaspored.setDatum(date2);
            
            KreirajDnevniRasporedHelp kdrh = new KreirajDnevniRasporedHelp(selectedDnevniRaspored, projekcije);           
            Response res = ControllerC.getInstance().izmeniDnevniRaspored(kdrh);

            if (res.getException() == null) {
                JOptionPane.showMessageDialog(this, "Sistem je izmenio dnevni raspored", "Uspesno izmenjen dnevni raspored", JOptionPane.INFORMATION_MESSAGE);
                populateDnevniRasporediTable();
//                emptyFields();
            } else {
                JOptionPane.showMessageDialog(this, res.getException().getMessage(), "Neuspesna izmena dnevnog rasporeda", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska prilikom izmene dnevnog rasporeda", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }//GEN-LAST:event_izmeniBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField datum;
    private javax.swing.JTable dnevniRasporedTable;
    private javax.swing.JPanel izmenaPanel;
    private javax.swing.JButton izmeniBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable projekcijeTable;
    // End of variables declaration//GEN-END:variables

    private void emptyFields() {
        datum.setText("");
    }

    private void init() {
        izmenaPanel.setVisible(false);

        populateDnevniRasporediTable();

        dnevniRasporedTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    Dnevni_Raspored dnevniRaspored = (Dnevni_Raspored) dnevniRasporedTableModel.getValueAtRow(row);
                    selectedDnevniRaspored = dnevniRaspored;
                    izmenaPanel.setVisible(true);
                    populateProjekcijeTable();

                    Date date = dnevniRaspored.getDatum();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);

                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH);
                    int year = calendar.get(Calendar.YEAR);

                    datum.setText(String.format("%d-%02d-%d", day, month + 1, year));
                }
            }

        });
    }

    private void populateProjekcijeTable() {
        projekcijeTable.getSelectionModel().clearSelection();

        try {
            LinkedList<P_DR> pdrs = new LinkedList<>();
            pdrs = ControllerC.getInstance().ucitajListuPDR(pdrs);


            LinkedList<Projekcija> projekcije = new LinkedList<>();
            projekcije = ControllerC.getInstance().ucitajListuProjekcija(projekcije);

            projekcijeTableModel = new ProjekcijaTableModel(projekcije);
            projekcijeTable.setModel(projekcijeTableModel);

            int currentIndex = 0;

            for (Projekcija projekcija : projekcije) {
                for (P_DR pdr : pdrs) {
                    if (projekcija.getId().equals(pdr.getProjekcija().getId()) && pdr.getDnevniRaspored().getId().equals(selectedDnevniRaspored.getId())) {
                        projekcijeTable.getSelectionModel().addSelectionInterval(currentIndex, currentIndex);
                    }
                }

                currentIndex++;
            }

        } catch (Exception ex) {
            Logger.getLogger(IzmeniDnevniRasporedForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void populateDnevniRasporediTable() {
        try {
            LinkedList<Dnevni_Raspored> dnevniRasporedi = new LinkedList<>();
            dnevniRasporedi = ControllerC.getInstance().ucitajListuDnevnihRasporeda(dnevniRasporedi);

            dnevniRasporedTableModel = new DnevniRasporedTableModel(dnevniRasporedi);
            dnevniRasporedTable.setModel(dnevniRasporedTableModel);
        } catch (Exception ex) {
            Logger.getLogger(IzmeniDnevniRasporedForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
