package web.atm.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;
import web.atm.dto.PersonasDTO;
import web.atm.dto.UsuariosDTO;
import web.atm.utils.BdConection;

public class PersonaDAO {
	
	
	Connection connect;
	BdConection bdConnect;

	

	public Boolean update(PersonasDTO usuario) {

		connect = bdConnect.conectar();
		Boolean validacion = false;

		try {
			CallableStatement cst = connect.prepareCall("{call update_per_us(?,?,?,?,?,?)}");
			
			cst.setInt(1, usuario.getIdPersona());
			cst.setString(2, usuario.getNombre());
			cst.setString(3, usuario.getApPaterno());
			cst.setString(4, usuario.getApMaterno());
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
	
	
	
	
	
	
	
	
	public PersonasDTO search(PersonasDTO per) {

		connect = bdConnect.conectar();
		Boolean validacion = false;

		try {
			CallableStatement cst = connect.prepareCall("{call Slct_Cntsper_ByIDRs(?,?)}");
			
			cst.setInt(1, per.getIdPersona());
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
			ResultSet rs = (ResultSet) cst.getObject(2);
			if(rs.next())
			{
				per = new PersonasDTO();
				per.setIdPersona(rs.getInt("ID_PERSONA"));
				per.setNombre  (rs.getString("NOMBRE"));
				per.setApPaterno(rs.getString("PATERNO"));
				per.setApMaterno(rs.getString("MATERNO"));
				per.setUsuario(rs.getString("USUARIO"));
				per.setPassword(rs.getString("PASSWORD"));
			}
			
			
			
			cst.close();
			connect.close();
			validacion = true;

		} catch (Exception e) {
			e.getStackTrace();
			e.getMessage();
			validacion = false;
		}
		return per;

	}
	
}
