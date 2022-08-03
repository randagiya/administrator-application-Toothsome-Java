package Controller;

import Models.Connetor;
import Models.pemasukan_m;
import Models.produk_m;
import View.pemasukan;
import View.pemasukan_menu;
import View.produk;
import View.produk_menu;
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
public class Pemasukan_c implements ActionListener, MouseListener {
    
    private pemasukan view;
    private pemasukan_menu view2;
    private pemasukan_m model;
    
    public Pemasukan_c(pemasukan view, pemasukan_menu view2, pemasukan_m model) {
        this.view = view;
        this.view2 = view2;
        this.model = model;
        view.btnPrint.addActionListener(this);
        view.ComWaktu.addActionListener(this);
        view.ComPilihan.addActionListener(this);
        view.btnBersih2.addActionListener(this);
        view.btnPencarian2.addActionListener(this);
        view.txtTotal.setEditable(false);
        view.btnPencarian.addActionListener(this);
        view.btnHapus.addActionListener(this);
    }
    
    public void KosongFromProduk2() {
        view.txtPencarian2.setText(null);
        view.txtTotal.setEditable(false);
        tampil_data();
    }
    
    public void tampil_data() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pesanan");//1
        model.addColumn("ID Kostumer");//2
        model.addColumn("ID Produk");//3
        model.addColumn("Pesanan Tanggal");//4
        model.addColumn("Pesanan Jumlah");//5
        model.addColumn("Pesanan Total");//6
        try {
            String sql = "select * from pesanan";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6)});
            }
            comboID();
            total();
            view2.table2.setModel(model);
            view.table.setModel(model);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void btnPencarian(String pilihan, String like) {
        if (pilihan == "produk") {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Produk ID");//1
            model.addColumn("Nama Barang");//2
            model.addColumn("Keterangan");//3
            model.addColumn("Kategori");//4
            model.addColumn("Harga");//5
            model.addColumn("Stok");//6
            model.addColumn("Path Gambar");//7
            model.addColumn("Daftar ID");//8
            try {
                String sql = "select * from produk where produk_id like '%" + like + "%'";
                java.sql.Connection conn = (Connection) Connetor.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                
                while (res.next()) {
                    model.addRow(new Object[]{
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5),
                        res.getString(6),
                        res.getString(7),
                        res.getString(8)});
                }
                
                view.tableCari.setModel(model);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (pilihan == "kostumer") {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Kostumer ID");//1
            model.addColumn("Nama");//2
            model.addColumn("Alamat");//3
            model.addColumn("Telepon");//4
            try {
                int no = 1;
                String sql = "select * from kostumer where kost_id like '%" + like + "%'";
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
                view.tableCari.setModel(model);
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if (pilihan == "daftarbahanproduk") {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Daftar ID");//1
            model.addColumn("Deskirpsi");//2
            model.addColumn("Jumlah");//3
            model.addColumn("Harga");//4
            model.addColumn("Tanggal Beli");//5
            try {
                String sql = "select * from daftarbahanproduk where daftar_id like '%" + like + "%'";
                java.sql.Connection conn = (Connection) Connetor.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                
                while (res.next()) {
                    model.addRow(new Object[]{
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5)});
                }
                view.tableCari.setModel(model);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ada yang Error (c)");
        }
    }
    
    public void btnPencarian2(String like) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pesanan");//1
        model.addColumn("ID Kostumer");//2
        model.addColumn("ID Produk");//3
        model.addColumn("Pesanan Tanggal");//4
        model.addColumn("Pesanan Jumlah");//5
        model.addColumn("Pesanan Total");//6
        try {
            String sql = "select * from pesanan where pesan_id like '%" + like + "%' or pesan_tanggal like '%" + like + "%'";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6)});
            }
            view.table.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hanya Memasukan Tanggal atau ID saja! : \n" + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void comboID() {
        try {
            String sql = "select pesan_Id as pesan_Id from pesanan";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()) {
                view.comID.addItem(res.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void comboIDCari(String table) {
        if ("produk".equals(table)) {
            try {
                String sql = "select produk_id from produk";
                java.sql.Connection conn = (Connection) Connetor.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                
                while (res.next()) {
                    view.comIDCari.addItem(res.getString(1));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if ("kostumer".equals(table)) {
            try {
                String sql = "select kost_id from kostumer";
                java.sql.Connection conn = (Connection) Connetor.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                
                while (res.next()) {
                    view.comIDCari.addItem(res.getString(1));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else if ("daftarbahanproduk".equals(table)) {
            try {
                String sql = "select daftar_id from daftarbahanproduk";
                java.sql.Connection conn = (Connection) Connetor.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                
                while (res.next()) {
                    view.comIDCari.addItem(res.getString(1));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error pada C", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void total() {
        try {
            String pilih = null;
            pilih = ((String) view.ComWaktu.getSelectedItem());
            if (pilih == null) {
                pilih = "Bulanan";
            }
            
            if ("Bulanan".equals(pilih)) {
                try {
                    String sql = "  SELECT SUM(pesan_bayar) FROM pesanan WHERE DATE_FORMAT"
                            + "(pesan_tanggal, \"%m\") = date_format(CURRENT_DATE,\"%m\")";
                    java.sql.Connection conn = (Connection) Connetor.configDB();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet res = stm.executeQuery(sql);
                    while (res.next()) {
                        view.txtTotal.setText(res.getString(1));
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            } else if ("Harian".equals(pilih)) {
                try {
                    String sql = "  SELECT SUM(pesan_bayar) FROM pesanan WHERE DATE_FORMAT"
                            + "(pesan_tanggal, \"%d\") = date_format(CURRENT_DATE,\"%d\")";
                    java.sql.Connection conn = (Connection) Connetor.configDB();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet res = stm.executeQuery(sql);
                    while (res.next()) {
                        view.txtTotal.setText(res.getString(1));
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            } else if ("Tahunan".equals(pilih)) {
                try {
                    String sql = "  SELECT SUM(pesan_bayar) FROM pesanan WHERE DATE_FORMAT"
                            + "(pesan_tanggal, \"%y\") = date_format(CURRENT_DATE,\"%y\")";
                    java.sql.Connection conn = (Connection) Connetor.configDB();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet res = stm.executeQuery(sql);
                    while (res.next()) {
                        view.txtTotal.setText(res.getString(1));
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                view.txtTotal.setText("null");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnBersih2) {
            KosongFromProduk2();
        } else if (e.getSource() == view.btnMenu) {
            tampil_data();
            view2.setVisible(true);
            view.setVisible(false);
            
        } else if (e.getSource() == view.btnHapus) {
            try {
                int id = Integer.parseInt((String) view.comID.getSelectedItem());
                model.setPesan_id(id);
                int kofrim = (JOptionPane.showConfirmDialog(null, "Yakin Menghapus data dengan ID: " + id + "?", "Mengapus", JOptionPane.YES_NO_OPTION));
                if (JOptionPane.YES_OPTION == kofrim) {
                    try {                       
                        if (model.Hapus_data(model)) {
                            tampil_data();
                        }
                    } catch (SQLException ha) {
                        JOptionPane.showMessageDialog(null, ha);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, a);
            }
            
        } else if (e.getSource() == view.ComPilihan) {
            String table = ((String) view.ComPilihan.getSelectedItem());
            comboIDCari(table);
            
        } else if (e.getSource() == view.btnPencarian) {
            try {
                String com = ((String) view.ComPilihan.getSelectedItem());
                String like = view.txtPencarian2.getText();
                btnPencarian(com, like);
            } catch (Exception penc) {
                JOptionPane.showMessageDialog(null, "Masukkan nilai/huruf terlebih dahulu atau nilai yang anda cari tidak ada:\n " + penc, "Tidak ada", JOptionPane.ERROR_MESSAGE);
            }
            
        } else if (e.getSource() == view.btnPencarian2) {
            try {
                String like = view.txtPencarian2.getText();
                btnPencarian2(like);
            } catch (Exception penc) {
                JOptionPane.showMessageDialog(null, "Masukkan nilai/huruf terlebih dahulu atau nilai yang anda cari tidak ada:\n " + penc, "Tidak ada", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == view.ComWaktu) {
            total();
        } else {
            JOptionPane.showMessageDialog(null, "ada yang error!");
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
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
