 package pe.infounsa.siaa.business.seguridad.dto;

public class UsuarioDto {
	
	private int codigo;
	public String usuario;
	public PerfilDto perfil;
	public PermisosAccesoSistemaDto permisosAccesoSistema;
	private RolesDto roles;
	private Byte activo;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public PerfilDto getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilDto perfil) {
		this.perfil = perfil;
	}	
	public Byte getActivo() {
		return activo;
	}
	public void setActivo(Byte activo) {
		this.activo = activo;
	}
	public RolesDto getRoles() {
		return roles;
	}
	public void setRoles(RolesDto roles) {
		this.roles = roles;
	}
	public PermisosAccesoSistemaDto getPermisosAccesoSistema() {
		return permisosAccesoSistema;
	}
	public void setPermisosAccesoSistema(
			PermisosAccesoSistemaDto permisosAccesoSistema) {
		this.permisosAccesoSistema = permisosAccesoSistema;
	}

}
