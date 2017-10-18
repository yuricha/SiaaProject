/**
 * 
 */
package pe.infounsa.siaa.business.aspect;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import pe.infounsa.siaa.common.utility.Logger;
import pe.infounsa.siaa.dataaccess.HistoryDao;

/**
 * @author Siaa
 *
 */
@Component
@Aspect
@Order(40)
public class BusinessHistoryAspect {

	@Autowired
	private HistoryDao historyDao;

	@Pointcut("execution(public * pe.infounsa.siaa.business.impl..*(..))")
	public void anyPublicBusinessMethod() {
	}

	@Pointcut("@annotation(pe.infounsa.siaa.common.annotation.AuditExecution)")
	public void anyBusinessAuditMethod() {
	}

	@Around("anyPublicBusinessMethod() && anyBusinessAuditMethod()")
	public Object profileExecution(ProceedingJoinPoint joinPoint)
			throws Throwable {

//		boolean isExceptionThrown = false;
		try {
			// execute the profiled method
			return joinPoint.proceed();
		} catch (RuntimeException e) {
//			isExceptionThrown = true;
			throw e;
		} finally {

			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();

			String username;

			if (auth != null && auth.isAuthenticated()) {
				username = auth.getName();
			} else {
				username = "ANONYMUS";
			}

			StringBuilder logMessage = new StringBuilder();
			logMessage.append("History for ");
			logMessage.append(joinPoint.getTarget().getClass().getName());
			logMessage.append(".");
			logMessage.append(joinPoint.getSignature().getName());

			logMessage.append(" with arguments "
					+ Arrays.toString(joinPoint.getArgs()));

			Logger.debug(joinPoint.getTarget(), logMessage.toString());

			historyDao.saveHistory(joinPoint.getSignature().getName(),
					new Date(), username);
		}
	}

}
