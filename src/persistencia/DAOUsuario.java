package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Administrador;
import entidades.Comun;
import entidades.Experto;
import entidades.Usuario;

public abstract class DAOUsuario {
	
	protected static final String INSERT_USUARIO = "INSERT INTO usuarios (ID_USUARIO, NOMBRE, APELLIDO, NOMB_USUARIO, CONTRASENIA, EMAIL) VALUES (SEQ_ID_USUARIO.NEXTVAL,?,?,?,?,?)";
	protected static final String UPDATE_USUARIO = "UPDATE usuarios SET NOMBRE=?,APELLIDO=?,NOMB_USUARIO=?,CONTRASENIA=?,EMAIL=? WHERE ID_USUARIO=?";
	
	private static final String DELETE_USUARIO = "DELETE FROM usuarios WHERE id_usuario = ?";
	private static final String LOGIN = "SELECT id_usuario FROM usuarios WHERE nomb_usuario=? AND contrasenia=?";
	
	private static final String ALL_USUARIOS = "SELECT\r\n" + 
			"    usuarios.*,\r\n" + 
			"    administradores.cedula,\r\n" + 
			"    administradores.instituto,\r\n" + 
			"    null AS profesion,\r\n" + 
			"    administradores.list_tareas,\r\n" + 
			"    'administrador' AS rol\r\n" + 
			"FROM\r\n" + 
			"         usuarios\r\n" + 
			"    INNER JOIN administradores ON usuarios.id_usuario = administradores.id_usuario\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    usuarios.*,\r\n" + 
			"    expertos.cedula,\r\n" + 
			"    null AS instituto,\r\n" + 
			"    expertos.profesion,\r\n" + 
			"    expertos.list_tareas,\r\n" + 
			"    'experto' AS rol\r\n" + 
			"FROM\r\n" + 
			"         usuarios\r\n" + 
			"    INNER JOIN expertos ON usuarios.id_usuario = expertos.id_usuario\r\n" + 
			"UNION\r\n" + 
			"SELECT\r\n" + 
			"    usuarios.*,\r\n" + 
			"    null AS cedula,\r\n" + 
			"    null AS instituto,\r\n" + 
			"    null AS profesion,\r\n" + 
			"    comunes.list_tareas,\r\n" + 
			"    'comun' AS rol\r\n" + 
			"FROM\r\n" + 
			"         usuarios\r\n" + 
			"    INNER JOIN comunes ON usuarios.id_usuario = comunes.id_usuario";
	
	private static Connection conexion = DatabaseManager.getConexion();
	
	public static LinkedList<Usuario> allUsuarios() {
		LinkedList<Usuario> usuarios = new LinkedList<>();
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(ALL_USUARIOS);
			
			while(rset.next()) {
				Usuario usuario = null;
				String rol = rset.getString("rol");
				if(rol.equals("administrador")) {
					usuario = new Administrador();
				} else if(rol.equals("experto")) {
					usuario = new Experto();
				} else if(rol.equals("comun")) {
					usuario = new Comun();
				}
				usuario.setId(rset.getInt("id_usuario"));
				usuario.setNombre(rset.getString("nombre"));
				usuario.setApellido(rset.getString("apellido"));
				usuario.setUser(rset.getString("nomb_usuario"));
				usuario.setPswd(rset.getString("contrasenia"));
				usuario.setEmail(rset.getString("email"));
				if(usuario.getRol().equals("administrador") || usuario.getRol().equals("experto")) {
					usuario.setCedula(rset.getInt("cedula"));
				}
				if(usuario.getRol().equals("administrador")) {
					usuario.setInstituto(rset.getString("instituto"));
				}
				if(usuario.getRol().equals("experto")) {
					usuario.setProfesion(rset.getString("profesion"));
				}
				usuario.setList_tareas(rset.getString("list_tareas"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public static boolean deleteUsuario(int id) {
		try {
			PreparedStatement eliminarUsuario = conexion.prepareStatement(DELETE_USUARIO);
			
			conexion.setAutoCommit(false);
			
			eliminarUsuario.setInt(1, id);
			
			int retorno = eliminarUsuario.executeUpdate();
			
			return retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static int login(String username, String password) {
		int id = 0;
		try {
			PreparedStatement pst = conexion.prepareStatement(LOGIN);
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) id = rs.getInt("ID_USUARIO");			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
