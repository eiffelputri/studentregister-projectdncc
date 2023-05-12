/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Asus
 */
public class TabelModelMahasiswa extends AbstractTableModel{
    List<Mahasiswa> listMhs;
    
    public TabelModelMahasiswa(List<Mahasiswa> lm)
    {
        listMhs = lm;
    }

    @Override
    public int getRowCount() {
        return listMhs.size();
    }

    @Override
    public int getColumnCount() {
       return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex)
       {
            case 0:
                return listMhs.get(rowIndex).getNik();
            case 1:
                return listMhs.get(rowIndex).getNama();
            case 2:
                return listMhs.get(rowIndex).getUmur();
            case 3:
                return listMhs.get(rowIndex).getAlamat(); 
            default:
               return null;
       }
    }
}
