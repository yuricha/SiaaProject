/**
 * 
 */
package pe.infounsa.siaa.domain.persistence.utility;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Siaa
 *
 */
public class AuditEntityListener {

	@PrePersist
	public void prePersist(PersistenceAuditableEntity<?> entity) {

		String currentUser = getCurrentUser();
		Date actualDate = new Date();

		entity.setCreatedBy(currentUser);
		entity.setCreatedDate(actualDate);

		entity.setLastChangedBy(currentUser);
		entity.setLastChangedDate(actualDate);

	}

	@PreUpdate
	public void preUpdate(PersistenceAuditableEntity<?> entity) {
		String currentUser = getCurrentUser();
		Date actualDate = new Date();

		entity.setLastChangedBy(currentUser);
		entity.setLastChangedDate(actualDate);
	}

	private String getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		if (auth != null) {
			
			return auth.getName();
		} else {
			return "ANONYMUS";
		}
	}
}
