package web.atm.dto;

public class LogueoDTO {

	private String usuario;
	private String password;
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
	
	public LogueoDTO(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}
	
	public LogueoDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LogueoDTO [usuario=" + usuario + ", password=" + password + "]";
	}
	
}
