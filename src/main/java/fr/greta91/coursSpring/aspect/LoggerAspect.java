package fr.greta91.coursSpring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

	private Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

	@Around("execution (* fr..*(..))")
	public Object logger(ProceedingJoinPoint joinPoint) throws Throwable {
		String packageName = joinPoint.getSignature().getDeclaringTypeName();
		String methodName = joinPoint.getSignature().getName();

		logger.info("Entering method [" + packageName + "." + methodName + "]");
		for (Object arg : joinPoint.getArgs()) {
//			logger.info("Args [" + arg.toString() + "]");
		}
		Object output = joinPoint.proceed();
		logger.info("Exiting method [" + packageName + "." + methodName + "]");
		return output;
	}
}
