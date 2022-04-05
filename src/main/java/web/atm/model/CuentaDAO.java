package web.atm.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;
import web.atm.dto.CuentaDTO;
import web.atm.dto.CuentasDTO;
import web.atm.entity.Cuenta;
import web.atm.utils.BdConection;

public class CuentaDAO {

	Connection connect;
	BdConection bdConnect;

	public ArrayList<Cuenta> accountsById(CuentasDTO account) {

		Cuenta acc = null;
		ArrayList<Cuenta> addAcc = null;
		connect = bdConnect.conectar();
		

		try {
//Slct_Cnts_ByIDRs

			CallableStatement cst = connect.prepareCall("{call Slct_Cnts_ByIDRs(?,?)}");
			cst.setInt(1, account.getIdCliente());
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
			ResultSet rs = (ResultSet) cst.getObject(2);

			addAcc = new ArrayList<Cuenta>();
			while (rs.next()) {
				acc = new Cuenta();
				acc.setIdCuenta(rs.getInt("ID_CUENTA"));
				acc.setNoCuenta(rs.getString("NOCUENTA"));
				acc.setSaldo(rs.getDouble("SALDO"));
				acc.setMoneda(rs.getString("MONEDA"));
				acc.setTipoCuenta(rs.getString("TIPOCUENTA"));
				acc.setIdCliente(rs.getInt("ID_CLIENTEFK"));
				addAcc.add(acc);
			}

			cst.close();
			connect.close();

		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}

		return addAcc;
	}

	public Boolean insert(Cuenta cnta) {

		connect = bdConnect.conectar();
		Boolean validacion = false;

		try {

			CallableStatement cst = connect.prepareCall("{call insert_Acc(?,?,?,?,?)}");
			cst.setString(1, cnta.getNoCuenta());
			cst.setDouble(2, cnta.getSaldo());
			cst.setString(3, cnta.getTipoCuenta());
			cst.setString(4, cnta.getMoneda());
			cst.setInt(5, cnta.getIdCliente());
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
	
	
	public Cuenta accountByNo(CuentaDTO account) {
		Cuenta acc = null;
		connect = bdConnect.conectar();

		try {
	
			CallableStatement cst = connect.prepareCall("{call Slct_Cn_ByIDRs(?,?)}");
			// En las funciones de recorre un lugar para el return
			cst.setString(1, account.getNoCuenta());
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
			ResultSet rs = (ResultSet) cst.getObject(2); 

			if (rs.next()) {
				acc = new Cuenta();
				acc.setIdCuenta(rs.getInt("ID_CUENTA"));
				acc.setNoCuenta(rs.getNString("NOCUENTA"));
				acc.setSaldo(rs.getDouble("SALDO"));
				acc.setMoneda(rs.getString("MONEDA"));
				acc.setTipoCuenta(rs.getNString("TIPOCUENTA"));
				acc.setIdCliente(rs.getInt("ID_CLIENTEFK"));

			}
			cst.close();
			rs.close();
			connect.close();

		} catch (Exception e) {
			e.getStackTrace();
		}

		return acc;
	}
	

}
