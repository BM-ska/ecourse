package com.fingo.ecourse.categories.controller.exception.handler;

import com.fingo.ecourse.categories.controller.exception.model.CategoryDuplicateException;
import com.fingo.ecourse.categories.controller.exception.model.NotFoundException;
import com.fingo.ecourse.categories.service.CategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LogManager.getLogger(CategoryService.class);

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<String> handleNotFound(Exception e){
		LOGGER.error("NotFoundException handler executed");
		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.NOT_FOUND
		);
	}

	@ExceptionHandler(CategoryDuplicateException.class)
	public final ResponseEntity<String> handleCategoryDuplicateException(Exception e){
		LOGGER.error("CategoryDuplicate handler executed");
		return new ResponseEntity<>(
				e.getMessage(),
				HttpStatus.BAD_REQUEST
		);
	}
}
