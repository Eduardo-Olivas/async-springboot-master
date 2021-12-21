package com.async.config;

import org.apache.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

	@SuppressWarnings("unused")
	private static Logger logJava = Logger.getLogger(AsyncExceptionHandler.class);
	
	@Override
    public void handleUncaughtException(Throwable ex, Method method, Object... args) {
		logJava.info("handleUncaughtException ::");
		
		logJava.info("Method Name" + method.getName()
                + "---" + Arrays.toString(args) + "----"
                + "error Message: " + ex.getMessage());

    }
}
