/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author RANDA
 */
public class input_pesanan_m {

    private int pesan_id, kost_id, produk_id, pesan_jumlah, pesan_bayar, produk_stok;
    private String pesan_tanggal, path_gambar;

    public String getPath_gambar() {
        return path_gambar;
    }

    public int getProduk_stok() {
        return produk_stok;
    }

    public void setProduk_stok(int produk_stok) {
        this.produk_stok = produk_stok;
    }

    public void setPath_gambar(String path_gambar) {
        this.path_gambar = path_gambar;
    }

    public int getPesan_id() {
        return pesan_id;
    }

    public void setPesan_id(int pesan_id) {
        this.pesan_id = pesan_id;
    }

    public int getKost_id() {
        return kost_id;
    }

    public void setKost_id(int kost_id) {
        this.kost_id = kost_id;
    }

    public int getProduk_id() {
        return produk_id;
    }

    public void setProduk_id(int produk_id) {
        this.produk_id = produk_id;
    }

    public int getPesan_jumlah() {
        return pesan_jumlah;
    }

    public void setPesan_jumlah(int pesan_jumlah) {
        this.pesan_jumlah = pesan_jumlah;
    }

    public int getPesan_bayar() {
        return pesan_bayar;
    }

    public void setPesan_bayar(int pesan_bayar) {
        this.pesan_bayar = pesan_bayar;
    }

    public String getPesan_tanggal() {
        return pesan_tanggal;
    }

    public void setPesan_tanggal(String pesan_tanggal) {
        this.pesan_tanggal = pesan_tanggal;
    }

    public boolean insert_data(input_pesanan_m data) throws SQLException {
        PreparedStatement pstm = null;
        Connection conn = (Connection) Connetor.configDB();

        String sql = "insert into pesanan values(?,?,?,?,?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, data.getPesan_id());
            pstm.setInt(2, data.getKost_id());
            pstm.setInt(3, data.getProduk_id());
            pstm.setString(4, data.getPesan_tanggal());
            pstm.setInt(5, data.getPesan_jumlah());
            pstm.setInt(6, data.getPesan_bayar());

            pstm.execute();
            return true;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "(M)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
   
}
