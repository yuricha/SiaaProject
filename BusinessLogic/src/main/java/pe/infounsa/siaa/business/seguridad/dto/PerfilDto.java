/**
 * 
 */
package pe.infounsa.siaa.business.seguridad.dto;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author 
 *
 */
@SuppressWarnings("serial")
public class PerfilDto implements GrantedAuthority {

	private int codigo;
	private String descripcion;
	private String nombre;
	private Integer habilitado;
	private Integer isadmin;
	//private Integer anulado;
	
	private List<GruposDto> grupos;
	
//	private final RolSistema rolSistema;
//
//	private final Date fechaActualizacion;
//
//	public PerfilDto(final String rolSistema, final Date fechaActualizacion)
//			throws Exception {
//		this.rolSistema = RolSistema.getValue(rolSistema);
//		this.fechaActualizacion = fechaActualizacion;
//	}
//
//	/**
//	 * @return the perfil
//	 */
//	public RolSistema getRol() {
//		return rolSistema;
//	}
//
//	/**
//	 * @return the fechaActualizacion
//	 */
//	public Date getFechaActualizacion() {
//		return fechaActualizacion;
//	}

	
	public int getCodigo() {
		return codigo;
	}


	public List<GruposDto> getGrupos() {
		return grupos;
	}


	public void setGrupos(List<GruposDto> grupos) {
		this.grupos = grupos;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public Integer getHabilitado() {
		return habilitado;
	}


	public void setHabilitado(Integer habilitado) {
		this.habilitado = habilitado;
	}


//	public Integer getAnulado() {
//		return anulado;
//	}
//
//
//	public void setAnulado(Integer anulado) {
//		this.anulado = anulado;
//	}

	public Integer getIsadmin() {
		return isadmin;
	}


	public void setIsadmin(Integer isadmin) {
		this.isadmin = isadmin;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
//		return rolSistema.toString();
		return "";
	}	

}
