///**
// * 
// */
//package pe.infounsa.siaa.common.seguridad;
//
///**
// * @author 
// *
// */
//public enum PermisoSistema {
//
//	GUARDAR_PEDIDO("G_PEDIDO"), CONSULTAR_PEDIDO("C_PEDIDO"), GUARDAR_USUARIO(
//			"G_USUARIO"), CONSULTAR_USUARIO("C_USUARIO");
//
//	private final String typeValue;
//
//	private PermisoSistema(final String typeValue) {
//		this.typeValue = typeValue;
//	}
//
//	/**
//	 * @return the typeValue
//	 */
//	protected String getTypeValue() {
//		return typeValue;
//	}
//
//	public static PermisoSistema getValue(final String typeValue)
//			throws Exception {
//		PermisoSistema labelType = null;
//
//		for (PermisoSistema modulo : values()) {
//			if (modulo.getTypeValue().equalsIgnoreCase(typeValue)) {
//				labelType = modulo;
//				break;
//			}
//		}
//
//		if (labelType == null) {
//			throw new Exception("Permiso " + typeValue
//					+ " desconocido, no es un valor válido");
//		}
//
//		return labelType;
//	}
//
//	@Override
//	public String toString() {
//		return getTypeValue();
//	}
//
//}
