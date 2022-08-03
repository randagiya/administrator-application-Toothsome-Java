package Models;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class pengeluaran_m {

    private int daftar_id;
    private String deskirpsi;
    private String jumlah;
    private int harga;
    private String tanggal_beli;

    public int getDaftar_id() {
        return daftar_id;
    }

    public void setDaftar_id(int daftar_id) {
        this.daftar_id = daftar_id;
    }

    public String getDeskirpsi() {
        return deskirpsi;
    }

    public void setDeskirpsi(String deskirpsi) {
        this.deskirpsi = deskirpsi;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getTanggal_beli() {
        return tanggal_beli;
    }

    public void setTanggal_beli(String tanggal_beli) {
        this.tanggal_beli = tanggal_beli;
    }

    public boolean insert_data(pengeluaran_m data) throws SQLException {
        PreparedStatement pstm = null;
        Connection conn = (Connection) Connetor.configDB();

        String sql = "insert into daftarbahanproduk values(?,?,?,?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, data.getDaftar_id());
            pstm.setString(2, data.getDeskirpsi());
            pstm.setString(3, data.getJumlah());
            pstm.setInt(4, data.getHarga());
            pstm.setString(5, data.getTanggal_beli());

            pstm.execute();
            return true;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "(M)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    }

    public boolean update_data(pengeluaran_m data) throws SQLException {
        PreparedStatement pstm = null;
        Connection conn = (Connection) Connetor.configDB();

        String sql = "UPDATE daftarbahanproduk set  Deskirpsi=?, Jumlah=?, harga=?, tanggal_beli=? WHERE Daftar_id=? ";
        try {

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, data.getDeskirpsi());
            pstm.setString(2, data.getJumlah());
            pstm.setInt(3, data.getHarga());
            pstm.setString(4, data.getTanggal_beli());
            pstm.setInt(5, data.getDaftar_id());

            pstm.execute();
            return true;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "(M)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public boolean Hapus_data(pengeluaran_m data) throws SQLException {
        PreparedStatement pstm = null;
        Connection conn = (Connection) Connetor.configDB();

        String sql = "DELETE from daftarbahanproduk where Daftar_id=?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, data.getDaftar_id());

            pstm.execute();
            return true;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "(M)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
