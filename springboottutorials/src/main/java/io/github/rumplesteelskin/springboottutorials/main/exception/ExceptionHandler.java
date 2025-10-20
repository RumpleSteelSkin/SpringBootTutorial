package io.github.rumplesteelskin.springboottutorials.main.exception;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ExceptionHandler implements AsyncUncaughtExceptionHandler {
    @SuppressWarnings("NullableProblems")
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        System.out.println("Async Handle Uncaught Exception: " + ex.getMessage());
        System.out.println("Method: " + method.getName());
        System.out.println("Params: " + Arrays.toString(params));
    }
}
