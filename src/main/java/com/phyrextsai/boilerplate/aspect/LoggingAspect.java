package com.phyrextsai.boilerplate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.apache.catalina.connector.RequestFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Configuration
public class LoggingAspect {
  private Logger log = LoggerFactory.getLogger(getClass());

  /**
   * Run around the method, log API information and execution time
   * @param joinPoint join point for advice
   * @return object
   * @throws Throwable exception
   */
  @Around("execution(* com.phyrextsai.boilerplate.controller.*.*(..))")
  public Object logControllerAround(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    try {
      Object result = joinPoint.proceed();
      long executionTime = System.currentTimeMillis() - start;
      for (int i = 0; i < joinPoint.getArgs().length; i++) {
        Object obj = joinPoint.getArgs()[i];
        if (obj instanceof RequestFacade) {
          RequestFacade request = (RequestFacade) obj;
          log.info("[API] {} {} {} +{}", request.getProtocol(), request.getMethod(), request.getServletPath(), executionTime + "ms");
        }
      }
      return result;
    } catch (Exception e) {
      throw e;
    }
  }

  /**
	 * Run after the method throw an exception, intercept the throw exception as well.
	 * @param joinPoint join point for advice
	 * @param error exception
	 */
  @AfterThrowing(value = "execution(* com.phyrextsai.boilerplate.controller.*.*(..))", throwing = "error")
	public void logControllerAfterThrowing(JoinPoint joinPoint, Throwable error) {
    for (int i = 0; i < joinPoint.getArgs().length; i++) {
      Object obj = joinPoint.getArgs()[i];
      if (obj instanceof RequestFacade) {
        RequestFacade request = (RequestFacade) obj;
        log.error("[API] {} {} {}, ERROR: {}", request.getProtocol(), request.getMethod(), request.getServletPath(), error.getMessage() != null ? error.getMessage() : "NULL");
      }
    }
  }
}
