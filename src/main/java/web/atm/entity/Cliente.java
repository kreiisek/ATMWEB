package web.atm.entity;

public class Cliente extends Persona{
	
	private Integer idCliente;
	private String usuario;
	private String password;
	private Integer idPersonaFK;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIdPersonaFK() {
		return idPersonaFK;
	}
	public void setIdPersonaFK(Integer idPersonaFK) {
		this.idPersonaFK = idPersonaFK;
	}

}
