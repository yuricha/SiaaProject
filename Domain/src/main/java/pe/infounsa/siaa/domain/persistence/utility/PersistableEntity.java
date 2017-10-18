/**
 * 
 */
package pe.infounsa.siaa.domain.persistence.utility;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

/**
 * @author Siaa
 *
 */
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class PersistableEntity<T> implements Serializable {

	public abstract T getId();

	public abstract void setId(T id);
}
