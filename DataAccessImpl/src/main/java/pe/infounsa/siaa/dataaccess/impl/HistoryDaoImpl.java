/**
 * 
 */
package pe.infounsa.siaa.dataaccess.impl;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pe.infounsa.siaa.common.utility.Logger;
import pe.infounsa.siaa.dataaccess.HistoryDao;

/**
 * @author Siaa
 *
 */
@Component
@Transactional
public class HistoryDaoImpl implements HistoryDao {

	@Override
	public void saveHistory(String methodName, Date accessDate, String userName) {
		Logger.info(this, "Save history method");

		Logger.info(this, methodName);
		Logger.info(this, String.valueOf(accessDate));
		Logger.info(this, userName);
	}

}
