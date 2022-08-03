package Models;

import View.produk;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class produk_m extends Connetor {

    private int produk_id;
    private String nama_barang;
    private String keterangan;
    private String kategori;
    private int harga;
    private int stok;
    private String gambar;
    private int daftar_id;

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getProduk_id() {
        return produk_id;
    }

    public void setProduk_id(int produk_id) {
        this.produk_id = produk_id;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getDaftar_id() {
        return daftar_id;
    }

    public void setDaftar_id(int daftar_id) {
        this.daftar_id = daftar_id;
    }

    public boolean insert_data(produk_m data) throws SQLException {
        PreparedStatement pstm = null;
        Connection conn = (Connection) Connetor.configDB();

        String sql = "insert into produk values(?,?,?,?,?,?,?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, data.getProduk_id());
            pstm.setString(2, data.getNama_barang());
            pstm.setString(3, data.getKeterangan());
            pstm.setString(4, data.getKategori());
            pstm.setInt(5, data.getHarga());
            pstm.setInt(6, data.getStok());
            pstm.setString(7, data.getGambar());
            pstm.setInt(8, data.getDaftar_id());

            pstm.execute();
            return true;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "(M)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    }

    public boolean update_data(produk_m data) throws SQLException {
        PreparedStatement pstm = null;
        Connection conn = (Connection) Connetor.configDB();

        String sql = "UPDATE produk set nama_barang=?, keterangan=?, kategori=?, harga=?, stok=?, path_gambar=?, daftar_id=? WHERE produk_id = ? ";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, data.getNama_barang());
            pstm.setString(2, data.getKeterangan());
            pstm.setString(3, data.getKategori());
            pstm.setInt(4, data.getHarga());
            pstm.setInt(5, data.getStok());
            pstm.setString(6, data.getGambar());
            pstm.setInt(7, data.getDaftar_id());
            pstm.setInt(8, data.getProduk_id());

            pstm.execute();
            return true;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "(M)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public boolean Hapus_data(produk_m data) throws SQLException {
        PreparedStatement pstm = null;
        Connection conn = (Connection) Connetor.configDB();

        String sql = "DELETE from produk where produk_id=?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, data.getProduk_id());

            pstm.execute();
            return true;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "(M)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }


}
