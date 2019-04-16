/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionesodbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class ConexionesOdbo {

  
    public static void main(String[] args) throws ClassNotFoundException {

        Conexion sqlserve=new Conexion();
        sqlserve.GetRegresandCiudadesSqlServer();
        
    }
    
}


class Conexion{



public void GetRegresandCiudadesSqlServer() throws ClassNotFoundException{
    
    ResultSet SalvadorSqlServer=null;
   
    

  
    try {
         Connection Conexion;
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         String url = "jdbc:sqlserver://192.168.43.246:1433;databaseName=ciudades";
        
         Connection con = (Connection) DriverManager.getConnection(url,"salvador","123456");
         
        String SqlServer="select \n" +
        "mysql.idUsuario as id_usuario,mysql.Nombre as nombre_alumno, ciudad.nombre as nombre_ciudad, poss.nombre as nombre_estado, db2.nombre as nombre_usuario\n" +
        "from [MYSQL]...alumno as mysql\n" +
        "inner join ciudad on mysql.idCiudad = ciudad.idciudad\n" +
        "inner join [PGSQL]...estados as poss on ciudad.idestado = poss.idestado\n" +
        "inner join [DB2BD]...usuario as db2 on mysql.idUsuario = db2.idusuario";
                 
                 
         java.sql.PreparedStatement stm1 = con.prepareStatement(SqlServer);
         SalvadorSqlServer=stm1.executeQuery();
            System.out.println("ID\tNombre\t\tUsuario\t\tCiudad\t\tEstado");
            System.out.println("----------------------------------------------------------------");
         while(SalvadorSqlServer.next()){
              System.out.print(SalvadorSqlServer.getString(1)+"\t");
              System.out.print(SalvadorSqlServer.getString(2)+"\t\t");
              System.out.print(SalvadorSqlServer.getString(5)+"\t\t");
              System.out.print(SalvadorSqlServer.getString(3)+"\t");
              System.out.print(SalvadorSqlServer.getString(4)+"\n");
                
          }
         
       
     
        
        
    }catch(SQLException e) {
       System.out.println("error "+e);
    }    
     

    
}  
  







   }
