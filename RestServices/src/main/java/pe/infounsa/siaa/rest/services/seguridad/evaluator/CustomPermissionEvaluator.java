/**
 * 
 */
package pe.infounsa.siaa.rest.services.seguridad.evaluator;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import pe.infounsa.siaa.business.seguridad.GestionarUserRightsBusiness;
import pe.infounsa.siaa.common.seguridad.ModuloSistema;
import pe.infounsa.siaa.common.utility.Logger;

/**
 * @author Siaa
 *
 */
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

	private static final String SECURED_OBJECT_PACKAGE = "(pe\\.infounsa\\.)([a-z]+)(\\.business\\.)([a-z]+\\.)(.)+";

	private static final String SECURED_LAYER = ".business.impl.";

	@Autowired
	private GestionarUserRightsBusiness gestionarUserRightsBusiness;

	@Override
	public boolean hasPermission(Authentication authentication,
			Object targetDomainObject, Object permission) {
		Logger.debug(this,
				"Evaluating expression using hasPermission signature #1");

		Logger.debug(this, "Retrieving user's highest role");
		// String role = getRole(authentication);

		Logger.debug(this, "****************");
		// Logger.debug(this, "role: " + role);
		Logger.debug(this, "targetDomainObject: " + targetDomainObject);
		Logger.debug(this, "permission: " + permission);
		Logger.debug(this, "****************");

		boolean hasaccess = false;

		// Check the type of object
		Logger.debug(this, "User is trying to access the object: "
				+ targetDomainObject);

		if (targetDomainObject != null
				&& targetDomainObject.getClass().getName()
						.matches(SECURED_OBJECT_PACKAGE)) {

			String targetClassName = targetDomainObject.getClass().getName();
			int posLayer = targetClassName.indexOf(SECURED_LAYER);

			int posModule = targetClassName.substring(
					posLayer + SECURED_LAYER.length()).indexOf(".");

			String moduleName = targetClassName.substring(posLayer
					+ SECURED_LAYER.length(), posLayer + SECURED_LAYER.length()
					+ posModule);

			if (!StringUtils.isEmpty(moduleName)) {
				ModuloSistema modulo = ModuloSistema.getByName(moduleName);
				
				if (modulo != null) {
					
					Logger.debug(this, "Check if user has permission");
					
					hasaccess = gestionarUserRightsBusiness.hasPermissionRight((UserDetails) authentication.getPrincipal(), String.valueOf(permission));
				}
			}

		}


		return hasaccess;
	}

	@Override
	public boolean hasPermission(Authentication authentication,
			Serializable targetId, String targetType, Object permission) {
		Logger.debug(this,
				"Evaluating expression using hasPermission signature #2");
		return false;
	}

}
