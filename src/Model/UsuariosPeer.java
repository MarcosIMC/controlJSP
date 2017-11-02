package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UsuariosPeer {
	public static boolean obtenerUsuarios(String user, String pass, DataManager manager) {
		
		Connection conn = manager.getConnection();	
		
	    if (conn != null) {
	        try {
	          Statement s = conn.createStatement();
	          String sql = "SELECT * FROM usuarios WHERE usuario = '"+user+"' AND clave = '"+pass+"'";
	          try {
	            ResultSet rs = s.executeQuery(sql);
	            try {
	            	if(rs != null) {
	            		System.out.println(rs.getString(1));
	            		return true;
	            	}
	              }
	            finally { rs.close(); }
	            }
	          finally { s.close(); }
	          }
	        catch (SQLException e) {
	          System.out.println("Could not search for books:" + e.getMessage());
	          }
	        finally {
	          manager.putConnection(conn);
	          }
	        }
		
		return false;
		
	}
}
