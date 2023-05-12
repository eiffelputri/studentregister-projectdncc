/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOMahasiswa;
import DAO.iMahasiswa;
import Model.Mahasiswa;
import Model.TabelModelMahasiswa;
import java.util.List;
import javax.swing.JOptionPane;
import view.Pendaftaran;

/**
 *
 * @author Asus
 */
public class ControllerMahasiswa {
    Pendaftaran pen;
    iMahasiswa imahasiswa;
    List<Mahasiswa> listMhs;
    
    public ControllerMahasiswa(Pendaftaran pen) {
        this.pen = pen;
        imahasiswa = new DAOMahasiswa();
        listMhs = imahasiswa.getAll();
    }
    
    public void isiTable() {
        listMhs = imahasiswa.getAll();
        TabelModelMahasiswa tmb = new TabelModelMahasiswa(listMhs);
        pen.getTable().setModel(tmb);
    }
    
    public void insert() {
        if(!pen.getNIK().trim().isEmpty()) {
            Mahasiswa m = new Mahasiswa();
            m.setNik(pen.getNIK());
            m.setNama(pen.getNama());
            m.setUmur(pen.getUmur());
            m.setAlamat(pen.getAlamat());
            imahasiswa.insert(m);
            JOptionPane.showMessageDialog(null, "Sukses Disimpan");
        }
        else {
            JOptionPane.showMessageDialog(null, "NIK Tidak Boleh Kosong");
        }
    }
    
    public void update() {
        if(!pen.getNIK().trim().isEmpty()) {
            Mahasiswa m = new Mahasiswa();
            m.setNik(pen.getNIK());
            m.setNama(pen.getNama());
            m.setUmur(pen.getUmur());
            m.setAlamat(pen.getAlamat());
            imahasiswa.update(m);
            JOptionPane.showMessageDialog(null, "Sukses Diupdate");
        }
        else {
            JOptionPane.showMessageDialog(null, "NIK Tidak Boleh Kosong");
        }
    }
    
    public void Delete(){
        if(!pen.getNIK().trim().isEmpty()) {
            String m = pen.getNIK();
            imahasiswa.delete(m);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        }
        else {
            JOptionPane.showMessageDialog(null, "Gagal Dihapus");
        }
    }
    
    public void isianform(int indx) {
        pen.setNIK(listMhs.get(indx).getNik());
        pen.setNama(listMhs.get(indx).getNama());
        pen.setUmur(listMhs.get(indx).getUmur());
        pen.setAlamat(listMhs.get(indx).getAlamat());
    }
    
    public void reset(){
        pen.setNIK("");
        pen.setNama("");
        pen.setUmur(0);
        pen.setAlamat("");
    }
}
