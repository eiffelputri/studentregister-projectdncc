/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.Koneksi;
import Model.Mahasiswa;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Asus
 */
public class DAOMahasiswa implements iMahasiswa{
    Connection con;
    final String queryInsert="insert into mahasiswa (nik,nama,umur,alamat) values(?,?,?,?)";
    final String querySelect="select * from mahasiswa";
    final String queryUpdate="update mahasiswa set nik=?, nama=?, umur=?, alamat=? where nik=?";
    final String queryDelete="delete from mahasiswa where nik=?";
    
    public DAOMahasiswa(){
        con=Koneksi.getConnection();
    }
    
    @Override
    public void insert(Mahasiswa m) {
        PreparedStatement statement=null;
        try{
            statement=con.prepareStatement(queryInsert);
            statement.setString(1, m.getNik());
            statement.setString(2, m.getNama());
            statement.setInt(3, m.getUmur());
            statement.setString(4, m.getAlamat());
            statement.executeUpdate();
            System.out.println("Berhasil Menginput");
        }catch(SQLException e){
            System.out.println("Gagal Menginput "+e.toString());
        }
        finally{
            try{
                statement.close();
            }catch(SQLException e){
                System.out.println("Gagal Menginput "+e.toString());
            }
        }
    }

    @Override
    public void update(Mahasiswa m) {
        PreparedStatement statement=null;
        try{
            statement=con.prepareStatement(queryUpdate);
            statement.setString(1, m.getNik());
            statement.setString(2, m.getNama());
            statement.setInt(3, m.getUmur());
            statement.setString(4, m.getAlamat());
            statement.setString(5, m.getNik());
            statement.executeUpdate();
            System.out.println("Berhasil Mengupdate");
        }catch(SQLException e){
            System.out.println("Gagal Mengupdate "+e.toString());
        }
        finally{
            try{
                statement.close();
            }catch(SQLException e){
                System.out.println("Gagal Mengupdate "+e.toString());
            }
        }
    }

    @Override
    public void delete(String m) {
        PreparedStatement statement=null;
        try{
            statement=con.prepareStatement(queryDelete);
            statement.setString(1, m);
            System.out.println("Berhasil Menghapus");
            statement.executeUpdate();
        }catch(SQLException e){
            System.out.println("Gagal Menghapus "+e.toString());
        }
        finally{
            try{
                statement.close();
            }catch(SQLException e){
                System.out.println("Gagal Menghapus "+e.toString());
            }
        }
    }

    @Override
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> listMhs=null;
        try{
            listMhs = new ArrayList<Mahasiswa>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(querySelect);
            while(rs.next()){
                Mahasiswa m = new Mahasiswa();
                m.setNik(rs.getString("nik"));
                m.setNama(rs.getString("nama"));
                m.setUmur(rs.getInt("umur"));
                m.setAlamat(rs.getString("alamat"));
                listMhs.add(m);
            }
        }catch(SQLException e){
            System.out.println("Gagal Membaca "+e.toString());
        }
        return listMhs;
    }
}
