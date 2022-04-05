package web.atm.dto;

public class PersonasDTO {

	
	private Integer idPersona;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String usuario;
	private String password;
	
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
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
	public PersonasDTO(Integer idPersona, String nombre, String apPaterno, String apMaterno, String usuario,
			String password) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.usuario = usuario;
		this.password = password;
	}
	
	public PersonasDTO() {

	}
	
	
	
	
}
