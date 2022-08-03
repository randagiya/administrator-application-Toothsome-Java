package Controller;

import Models.Connetor;
import Models.pengeluaran_m;
import Models.produk_m;
import View.pengeluaran_fix;
import View.pengeluaran_menu;
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
import java.text.ParseException;
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
public class Pengeluaran_c implements ActionListener, MouseListener {

    private pengeluaran_fix view;
    private pengeluaran_menu view2;
    private pengeluaran_m model;

    public Pengeluaran_c(pengeluaran_fix view, pengeluaran_menu view2, pengeluaran_m model) {
        this.view = view;
        this.view2 = view2;
        this.model = model;
        this.view.btnBersih.addActionListener(this);
        this.view.btnHapus.addActionListener(this);
        this.view.btnKonfi.addActionListener(this);
        this.view.btnPencarian.addActionListener(this);
        this.view.btnTambah.addActionListener(this);
        this.view.btnUbah.addActionListener(this);
        this.view.table.addMouseListener(this);
        this.view2.addMouseListener(this);
    }

    public void KosongFromProduk() {
        view.btnKonfi.setVisible(false);
        view.txtDaftar_id.setEditable(false);
        view.txtDeskirpsi.setText(null);
        view.txtJumlah.setText(null);
        view.txtHarga.setText(null);
        view.btnUbah.setVisible(true);
        view.btnKonfi.setVisible(false);
        ambil_id();
    }

    public void tampil_data() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Daftar ID");//1
        model.addColumn("Deskirpsi");//2
        model.addColumn("Jumlah");//3
        model.addColumn("Harga");//4
        model.addColumn("Tanggal Beli");//5
        try {
            String sql = "select * from daftarbahanproduk";
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
            combo_pilihan();
            KosongFromProduk();
            view2.table2.setModel(model);
            view.table.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void ambil_id() {
        try {
            String sql = "select max(daftar_id+1) as daftar_id from daftarbahanproduk";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                view.txtDaftar_id.setText(res.getString("daftar_id"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void BtnUbah() {
        int id = Integer.parseInt((String) view.ComPilihan.getSelectedItem());
        model.setDaftar_id(id);

        try {
            String sql = "select daftar_id as daftar from daftarbahanproduk where daftar_id = " + model.getDaftar_id();
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                view.txtDaftar_id.setText(res.getString("daftar"));
            }

            String sql2 = "select deskirpsi as daftar from daftarbahanproduk where daftar_id = " + model.getDaftar_id();
            java.sql.ResultSet res2 = stm.executeQuery(sql2);

            while (res2.next()) {
                view.txtDeskirpsi.setText(res2.getString("daftar"));
            }

            String sql3 = "select Jumlah as daftar from daftarbahanproduk where daftar_id = " + model.getDaftar_id();
            java.sql.ResultSet res3 = stm.executeQuery(sql3);

            while (res3.next()) {
                view.txtJumlah.setText(res3.getString("daftar"));
            }

            String sql4 = "select Harga as daftar from daftarbahanproduk where daftar_id = " + model.getDaftar_id();
            java.sql.ResultSet res4 = stm.executeQuery(sql4);

            while (res4.next()) {
                view.txtHarga.setText(res4.getString("daftar"));
            }

            String sql5 = "select tanggal_beli as daftar from daftarbahanproduk where daftar_id = " + model.getDaftar_id();
            java.sql.ResultSet res5 = stm.executeQuery(sql5);

            while (res5.next()) {
                try {
                    String tanggal = (res5.getString("daftar"));
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tanggal);
                    view.txtDateChooser.setDate(date);
                } catch (ParseException a) {
                    JOptionPane.showMessageDialog(null, a);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void getDate() {
        String tampilan = "yyyyMMdd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(view.txtDateChooser.getDate()));
        model.setTanggal_beli(tanggal);
    }

    public void combo_pilihan() {
        try {
            String sql = "select daftar_id from daftarbahanproduk";
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
            String sql = "select " + com + ", deskirpsi from daftarbahanproduk where " + com + " like '%" + like + "%'";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2)});
            }
            view.tableCari.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnTambah) {
            try {
                model.setDaftar_id(Integer.parseInt(view.txtDaftar_id.getText()));
                model.setDeskirpsi(view.txtDeskirpsi.getText());
                model.setJumlah(view.txtJumlah.getText());
                model.setHarga(Integer.parseInt(view.txtHarga.getText()));
                getDate();

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
            model.setDaftar_id(id);
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
                model.setDaftar_id(Integer.parseInt(view.txtDaftar_id.getText()));
                model.setDeskirpsi(view.txtDeskirpsi.getText());
                model.setJumlah(view.txtJumlah.getText());
                model.setHarga(Integer.parseInt(view.txtHarga.getText()));
               getDate();

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
                view.txtDaftar_id.setText("" + id);

                String Deskirpsi = view.table.getValueAt(baris, 2).toString();
                view.txtDeskirpsi.setText(Deskirpsi);

                String jumlah = view.table.getValueAt(baris, 3).toString();
                view.txtJumlah.setText(jumlah);

                int harga = Integer.parseInt(view.table.getValueAt(baris, 4).toString());
                view.txtHarga.setText("" + harga);

                String tanggal = view.table.getValueAt(baris, 5).toString();
                view.txtHarga.setText("" + tanggal);

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
