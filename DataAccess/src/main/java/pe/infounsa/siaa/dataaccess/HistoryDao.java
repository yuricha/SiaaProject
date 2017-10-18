/**
 * 
 */
package pe.infounsa.siaa.dataaccess;

import java.util.Date;

/**
 * @author Siaa
 *
 */
public interface HistoryDao {

	public void saveHistory(String methodName, Date accessDate, String userName);
}
