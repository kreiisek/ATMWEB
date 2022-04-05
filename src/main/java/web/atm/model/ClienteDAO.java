package web.atm.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;



import web.atm.utils.*;
import web.atm.dto.LogueoDTO;
import web.atm.dto.UsuariosDTO;
import web.atm.entity.*;

import oracle.jdbc.OracleTypes;

public class ClienteDAO {

	Connection connect;
	BdConection bdConnect;
	Cliente clnt = null;
	
	//regresar varianles de control
	

	public Boolean Insert(UsuariosDTO usuario) {

		connect = bdConnect.conectar();
		Boolean validacion = false;

		try {
			CallableStatement cst = connect.prepareCall("{call inser_per_us(?,?,?,?,?,?)}");
			
			cst.setString(1, usuario.getNombre());
			cst.setString(2, usuario.getApPaterno());
			cst.setString(3, usuario.getApMaterno());
			cst.setInt(4, Integer.parseInt(usuario.getEdad()));
			cst.setString(5, usuario.getUsuario());
			cst.setString(6, usuario.getPassword());
			cst.execute();

			cst.close();
			connect.close();
			validacion = true;

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			validacion = false;
		}
		return validacion;

	}
	
	
	
	
	public Cliente logueoCliente(LogueoDTO log) {
		clnt =new Cliente();
		connect = bdConnect.conectar();

		try {

			CallableStatement cst = connect.prepareCall("{call LogueUsPas(?,?,?)}");
			cst.setString(1, log.getUsuario());
			cst.setString(2, log.getPassword());
			cst.registerOutParameter(3, OracleTypes.CURSOR);// Asignar elparametro de resultset
			cst.execute();

			ResultSet rs = (ResultSet) cst.getObject(3);

			if (rs.next()) {

			//	getUser = new ClienteDAO();
				clnt.setIdPersona(rs.getInt("ID_PERSONA"));
				clnt.setIdPersonaFK(rs.getInt("ID_PERSONA"));
				clnt.setNombre(rs.getString("NOMBRE"));
				clnt.setApPaterno(rs.getString("PATERNO"));
				clnt.setApMaterno(rs.getString("MATERNO"));
				clnt.setEdad(rs.getString("EDAD"));
				clnt.setIdCliente(rs.getInt("ID_CLIENTE"));
				clnt.setUsuario(rs.getString("USUARIO"));
				clnt.setPassword(rs.getString("PASSWORD"));

			}
			cst.close();
			connect.close();

		} catch (Exception e) {
			e.getStackTrace();

		}

	return clnt;
	}
	
}
