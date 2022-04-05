package web.atm.dto;

public class MovimientosDTO {


	private Integer idCuentafk;
	private String tipocnta;
	private String noCuenta;
	private String tipoMovimiento;
	private String monedacnta;
	private String monedatran;
	private Double monto;
	private Double saldo;
	
	

	public String getTipocnta() {
		return tipocnta;
	}
	public void setTipocnta(String tipocnta) {
		this.tipocnta = tipocnta;
	}
	public Integer getIdCuentafk() {
		return idCuentafk;
	}
	public void setIdCuentafk(Integer idCuentafk) {
		this.idCuentafk = idCuentafk;
	}
	
	
	public String getNoCuenta() {
		return noCuenta;
	}
	public void setNoCuenta(String noCuenta) {
		this.noCuenta = noCuenta;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	
	
	
	public String getMonedacnta() {
		return monedacnta;
	}
	public void setMonedacnta(String monedacnta) {
		this.monedacnta = monedacnta;
	}
	public String getMonedatran() {
		return monedatran;
	}
	public void setMonedatran(String monedatran) {
		this.monedatran = monedatran;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	
	
	
	
	
	public MovimientosDTO(Integer idCuentafk, String tipocnta, String noCuenta, String tipoMovimiento,
			String monedacnta, String monedatran, Double monto, Double saldo) {
		super();
		this.idCuentafk = idCuentafk;
		this.tipocnta = tipocnta;
		this.noCuenta = noCuenta;
		this.tipoMovimiento = tipoMovimiento;
		this.monedacnta = monedacnta;
		this.monedatran = monedatran;
		this.monto = monto;
		this.saldo = saldo;
	}
	public MovimientosDTO() {

	}
	
	
	
}
