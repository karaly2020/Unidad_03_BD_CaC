package conector;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.spi.DirStateFactory.Result;
public class Conexion2021 {
    
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
        
    public Conexion2021 (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/informatica?autoReconnet=true&useSSL=false", "root", "20061992");
            st = con.createStatement();
            rs = st.executeQuery("select * from articulos");
            
            while(rs.next ()){
                
                //System.out.println(rs.getInt(1)); // codigo del articulo
                //System.out.println(rs.getString(2)); // nombre
                //System.out.println(rs.getInt(3)); // precio
                //System.out.println(rs.getDouble(3)); // precio
                //System.out.println(rs.getInt(4)); // fabricante
                
                // para dos columnas por ejemplo
                int codigo = rs.getInt(1);
                String nombre = rs.getString(2);
                System.out.println(codigo + ": " + nombre);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion2021.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion2021.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("**** ERROR DE CONEXION****");
        }
    }

    public static void main(String args[]) {
        Conexion2021 con1 = new Conexion2021();
    }
}