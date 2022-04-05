package web.atm.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;
import web.atm.dto.CuentaDTO;
import web.atm.dto.CuentasDTO;
import web.atm.dto.MovimientosDTO;
import web.atm.utils.BdConection;

public class MovimientoDAO {

	
	Connection connect;
	BdConection bdConnect;
	

	public void upAccSaldo(MovimientosDTO mov) {

		connect = bdConnect.conectar();

		try {
			CallableStatement cst = connect.prepareCall("{call UpSal_AddMovs(?,?,?,?,?,?)}");
			// String query = "UPDATE MMG_CUENTAS set SALDO = "+transac.getSaldo() +" where
			// NOCUENTA = '"+acc.getNoCuenta()+"'";
			// ResultSet rs = st.executeQuery(query);
			cst.setInt(1, mov.getIdCuentafk());
			cst.setDouble(2, mov.getSaldo());
			cst.setString(3, mov.getNoCuenta());
			cst.setString(4, mov.getTipoMovimiento());
			cst.setString(5, mov.getMonedatran());
			cst.setDouble(6, mov.getMonto());
			cst.execute();

			cst.close();
			connect.close();

		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}

	}
	

	public ArrayList<MovimientosDTO> selectTransactionByNoCuenta(CuentasDTO account)
	{
		MovimientosDTO trn = null;
		ArrayList<MovimientosDTO> getTransactions = null;
		connect =bdConnect.conectar();
		
		try {
			

			CallableStatement cst= connect.prepareCall("{call slc_mvs(?,?)}");
			cst.setInt(1, account.getIdCliente());
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
			ResultSet rs = (ResultSet) cst.getObject(2); 
			
			getTransactions = new ArrayList<MovimientosDTO>();
			while(rs.next())
			{
				trn = new MovimientosDTO();

				trn.setNoCuenta(rs.getString("NOCUENTA"));
				trn.setTipoMovimiento(rs.getString("TIPOMOVIMIENTO"));
				trn.setMonedatran(rs.getString("MONEDA"));
				trn.setMonto(rs.getDouble("MONTO"));
				trn.setSaldo(rs.getDouble("SALDO"));
				getTransactions.add(trn);
			}
			
			cst.close();
			connect.close();
			
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		
	
		return getTransactions;
	}
}
