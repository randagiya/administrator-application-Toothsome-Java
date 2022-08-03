package Models;

import Controller.Kostumer_c;
import View.produk;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class kostumer_m extends Connetor {

    private int kost_id;
    private String kost_nama;
    private String kost_alamat;
    private String telepon;

    public int getKost_id() {
        return kost_id;
    }

    public void setKost_id(int kost_id) {
        this.kost_id = kost_id;
    }

    public String getKost_nama() {
        return kost_nama;
    }

    public void setKost_nama(String kost_nama) {
        this.kost_nama = kost_nama;
    }

    public String getKost_alamat() {
        return kost_alamat;
    }

    public void setKost_alamat(String kost_alamat) {
        this.kost_alamat = kost_alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public boolean insert_data(kostumer_m data) throws SQLException {
        PreparedStatement pstm = null;
        Connection conn = (Connection) Connetor.configDB();

        String sql = "insert into kostumer values(?,?,?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, data.getKost_id());
            pstm.setString(2, data.getKost_nama());
            pstm.setString(3, data.getKost_alamat());
            pstm.setString(4, data.getTelepon());

            pstm.execute();
            return true;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "(M)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

    }

    public boolean update_data(kostumer_m data) throws SQLException {
        PreparedStatement pstm = null;
        Connection conn = (Connection) Connetor.configDB();

        String sql = "UPDATE kostumer set kost_nama=?, kost_alamat=?, telepon=? WHERE kost_id = ? ";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, data.getKost_nama());
            pstm.setString(2, data.getKost_alamat());
            pstm.setString(3, data.getTelepon());
            pstm.setInt(4, data.getKost_id());
           
            pstm.execute();
            return true;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "(M)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public boolean Hapus_data(kostumer_m data) throws SQLException {
        PreparedStatement pstm = null;
        Connection conn = (Connection) Connetor.configDB();

        String sql = "DELETE from kostumer where kost_id=?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, data.getKost_id());

            pstm.execute();
            return true;

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "(M)Maaf, ada masalah yaitu: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

}
