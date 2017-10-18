/**
 * 
 */
package pe.infounsa.siaa.business.seguridad.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pe.infounsa.siaa.common.seguridad.ModuloSistema;

/**
 * @author 
 *
 */
public class ModuloUsuarioDto {

	private final UsuarioAdminDto usuario;

	private List<ModuloSistema> modulos;

	private final Date fechaActualizacion;

	public ModuloUsuarioDto(final UsuarioAdminDto usuario,
			final Date fechaActualizacion) {
		this.usuario = usuario;
		this.modulos = new ArrayList<ModuloSistema>();
		this.fechaActualizacion = fechaActualizacion;
	}

	/**
	 * @return the usuario
	 */
	public UsuarioAdminDto getUsuario() {
		return usuario;
	}

	/**
	 * @return the modulos
	 */
	public List<ModuloSistema> getModulos() {
		return modulos;
	}

	/**
	 * 
	 * @param modulo
	 * @throws Exception
	 */
	public void addModulo(String modulo) {
		this.modulos.add(ModuloSistema.getByValue(modulo));
	}

	/**
	 * @return the fechaActualizacion
	 */
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

}
