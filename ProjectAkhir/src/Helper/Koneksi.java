/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Asus
 */
public class Koneksi {
    static Connection con;
    public static Connection getConnection(){
        if(con==null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("dnccakhir");
            data.setUser("root");
            data.setPassword("");
            try{
                con=data.getConnection();
                System.out.println("Berhasil Tersambung");
            }catch(SQLException e){
                System.out.println("Gagal Tersambung "+e);
            }
        }
        return con;
    }
    public static void main(String[] args){
        getConnection();
    }
}
