package pe.infounsa.siaa.common.seguridad;

import pe.infounsa.siaa.common.utility.Logger;

/**
 * @author
 *
 */
public enum ModuloSistema {
	ADMINISTRACION("ADM", "administracion");

	private final String typeValue;

	private final String name;

	private ModuloSistema(final String typeValue, final String name) {
		this.typeValue = typeValue;
		this.name = name;
	}

	/**
	 * @return the typeValue
	 */
	protected String getTypeValue() {
		return typeValue;
	}

	/**
	 * @return the name
	 */
	protected String getName() {
		return name;
	}

	public static ModuloSistema getByValue(final String typeValue) {
		ModuloSistema labelType = null;

		for (ModuloSistema modulo : values()) {
			if (modulo.getTypeValue().equalsIgnoreCase(typeValue)) {
				labelType = modulo;
				break;
			}
		}

		if (labelType == null) {
			Logger.error(ModuloSistema.class, "Modulo " + typeValue
					+ " desconocido, no es un valor válido");
		}

		return labelType;
	}

	public static ModuloSistema getByName(final String name) {
		ModuloSistema labelType = null;

		for (ModuloSistema modulo : values()) {
			if (modulo.getName().equalsIgnoreCase(name)) {
				labelType = modulo;
				break;
			}
		}

		if (labelType == null) {
			Logger.error(ModuloSistema.class, "Modulo " + name
					+ " desconocido, no es un valor válido");
		}

		return labelType;
	}

	@Override
	public String toString() {
		return getTypeValue() + "-" + getName();
	}
	
}
