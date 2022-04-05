package web.atm.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class BdConection {
	public static Connection conectar() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());// Paso 1 declarar driver
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sys as sysdba","admin");		
			System.out.println("Conexion exitosa...");
			return conn;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
}
