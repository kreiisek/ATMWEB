package web.atm.dto;

public class UsuariosDTO {
	
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String edad;
	private String usuario;
	private String password;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
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
	@Override
	public String toString() {
		return "UsuariosDTO [nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", edad="
				+ edad + ", usuario=" + usuario + ", password=" + password + "]";
	}
	
	
	
}
