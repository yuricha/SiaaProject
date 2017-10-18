/**
 * 
 */
package pe.infounsa.siaa.business.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import pe.infounsa.siaa.common.utility.Logger;

/**
 * @author Siaa
 *
 */
@Component
@Aspect
@Order(20)
public class BusinessLoggingAspect {

	@Pointcut("execution(public * pe.infounsa.siaa.business.impl..*(..))")
	public void anyPublicBusinessMethod() {
	}

	@Before("anyPublicBusinessMethod()")
	public void beforeExecution(JoinPoint joinPoint) {
		StringBuilder logMessage = new StringBuilder();

		logMessage.append("Start Business method: ");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append(" in class ");
		logMessage.append(joinPoint.getTarget().getClass().getName());
		logMessage.append(" ...");

		Logger.debug(joinPoint.getTarget(), logMessage.toString());
		Logger.debug(joinPoint.getTarget(),
				"with arguments " + Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "anyPublicBusinessMethod()", returning = "result")
	public void afterReturningExecution(JoinPoint joinPoint, Object result) {

		StringBuilder logMessage = new StringBuilder();

		logMessage.append("Success Business method: ");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append(" in class ");
		logMessage.append(joinPoint.getTarget().getClass().getName());

		Logger.debug(joinPoint.getTarget(), logMessage.toString());
		Logger.debug(joinPoint.getTarget(), "with result " + result);
	}
	
	@AfterThrowing(pointcut = "anyPublicBusinessMethod()", throwing = "exception")
    public void afterThrowingExecution(JoinPoint joinPoint, Exception exception){
		StringBuilder logMessage = new StringBuilder();

		logMessage.append("Failure Business method: ");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append(" in class ");
		logMessage.append(joinPoint.getTarget().getClass().getName());

		Logger.debug(joinPoint.getTarget(), logMessage.toString());
		Logger.debug(joinPoint.getTarget(), "with exception " + exception.getMessage());
		
    }

	@After("anyPublicBusinessMethod()")
	public void afterExecution(JoinPoint joinPoint) {
		StringBuilder logMessage = new StringBuilder();

		logMessage.append("... end Business method: ");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append(" in class ");
		logMessage.append(joinPoint.getTarget().getClass().getName());

		Logger.debug(joinPoint.getTarget(), logMessage.toString());
	}
}
