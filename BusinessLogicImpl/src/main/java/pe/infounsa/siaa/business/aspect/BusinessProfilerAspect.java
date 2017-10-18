/**
 * 
 */
package pe.infounsa.siaa.business.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StopWatch.TaskInfo;

import pe.infounsa.siaa.common.utility.Logger;

/**
 * @author Siaa
 *
 */
@Component
@Aspect
@Order(10)
public class BusinessProfilerAspect {

	@Pointcut("execution(public * pe.infounsa.siaa.business.impl..*(..))")
	public void anyPublicBusinessMethod() {
	}

	@Pointcut("@annotation(pe.infounsa.siaa.common.annotation.ProfileExecution)")
	public void anyBusinessProfileMethod() {
	}

	@Around("anyPublicBusinessMethod() && anyBusinessProfileMethod()")
	public Object profileExecution(ProceedingJoinPoint joinPoint)
			throws Throwable {

		StopWatch stopWatch = new StopWatch(joinPoint.getSignature().getName());
		stopWatch.start(joinPoint.toShortString());
		boolean isExceptionThrown = false;
		try {
			// execute the profiled method
			return joinPoint.proceed();
		} catch (RuntimeException e) {
			isExceptionThrown = true;
			throw e;
		} finally {
			stopWatch.stop();

			TaskInfo taskInfo = stopWatch.getLastTaskInfo();

			StringBuilder logMessage = new StringBuilder();
			logMessage.append(joinPoint.getTarget().getClass().getName());
			logMessage.append(".");
			logMessage.append(joinPoint.getSignature().getName());

			logMessage.append(" with arguments "
					+ Arrays.toString(joinPoint.getArgs()));

			// Log the method's profiling result
			String profileMessage = taskInfo.getTaskName() + ": "
					+ taskInfo.getTimeMillis() + " ms"
					+ (isExceptionThrown ? " (thrown Exception)" : "");

			Logger.debug(this, logMessage.toString());
//			Logger.debug(this,
//					"execution time: " + stopWatch.getTotalTimeMillis() + " ms");
			Logger.debug(this, profileMessage);
//			Logger.debug(this, stopWatch.prettyPrint());
		}
	}

}
