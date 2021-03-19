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
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import rs.ac.bg.fon.ps.communication.CommunicationWithServer;
import rs.ac.bg.fon.ps.communication.Operation;
import rs.ac.bg.fon.ps.communication.Request;
import rs.ac.bg.fon.ps.communication.Response;
import rs.ac.bg.fon.ps.domain.Film;
import rs.ac.bg.fon.ps.domain.IDomain;
import rs.ac.bg.fon.ps.domain.Projekcija;
import rs.ac.bg.fon.ps.domain.Sala;
import rs.ac.bg.fon.ps.helpClasses.PretragaHelp;
import rs.ac.bg.fon.ps.view.tableModels.FilmTableModel;
import rs.ac.bg.fon.ps.view.tableModels.ProjekcijaTableModel;

/**
 *
 * @author GaGiiiii
 */
public class PretraziProjekcijeForm extends javax.swing.JDialog {

    private ProjekcijaTableModel tableModel;
    private Projekcija selectedProjekcija;

    private LinkedList<Film> filmovi;
    private LinkedList<Sala> sale;

    public PretraziProjekcijeForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Pretrazivanje projekcija");
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
        jLabel3 = new javax.swing.JLabel();
        naziv = new javax.swing.JTextField();
        pretraziBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        projekcijeTable = new javax.swing.JTable();
        projekcijaInfoPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        closeBtn = new javax.swing.JButton();
        izmeniBtn = new javax.swing.JButton();
        vremeTxt = new javax.swing.JTextField();
        filmCb = new javax.swing.JComboBox<>();
        salaCb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("PRETRAZI PROJEKCIJE");

        jLabel3.setText("Unesi naziv filma / sale");

        pretraziBtn.setText("PRETRAZI");
        pretraziBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pretraziBtnActionPerformed(evt);
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

        jLabel2.setText("FILM");

        jLabel4.setText("VREME");

        jLabel7.setText("SALA");

        closeBtn.setText("ZATVORI");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        izmeniBtn.setText("IZMENI");
        izmeniBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izmeniBtnActionPerformed(evt);
            }
        });

        vremeTxt.setText("jTextField1");

        filmCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        salaCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout projekcijaInfoPanelLayout = new javax.swing.GroupLayout(projekcijaInfoPanel);
        projekcijaInfoPanel.setLayout(projekcijaInfoPanelLayout);
        projekcijaInfoPanelLayout.setHorizontalGroup(
            projekcijaInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projekcijaInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projekcijaInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(projekcijaInfoPanelLayout.createSequentialGroup()
                        .addGroup(projekcijaInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(projekcijaInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(projekcijaInfoPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(30, 30, 30))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, projekcijaInfoPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(40, 40, 40)))
                            .addGroup(projekcijaInfoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(38, 38, 38)))
                        .addGroup(projekcijaInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vremeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(filmCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salaCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(661, Short.MAX_VALUE))
                    .addGroup(projekcijaInfoPanelLayout.createSequentialGroup()
                        .addComponent(izmeniBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(closeBtn)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        projekcijaInfoPanelLayout.setVerticalGroup(
            projekcijaInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projekcijaInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projekcijaInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(vremeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(projekcijaInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(filmCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(projekcijaInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(salaCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(projekcijaInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(izmeniBtn)
                    .addComponent(closeBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projekcijaInfoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(naziv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pretraziBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(naziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pretraziBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(projekcijaInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pretraziBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pretraziBtnActionPerformed
        try {

            String nazivf = naziv.getText();
            LinkedList<IDomain> projekcije = new LinkedList<>();

            Request req = new Request();
            req.setOperation(Operation.PRETRAZI_PROJEKCIJE);
            req.setParameter(new PretragaHelp(nazivf, projekcije));

            CommunicationWithServer.getInstance().sendRequest(req);
            Response res = CommunicationWithServer.getInstance().getResponse();

            if (res.getException() == null) {
                tableModel = new ProjekcijaTableModel((List<Projekcija>) res.getResponse());
                projekcijeTable.setModel(tableModel);
            } else {
                JOptionPane.showMessageDialog(this, res.getException().getMessage(), "Neuspesno pretrazivanje projekcija", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska prilikom pretrazivanja projekcija", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }//GEN-LAST:event_pretraziBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        projekcijaInfoPanel.setVisible(false);
    }//GEN-LAST:event_closeBtnActionPerformed

    private void izmeniBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izmeniBtnActionPerformed
        try {
            Date date = null;

            try {
                String vreme = this.vremeTxt.getText();
                date = new SimpleDateFormat("HH:mm").parse(vreme);
            } catch (ParseException pe) {
                JOptionPane.showMessageDialog(this, "Pogresano uneto vreme", "Greska prilikom kreiranja", JOptionPane.ERROR_MESSAGE);

                return;
            }
            Film film = (Film) filmCb.getSelectedItem();
            Sala sala = (Sala) salaCb.getSelectedItem();

            selectedProjekcija.setVreme(date);
            selectedProjekcija.setFilm(film);
            selectedProjekcija.setSala(sala);

            Request req = new Request();
            req.setOperation(Operation.IZMENI_PROJEKCIJU);
            req.setParameter(selectedProjekcija);

            CommunicationWithServer.getInstance().sendRequest(req);
            Response res = CommunicationWithServer.getInstance().getResponse();

            if (res.getException() == null) {
                JOptionPane.showMessageDialog(this, "Sistem je zapamtio projekciju", "Uspesno izmenjena projekcija", JOptionPane.INFORMATION_MESSAGE);
                req.setOperation(Operation.UCITAJ_LISTU_PROJEKCIJA);

                CommunicationWithServer.getInstance().sendRequest(req);
                res = CommunicationWithServer.getInstance().getResponse();
                LinkedList<Projekcija> projekcije = (LinkedList<Projekcija>) res.getResponse();
                tableModel = new ProjekcijaTableModel((List<Projekcija>) res.getResponse());
                projekcijeTable.setModel(tableModel);
            } else {
                JOptionPane.showMessageDialog(this, res.getException().getMessage(), "Neuspesna izmena projekcije", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska prilikom kreiranja", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_izmeniBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBtn;
    private javax.swing.JComboBox<Object> filmCb;
    private javax.swing.JButton izmeniBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField naziv;
    private javax.swing.JButton pretraziBtn;
    private javax.swing.JPanel projekcijaInfoPanel;
    private javax.swing.JTable projekcijeTable;
    private javax.swing.JComboBox<Object> salaCb;
    private javax.swing.JTextField vremeTxt;
    // End of variables declaration//GEN-END:variables

    private void init() {
        try {
            populateFilmoviList();
            populateSaleList();

            projekcijaInfoPanel.setVisible(false);

            Request req = new Request();
            req.setOperation(Operation.UCITAJ_LISTU_PROJEKCIJA);

            CommunicationWithServer.getInstance().sendRequest(req);
            Response res = CommunicationWithServer.getInstance().getResponse();
            LinkedList<Projekcija> projekcije = (LinkedList<Projekcija>) res.getResponse();

            tableModel = new ProjekcijaTableModel(projekcije);
            projekcijeTable.setModel(tableModel);

            System.out.println(projekcije);
        } catch (Exception e) {
            e.printStackTrace();
        }

        projekcijeTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    Projekcija projekcija = (Projekcija) tableModel.getValueAtRow(row);
                    selectedProjekcija = projekcija;
                    projekcijaInfoPanel.setVisible(true);

                    Date vreme = projekcija.getVreme();
                    Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
                    calendar.setTime(vreme);   // assigns calendar to given date 
//                  https://stackoverflow.com/questions/11599947/calendar-minute-giving-minutes-without-leading-zero/11600070
                    vremeTxt.setText(String.format("%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE)));

                    populateFilmCb();
                    populateSalaCb();
                    filmCb.setSelectedItem(projekcija.getFilm());
                    salaCb.setSelectedItem(projekcija.getSala());
                }
            }

        });
    }

    private void populateFilmCb() {
        filmCb.removeAllItems();
        for (Film film : filmovi) {
            filmCb.addItem(film);
        }
    }

    private void populateSalaCb() {
        salaCb.removeAllItems();
        for (Sala sala : sale) {
            salaCb.addItem(sala);
        }
    }

    private void populateFilmoviList() throws Exception {
        Request req = new Request();
        req.setOperation(Operation.UCITAJ_LISTU_FILMOVA);

        CommunicationWithServer.getInstance().sendRequest(req);
        Response res = CommunicationWithServer.getInstance().getResponse();
        filmovi = (LinkedList<Film>) res.getResponse();
    }

    private void populateSaleList() throws Exception {
        Request req = new Request();
        req.setOperation(Operation.UCITAJ_LISTU_SALA);

        CommunicationWithServer.getInstance().sendRequest(req);
        Response res = CommunicationWithServer.getInstance().getResponse();
        sale = (LinkedList<Sala>) res.getResponse();
    }

}