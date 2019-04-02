package com.coffee.jiahui.exception;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(RuntimeException.class)
	public String RuntimeExceptionHandler(RuntimeException e) {
		return "运行时异常";
	}
	
	@ExceptionHandler(IOException.class)
	public String IoExceptionHandler(RuntimeException e) {
		return "IO异常";
	}
}
