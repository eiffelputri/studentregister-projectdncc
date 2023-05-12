/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Mahasiswa;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface iMahasiswa {
    public void insert(Mahasiswa m);
    public void update(Mahasiswa m);
    public void delete(String m);
    public List<Mahasiswa> getAll();
}
