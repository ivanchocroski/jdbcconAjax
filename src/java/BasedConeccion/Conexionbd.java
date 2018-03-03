/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedConeccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Contacto;

/**
 *
 * @author Usuario
 */
public class Conexionbd {
    
     private static String user="root";
    private static String password="estudiante";
    private static String url="jdbc:postgresql://localhost:3306/demo";
    private static Connection con=null;
    
    //metodo para conectar la base de datos
    public  static void connect() throws ClassNotFoundException, SQLException{
        //cargamos el driver
        Class.forName("org.postgresql.driver");
        con= DriverManager.getConnection(url,user,password);
        
    }
    //metodo para agregar los contactos en la base de datos.
    public static void insertarContactos(Contacto co) throws SQLException, ClassNotFoundException{
        connect();
        PreparedStatement pst = con.prepareStatement("insert into " + " contactos values (?,?,?,?)");
        pst.setInt(1, co.getId());
        pst.setString(2, co.getNombre());
        pst.setString(3, co.getApellido());
        pst.setString(4, co.getCorreo());
        con.close();
        pst.close();
        
        
    }
    
    //metodos para borrar contactos
    public static void borrarContactos(Contacto co) throws ClassNotFoundException, SQLException{
        connect();
        PreparedStatement pst= con.prepareStatement("Delete from contactos where nombre");
        pst.setString(1, co.getNombre());
        pst.execute();
        
    }
    //metodo para ver los contactos en la lista
    public static List<Contacto> list() throws ClassNotFoundException, SQLException{
        connect();
       List<Contacto> listaContacto=new  ArrayList<>();
        PreparedStatement pst = con.prepareStatement("Select * from contactos ");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Contacto c=new Contacto(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4));
            listaContacto.add(c);
        }
        con.close();
        pst.close();
        return listaContacto;
    }
     //metodo para actualizar los contactos en la base de datos
    public static void actualizarContactos(Contacto co) throws ClassNotFoundException, SQLException{
        connect();
        PreparedStatement pst = con.prepareStatement("Update contactos set correo=?, nombre=?, apellidos=?, where id=?");
        pst.setInt(4,co.getId());
        pst.setString(1, co.getCorreo());
        pst.setString(2, co.getNombre());
        pst.setString(3, co.getApellido());
        pst.executeUpdate();
        pst.close();
        con.close();
    }
       
} 
    
        
   
    

   

   
    
    
    
    

