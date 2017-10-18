package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codigo;
	private Integer activo;
	private String contrasena;
	private String usuario;
	
//	@ManyToOne
//	@JoinColumn(name="roles")
//	private Roles roles;
//	
//	@ManyToOne
//	@JoinColumn(name="perfil")
//	private Perfil perfil;
//	
//	@ManyToOne
//	@JoinColumn(name="trabajador")
//	private Trabajador trabajador;
//	
//	@ManyToOne
//	@JoinColumn(name="permisosaccesosistema")
//	private PermisosAccesoSistema permisosAccesoSistema;
	
	public Usuario() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}	

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}