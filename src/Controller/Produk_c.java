package Controller;

import Models.Connetor;
import Models.produk_m;
import View.produk;
import View.produk_menu;
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
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author RANDA
 */
public class Produk_c implements ActionListener, MouseListener {

    private produk view;
    private produk_menu view2;
    private produk_m model;

    public Produk_c(produk_menu view2, produk_m model, produk view) {
        this.view = view;
        this.view2 = view2;
        this.model = model;
        this.view2.table2.addMouseListener(this);
        this.view.table.addMouseListener(this);
        this.view.btnTambah.addActionListener(this);
        this.view.btnHapus.addActionListener(this);
        this.view.btnBersih.addActionListener(this);
        this.view.btnMenu.addActionListener(this);
        this.view.btnUpload.addActionListener(this);
        this.view.btnUbah.addActionListener(this);
        this.view.btnKonfi.addActionListener(this);
        this.view.ComDaftar_id.addActionListener(this);
        this.view.btnPencarian.addActionListener(this);
        this.view2.btnCetak.addActionListener(this);
    }

    public void KosongFromProduk() {
        view.btnKonfi.setVisible(false);
        view.txtID.setEditable(false);
        view.txtGambar.setEditable(false);
        view.txtDaftarID.setEditable(false);
        view.txtNama.setText(null);
        view.txtJumlah.setText(null);
        view.txtHarga.setText(null);
        view.txtKategori.setText(null);
        view.txtKeterangan.setText(null);
        view.txtGambar.setText(null);
        view.txtDaftarID.setText(null);
        view.btnUbah.setVisible(true);
        view.btnKonfi.setVisible(false);
        view.Gambar.setIcon(null);
        ambil_id();
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
            combo_pilihan();
            combo_Daftar_id();
            view2.table2.setModel(model);
            view.table.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void ambil_id() {
        try {
            String sql = "select max(produk_id+1) as produk_id from produk";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                view.txtID.setText(res.getString("produk_id"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void BtnUbah() {
        int id = Integer.parseInt((String) view.ComPilihan.getSelectedItem());
        model.setProduk_id(id);

        try {
            String sql = "select produk_id as produk from produk where produk_id = " + model.getProduk_id();
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                view.txtID.setText(res.getString("produk"));
            }

            String sql2 = "select nama_barang as produk from produk where produk_id = " + model.getProduk_id();
            java.sql.ResultSet res2 = stm.executeQuery(sql2);

            while (res2.next()) {
                view.txtNama.setText(res2.getString("produk"));
            }

            String sql3 = "select keterangan as produk from produk where produk_id = " + model.getProduk_id();
            java.sql.ResultSet res3 = stm.executeQuery(sql3);

            while (res3.next()) {
                view.txtKeterangan.setText(res3.getString("produk"));
            }

            String sql4 = "select kategori as produk from produk where produk_id = " + model.getProduk_id();
            java.sql.ResultSet res4 = stm.executeQuery(sql4);

            while (res4.next()) {
                view.txtKategori.setText(res4.getString("produk"));
            }

            String sql5 = "select harga as produk from produk where produk_id = " + model.getProduk_id();
            java.sql.ResultSet res5 = stm.executeQuery(sql5);

            while (res5.next()) {
                view.txtHarga.setText(res5.getString("produk"));
            }

            String sql6 = "select stok as produk from produk where produk_id = " + model.getProduk_id();
            java.sql.ResultSet res6 = stm.executeQuery(sql6);

            while (res6.next()) {
                view.txtJumlah.setText(res6.getString("produk"));
            }

            String sql7 = "select path_gambar as produk from produk where produk_id = " + model.getProduk_id();
            java.sql.ResultSet res7 = stm.executeQuery(sql7);

            while (res7.next()) {
                view.txtGambar.setText(res7.getString("produk"));
            }

            String sql8 = "select daftar_id as produk from produk where produk_id = " + model.getProduk_id();
            java.sql.ResultSet res8 = stm.executeQuery(sql8);

            while (res8.next()) {
                view.txtDaftarID.setText(res8.getString("produk"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public void combo_pilihan() {
        try {
            String sql = "select produk_id as produk_id from produk";
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

    public void combo_Daftar_id() {
        try {
            String sql = "select daftar_id as daftar_id from daftarbahanproduk";
            java.sql.Connection conn = (Connection) Connetor.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                view.ComDaftar_id.addItem(res.getString(1));
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
            String sql = "select " + com + ", nama_barang from produk where " + com + " like '%" + like + "%'";
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

    public void btnUpload() {
        try {
            String filename;
            String filename2;
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(f.toString());
            Image image = icon.getImage().getScaledInstance(view.Gambar.getWidth(), view.Gambar.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(image);
            view.Gambar.setIcon(ic);

            filename = f.getAbsolutePath();

            String newpath = "src/Gambar/kue/";
            File directory = new File(newpath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File sourceFile = null;
            File destinationFile = null;
            String extension = filename.substring(filename.lastIndexOf('.') + 1);
            sourceFile = new File(filename);
            Date tanggal_update = new Date();
            String tampilan = "yyyyMMddhhmmss";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(tanggal_update));
            destinationFile = new File(newpath + "/newImage" + tanggal.toString() + "." + extension);

            Files.copy(sourceFile.toPath(), destinationFile.toPath());
            filename2 = destinationFile.getAbsolutePath();
            view.txtGambar.setText(filename2);

        } catch (Exception eo) {
            JOptionPane.showMessageDialog(null, "(C)Maaf, ada masalah di upload yaitu: " + eo.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void gambarMuncul(String path) throws IOException {
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

    public void klik_table() {
        DefaultTableModel md = (DefaultTableModel) view.table.getModel();
        view.txtID.setText(md.getValueAt(view.table.getSelectedRow(), 0).toString());
        view.txtNama.setText(md.getValueAt(view.table.getSelectedRow(), 1).toString());
        view.txtKeterangan.setText(md.getValueAt(view.table.getSelectedRow(), 2).toString());
        view.txtKategori.setText(md.getValueAt(view.table.getSelectedRow(), 3).toString());
        view.txtHarga.setText(md.getValueAt(view.table.getSelectedRow(), 4).toString());
        view.txtJumlah.setText(md.getValueAt(view.table.getSelectedRow(), 5).toString());
        view.txtGambar.setText(md.getValueAt(view.table.getSelectedRow(), 6).toString());
        view.txtDaftarID.setText(md.getValueAt(view.table.getSelectedRow(), 7).toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnTambah) {
            try {
                model.setProduk_id(Integer.parseInt(view.txtID.getText()));
                model.setNama_barang(view.txtNama.getText());
                model.setKeterangan(view.txtKeterangan.getText());
                model.setKategori(view.txtKategori.getText());
                model.setHarga(Integer.parseInt(view.txtHarga.getText()));
                model.setStok(Integer.parseInt(view.txtJumlah.getText()));
                model.setGambar(view.txtGambar.getText());
                model.setDaftar_id(Integer.parseInt(view.txtDaftarID.getText()));
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

        } else if (e.getSource() == view.btnUpload) {
            btnUpload();

        } else if (e.getSource() == view.btnHapus) {
            int id = Integer.parseInt((String) view.ComPilihan.getSelectedItem());
            model.setProduk_id(id);
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
                gambarMuncul(view.txtGambar.getText());
                view.btnUbah.setVisible(false);
                view.btnKonfi.setVisible(true);
                JOptionPane.showMessageDialog(null, "Tekan Tombol Konfirmasi jika sudah selesai mengedit");

            } catch (Exception o) {
                JOptionPane.showMessageDialog(null, "Ada masalah pada Button ubah " + o);
            }
        } else if (e.getSource() == view.btnKonfi) {
            try {
                model.setProduk_id(Integer.parseInt(view.txtID.getText()));
                model.setNama_barang(view.txtNama.getText());
                model.setKeterangan(view.txtKeterangan.getText());
                model.setKategori(view.txtKategori.getText());
                model.setHarga(Integer.parseInt(view.txtHarga.getText()));
                model.setStok(Integer.parseInt(view.txtJumlah.getText()));
                model.setGambar(view.txtGambar.getText());
                model.setDaftar_id(Integer.parseInt(view.txtDaftarID.getText()));

                try {
                    if (model.update_data(model)) {
                        gambarMuncul(view.txtGambar.getText());
                        KosongFromProduk();
                        tampil_data();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "Ada masalah pada tombol Yakin: " + a);
            }
        } else if (e.getSource() == view.ComDaftar_id) {
            int d_id = Integer.parseInt((String) view.ComDaftar_id.getSelectedItem());
            view.txtDaftarID.setText("" + d_id);

        } else if (e.getSource() == view.btnPencarian) {
            try {
                String com = ((String) view.comKolom.getSelectedItem());
                String like = view.txtPencarian.getText();
                btnPencarian(com, like);
            } catch (Exception penc) {
                JOptionPane.showMessageDialog(null, "Masukkan nilai/huruf terlebih dahulu atau nilai yang anda cari tidak ada:\n " + penc, "Tidak ada", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == view2.btnCetak) {
            try{
                try{
                java.sql.Connection conn = (Connection) Connetor.configDB();
                InputStream is = view2.getClass().getResourceAsStream("/Report/ReportProduk.jasper");
                JasperPrint jsPrint = JasperFillManager.fillReport(is, null, conn);
                JasperViewer.viewReport(jsPrint,false);
                }catch(SQLException n){
                    JOptionPane.showMessageDialog(null, n);
                }
            }catch(JRException l){
                JOptionPane.showMessageDialog(null, l);
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
                String keterangan = view.table.getValueAt(baris, 3).toString();
                view.txtKeterangan.setText(keterangan);
                String Kategori = view.table.getValueAt(baris, 4).toString();
                view.txtKategori.setText(Kategori);
                int harga = Integer.parseInt(view.table.getValueAt(baris, 5).toString());
                view.txtHarga.setText("" + harga);
                int stok = Integer.parseInt(view.table.getValueAt(baris, 6).toString());
                view.txtJumlah.setText("" + stok);
                byte gambar = Byte.parseByte(view.table.getValueAt(baris, 7).toString());
                view.txtGambar.setText("" + gambar);
                int daftar_id = Integer.parseInt(view.table.getValueAt(baris, 8).toString());
                view.txtDaftarID.setText("" + daftar_id);
            } catch (Exception table) {
                JOptionPane.showMessageDialog(null, "Table ada yang error: " + table);
            }

        }
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
