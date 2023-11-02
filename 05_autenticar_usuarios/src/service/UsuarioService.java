package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioService {

	String cadena = "jdbc:mysql://localhost:3306/empresa";
	String user = "root", pwd = "root";

	public boolean comprobarUsuario (Usuario usuario) {
		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "select * from usuarios where usuario = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getPassword());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException ex) {
			ex.printStackTrace(); 
			return false;
		}
	}
	
	public Usuario getUser(String usuario) {
		try (Connection con = DriverManager.getConnection(cadena, user, pwd);) {
			String sql = "select * from usuarios where usuario = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usuario);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Usuario( usuario, rs.getString("password") );
			} else {
				return null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace(); 
			return null;
		}
	}
}