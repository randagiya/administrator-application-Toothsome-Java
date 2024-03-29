/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Input_Pesanan_c;
import Controller.Kostumer_c;
import Controller.Pemasukan_c;
import Controller.Pengeluaran_c;
import Controller.Produk_c;
import Models.input_pesanan_m;
import Models.kostumer_m;
import Models.pemasukan_m;
import Models.pengeluaran_m;
import Models.produk_m;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author baiha
 */
public class kostumer_menu extends javax.swing.JFrame {

    /**
     * Creates new form kostumer_menu
     */
    public kostumer_menu() {
        setIcon();
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabel = new javax.swing.JPanel();
        panelPembukuan = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        panelDetail = new javax.swing.JPanel();
        detailbtn = new javax.swing.JButton();
        panelInput = new javax.swing.JPanel();
        btninputpesanan = new javax.swing.JButton();
        panelKalkulator = new javax.swing.JPanel();
        btnkalkulator = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        bttnproduk1 = new javax.swing.JButton();
        btnpesanan1 = new javax.swing.JButton();
        btnkostumer1 = new javax.swing.JButton();
        btninfo = new javax.swing.JButton();
        btnpemasukan = new javax.swing.JButton();
        baground = new javax.swing.JLabel();
        brnpengeluaran = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ToothSome");

        panelTabel.setBackground(new java.awt.Color(102, 102, 102));

        panelPembukuan.setBackground(new java.awt.Color(255, 102, 153));
        panelPembukuan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        panelPembukuan.setRequestFocusEnabled(false);
        panelPembukuan.setVerifyInputWhenFocusTarget(false);

        jButton7.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/file-storage.png"))); // NOI18N
        jButton7.setText("Pembukuan");
        jButton7.setContentAreaFilled(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton7.setRequestFocusEnabled(false);
        jButton7.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout panelPembukuanLayout = new javax.swing.GroupLayout(panelPembukuan);
        panelPembukuan.setLayout(panelPembukuanLayout);
        panelPembukuanLayout.setHorizontalGroup(
            panelPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
        );
        panelPembukuanLayout.setVerticalGroup(
            panelPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
            .addGroup(panelPembukuanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPembukuanLayout.createSequentialGroup()
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelDetail.setBackground(new java.awt.Color(255, 153, 153));
        panelDetail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        panelDetail.setRequestFocusEnabled(false);
        panelDetail.setVerifyInputWhenFocusTarget(false);

        detailbtn.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        detailbtn.setForeground(new java.awt.Color(255, 255, 255));
        detailbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        detailbtn.setText("Detail");
        detailbtn.setContentAreaFilled(false);
        detailbtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        detailbtn.setRequestFocusEnabled(false);
        detailbtn.setVerifyInputWhenFocusTarget(false);
        detailbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDetailLayout = new javax.swing.GroupLayout(panelDetail);
        panelDetail.setLayout(panelDetailLayout);
        panelDetailLayout.setHorizontalGroup(
            panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
            .addGroup(panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelDetailLayout.createSequentialGroup()
                    .addComponent(detailbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addGap(6, 6, 6)))
        );
        panelDetailLayout.setVerticalGroup(
            panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
            .addGroup(panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(detailbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelInput.setBackground(new java.awt.Color(51, 153, 255));
        panelInput.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        panelInput.setRequestFocusEnabled(false);
        panelInput.setVerifyInputWhenFocusTarget(false);

        btninputpesanan.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        btninputpesanan.setForeground(new java.awt.Color(255, 255, 255));
        btninputpesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/input.png"))); // NOI18N
        btninputpesanan.setText("Input Pesanan");
        btninputpesanan.setContentAreaFilled(false);
        btninputpesanan.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btninputpesanan.setRequestFocusEnabled(false);
        btninputpesanan.setVerifyInputWhenFocusTarget(false);
        btninputpesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninputpesananActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInputLayout = new javax.swing.GroupLayout(panelInput);
        panelInput.setLayout(panelInputLayout);
        panelInputLayout.setHorizontalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btninputpesanan, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
        );
        panelInputLayout.setVerticalGroup(
            panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
            .addGroup(panelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btninputpesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelKalkulator.setBackground(new java.awt.Color(0, 153, 153));
        panelKalkulator.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        panelKalkulator.setRequestFocusEnabled(false);
        panelKalkulator.setVerifyInputWhenFocusTarget(false);

        btnkalkulator.setBackground(new java.awt.Color(153, 0, 153));
        btnkalkulator.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        btnkalkulator.setForeground(new java.awt.Color(255, 255, 255));
        btnkalkulator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calculator.png"))); // NOI18N
        btnkalkulator.setText("Kalkulator");
        btnkalkulator.setContentAreaFilled(false);
        btnkalkulator.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnkalkulator.setRequestFocusEnabled(false);
        btnkalkulator.setVerifyInputWhenFocusTarget(false);
        btnkalkulator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkalkulatorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelKalkulatorLayout = new javax.swing.GroupLayout(panelKalkulator);
        panelKalkulator.setLayout(panelKalkulatorLayout);
        panelKalkulatorLayout.setHorizontalGroup(
            panelKalkulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnkalkulator, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        panelKalkulatorLayout.setVerticalGroup(
            panelKalkulatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnkalkulator, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Table2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Table2);

        javax.swing.GroupLayout panelTabelLayout = new javax.swing.GroupLayout(panelTabel);
        panelTabel.setLayout(panelTabelLayout);
        panelTabelLayout.setHorizontalGroup(
            panelTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTabelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelTabelLayout.createSequentialGroup()
                        .addGroup(panelTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelKalkulator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelPembukuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(23, 23, 23))
        );
        panelTabelLayout.setVerticalGroup(
            panelTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPembukuan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelTabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDetail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelKalkulator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(160, 354));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profil_photo.png"))); // NOI18N

        bttnproduk1.setBackground(new java.awt.Color(0, 0, 0));
        bttnproduk1.setFont(new java.awt.Font("Bodoni MT", 1, 15)); // NOI18N
        bttnproduk1.setForeground(new java.awt.Color(255, 255, 255));
        bttnproduk1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bread.png"))); // NOI18N
        bttnproduk1.setText("Produk");
        bttnproduk1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bttnproduk1.setPreferredSize(new java.awt.Dimension(137, 33));
        bttnproduk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnproduk1ActionPerformed(evt);
            }
        });

        btnpesanan1.setBackground(new java.awt.Color(0, 0, 0));
        btnpesanan1.setFont(new java.awt.Font("Bodoni MT", 1, 15)); // NOI18N
        btnpesanan1.setForeground(new java.awt.Color(255, 255, 255));
        btnpesanan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/to-do-list.png"))); // NOI18N
        btnpesanan1.setText("Pesanan");
        btnpesanan1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnpesanan1.setPreferredSize(new java.awt.Dimension(137, 33));
        btnpesanan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnpesanan1MouseClicked(evt);
            }
        });
        btnpesanan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesanan1ActionPerformed(evt);
            }
        });

        btnkostumer1.setBackground(new java.awt.Color(0, 0, 0));
        btnkostumer1.setFont(new java.awt.Font("Bodoni MT", 1, 15)); // NOI18N
        btnkostumer1.setForeground(java.awt.Color.lightGray);
        btnkostumer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/team.png"))); // NOI18N
        btnkostumer1.setText("Kostumer");
        btnkostumer1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnkostumer1.setPreferredSize(new java.awt.Dimension(137, 33));
        btnkostumer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkostumer1ActionPerformed(evt);
            }
        });

        btninfo.setBackground(new java.awt.Color(0, 0, 0));
        btninfo.setFont(new java.awt.Font("Bodoni MT", 1, 15)); // NOI18N
        btninfo.setForeground(new java.awt.Color(255, 255, 255));
        btninfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/info.png"))); // NOI18N
        btninfo.setText("Info");
        btninfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btninfo.setPreferredSize(new java.awt.Dimension(137, 33));
        btninfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninfoActionPerformed(evt);
            }
        });

        btnpemasukan.setBackground(new java.awt.Color(0, 0, 0));
        btnpemasukan.setFont(new java.awt.Font("Bodoni MT", 1, 15)); // NOI18N
        btnpemasukan.setForeground(new java.awt.Color(255, 255, 255));
        btnpemasukan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/financial-profit.png"))); // NOI18N
        btnpemasukan.setText("Pemasukan");
        btnpemasukan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnpemasukan.setMaximumSize(new java.awt.Dimension(137, 33));
        btnpemasukan.setMinimumSize(new java.awt.Dimension(137, 33));
        btnpemasukan.setPreferredSize(new java.awt.Dimension(137, 33));
        btnpemasukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpemasukanActionPerformed(evt);
            }
        });

        baground.setBackground(new java.awt.Color(153, 255, 255));
        baground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pexels-marta-dzedyshko-7693950.jpg"))); // NOI18N

        brnpengeluaran.setBackground(new java.awt.Color(0, 0, 0));
        brnpengeluaran.setFont(new java.awt.Font("Bodoni MT", 1, 15)); // NOI18N
        brnpengeluaran.setForeground(new java.awt.Color(255, 255, 255));
        brnpengeluaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/money.png"))); // NOI18N
        brnpengeluaran.setText("Pengeluaran");
        brnpengeluaran.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        brnpengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnpengeluaranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnkostumer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brnpengeluaran)
                    .addComponent(btnpesanan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnproduk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btninfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(baground, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(btnkostumer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnpemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(brnpengeluaran))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btnpesanan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(bttnproduk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(btninfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(baground, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(887, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(panelTabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 803, Short.MAX_VALUE)
            .addComponent(panelTabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void detailbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailbtnActionPerformed
        // TODO add your handling code here:
        kostumer_m model = new kostumer_m();
        kostumer_menu view2 = new kostumer_menu();
        kostumer view = new kostumer();
        Kostumer_c ctrl = new Kostumer_c(view, model, view2);

        ctrl.KosongFromProduk();
        ctrl.tampil_data();
        ctrl.ambil_id();

        view.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_detailbtnActionPerformed

    private void btninputpesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninputpesananActionPerformed
        // TODO add your handling code here:
        input_pesanan_m model = new input_pesanan_m();
        input_pesanan view = new input_pesanan();
        Input_Pesanan_c ctrl = new Input_Pesanan_c(view, model);

        ctrl.tampil_data();
        view.setVisible(true);
    }//GEN-LAST:event_btninputpesananActionPerformed

    private void btnkalkulatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkalkulatorActionPerformed
        // TODO add your handling code here:
        calculator cal = new calculator();
        cal.setVisible(true);
    }//GEN-LAST:event_btnkalkulatorActionPerformed

    private void bttnproduk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnproduk1ActionPerformed
        // TODO add your handling code here:
        produk_m model = new produk_m();
        produk_menu view2 = new produk_menu();
        produk view = new produk();
        Produk_c pro_c = new Produk_c(view2, model, view);

        pro_c.tampil_data();
        view2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bttnproduk1ActionPerformed

    private void btnpesanan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpesanan1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpesanan1MouseClicked

    private void btnpesanan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesanan1ActionPerformed
        input_pesanan_m model = new input_pesanan_m();
        input_pesanan view = new input_pesanan();
        Input_Pesanan_c ctrl = new Input_Pesanan_c(view, model);

        ctrl.tampil_data();
        view.setVisible(true);
    }//GEN-LAST:event_btnpesanan1ActionPerformed

    private void btninfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninfoActionPerformed
        // TODO add your handling code here:
        info_menu info = new info_menu();
        info.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btninfoActionPerformed

    private void btnpemasukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpemasukanActionPerformed
        // TODO add your handling code here:
        pemasukan_m model = new pemasukan_m();
        pemasukan_menu view2 = new pemasukan_menu();
        pemasukan view = new pemasukan();
        Pemasukan_c ctrl = new Pemasukan_c(view, view2, model);

        ctrl.tampil_data();
        view2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnpemasukanActionPerformed

    private void brnpengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnpengeluaranActionPerformed
        // TODO add your handling code here:
        pengeluaran_m model = new pengeluaran_m();
        pengeluaran_menu view2 = new pengeluaran_menu();
        pengeluaran_fix view = new pengeluaran_fix();
        Pengeluaran_c ctrl = new Pengeluaran_c(view, view2, model);

        ctrl.tampil_data();
        view2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_brnpengeluaranActionPerformed

    private void btnkostumer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkostumer1ActionPerformed

    }//GEN-LAST:event_btnkostumer1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Table2;
    private javax.swing.JLabel baground;
    public javax.swing.JButton brnpengeluaran;
    public javax.swing.JButton btninfo;
    private javax.swing.JButton btninputpesanan;
    private javax.swing.JButton btnkalkulator;
    public javax.swing.JButton btnkostumer1;
    public javax.swing.JButton btnpemasukan;
    public javax.swing.JButton btnpesanan1;
    public javax.swing.JButton bttnproduk1;
    private javax.swing.JButton detailbtn;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelDetail;
    private javax.swing.JPanel panelInput;
    private javax.swing.JPanel panelKalkulator;
    private javax.swing.JPanel panelPembukuan;
    private javax.swing.JPanel panelTabel;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bread.png")));
    }
}
