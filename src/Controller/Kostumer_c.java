package Controller;

import Models.Connetor;
import Models.kostumer_m;
import View.kostumer;
import View.kostumer_menu;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author RANDA
 */
public class Kostumer_c implements ActionListener, MouseListener {

    private kostumer view;
    private kostumer_menu view2;
    private kostumer_m model;

    public Kostumer_c(kostumer view, kostumer_m model, kostumer_menu view2) {
        this.view = view;
        this.view2 = view2;
        this.model = model;
        this.view.table.addMouseListener(this);
        this.view2.Table2.addMouseListener(this);
        this.view.btnTambah.addActionListener(this);
        this.view.btnHapus.addActionListener(this);
        this.view.btnBersih.addActionListener(this);
        this.view.btnMenu.addActionListener(this);
        this.view.btnUbah.addActionListener(this);
        this.view.btnKonfi.addActionListener(this);
        this.view.btnPencarian.addActionListener(this);
    }

    public void KosongFromProduk() {
        view.btnKonfi.setVisible(false);
        view.txtID.setEditable(false);
        view.txtID.setText(null);
        view.txtNama.setText(null);
        view.txtAlamat.setText(null);
        view.txtTelepon.setText(null);
        view.btnUbah.setVisible(true);
        view.btnKonfi.setVisible(false);
        ambil_id();
        combo_pilihan();
    }

    public void tampil_data() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kostumer ID");//1
        model.addColumn("Nama");//2
        model.addColumn("Alamat");//3
        model.addColumn("Telepon");//4
        try {
            int no = 1;
            String sql = "select * from kostumer";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)});
            }
            view.table.setModel(model);
            view2.Table2.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void ambil_id() {
        try {
            String sql = "select max(kost_id+1) as kost_id from kostumer";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                view.txtID.setText(res.getString("kost_id"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void BtnUbah() {
        int id = Integer.parseInt((String) view.ComPilihan.getSelectedItem());
        model.setKost_id(id);

        try {
            String sql = "select kost_id as kostumer from kostumer where kost_id = " + model.getKost_id();
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                view.txtID.setText(res.getString("kostumer"));
            }

            String sql2 = "select kost_nama as kostumer from kostumer where kost_id = " + model.getKost_id();
            java.sql.ResultSet res2 = stm.executeQuery(sql2);

            while (res2.next()) {
                view.txtNama.setText(res2.getString("kostumer"));
            }

            String sql3 = "select kost_alamat as kostumer from kostumer where kost_id = " + model.getKost_id();
            java.sql.ResultSet res3 = stm.executeQuery(sql3);

            while (res3.next()) {
                view.txtAlamat.setText(res3.getString("kostumer"));
            }

            String sql4 = "select telepon as kostumer from kostumer where kost_id = " + model.getKost_id();
            java.sql.ResultSet res4 = stm.executeQuery(sql4);

            while (res4.next()) {
                view.txtTelepon.setText(res4.getString("kostumer"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void combo_pilihan() {
        try {
            String sql = "select kost_id from kostumer";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                view.ComPilihan.addItem(res.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void btnPencarian(String com, String like) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(com);
        model.addColumn("Nama Barang");
        try {
            String sql = "select " + com + ", kost_nama from kostumer where " + com + " like '%" + like + "%'";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2)});
            }
            view.TableCari.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnTambah) {
            try {
                model.setKost_id(Integer.parseInt(view.txtID.getText()));
                model.setKost_nama(view.txtNama.getText());
                model.setKost_alamat(view.txtAlamat.getText());
                model.setTelepon(view.txtTelepon.getText());
                try {
                    if (model.insert_data(model)) {
                        KosongFromProduk();
                        tampil_data();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "Ada masalah pada tombol Simpan: " + a);
            }
        } else if (e.getSource() == view.btnBersih) {
            KosongFromProduk();
            ambil_id();
        } else if (e.getSource() == view.btnMenu) {
            KosongFromProduk();
            tampil_data();
            view2.setVisible(true);
            view.setVisible(false);

        } else if (e.getSource() == view.btnHapus) {
            int id = Integer.parseInt((String) view.ComPilihan.getSelectedItem());
            model.setKost_id(id);
            int kofrim = (JOptionPane.showConfirmDialog(null, "Yakin Menghapus data dengan ID: " + id + "?", "Mengapus", JOptionPane.YES_NO_OPTION));
            if (JOptionPane.YES_OPTION == kofrim) {
                try {

                    if (model.Hapus_data(model)) {
                        KosongFromProduk();
                        tampil_data();
                    }
                } catch (SQLException ha) {
                    JOptionPane.showMessageDialog(null, ha);
                }
            }

        } else if (e.getSource() == view.btnUbah) {
            try {
                BtnUbah();
                view.btnUbah.setVisible(false);
                view.btnKonfi.setVisible(true);
                JOptionPane.showMessageDialog(null, "Tekan Tombol Konfirmasi jika sudah selesai mengedit");

            } catch (Exception o) {
                JOptionPane.showMessageDialog(null, "Ada masalah pada Button ubah " + o);
            }
        } else if (e.getSource() == view.btnKonfi) {
            try {
                model.setKost_id(Integer.parseInt(view.txtID.getText()));
                model.setKost_nama(view.txtNama.getText());
                model.setKost_alamat(view.txtAlamat.getText());
                model.setTelepon(view.txtTelepon.getText());

                try {
                    if (model.update_data(model)) {

                        KosongFromProduk();
                        tampil_data();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "Ada masalah pada tombol Yakin: " + a);
            }
        } else if (e.getSource() == view.btnPencarian) {
            try {
                String com = ((String) view.comKolom.getSelectedItem());
                String like = view.txtPencarian.getText();
                btnPencarian(com, like);
            } catch (Exception penc) {
                JOptionPane.showMessageDialog(null, "Masukkan nilai/huruf terlebih dahulu atau nilai yang anda cari tidak ada:\n " + penc, "Tidak ada", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "ada yang error!");
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == view.table) {
            try {

                int baris = view.table.rowAtPoint(me.getPoint());

                int id = Integer.parseInt(view.table.getValueAt(baris, 1).toString());
                view.txtID.setText("" + id);
                String nama_produk = view.table.getValueAt(baris, 2).toString();
                view.txtNama.setText(nama_produk);
                String Alamat = view.table.getValueAt(baris, 3).toString();
                view.txtAlamat.setText(Alamat);
                String Telepon = view.table.getValueAt(baris, 4).toString();
                view.txtTelepon.setText(Telepon);
                int harga = Integer.parseInt(view.table.getValueAt(baris, 5).toString());
            } catch (Exception table) {
                JOptionPane.showMessageDialog(null, "Table ada yang error: " + table);
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
