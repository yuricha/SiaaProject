/**
 * 
 */
package pe.infounsa.siaa.business.seguridad.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author
 *
 */
public class PermisoUsuarioDto {

	private final UsuarioAdminDto usuario;
 
	private List<String> permisos;

	private final Date fechaActualizacion;

	public PermisoUsuarioDto(final UsuarioAdminDto usuario,
			final Date fechaActualizacion) {
		this.usuario = usuario;
		this.permisos = new ArrayList<String>(); // new HashMap<String, List<String>>();
		// this.permiso = PermisoSistema.getValue(permiso);
		this.fechaActualizacion = fechaActualizacion;
	}

	/**
	 * @return the usuario
	 */
	public UsuarioAdminDto getUsuario() {
		return usuario;
	}

	/**
	 * @return the permisos
	 */
	public List<String> getPermisos() {
		return permisos; //.get(modulo.toString());
	}

	/**
	 * 
	 * @param permiso
	 * @throws Exception
	 */
//	public synchronized void addPermiso(ModuloSistema modulo, String permiso) {
//		String moduloKey = modulo.toString();
//
//		if (!this.permisos.containsKey(moduloKey)) {
//			this.permisos.put(moduloKey, new ArrayList<String>());
//		}
//
//		this.permisos.get(moduloKey).add(permiso);
//	}
//	
	public synchronized void addPermiso(String permiso) {
		//String moduloKey = modulo.toString();

		if (!this.permisos.contains(permiso)) {
			//this.permisos.put(moduloKey, new ArrayList<String>());
			this.permisos.add(permiso);
		}

		//this.permisos.get(moduloKey).add(permiso);
	}

	/**
	 * @return the fechaActualizacion
	 */
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

}
