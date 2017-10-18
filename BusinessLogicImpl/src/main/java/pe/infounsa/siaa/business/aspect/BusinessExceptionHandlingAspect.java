/**
 * 
 */
package pe.infounsa.siaa.business.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import pe.infounsa.siaa.business.exception.BusinessException;
import pe.infounsa.siaa.business.exception.GenericBusinessException;
import pe.infounsa.siaa.common.utility.Logger;

/**
 * @author Siaa
 *
 */
@Component
@Aspect
@Order(30)
public class BusinessExceptionHandlingAspect {

	@Pointcut("execution(public * pe.infounsa.siaa.business.impl..*(..))")
	public void anyPublicBusinessMethod() {
	}

	@Around("anyPublicBusinessMethod()")
	public Object exceptionHandlingExecution(ProceedingJoinPoint joinPoint)
			throws Throwable {

		try {
			return joinPoint.proceed();
		} catch (Exception exception) {

			Logger.error(joinPoint.getTarget(), exception.getMessage());
			
			if (!(exception instanceof BusinessException
					|| exception instanceof AuthenticationException || exception instanceof AccessDeniedException)) {
				
				throw new GenericBusinessException("001",
						"Error no controlado en Business layer", exception);
//			} else if(exception instanceof ConstraintViolationException){
//				throw new GenericBusinessException("001",
//						"Error de referencia", exception);
			}else{
				throw exception;
			}
		}
		finally {

		}
	}
}
