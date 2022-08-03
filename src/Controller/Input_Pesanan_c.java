package Controller;

import Models.Connetor;
import Models.input_pesanan_m;
import Models.kostumer_m;
import View.input_pesanan;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author RANDA
 */
public class Input_Pesanan_c implements ActionListener, MouseListener {

    private input_pesanan view;
    private input_pesanan_m model;

    public Input_Pesanan_c(input_pesanan view, input_pesanan_m model) {
        this.view = view;
        this.model = model;
        this.view.btnKostumer.addActionListener(this);
        this.view.btnBersih.addActionListener(this);
        this.view.btnSimpan.addActionListener(this);
        this.view.CheckDiskon.addActionListener(this);
        this.view.ComProduk.addActionListener(this);
        this.view.btnCalDiskon.addActionListener(this);
    }

    public void KosongFromProduk() {
        view.TxtDiskon.setText("" + 0);
        view.txtJumlah.setText(null);
        view.txtNamaKost.setText(null);
        view.txtSubTotal.setText(null);
        view.txtTotal.setText(null);
        view.txtAlamatKost.setVisible(false);
        view.txtTeleponKost.setVisible(false);
        view.LabAlamat.setVisible(false);
        view.LabTelep.setVisible(false);
        view.Gambar.setIcon(null);
        view.TxtDiskon.setEditable(false);
        view.CheckDiskon.setSelected(false);
        combo_produk();
        path_gambar();
        try {
            gambarMuncul();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Gambar Error: \n" + e);
        }
    }

    public void tampil_data() {
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
            String sql = "select * from produk";
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
            KosongFromProduk();
            combo_produk();
            view.Tabel.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void ambil_idProduk() {
        try {
            String produk = ((String) view.ComProduk.getSelectedItem());
            String sql = "select produk_id as produk_id from produk where nama_barang = \"" + produk + "\"";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.setProduk_id(res.getInt(1));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void produk_kurang() {
        try {

            int id = model.getProduk_id();
            int jumlah = model.getPesan_jumlah();
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            String sql = "select stok from produk where produk_id = " + id;
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.setProduk_stok(res.getInt(1));
            }

            produk_kurang2(jumlah, id);

        } catch (SQLException l) {
            JOptionPane.showMessageDialog(null, l);
        }
    }

    public void produk_kurang2(int jumlah, int id) {
        try {
            PreparedStatement pstm = null;
            int hasil = model.getProduk_stok() - jumlah;
            java.sql.Connection conn = (Connection) Connetor.configDB();

            String sql = "update produk set stok = ? where produk_id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, hasil);
            pstm.setInt(2, id);

            pstm.execute();

        } catch (SQLException a) {
            JOptionPane.showMessageDialog(null, "Jumlah Stok Produk Anda lebih Kurang Dari pada yang dijual!\n" + a, "KURANG!", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void combo_produk() {
        try {
            String sql = "select nama_barang from produk";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                view.ComProduk.addItem(res.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void path_gambar() {
        try {
            String produk = ((String) view.ComProduk.getSelectedItem());
            String sql = "select path_gambar from produk where nama_barang = \"" + produk + "\"";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.setPath_gambar(res.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Path Gambar ERROR: \n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void gambarMuncul() throws IOException {
        String path = model.getPath_gambar();
        try {
            File file = new File(path);
            BufferedImage bufferedImage = ImageIO.read(file);

            ImageIcon imageIcon = new ImageIcon(bufferedImage);
            JFrame jFrame = new JFrame();
            Image image = imageIcon.getImage().getScaledInstance(view.Gambar.getWidth(), view.Gambar.getHeight(), Image.SCALE_SMOOTH);

            ImageIcon ic = new ImageIcon(image);
            view.Gambar.setIcon(ic);
        } catch (IOException er) {
            JOptionPane.showMessageDialog(null, "Gambar tidak ditemukan!\nCoba Upload Gambar Baru Kembali\n" + er, "Tidak Ditemukan", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void kostumer(String nama) {
        kostumer_m model_k = new kostumer_m();
        try {
            String sql = "select kost_id from kostumer where kost_nama = \"" + nama + "\"";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model_k.setKost_id(res.getInt(1));
            }
            if (model_k.getKost_id() != 0) {

                model_k.setKost_nama(view.txtNamaKost.getText());
                model_k.setKost_alamat(view.txtAlamatKost.getText());
                model_k.setTelepon(view.txtTeleponKost.getText());
                try {
                    model_k.update_data(model_k);
                } catch (SQLException a) {
                    JOptionPane.showMessageDialog(null, a);
                }
            } else {
                kost_baru();
            }
        } catch (SQLException b) {
            kost_baru();
        }

    }

    public void kost_baru() {
        try {
            kost_id_baru();
            kostumer_m model_k = new kostumer_m();
            model_k.setKost_nama(view.txtNamaKost.getText());
            model_k.setKost_alamat(view.txtAlamatKost.getText());
            model_k.setTelepon(view.txtTeleponKost.getText());
            model_k.insert_data(model_k);
            JOptionPane.showMessageDialog(null, "Kostumer baru berhasil Tersimpan!", "Tersimpan!", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException a) {
            JOptionPane.showMessageDialog(null, "Kostumer Baru Tidak Berhasil Tersimpan: \n" + a);
        }
    }

    public void kost_id_baru() {
        try {
            kostumer_m model_k = new kostumer_m();
            String sql = "select max(kost_id+1) from kostumer";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model_k.setKost_id(res.getInt(1));
            }
        } catch (SQLException a) {
            JOptionPane.showMessageDialog(null, "Kostumer ID Baru ERROR!", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void PesanID() {
        try {
            String sql = "select max(pesan_id+1) from pesanan";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.setPesan_id(res.getInt(1));
            }
        } catch (SQLException a) {
            JOptionPane.showMessageDialog(null, "Pesanan ID Baru ERROR!:\n" + a, "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void harga() {
        try {

            try {
                String produk = ((String) view.ComProduk.getSelectedItem());
                String sql = "select harga from produk where nama_barang = \"" + produk + "\"";
                java.sql.Connection conn = (Connection) Connetor.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);

                while (res.next()) {
                    view.txtHarga.setText(res.getString(1));
                }
            } catch (SQLException a) {
                JOptionPane.showMessageDialog(null, "Harga Diproduk Harus diisi!!!" + a, "ERROR", JOptionPane.WARNING_MESSAGE);
            }

            int harga = Integer.parseInt(view.txtHarga.getText());
            int subtotal = 1;
            subtotal = harga * Integer.parseInt(view.txtJumlah.getText());
            view.txtSubTotal.setText(String.valueOf(subtotal));

        } catch (Exception o) {

        }

    }

    public void total_bayar(double diskonMentah) {
        double diskon = diskonMentah / 100;
        double total;
        int subtotal = Integer.parseInt(view.txtSubTotal.getText());
        if (diskon > 0) {
            total = subtotal - (subtotal * diskon);
        } else {
            total = subtotal;
        }
        int roundVal = (int) Math.round(total);
        view.txtTotal.setText(String.valueOf(roundVal));
        model.setPesan_bayar(roundVal);
    }

    public void getDate() {
        String tampilan = "yyyyMMdd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(view.txtDateChooser.getDate()));
        model.setPesan_tanggal(tanggal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnSimpan) {
            try {
                kostumer_m model_k = new kostumer_m();

                PesanID();
                kostumer(view.txtNamaKost.getText());
                ambil_idProduk();
                model.setKost_id(model_k.getKost_id());
                getDate();
                model.setPesan_jumlah(Integer.parseInt(view.txtJumlah.getText()));
                produk_kurang();

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

        } else if (e.getSource() == view.btnKostumer) {
            try {
                view.LabAlamat.setVisible(true);
                view.LabTelep.setVisible(true);
                view.txtAlamatKost.setVisible(true);
                view.txtTeleponKost.setVisible(true);
            } catch (Exception o) {
                JOptionPane.showMessageDialog(null, e);
            }

        } else if (e.getSource() == view.CheckDiskon) {
            view.TxtDiskon.setEditable(true);
        } else if (e.getSource() == view.ComProduk) {
            try {
                try {
                    path_gambar();
                    gambarMuncul();
                } catch (IOException q) {
                    JOptionPane.showMessageDialog(null, "Gambar tidak ditemukan!\nCoba Upload Gambar Baru Kembali\n" + q, "Tidak Ditemukan", JOptionPane.WARNING_MESSAGE);
                }
                harga();
            } catch (Exception m) {
                JOptionPane.showMessageDialog(null, m);
            }
        } else if (e.getSource() == view.btnCalDiskon) {
            total_bayar(Integer.parseInt(view.TxtDiskon.getText()));
        } else {
            JOptionPane.showMessageDialog(null, "ada yang error!");
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        DefaultTableModel md = (DefaultTableModel) view.Tabel.getModel();
        view.txtHarga.setText(md.getValueAt(view.Tabel.getSelectedRow(), 5).toString());
        view.txtNamaKost.setText(md.getValueAt(view.Tabel.getSelectedRow(), 4).toString());
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {

    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {

    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {

    }

    @Override
    public void mouseExited(MouseEvent e
    ) {

    }
}
