///**
// * 
// */
//package pe.infounsa.siaa.common.seguridad;
//
///**
// * @author 
// *
// */
//public enum RolSistema {
//	ADMINISTRADOR("ADM"), MOZO("MOZ"), COCINERO("COC"), CAJERO("CAJ"), USUARIO("USR");
//
//	private final String typeValue;
//
//	private RolSistema(final String typeValue) {
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
//	public static RolSistema getValue(final String typeValue) throws Exception {
//		RolSistema labelType = null;
//		
//		for (RolSistema modulo: values())
//	    {
//			if (modulo.getTypeValue().equalsIgnoreCase(typeValue)) {
//				labelType = modulo;
//				break;
//			}
//	    }
//
//		if (labelType == null) {
//			throw new Exception ("Rol " + typeValue + " desconocido, no es un valor válido");
//		}
//
//		return labelType;
//	}
//	
//	@Override
//	public String toString() {
//		return getTypeValue();
//	}
//}
